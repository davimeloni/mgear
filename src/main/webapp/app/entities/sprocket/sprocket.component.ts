import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Papa } from 'ngx-papaparse';

import { ISprocket } from 'app/shared/model/sprocket.model';
import { Principal } from 'app/core';
import { SprocketService } from './sprocket.service';

import allCols from './sprocket-columns';
import { MessageService } from 'primeng/api';

@Component({
    selector: 'jhi-sprocket',
    templateUrl: './sprocket.component.html',
    providers: [MessageService]
})
export class SprocketComponent implements OnInit, OnDestroy {
    sprockets: ISprocket[];
    currentAccount: any;
    eventSubscriber: Subscription;

    isSaving: boolean;
    private _sprocket: ISprocket;
    eDateDp: any;
    csvToSave: any[];

    selectedSprockets: any[];

    displayDialog: boolean = false;
    displayDialog2: boolean = false;
    dialogContent: String;

    isRowChanged = false;

    booleanOptions = [{ value: true, label: 'Yes' }, { value: false, label: 'No' }];

    ynOptions = ['Y', 'N'];

    displayColumns2: any[];
    selectedColumns: any[];

    lastCSVReport: any[];
    lastCSVObj: any = { id: '', sku: '', performed: '', status: '', errorMessage: '' };
    dialogLastCSV = false;
    expanded: boolean = false;

    constructor(
        private sprocketService: SprocketService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private activatedRoute: ActivatedRoute,
        private papa: Papa,
        private principal: Principal,
        private messageService: MessageService
    ) { }

    loadAll() {
        this.sprocketService.query().subscribe(
            (res: HttpResponse<ISprocket[]>) => {
                this.sprockets = res.body;
                this.displayDialog2 = false;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.isSaving = false;
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInSprockets();
        this.selectedColumns = [];
        this.displayColumns2 = allCols;
    }

    reloadAll() {
        this.sprocketService.query().subscribe(
            (res: HttpResponse<ISprocket[]>) => {
                this.sprockets = res.body;
                this.displayDialog2 = false;
                this.messageService.add({ severity: 'success', summary: 'Data Successfully Updated'});
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ISprocket) {
        return item.id;
    }

    registerChangeInSprockets() {
        this.eventSubscriber = this.eventManager.subscribe('sprocketListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    /* Rows */
    saveRow(row) {
        console.log(row);
        this.sprocket = row;
        if (this.isRowChanged) {
            this.isSaving = true;
            this.subscribeToSaveResponse(this.sprocketService.update(this.sprocket));
        } else if (this.sprocket.eDate) {
            this.isSaving = true;
            this.subscribeToSaveResponse(this.sprocketService.update(this.sprocket));
        }
        this.isRowChanged = false;
    }

    rowChanged() {
        this.isRowChanged = true;
        console.log('row is changed: ' + this.isRowChanged)
    }

    /* Columns */
    selectAllColumns() {
        let cols = this.displayColumns2;
        for (let col of cols) {
            if (col.header !== "ID") {
                col.display = true;
            }
        }
    }
    unselectAllColumns() {
        let cols = this.displayColumns2;
        for (let col of cols) {
            col.display = false;
        }
    }

    onRowSelect(event) {
        // this.messageService.add({severity:'info', summary:'Car Selected', detail:'Vin: ' + event.data.vin});
        console.log(event);

    }

    onRowUnselect(event) {
        // this.messageService.add({severity:'info', summary:'Car Unselected', detail:'Vin: ' + event.data.vin});
        console.log(event);
    }

    /* UPDATE SPROCKET */
    /* CSV */
    convertFile(input) {
        this.papa.parse(input.files[0], {
            header: true,
            complete: (result) => {
                console.log('Parsed: ', result);
                this.csvToSave = result.data;
            }
        });
    }

    popupCSV() {
        this.dialogLastCSV = true;
    }

    loopSaveCSV() {
        console.log('display dialog2 ' + this.displayDialog);
        // console.log('save csv one by one')
        // console.log(this.csvToSave)
        // this.chain = this.csvToSave[0];
        // this.subscribeToSaveResponse(this.chainService.create(this.chain));
        let created = 0;
        let updated = 0;
        let error = 0;
        this.lastCSVReport = [];

        for (const cts of this.csvToSave) {
            let isUpdate: any;
            this.isSaving = true;
            let csvObj = { id: 0, sku: '', performed: '', status: '', errorMessage: '' };
            let afterSave
            // let afterSave: any;
            isUpdate = this.sprockets.find(c => {
                return c.sku === cts.sku;
            });

            if (isUpdate === undefined) {
                this.sprocket = cts;
                // console.log('undefined --- ' + this.chain.sku);
                if (this.sprocket.sku.length < 2) {
                    error = error + 1;
                } else {
                    console.log('error create?');
                    // this.sprocket.id = isUpdate.id;
                    csvObj.sku = this.sprocket.sku;
                    csvObj.performed = 'Create';
                    this.subscribeToCSVSaveResponse(csvObj, this.sprocketService.create(this.sprocket));
                    // lastCSVObj.status = afterSave.status;
                    // lastCSVObj.errorMessage = afterSave.errorMessage;
                    created = created + 1;
                }
            } else {
                console.log('error update?');
                this.sprocket = cts;
                this.sprocket.id = isUpdate.id;
                csvObj.id = this.sprocket.id;
                csvObj.sku = this.sprocket.sku;
                csvObj.performed = 'Update';
                this.subscribeToCSVSaveResponse(csvObj, this.sprocketService.update(this.sprocket));
                // lastCSVObj.status = afterSave.status;
                // lastCSVObj.errorMessage = afterSave.errorMessage;
                updated = updated + 1;
            }
        }

        console.log('after forloop');
        // this.loadAll();
        // alert('created: ' + created + ' updated: ' + updated + ' error: ' + error);
    }

    saveCSV() {
        if (this.csvToSave === undefined || this.csvToSave.length < 1) {
            console.log('csv empty or no csv');
            alert('No CSV File or CSV Empty');
        } else {
            this.displayDialog2 = true;
            setTimeout(() => {
                this.loopSaveCSV();
            }, 1000);       
        }
    }

    private subscribeToCSVSaveResponse(csvObj, result: Observable<HttpResponse<ISprocket>>) {
         result.subscribe((res: HttpResponse<ISprocket>) => this.onCSVSaveSuccess(res, csvObj), (res: HttpErrorResponse) => this.onCSVSaveError(res, csvObj));
    }

    private onCSVSaveSuccess(res, csvObj) {
        this.isSaving = false;
        console.log('on success');
        console.log(res);
        csvObj.status = 'Success';
        this.lastCSVReport = [...this.lastCSVReport, csvObj];
        // this.messageService.add({severity:'success', summary: 'Success saved', detail: res.body.sku});
    }

    private onCSVSaveError(res, csvObj) {
        this.isSaving = false;
        let resultObjItem = {status: '', errorMessage: ''};
        console.log('on error before');
        console.log(res);
        csvObj.status = 'Error';
        csvObj.errorMessage = res.error.detail;
        this.lastCSVReport = [...this.lastCSVReport, csvObj];
        // this.messageService.add({severity:'error', summary: 'Error', detail: res.error.detail});
    }

    /* NORMAL SAVE */
    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.sprocket.id !== undefined) {
            this.subscribeToSaveResponse(this.sprocketService.update(this.sprocket));
        } else {
            this.subscribeToSaveResponse(this.sprocketService.create(this.sprocket));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ISprocket>>) {
        result.subscribe((res: HttpResponse<ISprocket>) => this.onSaveSuccess(res), (res: HttpErrorResponse) => this.onSaveError(res));
    }

    private onSaveSuccess(res) {
        this.isSaving = false;
        this.messageService.add({ severity: 'success', summary: 'Success saved', detail: res.body.sku });
        // this.previousState();
    }

    private onSaveError(res) {
        console.log(res)
        this.isSaving = false;
        this.messageService.add({ severity: 'error', summary: 'Error', detail: res.error.detail });
    }

    /* Delete Sprockets */
    deleteItems() {
        console.log('on delete selected')
        for (let sprocket of this.selectedSprockets) {
            console.log(sprocket.sku)
            this.confirmDelete(sprocket.id)
        }
        this.displayDialog = false;
        this.messageService.add({ severity: 'info', summary: 'Info', detail: 'Items deleted' });
    }

    confirmDeleteSelected() {
        this.dialogContent = "Are you sure you want to delete those Sprockets?"
        this.displayDialog = true;
    }

    confirmDelete(id: number) {
        this.sprocketService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'sprocketListModification',
                content: 'Deleted an sprocket'
            });
        });
    }

    /* GETTER AND SETTER */
    get sprocket() {
        return this._sprocket;
    }

    set sprocket(sprocket: ISprocket) {
        this._sprocket = sprocket;
    }
}
