import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';

@Component({
    selector: 'jhi-rear-sprocket-conv-detail',
    templateUrl: './rear-sprocket-conv-detail.component.html'
})
export class RearSprocketConvDetailComponent implements OnInit {
    rearSprocketConv: IRearSprocketConv;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ rearSprocketConv }) => {
            this.rearSprocketConv = rearSprocketConv;
        });
    }

    previousState() {
        window.history.back();
    }
}
