import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBike } from 'app/shared/model/bike.model';
import { Principal } from 'app/core';
import { BikeService } from './bike.service';

import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { Papa } from 'ngx-papaparse';

import { IBikeFrontSprocket } from 'app/shared/model/bike-front-sprocket.model';
import { BikeFrontSprocketService } from 'app/entities/bike-front-sprocket';
import { IBikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';
import { BikeRearSprocketService } from 'app/entities/bike-rear-sprocket';
import { IRearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';
import { RearSprocketConvService } from 'app/entities/rear-sprocket-conv';
import { IFrontSprocketConv } from 'app/shared/model/front-sprocket-conv.model';
import { FrontSprocketConvService } from 'app/entities/front-sprocket-conv';
import { IChain } from 'app/shared/model/chain.model';
import { ChainService } from 'app/entities/chain';
import { IBikeBrakePad } from 'app/shared/model/bike-brake-pad.model';
import { BikeBrakePadService } from 'app/entities/bike-brake-pad';
import { IBikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';
import { BikeBrakeDiscService } from 'app/entities/bike-brake-disc';
import { MessageService } from 'primeng/api';

import allCols from './bike-columns';

@Component({
    selector: 'jhi-bike',
    templateUrl: './bike.component.html',
    providers: [MessageService]
})
export class BikeComponent implements OnInit, OnDestroy {
    bikes: IBike[];
    currentAccount: any;
    eventSubscriber: Subscription;

    /* entities */
    private _bike: IBike;
    bikefrontsprockets: IBikeFrontSprocket[];
    bikerearsprockets: IBikeRearSprocket[];
    rearsprocketconvs: IRearSprocketConv[];
    frontsprocketconvs: IFrontSprocketConv[];
    chains: IChain[];
    bikebrakepads: IBikeBrakePad[];
    bikebrakediscs: IBikeBrakeDisc[];

    isSaving: boolean;
    csvToSave: any[];
    selectedBikes: any[];
    displayDialog: boolean = false;
    displayDialog2: boolean = false;
    dialogContent: String;

    isRowChanged = false;

    booleanOptions = [{ value: 'Y', label: 'Y' }, { value: 'N', label: 'N' }];
    strokeOptions = ['2-Stroke','4-Stroke'];
    finalDriveTypeOptions = ['Chain', 'Shaft Belt'];
    oemRearBrakeSystemTypeOptions = ['Disc', 'Drum'];
    oemFrontWheelTypeOptions = ['Cast', 'Forged', 'Spoke'];

    modelType1Options = ['ATV', 'Dirt', 'Side by Side', 'Street' ];
    modelType1Filter = [
        { value: 'ATV', label: 'ATV' },
        { value: 'Dirt', label: 'Dirt' },
        { value: 'Side by Side', label: 'Side by Side' },
        { value: 'Street', label: 'Street' }
    ]

    strokeTest: any;

    displayColumns2: any[];
    modelColumns: any[];
    chainColumns: any[];
    sprocketColumns: any[];
    discColumns: any[];
    padColumns: any[];
    frozenCols: any[];

    lastCSVReport: any[];
    lastCSVObj: any = { id: '', performed: '', status: '', errorMessage: '' };
    dialogLastCSV = false;
    csvImportStatus: string;

    constructor(
        private bikeService: BikeService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal,
        private bikeFrontSprocketService: BikeFrontSprocketService,
        private bikeRearSprocketService: BikeRearSprocketService,
        private rearSprocketConvService: RearSprocketConvService,
        private frontSprocketConvService: FrontSprocketConvService,
        private chainService: ChainService,
        private bikeBrakePadService: BikeBrakePadService,
        private bikeBrakeDiscService: BikeBrakeDiscService,
        private activatedRoute: ActivatedRoute,
        private messageService: MessageService,
        private papa: Papa,
    ) { }

    loadAll() {
        this.bikeService.query().subscribe(
            (res: HttpResponse<IBike[]>) => {
                this.bikes = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );

        /* Load Options */
        this.bikeFrontSprocketService.query().subscribe(
            (res: HttpResponse<IBikeFrontSprocket[]>) => {
                this.bikefrontsprockets = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.bikeRearSprocketService.query().subscribe(
            (res: HttpResponse<IBikeRearSprocket[]>) => {
                this.bikerearsprockets = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.rearSprocketConvService.query().subscribe(
            (res: HttpResponse<IRearSprocketConv[]>) => {
                this.rearsprocketconvs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.frontSprocketConvService.query().subscribe(
            (res: HttpResponse<IFrontSprocketConv[]>) => {
                this.frontsprocketconvs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.chainService.query().subscribe(
            (res: HttpResponse<IChain[]>) => {
                this.chains = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.bikeBrakePadService.query().subscribe(
            (res: HttpResponse<IBikeBrakePad[]>) => {
                this.bikebrakepads = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.bikeBrakeDiscService.query().subscribe(
            (res: HttpResponse<IBikeBrakeDisc[]>) => {
                this.bikebrakediscs = res.body;
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
        this.registerChangeInBikes();
        this.chainColumns = [];
        this.sprocketColumns = [];
        this.discColumns = [];
        this.padColumns = [];
        this.modelColumns = [];
        this.displayColumns2 = allCols;
        this.chainColumns = allCols.filter(c => c.group === 'Chain Info');
        this.modelColumns = allCols.filter(c => c.group === 'Bike Model Info');
        this.sprocketColumns = allCols.filter(c => c.group === 'Sprocket Info');
        this.discColumns = allCols.filter(c => c.group === 'Brake Disc');
        this.padColumns = allCols.filter(c => c.group === 'Brake Pad');
        /*
        for (let col of allCols) {
            if (col.group === 'Bike Model Info') {
                this.modelColumns.push(col);
            } else if (col.group === 'Chain Info') {
                this.chainColumns.push(col);
            } else if (col.group === 'Sprocket Info') {
                this.sprocketColumns.push(col);
            } else if (col.group === 'Brake Disc') {
                this.discColumns.push(col);
            } else if (col.group === 'Brake Pad') {
                this.padColumns.push(col);
            }
        }
        */
    }

    reloadAll() {
        this.bikeService.query().subscribe(
            (res: HttpResponse<IBike[]>) => {
                this.bikes = res.body;
                this.messageService.add({ severity: 'success', summary: 'Data Successfully Updated'});
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );

        /* Load Options */
        this.bikeFrontSprocketService.query().subscribe(
            (res: HttpResponse<IBikeFrontSprocket[]>) => {
                this.bikefrontsprockets = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.bikeRearSprocketService.query().subscribe(
            (res: HttpResponse<IBikeRearSprocket[]>) => {
                this.bikerearsprockets = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.rearSprocketConvService.query().subscribe(
            (res: HttpResponse<IRearSprocketConv[]>) => {
                this.rearsprocketconvs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.frontSprocketConvService.query().subscribe(
            (res: HttpResponse<IFrontSprocketConv[]>) => {
                this.frontsprocketconvs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.chainService.query().subscribe(
            (res: HttpResponse<IChain[]>) => {
                this.chains = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.bikeBrakePadService.query().subscribe(
            (res: HttpResponse<IBikeBrakePad[]>) => {
                this.bikebrakepads = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.bikeBrakeDiscService.query().subscribe(
            (res: HttpResponse<IBikeBrakeDisc[]>) => {
                this.bikebrakediscs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBike) {
        return item.id;
    }

    registerChangeInBikes() {
        this.eventSubscriber = this.eventManager.subscribe('bikeListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    /* Rows */
    saveRow(row) {
        console.log(row);
        this.bike = row;
        if (this.isRowChanged) {
            this.isSaving = true;
            this.subscribeToSaveResponse(this.bikeService.update(this.bike));
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
            col.display = true;
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


    /* Update Bike */
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
            let csvObj = { id: 0, performed: '', status: '', errorMessage: '' };
            let afterSave
            // let afterSave: any;
            isUpdate = this.bikes.find(c => c.id === this.bike.id);

            if (isUpdate === undefined) {
                this.bike = cts;
                // console.log('undefined --- ' + this.chain.sku);
                if (this.bike.id < 2) {
                    error = error + 1;
                } else {
                    this.bike.id = isUpdate.id;
                    // csvObj.sku = this.chain.sku;
                    csvObj.performed = 'Create';
                    this.subscribeToCSVSaveResponse(csvObj, this.bikeService.create(this.bike));
                    // lastCSVObj.status = afterSave.status;
                    // lastCSVObj.errorMessage = afterSave.errorMessage;
                    created = created + 1;
                }
            } else {
                this.bike = cts;
                this.bike.id = isUpdate.id;
                csvObj.id = this.bike.id;
                // csvObj.sku = this.chain.sku;
                csvObj.performed = 'Update';
                this.subscribeToCSVSaveResponse(csvObj, this.bikeService.update(this.bike));
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

    private subscribeToCSVSaveResponse(csvObj, result: Observable<HttpResponse<IBike>>) {
         result.subscribe((res: HttpResponse<IBike>) => this.onCSVSaveSuccess(res, csvObj), (res: HttpErrorResponse) => this.onCSVSaveError(res, csvObj));
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

    forkJoinFunction() {
        const observables = [];
        let bikesToSave: IBike[] = [];
        let bikeToSave: IBike = {}; 
        this.lastCSVReport = [];
        console.log('forkjoin');
        for (let cts of this.csvToSave) {
            let isUpdate: any;
            // this.isSaving = true;
            let csvObj = { id: 0, sku: '', performed: '', status: '', csvLine: 0, errorMessage: '' };
            // let afterSave: any;
            isUpdate = this.bikes.find(c => {
                return c.id === cts.id;
            });

            if (isUpdate === undefined) {
                bikeToSave = cts;
                // console.log(cts);
                // console.log(bikeToSave);
                csvObj.csvLine = this.csvToSave.indexOf(cts) + 1;
                // this.chain.id = isUpdate.id;
                csvObj.performed = 'Create';
                bikesToSave.push(bikeToSave);
                this.lastCSVReport = [...this.lastCSVReport, csvObj];
                // observables.push(this.chainService.create(this.chain));

            } else {
                bikeToSave = cts;
                bikeToSave.id = isUpdate.id;
                csvObj.csvLine = this.csvToSave.indexOf(cts) + 1;
                csvObj.id = bikeToSave.id;
                csvObj.performed = 'Update';
                this.lastCSVReport = [...this.lastCSVReport, csvObj];
                bikesToSave.push(bikeToSave);
                //observables.push(this.chainService.update2(this.chain));
            }
            // observables.push(this.subscribeToSaveResponse(this.chainService.update(cts)));
        }

        console.log(bikesToSave);

        this.bikeService.saveCSV(bikesToSave).subscribe((res) => {
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

    /* Normal Save */
    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.bike.id !== undefined) {
            this.subscribeToSaveResponse(this.bikeService.update(this.bike));
        } else {
            this.subscribeToSaveResponse(this.bikeService.create(this.bike));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBike>>) {
        result.subscribe((res: HttpResponse<IBike>) => this.onSaveSuccess(res), (res: HttpErrorResponse) => this.onSaveError(res));
    }

    private onSaveSuccess(res) {
        this.isSaving = false;
        this.messageService.add({ severity: 'success', summary: 'Success saved', detail: res.body.id });
        // this.previousState();
    }

    private onSaveError(res) {
        this.isSaving = false;
        this.messageService.add({ severity: 'error', summary: 'Error', detail: res.error.detail });
    }

    /* Delete Bikes */
    deleteItems() {
        console.log('on delete selected')
        for (let bike of this.selectedBikes) {
            console.log(bike.id)
            this.confirmDelete(bike.id)
        }
        this.displayDialog=false;
    }

    confirmDeleteSelected() {
        this.dialogContent = "Are you sure you want to delete those Bikes?"
        this.displayDialog = true;
    }

    confirmDelete(id: number) {
        this.bikeService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'bikeListModification',
                content: 'Deleted an bike'
            });
        });
    }

    /* Track options */
    trackBikeFrontSprocketById(index: number, item: IBikeFrontSprocket) {
        return item.id;
    }

    trackBikeRearSprocketById(index: number, item: IBikeRearSprocket) {
        return item.id;
    }

    trackRearSprocketConvById(index: number, item: IRearSprocketConv) {
        return item.id;
    }

    trackFrontSprocketConvById(index: number, item: IFrontSprocketConv) {
        return item.id;
    }

    trackChainById(index: number, item: IChain) {
        return item.id;
    }

    trackBikeBrakePadById(index: number, item: IBikeBrakePad) {
        return item.id;
    }

    trackBikeBrakeDiscById(index: number, item: IBikeBrakeDisc) {
        return item.id;
    }

    // Revisit this method
    getSelected(selectedVals: Array<any>, option: any) {
        if (selectedVals) {
            for (let i = 0; i < selectedVals.length; i++) {
                if (option.id === selectedVals[i].id) {
                    return selectedVals[i];
                }
            }
        }
        return option;
    }

    /* GETTERS AND SETTERS */
    get bike() {
        return this._bike;
    }

    set bike(bike: IBike) {
        this._bike = bike;
    }

    /* auto fill logic */
    autoFillChain(rowData) {
        this.bike = rowData
        console.log(this.bike.modeltype1);
        console.log(this.bike.capacity);
        console.log(this.bike.oemChainSize);
        console.log(this.bike.oemChainLinks);
        if (this.bike.modeltype1 == null || this.bike.capacity == null || this.bike.oemChainSize == null || this.bike.oemChainLinks == null) {
            this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Please fill all necessary fields' });                       
        } else {
            if (this.bike.modeltype1 == 'Street') {
                for (let chain of this.chains) {
                    if (this.bike.capacity <= chain.maxccStreet && this.bike.oemChainSize == chain.chainSize && this.bike.oemChainLinks == chain.chainLinks) {
                        console.log('adding ' + chain.sku + ' to the bike');
                        this.bike.chains.push(chain);
                    }
                }      
            } else if (this.bike.modeltype1 == 'Dirt') {
                for (let chain of this.chains) {
                    if (this.bike.capacity <= chain.maxccDirt && this.bike.oemChainSize == chain.chainSize && this.bike.oemChainLinks == chain.chainLinks) {
                        console.log('adding ' + chain.sku + ' to the bike');
                        this.bike.chains.push(chain);
                    }
                } 
            }
            
            console.log('bike autofillchain');
            console.log(this.bike);
            this.save();
            this.isSaving = false;
        }
    }

    removeChain(chain, bike) {
        console.log('bike chains before');
        console.log(bike.chains);

        bike.chains = bike.chains.filter((c) => {
            return c.sku !== chain.sku;
        })
        console.log('bike chains after');
        console.log(bike.chains);
        this.bike = bike;
        console.log(this.bike);
        this.save();
    }

    /*
    autoFillFrontSprockets() {

    }

    autoFillRearSprockets() {

    }
    */
}
