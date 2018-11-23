import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { BikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';
import { BikeRearSprocketService } from './bike-rear-sprocket.service';
import { BikeRearSprocketComponent } from './bike-rear-sprocket.component';
import { BikeRearSprocketDetailComponent } from './bike-rear-sprocket-detail.component';
import { BikeRearSprocketUpdateComponent } from './bike-rear-sprocket-update.component';
import { BikeRearSprocketDeletePopupComponent } from './bike-rear-sprocket-delete-dialog.component';
import { IBikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';

@Injectable({ providedIn: 'root' })
export class BikeRearSprocketResolve implements Resolve<IBikeRearSprocket> {
    constructor(private service: BikeRearSprocketService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((bikeRearSprocket: HttpResponse<BikeRearSprocket>) => bikeRearSprocket.body));
        }
        return of(new BikeRearSprocket());
    }
}

export const bikeRearSprocketRoute: Routes = [
    {
        path: 'bike-rear-sprocket',
        component: BikeRearSprocketComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeRearSprockets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-rear-sprocket/:id/view',
        component: BikeRearSprocketDetailComponent,
        resolve: {
            bikeRearSprocket: BikeRearSprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeRearSprockets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-rear-sprocket/new',
        component: BikeRearSprocketUpdateComponent,
        resolve: {
            bikeRearSprocket: BikeRearSprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeRearSprockets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-rear-sprocket/:id/edit',
        component: BikeRearSprocketUpdateComponent,
        resolve: {
            bikeRearSprocket: BikeRearSprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeRearSprockets'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const bikeRearSprocketPopupRoute: Routes = [
    {
        path: 'bike-rear-sprocket/:id/delete',
        component: BikeRearSprocketDeletePopupComponent,
        resolve: {
            bikeRearSprocket: BikeRearSprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeRearSprockets'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
