import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IFrontSprocketConv } from 'app/shared/model/front-sprocket-conv.model';
import { FrontSprocketConvService } from './front-sprocket-conv.service';
import { IBike } from 'app/shared/model/bike.model';
import { BikeService } from 'app/entities/bike';

@Component({
    selector: 'jhi-front-sprocket-conv-update',
    templateUrl: './front-sprocket-conv-update.component.html'
})
export class FrontSprocketConvUpdateComponent implements OnInit {
    private _frontSprocketConv: IFrontSprocketConv;
    isSaving: boolean;

    bikes: IBike[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private frontSprocketConvService: FrontSprocketConvService,
        private bikeService: BikeService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ frontSprocketConv }) => {
            this.frontSprocketConv = frontSprocketConv;
        });
        this.bikeService.query().subscribe(
            (res: HttpResponse<IBike[]>) => {
                this.bikes = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.frontSprocketConv.id !== undefined) {
            this.subscribeToSaveResponse(this.frontSprocketConvService.update(this.frontSprocketConv));
        } else {
            this.subscribeToSaveResponse(this.frontSprocketConvService.create(this.frontSprocketConv));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IFrontSprocketConv>>) {
        result.subscribe((res: HttpResponse<IFrontSprocketConv>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackBikeById(index: number, item: IBike) {
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
    get frontSprocketConv() {
        return this._frontSprocketConv;
    }

    set frontSprocketConv(frontSprocketConv: IFrontSprocketConv) {
        this._frontSprocketConv = frontSprocketConv;
    }
}
