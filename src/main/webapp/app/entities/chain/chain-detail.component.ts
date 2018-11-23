import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IChain } from 'app/shared/model/chain.model';

@Component({
    selector: 'jhi-chain-detail',
    templateUrl: './chain-detail.component.html'
})
export class ChainDetailComponent implements OnInit {
    chain: IChain;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ chain }) => {
            this.chain = chain;
        });
    }

    previousState() {
        window.history.back();
    }
}
