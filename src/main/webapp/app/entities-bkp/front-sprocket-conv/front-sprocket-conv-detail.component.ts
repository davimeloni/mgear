import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IFrontSprocketConv } from 'app/shared/model/front-sprocket-conv.model';

@Component({
    selector: 'jhi-front-sprocket-conv-detail',
    templateUrl: './front-sprocket-conv-detail.component.html'
})
export class FrontSprocketConvDetailComponent implements OnInit {
    frontSprocketConv: IFrontSprocketConv;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ frontSprocketConv }) => {
            this.frontSprocketConv = frontSprocketConv;
        });
    }

    previousState() {
        window.history.back();
    }
}
