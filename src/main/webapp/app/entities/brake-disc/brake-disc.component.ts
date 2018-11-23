import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Papa } from 'ngx-papaparse';

import { IBrakeDisc } from 'app/shared/model/brake-disc.model';
import { Principal } from 'app/core';
import { BrakeDiscService } from './brake-disc.service';

import allCols from './brake-disc-columns';
import { MessageService } from 'primeng/api';

@Component({
    selector: 'jhi-brake-disc',
    templateUrl: './brake-disc.component.html',
    providers: [MessageService]
})
export class BrakeDiscComponent implements OnInit, OnDestroy {
    brakeDiscs: IBrakeDisc[];
    currentAccount: any;
    eventSubscriber: Subscription;

    private _brakeDisc: IBrakeDisc;
    isSaving: boolean;
    eDateDp: any;
    dateDp: any;
    datesentDp: any;
    hAPapprovedDp: any;
    sHAapprovedDp: any;

    csvToSave: any[];
    selectedDiscs: any[];
    displayDialog: boolean = false;
    displayDialog2: boolean = false;
    dialogContent: String;

    isRowChanged = false;

    booleanOptions = [{value: true, label: 'Yes'}, {value: false, label: 'No'}];

    ynOptions = ['Y', 'N'];

    displayColumns2: any[];
    selectedColumns: any[];

    lastCSVReport: any[];
    lastCSVObj: any = { id: '', sku: '', performed: '', status: '', errorMessage: '' };
    dialogLastCSV = false;

    expanded: boolean = false;

    constructor(
        private brakeDiscService: BrakeDiscService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private activatedRoute: ActivatedRoute,
        private papa: Papa,
        private principal: Principal,
        private messageService: MessageService
    ) {}

    loadAll() {
        this.brakeDiscService.query().subscribe(
            (res: HttpResponse<IBrakeDisc[]>) => {
                this.brakeDiscs = res.body;
                this.displayDialog2 = false;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBrakeDiscs();
        this.selectedColumns = [];
        this.displayColumns2 = allCols;
    }

    reloadAll() {
        this.brakeDiscService.query().subscribe(
            (res: HttpResponse<IBrakeDisc[]>) => {
                this.brakeDiscs = res.body;
                // console.log(this.chains);
                this.displayDialog2 = false;
                this.messageService.add({ severity: 'success', summary: 'Data Successfully Updated'});
            },
            (res: HttpErrorResponse) => {
                this.onError(res.message);
            }
        );
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBrakeDisc) {
        return item.id;
    }

    registerChangeInBrakeDiscs() {
        this.eventSubscriber = this.eventManager.subscribe('brakeDiscListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    /* Rows */
    saveRow(row) {
        console.log(row);
        this.brakeDisc = row;
        if (this.isRowChanged) {
            this.isSaving = true;
            this.subscribeToSaveResponse(this.brakeDiscService.update(this.brakeDisc));
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

    /* UPDATE Disc */
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
        this.displayDialog = true;
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
            isUpdate = this.brakeDiscs.find(c => {
                return c.sku === cts.sku;
            });

            if (isUpdate === undefined) {
                this.brakeDisc = cts;
                // console.log('undefined --- ' + this.chain.sku);
                if (this.brakeDisc.sku.length < 2) {
                    error = error + 1;
                } else {
                    // this.brakeDisc.id = isUpdate.id;
                    csvObj.sku = this.brakeDisc.sku;
                    csvObj.performed = 'Create';
                    this.subscribeToCSVSaveResponse(csvObj, this.brakeDiscService.create(this.brakeDisc));
                    // lastCSVObj.status = afterSave.status;
                    // lastCSVObj.errorMessage = afterSave.errorMessage;
                    created = created + 1;
                }
            } else {
                this.brakeDisc = cts;
                this.brakeDisc.id = isUpdate.id;
                csvObj.id = this.brakeDisc.id;
                csvObj.sku = this.brakeDisc.sku;
                csvObj.performed = 'Update';
                this.subscribeToCSVSaveResponse(csvObj, this.brakeDiscService.update(this.brakeDisc));
                // lastCSVObj.status = afterSave.status;
                // lastCSVObj.errorMessage = afterSave.errorMessage;
                updated = updated + 1;
            }
        }

        console.log('after forloop');
        this.loadAll();
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

    private subscribeToCSVSaveResponse(csvObj, result: Observable<HttpResponse<IBrakeDisc>>) {
         result.subscribe((res: HttpResponse<IBrakeDisc>) => this.onCSVSaveSuccess(res, csvObj), (res: HttpErrorResponse) => this.onCSVSaveError(res, csvObj));
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
        if (this.brakeDisc.id !== undefined) {
            this.subscribeToSaveResponse(this.brakeDiscService.update(this.brakeDisc));
        } else {
            this.subscribeToSaveResponse(this.brakeDiscService.create(this.brakeDisc));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBrakeDisc>>) {
        result.subscribe((res: HttpResponse<IBrakeDisc>) => this.onSaveSuccess(res), (res: HttpErrorResponse) => this.onSaveError(res));
    }

    private onSaveSuccess(res) {
        this.isSaving = false;
        // this.previousState();
        this.messageService.add({ severity: 'success', summary: 'Success saved', detail: res.body.sku });

    }

    private onSaveError(res) {
        this.isSaving = false;
        this.messageService.add({ severity: 'error', summary: 'Error', detail: res.error.detail });
    }

    /* Delete Discs */
    deleteItems() {
        console.log('on delete selected')
        for (let disc of this.selectedDiscs) {
            console.log(disc.sku)
            this.confirmDelete(disc.id)
        }
        this.displayDialog = false;
    }


    confirmDeleteSelected() {
        this.dialogContent = "Are you sure you want to delete those Brake Discs?"
        this.displayDialog = true;
    }
    
    confirmDelete(id: number) {
        this.brakeDiscService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'brakeDiscListModification',
                content: 'Deleted an brakeDisc'
            });
        });
    }

    /* GETTERS AND SETTERS */
    get brakeDisc() {
        return this._brakeDisc;
    }

    set brakeDisc(brakeDisc: IBrakeDisc) {
        this._brakeDisc = brakeDisc;
    }
}
