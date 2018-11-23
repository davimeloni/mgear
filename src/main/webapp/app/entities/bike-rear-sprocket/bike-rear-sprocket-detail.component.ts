import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';

@Component({
    selector: 'jhi-bike-rear-sprocket-detail',
    templateUrl: './bike-rear-sprocket-detail.component.html'
})
export class BikeRearSprocketDetailComponent implements OnInit {
    bikeRearSprocket: IBikeRearSprocket;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bikeRearSprocket }) => {
            this.bikeRearSprocket = bikeRearSprocket;
        });
    }

    previousState() {
        window.history.back();
    }
}
