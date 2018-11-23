import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IBikeFrontSprocket } from 'app/shared/model/bike-front-sprocket.model';
import { BikeFrontSprocketService } from './bike-front-sprocket.service';
import { IBike } from 'app/shared/model/bike.model';
import { BikeService } from 'app/entities/bike';

@Component({
    selector: 'jhi-bike-front-sprocket-update',
    templateUrl: './bike-front-sprocket-update.component.html'
})
export class BikeFrontSprocketUpdateComponent implements OnInit {
    private _bikeFrontSprocket: IBikeFrontSprocket;
    isSaving: boolean;

    bikes: IBike[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private bikeFrontSprocketService: BikeFrontSprocketService,
        private bikeService: BikeService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bikeFrontSprocket }) => {
            this.bikeFrontSprocket = bikeFrontSprocket;
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
        if (this.bikeFrontSprocket.id !== undefined) {
            this.subscribeToSaveResponse(this.bikeFrontSprocketService.update(this.bikeFrontSprocket));
        } else {
            this.subscribeToSaveResponse(this.bikeFrontSprocketService.create(this.bikeFrontSprocket));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBikeFrontSprocket>>) {
        result.subscribe((res: HttpResponse<IBikeFrontSprocket>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
    get bikeFrontSprocket() {
        return this._bikeFrontSprocket;
    }

    set bikeFrontSprocket(bikeFrontSprocket: IBikeFrontSprocket) {
        this._bikeFrontSprocket = bikeFrontSprocket;
    }
}
