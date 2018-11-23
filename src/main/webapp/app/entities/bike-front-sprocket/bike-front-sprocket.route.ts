import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { BikeFrontSprocket } from 'app/shared/model/bike-front-sprocket.model';
import { BikeFrontSprocketService } from './bike-front-sprocket.service';
import { BikeFrontSprocketComponent } from './bike-front-sprocket.component';
import { BikeFrontSprocketDetailComponent } from './bike-front-sprocket-detail.component';
import { BikeFrontSprocketUpdateComponent } from './bike-front-sprocket-update.component';
import { BikeFrontSprocketDeletePopupComponent } from './bike-front-sprocket-delete-dialog.component';
import { IBikeFrontSprocket } from 'app/shared/model/bike-front-sprocket.model';

@Injectable({ providedIn: 'root' })
export class BikeFrontSprocketResolve implements Resolve<IBikeFrontSprocket> {
    constructor(private service: BikeFrontSprocketService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((bikeFrontSprocket: HttpResponse<BikeFrontSprocket>) => bikeFrontSprocket.body));
        }
        return of(new BikeFrontSprocket());
    }
}

export const bikeFrontSprocketRoute: Routes = [
    {
        path: 'bike-front-sprocket',
        component: BikeFrontSprocketComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeFrontSprockets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-front-sprocket/:id/view',
        component: BikeFrontSprocketDetailComponent,
        resolve: {
            bikeFrontSprocket: BikeFrontSprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeFrontSprockets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-front-sprocket/new',
        component: BikeFrontSprocketUpdateComponent,
        resolve: {
            bikeFrontSprocket: BikeFrontSprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeFrontSprockets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-front-sprocket/:id/edit',
        component: BikeFrontSprocketUpdateComponent,
        resolve: {
            bikeFrontSprocket: BikeFrontSprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeFrontSprockets'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const bikeFrontSprocketPopupRoute: Routes = [
    {
        path: 'bike-front-sprocket/:id/delete',
        component: BikeFrontSprocketDeletePopupComponent,
        resolve: {
            bikeFrontSprocket: BikeFrontSprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeFrontSprockets'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
