import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBrakePad } from 'app/shared/model/brake-pad.model';

@Component({
    selector: 'jhi-brake-pad-detail',
    templateUrl: './brake-pad-detail.component.html'
})
export class BrakePadDetailComponent implements OnInit {
    brakePad: IBrakePad;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ brakePad }) => {
            this.brakePad = brakePad;
        });
    }

    previousState() {
        window.history.back();
    }
}
