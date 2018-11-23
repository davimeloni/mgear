import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IBrakePad } from 'app/shared/model/brake-pad.model';
import { BrakePadService } from './brake-pad.service';

@Component({
    selector: 'jhi-brake-pad-update',
    templateUrl: './brake-pad-update.component.html'
})
export class BrakePadUpdateComponent implements OnInit {
    private _brakePad: IBrakePad;
    isSaving: boolean;
    eDateDp: any;

    constructor(private brakePadService: BrakePadService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ brakePad }) => {
            this.brakePad = brakePad;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.brakePad.id !== undefined) {
            this.subscribeToSaveResponse(this.brakePadService.update(this.brakePad));
        } else {
            this.subscribeToSaveResponse(this.brakePadService.create(this.brakePad));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBrakePad>>) {
        result.subscribe((res: HttpResponse<IBrakePad>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get brakePad() {
        return this._brakePad;
    }

    set brakePad(brakePad: IBrakePad) {
        this._brakePad = brakePad;
    }
}
