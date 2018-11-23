import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';

@Component({
    selector: 'jhi-bike-brake-disc-detail',
    templateUrl: './bike-brake-disc-detail.component.html'
})
export class BikeBrakeDiscDetailComponent implements OnInit {
    bikeBrakeDisc: IBikeBrakeDisc;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bikeBrakeDisc }) => {
            this.bikeBrakeDisc = bikeBrakeDisc;
        });
    }

    previousState() {
        window.history.back();
    }
}
