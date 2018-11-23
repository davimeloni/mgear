import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IBikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';
import { BikeBrakeDiscService } from './bike-brake-disc.service';
import { IBike } from 'app/shared/model/bike.model';
import { BikeService } from 'app/entities/bike';

@Component({
    selector: 'jhi-bike-brake-disc-update',
    templateUrl: './bike-brake-disc-update.component.html'
})
export class BikeBrakeDiscUpdateComponent implements OnInit {
    private _bikeBrakeDisc: IBikeBrakeDisc;
    isSaving: boolean;

    bikes: IBike[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private bikeBrakeDiscService: BikeBrakeDiscService,
        private bikeService: BikeService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bikeBrakeDisc }) => {
            this.bikeBrakeDisc = bikeBrakeDisc;
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
        if (this.bikeBrakeDisc.id !== undefined) {
            this.subscribeToSaveResponse(this.bikeBrakeDiscService.update(this.bikeBrakeDisc));
        } else {
            this.subscribeToSaveResponse(this.bikeBrakeDiscService.create(this.bikeBrakeDisc));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBikeBrakeDisc>>) {
        result.subscribe((res: HttpResponse<IBikeBrakeDisc>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
    get bikeBrakeDisc() {
        return this._bikeBrakeDisc;
    }

    set bikeBrakeDisc(bikeBrakeDisc: IBikeBrakeDisc) {
        this._bikeBrakeDisc = bikeBrakeDisc;
    }
}
