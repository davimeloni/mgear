import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Bike } from 'app/shared/model/bike.model';
import { BikeService } from './bike.service';
import { BikeComponent } from './bike.component';
import { BikeDetailComponent } from './bike-detail.component';
import { BikeUpdateComponent } from './bike-update.component';
import { BikeDeletePopupComponent } from './bike-delete-dialog.component';
import { IBike } from 'app/shared/model/bike.model';

@Injectable({ providedIn: 'root' })
export class BikeResolve implements Resolve<IBike> {
    constructor(private service: BikeService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((bike: HttpResponse<Bike>) => bike.body));
        }
        return of(new Bike());
    }
}

export const bikeRoute: Routes = [
    {
        path: 'bike',
        component: BikeComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Bikes'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike/:id/view',
        component: BikeDetailComponent,
        resolve: {
            bike: BikeResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Bikes'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike/new',
        component: BikeUpdateComponent,
        resolve: {
            bike: BikeResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Bikes'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike/:id/edit',
        component: BikeUpdateComponent,
        resolve: {
            bike: BikeResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Bikes'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const bikePopupRoute: Routes = [
    {
        path: 'bike/:id/delete',
        component: BikeDeletePopupComponent,
        resolve: {
            bike: BikeResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Bikes'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
