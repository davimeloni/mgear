import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Papa } from 'ngx-papaparse';

import { IBrakePad } from 'app/shared/model/brake-pad.model';
import { Principal } from 'app/core';
import { BrakePadService } from './brake-pad.service';

import allCols from './brake-pad-columns';
import { MessageService } from 'primeng/api';

@Component({
    selector: 'jhi-brake-pad',
    templateUrl: './brake-pad.component.html',
    providers: [MessageService]
})
export class BrakePadComponent implements OnInit, OnDestroy {
    brakePads: IBrakePad[];
    currentAccount: any;
    eventSubscriber: Subscription;

    isSaving: boolean;
    private _brakePad: IBrakePad;
    eDateDp: any;
    csvToSave: any[];
    selectedPads: any[];
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
        private brakePadService: BrakePadService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal,
        private activatedRoute: ActivatedRoute,
        private papa: Papa,
        private messageService: MessageService
    ) {}

    loadAll() {
        this.brakePadService.query().subscribe(
            (res: HttpResponse<IBrakePad[]>) => {
                this.brakePads = res.body;
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
        this.registerChangeInBrakePads();
        this.selectedColumns = [];
        this.displayColumns2 = allCols;
    }

    reloadAll() {
        this.brakePadService.query().subscribe(
            (res: HttpResponse<IBrakePad[]>) => {
                this.brakePads = res.body;
                this.displayDialog2 = false;
                this.messageService.add({ severity: 'success', summary: 'Data Successfully Updated'});

            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBrakePad) {
        return item.id;
    }

    registerChangeInBrakePads() {
        this.eventSubscriber = this.eventManager.subscribe('brakePadListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    /* Rows */
    saveRow(row) {
        console.log(row);
        this.brakePad = row;
        if (this.isRowChanged) {
            this.isSaving = true;
            this.subscribeToSaveResponse(this.brakePadService.update(this.brakePad));
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

    /* UPDATE CHAIN */
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
            isUpdate = this.brakePads.find(c => {
                return c.sku === cts.sku;
            });

            if (isUpdate === undefined) {
                this.brakePad = cts;
                // console.log('undefined --- ' + this.chain.sku);
                if (this.brakePad.sku.length < 2) {
                    error = error + 1;
                } else {
                    // this.brakePad.id = isUpdate.id;
                    csvObj.sku = this.brakePad.sku;
                    csvObj.performed = 'Create';
                    this.subscribeToCSVSaveResponse(csvObj, this.brakePadService.create(this.brakePad));
                    // lastCSVObj.status = afterSave.status;
                    // lastCSVObj.errorMessage = afterSave.errorMessage;
                    created = created + 1;
                }
            } else {
                this.brakePad = cts;
                this.brakePad.id = isUpdate.id;
                csvObj.id = this.brakePad.id;
                csvObj.sku = this.brakePad.sku;
                csvObj.performed = 'Update';
                this.subscribeToCSVSaveResponse(csvObj, this.brakePadService.update(this.brakePad));
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

    private subscribeToCSVSaveResponse(csvObj, result: Observable<HttpResponse<IBrakePad>>) {
         result.subscribe((res: HttpResponse<IBrakePad>) => this.onCSVSaveSuccess(res, csvObj), (res: HttpErrorResponse) => this.onCSVSaveError(res, csvObj));
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
        if (this.brakePad.id !== undefined) {
            this.subscribeToSaveResponse(this.brakePadService.update(this.brakePad));
        } else {
            this.subscribeToSaveResponse(this.brakePadService.create(this.brakePad));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBrakePad>>) {
        result.subscribe((res: HttpResponse<IBrakePad>) => this.onSaveSuccess(res), (res: HttpErrorResponse) => this.onSaveError(res));
    }

    private onSaveSuccess(res) {
        this.isSaving = false;
        this.messageService.add({ severity: 'success', summary: 'Success saved', detail: res.body.sku });
    }

    private onSaveError(res) {
        this.isSaving = false;
        this.messageService.add({ severity: 'error', summary: 'Error', detail: res.error.detail });
    }

    /* DELETE */
    deleteItems() {
        console.log('on delete selected')
        for (let pad of this.selectedPads) {
            console.log(pad.sku)
            this.confirmDelete(pad.id)
        }
        this.displayDialog = false;
    }

    confirmDelete(id: number) {
        this.brakePadService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'brakePadListModification',
                content: 'Deleted an brakePad'
            });
        });
    }

    confirmDeleteSelected() {
        this.dialogContent = "Are you sure you want to delete those Brake Pads?"
        this.displayDialog = true;
    }

    /* GETTERS AND SETTERS */
    get brakePad() {
        return this._brakePad;
    }

    set brakePad(brakePad: IBrakePad) {
        this._brakePad = brakePad;
    }
}
