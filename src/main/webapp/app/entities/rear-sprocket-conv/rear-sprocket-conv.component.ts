import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';
import { Principal } from 'app/core';
import { RearSprocketConvService } from './rear-sprocket-conv.service';

@Component({
    selector: 'jhi-rear-sprocket-conv',
    templateUrl: './rear-sprocket-conv.component.html'
})
export class RearSprocketConvComponent implements OnInit, OnDestroy {
    rearSprocketConvs: IRearSprocketConv[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rearSprocketConvService: RearSprocketConvService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.rearSprocketConvService.query().subscribe(
            (res: HttpResponse<IRearSprocketConv[]>) => {
                this.rearSprocketConvs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRearSprocketConvs();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRearSprocketConv) {
        return item.id;
    }

    registerChangeInRearSprocketConvs() {
        this.eventSubscriber = this.eventManager.subscribe('rearSprocketConvListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
