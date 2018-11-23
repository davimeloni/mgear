import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IChain } from 'app/shared/model/chain.model';
import { ChainService } from './chain.service';
import { IBike } from 'app/shared/model/bike.model';
import { BikeService } from 'app/entities/bike';

@Component({
    selector: 'jhi-chain-update',
    templateUrl: './chain-update.component.html'
})
export class ChainUpdateComponent implements OnInit {
    private _chain: IChain;
    isSaving: boolean;

    bikes: IBike[];
    eDateDp: any;

    constructor(
        private jhiAlertService: JhiAlertService,
        private chainService: ChainService,
        private bikeService: BikeService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ chain }) => {
            this.chain = chain;
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
        if (this.chain.id !== undefined) {
            this.subscribeToSaveResponse(this.chainService.update(this.chain));
        } else {
            this.subscribeToSaveResponse(this.chainService.create(this.chain));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IChain>>) {
        result.subscribe((res: HttpResponse<IChain>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
    get chain() {
        return this._chain;
    }

    set chain(chain: IChain) {
        this._chain = chain;
    }
}
