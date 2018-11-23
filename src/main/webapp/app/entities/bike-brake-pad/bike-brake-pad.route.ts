import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { BikeBrakePad } from 'app/shared/model/bike-brake-pad.model';
import { BikeBrakePadService } from './bike-brake-pad.service';
import { BikeBrakePadComponent } from './bike-brake-pad.component';
import { BikeBrakePadDetailComponent } from './bike-brake-pad-detail.component';
import { BikeBrakePadUpdateComponent } from './bike-brake-pad-update.component';
import { BikeBrakePadDeletePopupComponent } from './bike-brake-pad-delete-dialog.component';
import { IBikeBrakePad } from 'app/shared/model/bike-brake-pad.model';

@Injectable({ providedIn: 'root' })
export class BikeBrakePadResolve implements Resolve<IBikeBrakePad> {
    constructor(private service: BikeBrakePadService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((bikeBrakePad: HttpResponse<BikeBrakePad>) => bikeBrakePad.body));
        }
        return of(new BikeBrakePad());
    }
}

export const bikeBrakePadRoute: Routes = [
    {
        path: 'bike-brake-pad',
        component: BikeBrakePadComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeBrakePads'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-brake-pad/:id/view',
        component: BikeBrakePadDetailComponent,
        resolve: {
            bikeBrakePad: BikeBrakePadResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeBrakePads'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-brake-pad/new',
        component: BikeBrakePadUpdateComponent,
        resolve: {
            bikeBrakePad: BikeBrakePadResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeBrakePads'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-brake-pad/:id/edit',
        component: BikeBrakePadUpdateComponent,
        resolve: {
            bikeBrakePad: BikeBrakePadResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeBrakePads'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const bikeBrakePadPopupRoute: Routes = [
    {
        path: 'bike-brake-pad/:id/delete',
        component: BikeBrakePadDeletePopupComponent,
        resolve: {
            bikeBrakePad: BikeBrakePadResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeBrakePads'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
