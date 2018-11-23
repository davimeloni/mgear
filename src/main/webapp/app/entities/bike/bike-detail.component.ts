import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBike } from 'app/shared/model/bike.model';

@Component({
    selector: 'jhi-bike-detail',
    templateUrl: './bike-detail.component.html'
})
export class BikeDetailComponent implements OnInit {
    bike: IBike;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bike }) => {
            this.bike = bike;
        });
    }

    previousState() {
        window.history.back();
    }
}
