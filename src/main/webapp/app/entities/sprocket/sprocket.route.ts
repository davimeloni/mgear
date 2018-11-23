import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Sprocket } from 'app/shared/model/sprocket.model';
import { SprocketService } from './sprocket.service';
import { SprocketComponent } from './sprocket.component';
import { SprocketDetailComponent } from './sprocket-detail.component';
import { SprocketUpdateComponent } from './sprocket-update.component';
import { SprocketDeletePopupComponent } from './sprocket-delete-dialog.component';
import { ISprocket } from 'app/shared/model/sprocket.model';

@Injectable({ providedIn: 'root' })
export class SprocketResolve implements Resolve<ISprocket> {
    constructor(private service: SprocketService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((sprocket: HttpResponse<Sprocket>) => sprocket.body));
        }
        return of(new Sprocket());
    }
}

export const sprocketRoute: Routes = [
    {
        path: 'sprocket',
        component: SprocketComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Sprockets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'sprocket/:id/view',
        component: SprocketDetailComponent,
        resolve: {
            sprocket: SprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Sprockets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'sprocket/new',
        component: SprocketUpdateComponent,
        resolve: {
            sprocket: SprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Sprockets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'sprocket/:id/edit',
        component: SprocketUpdateComponent,
        resolve: {
            sprocket: SprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Sprockets'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sprocketPopupRoute: Routes = [
    {
        path: 'sprocket/:id/delete',
        component: SprocketDeletePopupComponent,
        resolve: {
            sprocket: SprocketResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Sprockets'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
