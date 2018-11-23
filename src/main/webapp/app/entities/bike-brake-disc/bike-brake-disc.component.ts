import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';
import { Principal } from 'app/core';
import { BikeBrakeDiscService } from './bike-brake-disc.service';

@Component({
    selector: 'jhi-bike-brake-disc',
    templateUrl: './bike-brake-disc.component.html'
})
export class BikeBrakeDiscComponent implements OnInit, OnDestroy {
    bikeBrakeDiscs: IBikeBrakeDisc[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private bikeBrakeDiscService: BikeBrakeDiscService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.bikeBrakeDiscService.query().subscribe(
            (res: HttpResponse<IBikeBrakeDisc[]>) => {
                this.bikeBrakeDiscs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBikeBrakeDiscs();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBikeBrakeDisc) {
        return item.id;
    }

    registerChangeInBikeBrakeDiscs() {
        this.eventSubscriber = this.eventManager.subscribe('bikeBrakeDiscListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
