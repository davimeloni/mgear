import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBrakeDisc } from 'app/shared/model/brake-disc.model';
import { Principal } from 'app/core';
import { BrakeDiscService } from './brake-disc.service';

@Component({
    selector: 'jhi-brake-disc',
    templateUrl: './brake-disc.component.html'
})
export class BrakeDiscComponent implements OnInit, OnDestroy {
    brakeDiscs: IBrakeDisc[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private brakeDiscService: BrakeDiscService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.brakeDiscService.query().subscribe(
            (res: HttpResponse<IBrakeDisc[]>) => {
                this.brakeDiscs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBrakeDiscs();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBrakeDisc) {
        return item.id;
    }

    registerChangeInBrakeDiscs() {
        this.eventSubscriber = this.eventManager.subscribe('brakeDiscListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
