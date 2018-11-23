import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBikeBrakePad } from 'app/shared/model/bike-brake-pad.model';
import { Principal } from 'app/core';
import { BikeBrakePadService } from './bike-brake-pad.service';

@Component({
    selector: 'jhi-bike-brake-pad',
    templateUrl: './bike-brake-pad.component.html'
})
export class BikeBrakePadComponent implements OnInit, OnDestroy {
    bikeBrakePads: IBikeBrakePad[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private bikeBrakePadService: BikeBrakePadService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.bikeBrakePadService.query().subscribe(
            (res: HttpResponse<IBikeBrakePad[]>) => {
                this.bikeBrakePads = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBikeBrakePads();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBikeBrakePad) {
        return item.id;
    }

    registerChangeInBikeBrakePads() {
        this.eventSubscriber = this.eventManager.subscribe('bikeBrakePadListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
