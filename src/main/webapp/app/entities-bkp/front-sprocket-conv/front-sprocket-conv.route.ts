import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { FrontSprocketConv } from 'app/shared/model/front-sprocket-conv.model';
import { FrontSprocketConvService } from './front-sprocket-conv.service';
import { FrontSprocketConvComponent } from './front-sprocket-conv.component';
import { FrontSprocketConvDetailComponent } from './front-sprocket-conv-detail.component';
import { FrontSprocketConvUpdateComponent } from './front-sprocket-conv-update.component';
import { FrontSprocketConvDeletePopupComponent } from './front-sprocket-conv-delete-dialog.component';
import { IFrontSprocketConv } from 'app/shared/model/front-sprocket-conv.model';

@Injectable({ providedIn: 'root' })
export class FrontSprocketConvResolve implements Resolve<IFrontSprocketConv> {
    constructor(private service: FrontSprocketConvService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((frontSprocketConv: HttpResponse<FrontSprocketConv>) => frontSprocketConv.body));
        }
        return of(new FrontSprocketConv());
    }
}

export const frontSprocketConvRoute: Routes = [
    {
        path: 'front-sprocket-conv',
        component: FrontSprocketConvComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'FrontSprocketConvs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'front-sprocket-conv/:id/view',
        component: FrontSprocketConvDetailComponent,
        resolve: {
            frontSprocketConv: FrontSprocketConvResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'FrontSprocketConvs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'front-sprocket-conv/new',
        component: FrontSprocketConvUpdateComponent,
        resolve: {
            frontSprocketConv: FrontSprocketConvResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'FrontSprocketConvs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'front-sprocket-conv/:id/edit',
        component: FrontSprocketConvUpdateComponent,
        resolve: {
            frontSprocketConv: FrontSprocketConvResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'FrontSprocketConvs'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const frontSprocketConvPopupRoute: Routes = [
    {
        path: 'front-sprocket-conv/:id/delete',
        component: FrontSprocketConvDeletePopupComponent,
        resolve: {
            frontSprocketConv: FrontSprocketConvResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'FrontSprocketConvs'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
