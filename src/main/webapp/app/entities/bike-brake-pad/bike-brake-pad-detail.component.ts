import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBikeBrakePad } from 'app/shared/model/bike-brake-pad.model';

@Component({
    selector: 'jhi-bike-brake-pad-detail',
    templateUrl: './bike-brake-pad-detail.component.html'
})
export class BikeBrakePadDetailComponent implements OnInit {
    bikeBrakePad: IBikeBrakePad;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bikeBrakePad }) => {
            this.bikeBrakePad = bikeBrakePad;
        });
    }

    previousState() {
        window.history.back();
    }
}
