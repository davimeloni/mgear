import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBikeFrontSprocket } from 'app/shared/model/bike-front-sprocket.model';

@Component({
    selector: 'jhi-bike-front-sprocket-detail',
    templateUrl: './bike-front-sprocket-detail.component.html'
})
export class BikeFrontSprocketDetailComponent implements OnInit {
    bikeFrontSprocket: IBikeFrontSprocket;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bikeFrontSprocket }) => {
            this.bikeFrontSprocket = bikeFrontSprocket;
        });
    }

    previousState() {
        window.history.back();
    }
}
