import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IFrontSprocketConv } from 'app/shared/model/front-sprocket-conv.model';
import { Principal } from 'app/core';
import { FrontSprocketConvService } from './front-sprocket-conv.service';

@Component({
    selector: 'jhi-front-sprocket-conv',
    templateUrl: './front-sprocket-conv.component.html'
})
export class FrontSprocketConvComponent implements OnInit, OnDestroy {
    frontSprocketConvs: IFrontSprocketConv[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private frontSprocketConvService: FrontSprocketConvService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.frontSprocketConvService.query().subscribe(
            (res: HttpResponse<IFrontSprocketConv[]>) => {
                this.frontSprocketConvs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInFrontSprocketConvs();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IFrontSprocketConv) {
        return item.id;
    }

    registerChangeInFrontSprocketConvs() {
        this.eventSubscriber = this.eventManager.subscribe('frontSprocketConvListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
