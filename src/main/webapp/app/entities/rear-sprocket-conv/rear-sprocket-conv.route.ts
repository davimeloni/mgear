import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { RearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';
import { RearSprocketConvService } from './rear-sprocket-conv.service';
import { RearSprocketConvComponent } from './rear-sprocket-conv.component';
import { RearSprocketConvDetailComponent } from './rear-sprocket-conv-detail.component';
import { RearSprocketConvUpdateComponent } from './rear-sprocket-conv-update.component';
import { RearSprocketConvDeletePopupComponent } from './rear-sprocket-conv-delete-dialog.component';
import { IRearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';

@Injectable({ providedIn: 'root' })
export class RearSprocketConvResolve implements Resolve<IRearSprocketConv> {
    constructor(private service: RearSprocketConvService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((rearSprocketConv: HttpResponse<RearSprocketConv>) => rearSprocketConv.body));
        }
        return of(new RearSprocketConv());
    }
}

export const rearSprocketConvRoute: Routes = [
    {
        path: 'rear-sprocket-conv',
        component: RearSprocketConvComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RearSprocketConvs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'rear-sprocket-conv/:id/view',
        component: RearSprocketConvDetailComponent,
        resolve: {
            rearSprocketConv: RearSprocketConvResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RearSprocketConvs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'rear-sprocket-conv/new',
        component: RearSprocketConvUpdateComponent,
        resolve: {
            rearSprocketConv: RearSprocketConvResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RearSprocketConvs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'rear-sprocket-conv/:id/edit',
        component: RearSprocketConvUpdateComponent,
        resolve: {
            rearSprocketConv: RearSprocketConvResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RearSprocketConvs'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rearSprocketConvPopupRoute: Routes = [
    {
        path: 'rear-sprocket-conv/:id/delete',
        component: RearSprocketConvDeletePopupComponent,
        resolve: {
            rearSprocketConv: RearSprocketConvResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RearSprocketConvs'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
