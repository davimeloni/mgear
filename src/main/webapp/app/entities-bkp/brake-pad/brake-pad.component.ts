import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBrakePad } from 'app/shared/model/brake-pad.model';
import { Principal } from 'app/core';
import { BrakePadService } from './brake-pad.service';

@Component({
    selector: 'jhi-brake-pad',
    templateUrl: './brake-pad.component.html'
})
export class BrakePadComponent implements OnInit, OnDestroy {
    brakePads: IBrakePad[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private brakePadService: BrakePadService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.brakePadService.query().subscribe(
            (res: HttpResponse<IBrakePad[]>) => {
                this.brakePads = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBrakePads();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBrakePad) {
        return item.id;
    }

    registerChangeInBrakePads() {
        this.eventSubscriber = this.eventManager.subscribe('brakePadListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
