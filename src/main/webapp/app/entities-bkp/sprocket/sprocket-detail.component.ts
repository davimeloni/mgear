import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ISprocket } from 'app/shared/model/sprocket.model';

@Component({
    selector: 'jhi-sprocket-detail',
    templateUrl: './sprocket-detail.component.html'
})
export class SprocketDetailComponent implements OnInit {
    sprocket: ISprocket;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ sprocket }) => {
            this.sprocket = sprocket;
        });
    }

    previousState() {
        window.history.back();
    }
}
