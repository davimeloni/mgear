import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { BrakePad } from 'app/shared/model/brake-pad.model';
import { BrakePadService } from './brake-pad.service';
import { BrakePadComponent } from './brake-pad.component';
import { BrakePadDetailComponent } from './brake-pad-detail.component';
import { BrakePadUpdateComponent } from './brake-pad-update.component';
import { BrakePadDeletePopupComponent } from './brake-pad-delete-dialog.component';
import { IBrakePad } from 'app/shared/model/brake-pad.model';

@Injectable({ providedIn: 'root' })
export class BrakePadResolve implements Resolve<IBrakePad> {
    constructor(private service: BrakePadService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((brakePad: HttpResponse<BrakePad>) => brakePad.body));
        }
        return of(new BrakePad());
    }
}

export const brakePadRoute: Routes = [
    {
        path: 'brake-pad',
        component: BrakePadComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BrakePads'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'brake-pad/:id/view',
        component: BrakePadDetailComponent,
        resolve: {
            brakePad: BrakePadResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BrakePads'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'brake-pad/new',
        component: BrakePadUpdateComponent,
        resolve: {
            brakePad: BrakePadResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BrakePads'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'brake-pad/:id/edit',
        component: BrakePadUpdateComponent,
        resolve: {
            brakePad: BrakePadResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BrakePads'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const brakePadPopupRoute: Routes = [
    {
        path: 'brake-pad/:id/delete',
        component: BrakePadDeletePopupComponent,
        resolve: {
            brakePad: BrakePadResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BrakePads'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
