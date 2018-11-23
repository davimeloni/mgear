import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IBrakeDisc } from 'app/shared/model/brake-disc.model';
import { BrakeDiscService } from './brake-disc.service';

@Component({
    selector: 'jhi-brake-disc-update',
    templateUrl: './brake-disc-update.component.html'
})
export class BrakeDiscUpdateComponent implements OnInit {
    private _brakeDisc: IBrakeDisc;
    isSaving: boolean;
    eDateDp: any;
    dateDp: any;
    datesentDp: any;
    hAPapprovedDp: any;
    sHAapprovedDp: any;

    constructor(private brakeDiscService: BrakeDiscService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ brakeDisc }) => {
            this.brakeDisc = brakeDisc;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.brakeDisc.id !== undefined) {
            this.subscribeToSaveResponse(this.brakeDiscService.update(this.brakeDisc));
        } else {
            this.subscribeToSaveResponse(this.brakeDiscService.create(this.brakeDisc));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBrakeDisc>>) {
        result.subscribe((res: HttpResponse<IBrakeDisc>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get brakeDisc() {
        return this._brakeDisc;
    }

    set brakeDisc(brakeDisc: IBrakeDisc) {
        this._brakeDisc = brakeDisc;
    }
}
