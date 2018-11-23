import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IBikeBrakePad } from 'app/shared/model/bike-brake-pad.model';
import { BikeBrakePadService } from './bike-brake-pad.service';
import { IBike } from 'app/shared/model/bike.model';
import { BikeService } from 'app/entities/bike';

@Component({
    selector: 'jhi-bike-brake-pad-update',
    templateUrl: './bike-brake-pad-update.component.html'
})
export class BikeBrakePadUpdateComponent implements OnInit {
    private _bikeBrakePad: IBikeBrakePad;
    isSaving: boolean;

    bikes: IBike[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private bikeBrakePadService: BikeBrakePadService,
        private bikeService: BikeService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bikeBrakePad }) => {
            this.bikeBrakePad = bikeBrakePad;
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
        if (this.bikeBrakePad.id !== undefined) {
            this.subscribeToSaveResponse(this.bikeBrakePadService.update(this.bikeBrakePad));
        } else {
            this.subscribeToSaveResponse(this.bikeBrakePadService.create(this.bikeBrakePad));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBikeBrakePad>>) {
        result.subscribe((res: HttpResponse<IBikeBrakePad>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
    get bikeBrakePad() {
        return this._bikeBrakePad;
    }

    set bikeBrakePad(bikeBrakePad: IBikeBrakePad) {
        this._bikeBrakePad = bikeBrakePad;
    }
}
