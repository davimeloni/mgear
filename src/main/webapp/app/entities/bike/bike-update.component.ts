import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IBike } from 'app/shared/model/bike.model';
import { BikeService } from './bike.service';
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

@Component({
    selector: 'jhi-bike-update',
    templateUrl: './bike-update.component.html'
})
export class BikeUpdateComponent implements OnInit {
    private _bike: IBike;
    isSaving: boolean;

    bikefrontsprockets: IBikeFrontSprocket[];

    bikerearsprockets: IBikeRearSprocket[];

    rearsprocketconvs: IRearSprocketConv[];

    frontsprocketconvs: IFrontSprocketConv[];

    chains: IChain[];

    bikebrakepads: IBikeBrakePad[];

    bikebrakediscs: IBikeBrakeDisc[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private bikeService: BikeService,
        private bikeFrontSprocketService: BikeFrontSprocketService,
        private bikeRearSprocketService: BikeRearSprocketService,
        private rearSprocketConvService: RearSprocketConvService,
        private frontSprocketConvService: FrontSprocketConvService,
        private chainService: ChainService,
        private bikeBrakePadService: BikeBrakePadService,
        private bikeBrakeDiscService: BikeBrakeDiscService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bike }) => {
            this.bike = bike;
        });
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
        result.subscribe((res: HttpResponse<IBike>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

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
    get bike() {
        return this._bike;
    }

    set bike(bike: IBike) {
        this._bike = bike;
    }
}
