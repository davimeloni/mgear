import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBrakeDisc } from 'app/shared/model/brake-disc.model';

@Component({
    selector: 'jhi-brake-disc-detail',
    templateUrl: './brake-disc-detail.component.html'
})
export class BrakeDiscDetailComponent implements OnInit {
    brakeDisc: IBrakeDisc;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ brakeDisc }) => {
            this.brakeDisc = brakeDisc;
        });
    }

    previousState() {
        window.history.back();
    }
}
