import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IBikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';
import { BikeRearSprocketService } from './bike-rear-sprocket.service';
import { IBike } from 'app/shared/model/bike.model';
import { BikeService } from 'app/entities/bike';

@Component({
    selector: 'jhi-bike-rear-sprocket-update',
    templateUrl: './bike-rear-sprocket-update.component.html'
})
export class BikeRearSprocketUpdateComponent implements OnInit {
    private _bikeRearSprocket: IBikeRearSprocket;
    isSaving: boolean;

    bikes: IBike[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private bikeRearSprocketService: BikeRearSprocketService,
        private bikeService: BikeService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bikeRearSprocket }) => {
            this.bikeRearSprocket = bikeRearSprocket;
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
        if (this.bikeRearSprocket.id !== undefined) {
            this.subscribeToSaveResponse(this.bikeRearSprocketService.update(this.bikeRearSprocket));
        } else {
            this.subscribeToSaveResponse(this.bikeRearSprocketService.create(this.bikeRearSprocket));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBikeRearSprocket>>) {
        result.subscribe((res: HttpResponse<IBikeRearSprocket>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
    get bikeRearSprocket() {
        return this._bikeRearSprocket;
    }

    set bikeRearSprocket(bikeRearSprocket: IBikeRearSprocket) {
        this._bikeRearSprocket = bikeRearSprocket;
    }
}
