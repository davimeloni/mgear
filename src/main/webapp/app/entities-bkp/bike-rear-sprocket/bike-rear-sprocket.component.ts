import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';
import { Principal } from 'app/core';
import { BikeRearSprocketService } from './bike-rear-sprocket.service';

@Component({
    selector: 'jhi-bike-rear-sprocket',
    templateUrl: './bike-rear-sprocket.component.html'
})
export class BikeRearSprocketComponent implements OnInit, OnDestroy {
    bikeRearSprockets: IBikeRearSprocket[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private bikeRearSprocketService: BikeRearSprocketService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.bikeRearSprocketService.query().subscribe(
            (res: HttpResponse<IBikeRearSprocket[]>) => {
                this.bikeRearSprockets = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBikeRearSprockets();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBikeRearSprocket) {
        return item.id;
    }

    registerChangeInBikeRearSprockets() {
        this.eventSubscriber = this.eventManager.subscribe('bikeRearSprocketListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
