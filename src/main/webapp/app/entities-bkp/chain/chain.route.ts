import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Chain } from 'app/shared/model/chain.model';
import { ChainService } from './chain.service';
import { ChainComponent } from './chain.component';
import { ChainDetailComponent } from './chain-detail.component';
import { ChainUpdateComponent } from './chain-update.component';
import { ChainDeletePopupComponent } from './chain-delete-dialog.component';
import { IChain } from 'app/shared/model/chain.model';

@Injectable({ providedIn: 'root' })
export class ChainResolve implements Resolve<IChain> {
    constructor(private service: ChainService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((chain: HttpResponse<Chain>) => chain.body));
        }
        return of(new Chain());
    }
}

export const chainRoute: Routes = [
    {
        path: 'chain',
        component: ChainComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Chains'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'chain/:id/view',
        component: ChainDetailComponent,
        resolve: {
            chain: ChainResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Chains'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'chain/new',
        component: ChainUpdateComponent,
        resolve: {
            chain: ChainResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Chains'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'chain/:id/edit',
        component: ChainUpdateComponent,
        resolve: {
            chain: ChainResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Chains'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const chainPopupRoute: Routes = [
    {
        path: 'chain/:id/delete',
        component: ChainDeletePopupComponent,
        resolve: {
            chain: ChainResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Chains'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
