import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { BrakeDisc } from 'app/shared/model/brake-disc.model';
import { BrakeDiscService } from './brake-disc.service';
import { BrakeDiscComponent } from './brake-disc.component';
import { BrakeDiscDetailComponent } from './brake-disc-detail.component';
import { BrakeDiscUpdateComponent } from './brake-disc-update.component';
import { BrakeDiscDeletePopupComponent } from './brake-disc-delete-dialog.component';
import { IBrakeDisc } from 'app/shared/model/brake-disc.model';

@Injectable({ providedIn: 'root' })
export class BrakeDiscResolve implements Resolve<IBrakeDisc> {
    constructor(private service: BrakeDiscService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((brakeDisc: HttpResponse<BrakeDisc>) => brakeDisc.body));
        }
        return of(new BrakeDisc());
    }
}

export const brakeDiscRoute: Routes = [
    {
        path: 'brake-disc',
        component: BrakeDiscComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BrakeDiscs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'brake-disc/:id/view',
        component: BrakeDiscDetailComponent,
        resolve: {
            brakeDisc: BrakeDiscResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BrakeDiscs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'brake-disc/new',
        component: BrakeDiscUpdateComponent,
        resolve: {
            brakeDisc: BrakeDiscResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BrakeDiscs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'brake-disc/:id/edit',
        component: BrakeDiscUpdateComponent,
        resolve: {
            brakeDisc: BrakeDiscResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BrakeDiscs'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const brakeDiscPopupRoute: Routes = [
    {
        path: 'brake-disc/:id/delete',
        component: BrakeDiscDeletePopupComponent,
        resolve: {
            brakeDisc: BrakeDiscResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BrakeDiscs'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
