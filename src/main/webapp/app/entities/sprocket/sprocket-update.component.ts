import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ISprocket } from 'app/shared/model/sprocket.model';
import { SprocketService } from './sprocket.service';

@Component({
    selector: 'jhi-sprocket-update',
    templateUrl: './sprocket-update.component.html'
})
export class SprocketUpdateComponent implements OnInit {
    private _sprocket: ISprocket;
    isSaving: boolean;
    eDateDp: any;

    constructor(private sprocketService: SprocketService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ sprocket }) => {
            this.sprocket = sprocket;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.sprocket.id !== undefined) {
            this.subscribeToSaveResponse(this.sprocketService.update(this.sprocket));
        } else {
            this.subscribeToSaveResponse(this.sprocketService.create(this.sprocket));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ISprocket>>) {
        result.subscribe((res: HttpResponse<ISprocket>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get sprocket() {
        return this._sprocket;
    }

    set sprocket(sprocket: ISprocket) {
        this._sprocket = sprocket;
    }
}
