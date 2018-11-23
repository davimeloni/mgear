import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IRearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';
import { RearSprocketConvService } from './rear-sprocket-conv.service';
import { IBike } from 'app/shared/model/bike.model';
import { BikeService } from 'app/entities/bike';

@Component({
    selector: 'jhi-rear-sprocket-conv-update',
    templateUrl: './rear-sprocket-conv-update.component.html'
})
export class RearSprocketConvUpdateComponent implements OnInit {
    private _rearSprocketConv: IRearSprocketConv;
    isSaving: boolean;

    bikes: IBike[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private rearSprocketConvService: RearSprocketConvService,
        private bikeService: BikeService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ rearSprocketConv }) => {
            this.rearSprocketConv = rearSprocketConv;
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
        if (this.rearSprocketConv.id !== undefined) {
            this.subscribeToSaveResponse(this.rearSprocketConvService.update(this.rearSprocketConv));
        } else {
            this.subscribeToSaveResponse(this.rearSprocketConvService.create(this.rearSprocketConv));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRearSprocketConv>>) {
        result.subscribe((res: HttpResponse<IRearSprocketConv>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
    get rearSprocketConv() {
        return this._rearSprocketConv;
    }

    set rearSprocketConv(rearSprocketConv: IRearSprocketConv) {
        this._rearSprocketConv = rearSprocketConv;
    }
}
