import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBike } from 'app/shared/model/bike.model';
import { Principal } from 'app/core';
import { BikeService } from './bike.service';

@Component({
    selector: 'jhi-bike',
    templateUrl: './bike.component.html'
})
export class BikeComponent implements OnInit, OnDestroy {
    bikes: IBike[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private bikeService: BikeService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.bikeService.query().subscribe(
            (res: HttpResponse<IBike[]>) => {
                this.bikes = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBikes();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBike) {
        return item.id;
    }

    registerChangeInBikes() {
        this.eventSubscriber = this.eventManager.subscribe('bikeListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
