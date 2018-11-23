import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBikeFrontSprocket } from 'app/shared/model/bike-front-sprocket.model';
import { Principal } from 'app/core';
import { BikeFrontSprocketService } from './bike-front-sprocket.service';

@Component({
    selector: 'jhi-bike-front-sprocket',
    templateUrl: './bike-front-sprocket.component.html'
})
export class BikeFrontSprocketComponent implements OnInit, OnDestroy {
    bikeFrontSprockets: IBikeFrontSprocket[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private bikeFrontSprocketService: BikeFrontSprocketService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.bikeFrontSprocketService.query().subscribe(
            (res: HttpResponse<IBikeFrontSprocket[]>) => {
                this.bikeFrontSprockets = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBikeFrontSprockets();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBikeFrontSprocket) {
        return item.id;
    }

    registerChangeInBikeFrontSprockets() {
        this.eventSubscriber = this.eventManager.subscribe('bikeFrontSprocketListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
