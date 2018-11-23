import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IChain } from 'app/shared/model/chain.model';
import { Principal } from 'app/core';
import { ChainService } from './chain.service';

@Component({
    selector: 'jhi-chain',
    templateUrl: './chain.component.html'
})
export class ChainComponent implements OnInit, OnDestroy {
    chains: IChain[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private chainService: ChainService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.chainService.query().subscribe(
            (res: HttpResponse<IChain[]>) => {
                this.chains = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInChains();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IChain) {
        return item.id;
    }

    registerChangeInChains() {
        this.eventSubscriber = this.eventManager.subscribe('chainListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
