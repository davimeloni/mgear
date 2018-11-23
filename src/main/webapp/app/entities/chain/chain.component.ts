import { Component, OnInit, OnDestroy, HostListener } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Papa } from 'ngx-papaparse';

import { IChain } from 'app/shared/model/chain.model';
import { Principal } from 'app/core';
import { ChainService } from './chain.service';
import { SelectItem } from 'primeng/primeng';
import { MessageService } from 'primeng/api';
import {forkJoin} from 'rxjs';

import allCols from './chain-columns';
import { resolve } from 'path';
import { WebWorkerService } from 'ngx-web-worker';

@Component({
    selector: 'jhi-chain',
    templateUrl: './chain.component.html',
    styles: [],
    providers: [MessageService, WebWorkerService]
})
export class ChainComponent implements OnInit, OnDestroy {
    chains: IChain[];
    currentAccount: any;
    eventSubscriber: Subscription;

    isSaving: boolean;
    private _chain: IChain;
    eDateDp: any;

    csvToSave: any[];
    
    selectedChains: any[];
    displayDialog: boolean = false;
    displayDialog2: boolean = false;
    dialogContent: String;

    isRowChanged = false;

    booleanOptions = [{ value: 'Y', label: 'Y' }, { value: 'N', label: 'N' }, { value: '', label: 'Clear' }];
    ynOptions = ['', 'Y', 'N'];

    displayColumns2: any[];
    selectedColumns: any[];

    lastCSVReport: any[];
    lastCSVObj: any = { id: '', sku: '', performed: '', status: '', errorMessage: '' };
    dialogLastCSV = false;
    savingCSV: boolean = false;
    textCSVSaving = '';
    csvItemsError: any[];

    expanded: boolean = false;

    dirtCCFilter: number;
    dirtCCTimeout: any;
    streetCCFilter: number;
    streetCCTimeout: any;

    timeoutTime: number = 3000;
    csvImportStatus: string;

    constructor(
        private chainService: ChainService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private activatedRoute: ActivatedRoute,
        private papa: Papa,
        private principal: Principal,
        private messageService: MessageService,
        private _webWorkerService: WebWorkerService
    ) { }

    getCheckboxScope(e) {
        console.log(e)
    }

    loadAll() {
        this.chainService.query().subscribe(
            (res: HttpResponse<IChain[]>) => {
                this.chains = res.body;
                // console.log(this.chains);
                this.displayDialog2 = false;
                /*
                if (this.savingCSV) {
                    this.messageService.add({ severity: 'info', summary: 'CSV Imported', detail: 'Please check report'});
                    this.savingCSV = false;
                }
                */
            },
            (res: HttpErrorResponse) => {
                this.onError(res.message);
            }
        );
    }

    ngOnInit() {
        this.isSaving = false;
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInChains();
        this.selectedColumns = [];
        this.displayColumns2 = allCols;
        this.dialogLastCSV = false;
        this.csvImportStatus = '';
        this.csvItemsError = [];
    }

    @HostListener("window:beforeunload", ["$event"]) unloadHandler(event: Event) {
        console.log("Processing beforeunload...");
        // Do more processing...
        alert('prevent reloading');
        event.returnValue = false;
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    reloadAll() {
        this.chainService.query().subscribe(
            (res: HttpResponse<IChain[]>) => {
                this.chains = res.body;
                // console.log(this.chains);
                this.displayDialog2 = false;
                this.messageService.add({ severity: 'success', summary: 'Data Successfully Updated'});
            },
            (res: HttpErrorResponse) => {
                this.onError(res.message);
            }
        );
    }

    trackId(index: number, item: IChain) {
        return item.id;
    }

    registerChangeInChains() {
        this.eventSubscriber = this.eventManager.subscribe('chainListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

     /* Add New */
     addNew() {
        let newChain: IChain = {}; 
        console.log('new chain');
        console.log(newChain);
        this.chains.unshift(newChain);
        console.log(this.chains);
    }

    cancelNew(newObj) {
        console.log(newObj);
        this.chains.shift();
    }

    saveNew(newChain) {
        this.chain = newChain;
        if (this.chains.find(c => c.sku == this.chain.sku)) {
            this.messageService.add({ severity: 'error', summary: 'Error', detail: 'This SKU already exists in the database.' });
        } else {
            this.subscribeToSaveResponse(this.chainService.create(this.chain));
            this.loadAll();
        }
        
    }

    /* Rows */
    saveRow(row) {
        console.log(row);
        this.chain = row;
        if (this.isRowChanged && row.id) {
            this.isSaving = true;
            this.subscribeToSaveResponse(this.chainService.update(this.chain));
        }
        this.isRowChanged = false;
    }

    rowChanged() {
        this.isRowChanged = true;
        console.log('row is changed: ' + this.isRowChanged);
    }

    /* Columns */
    selectAllColumns() {
        let cols = this.displayColumns2;
        for (let col of cols) {
            if (col.field === 'ourNotes') {
                col.display = false;
            } else if (col.field === 'customerNotes') {
                col.display = false;
            } else {
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

    validateCSV() {
        let convertArray: IChain[] = [];
        let validateChain = this.chains[4];
        convertArray = this.csvToSave;
        for (let item of convertArray) {
            // console.log(item);
            for (let prop in item) {
                console.log(typeof item[prop]);
                console.log(validateChain[prop] + typeof validateChain[prop]);
            }
        }
        console.log(this.csvItemsError);
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
        let savingChain

        for (const cts of this.csvToSave) {
            let isUpdate: any;
            this.isSaving = true;
            let csvObj = { id: 0, sku: '', performed: '', status: '', csvLine: 0, errorMessage: '' };
            let afterSave
            // let afterSave: any;
            isUpdate = this.chains.find(c => {
                return c.sku === cts.sku;
            });

            if (isUpdate === undefined) {
                this.chain = cts;
                // console.log('undefined --- ' + this.chain.sku);
                if (this.chain.sku.length < 2) {
                    error = error + 1;
                } else {
                    csvObj.csvLine = this.csvToSave.indexOf(cts) + 1;
                    // this.chain.id = isUpdate.id;
                    csvObj.sku = this.chain.sku;
                    csvObj.performed = 'Create';
                    this.subscribeToCSVSaveResponse(csvObj, this.chainService.create(this.chain));
                    // lastCSVObj.status = afterSave.status;
                    // lastCSVObj.errorMessage = afterSave.errorMessage;
                    created = created + 1;
                }
            } else {
                this.chain = cts;
                this.chain.id = isUpdate.id;
                csvObj.csvLine = this.csvToSave.indexOf(cts) + 1;
                csvObj.id = this.chain.id;
                csvObj.sku = this.chain.sku;
                csvObj.performed = 'Update';
                this.subscribeToCSVSaveResponse(csvObj, this.chainService.update(this.chain));
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
            if (this.csvToSave.length > 1000) {
                this.timeoutTime = 1000;
            }
            //$event.preventDefault();
            this.savingCSV = true;
            this.csvImportStatus = 'Importing CSV File...';
            // this.displayDialog2 = true;
            setTimeout(() => {
                // this.loopSaveCSV();
                this.forkJoinFunction();
            }, this.timeoutTime);       
        }
    }

    private subscribeToCSVSaveResponse(csvObj, result: Observable<HttpResponse<IChain>>) {
         result.subscribe((res: HttpResponse<IChain>) => this.onCSVSaveSuccess(res, csvObj), (res: HttpErrorResponse) => this.onCSVSaveError(res, csvObj));
    }

    private onCSVSaveSuccess(res, csvObj) {
        this.isSaving = false;
        // console.log('on success');
        // console.log(res);
        csvObj.status = 'Success';
        this.textCSVSaving = 'success ' + res.body.sku;
        this.lastCSVReport = [...this.lastCSVReport, csvObj];
        // this.messageService.add({severity:'success', summary: 'Success saved', detail: res.body.sku});
    }

    private onCSVSaveError(res, csvObj) {
        this.isSaving = false;
        let resultObjItem = {status: '', errorMessage: ''};
        // console.log('on error before');
        // console.log(res);
        csvObj.status = 'Error';
        csvObj.errorMessage = res.error.detail;
        this.lastCSVReport = [...this.lastCSVReport, csvObj];
        // this.messageService.add({severity:'error', summary: 'Error', detail: res.error.detail});
    }

    forkJoinFunction() {
        const observables = [];
        let chainsToSave: IChain[] = [];
        let chainToSave: IChain = {}; 
        this.lastCSVReport = [];
        console.log('forkjoin');
        for (let cts of this.csvToSave) {
            let isUpdate: any;
            // this.isSaving = true;
            let csvObj = { id: 0, sku: '', performed: '', status: '', csvLine: 0, errorMessage: '' };
            // let afterSave: any;
            isUpdate = this.chains.find(c => {
                return c.sku === cts.sku;
            });

            if (isUpdate === undefined) {
                chainToSave = cts;
                // console.log('undefined --- ' + this.chain.sku);
                if (chainToSave.sku.length < 2) {
                    console.log('sku too short');
                } else {
                    csvObj.csvLine = this.csvToSave.indexOf(cts) + 1;
                    // this.chain.id = isUpdate.id;
                    csvObj.sku = chainToSave.sku;
                    csvObj.performed = 'Create';
                    this.lastCSVReport = [...this.lastCSVReport, csvObj];
                    // observables.push(this.chainService.create(this.chain));
                }
            } else {
                chainToSave = cts;
                chainToSave.id = isUpdate.id;
                csvObj.csvLine = this.csvToSave.indexOf(cts) + 1;
                csvObj.id = chainToSave.id;
                csvObj.sku = chainToSave.sku;
                csvObj.performed = 'Update';
                this.lastCSVReport = [...this.lastCSVReport, csvObj];
                chainsToSave.push(chainToSave);
                //observables.push(this.chainService.update2(this.chain));
            }
            // observables.push(this.subscribeToSaveResponse(this.chainService.update(cts)));
        }

        this.chainService.update2(chainsToSave).subscribe((res) => {
            console.log(res);
            // this.lastCSVReport = res.body;
        }, (err) => {
            console.log(err)
        });

        //forkJoin(observables).subscribe((aaa: any[]) => {
        //    console.log('x');
        //});
        this.csvImportStatus = 'CSV file imported! Reload table.';
        this.messageService.add({ severity: 'success', summary: 'CSV Imported', detail: 'Please check report'});
        // this.loadAll();
    }

    logCSVObj() {
        console.log(this.lastCSVReport);
    }
        
    
    /* Export CSV */
    exportCSV() {

        for (let chain of this.selectedChains) {
            for (let col of this.displayColumns2) {
                if (!col.display) {
                    delete chain[col.field];
                }
            } 
        }
        let csvToExport = this.papa.unparse(this.selectedChains);
        console.log(csvToExport);
        let hiddenElement = document.createElement('a');

        hiddenElement.href = 'data:attachment/text,' + encodeURI(csvToExport);
        hiddenElement.target = '_blank';
        hiddenElement.download = 'myFile.csv';
        hiddenElement.click();
    }

    /* NORMAL SAVE */
    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.chain.id !== undefined) {
            this.subscribeToSaveResponse(this.chainService.update(this.chain));
        } else {
            this.subscribeToSaveResponse(this.chainService.create(this.chain));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IChain>>) {
        result.subscribe((res: HttpResponse<IChain>) => this.onSaveSuccess(res), (res: HttpErrorResponse) => this.onSaveError(res));
    }

    private onSaveSuccess(res) {
        this.isSaving = false;
        console.log('on success');
        console.log(res);
        this.messageService.add({ severity: 'success', summary: 'Success saved', detail: res.body.sku });
        // this.previousState();
    }

    private onSaveError(res) {
        this.isSaving = false;
        console.log('on error')
        console.log(res);
        this.messageService.add({ severity: 'error', summary: 'Error', detail: res.error.detail });
    }

    /* Delete Chains */
    deleteItems() {
        console.log('on delete selected');
        if (this.selectedChains.length > 100) {
            this.timeoutTime = 30000;
        } else if (this.selectedChains.length > 50) {
            this.timeoutTime = 15000;
        } else if (this.selectedChains.length < 3) {
            this.timeoutTime = 1000;
        }
        setTimeout(() => {
            for (let chain of this.selectedChains) {
                console.log(chain.sku)
                this.confirmDelete(chain.id)
            }
            this.displayDialog = false;
            this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Items deleted' });
        }, this.timeoutTime)
        
    }


    confirmDeleteSelected() {
        this.dialogContent = "Are you sure you want to delete those Chains?"
        this.displayDialog = true; 
    }

    confirmDelete(id: number) {
        this.chainService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'chainListModification',
                content: 'Deleted an chain'
            });
        }, (err) => {
            console.log('err');
            console.log(err);
            this.messageService.add({ severity: 'error', summary: 'Error', detail: err.error.detail });

        });
    }

    /* Filters */

    onDirtCCChange(event, dt) {
        if (this.dirtCCTimeout) {
            clearTimeout(this.dirtCCTimeout);
        }

        this.dirtCCTimeout = setTimeout(() => {
            dt.filter(event.value, 'maxdirtStreet', 'gt');
        }, 250);
    }

    onStreetCCChange(event, dt) {
        if (this.streetCCTimeout) {
            clearTimeout(this.streetCCTimeout);
        }

        this.streetCCTimeout = setTimeout(() => {
            dt.filter(event.value, 'maxccStreet', 'gt');
        }, 250);
    }

    /* GETTER AND SETTER */
    get chain() {
        return this._chain;
    }

    set chain(chain: IChain) {
        this._chain = chain;
    }
}
