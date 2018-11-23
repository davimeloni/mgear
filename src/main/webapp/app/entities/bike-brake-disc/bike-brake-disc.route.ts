import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { BikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';
import { BikeBrakeDiscService } from './bike-brake-disc.service';
import { BikeBrakeDiscComponent } from './bike-brake-disc.component';
import { BikeBrakeDiscDetailComponent } from './bike-brake-disc-detail.component';
import { BikeBrakeDiscUpdateComponent } from './bike-brake-disc-update.component';
import { BikeBrakeDiscDeletePopupComponent } from './bike-brake-disc-delete-dialog.component';
import { IBikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';

@Injectable({ providedIn: 'root' })
export class BikeBrakeDiscResolve implements Resolve<IBikeBrakeDisc> {
    constructor(private service: BikeBrakeDiscService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((bikeBrakeDisc: HttpResponse<BikeBrakeDisc>) => bikeBrakeDisc.body));
        }
        return of(new BikeBrakeDisc());
    }
}

export const bikeBrakeDiscRoute: Routes = [
    {
        path: 'bike-brake-disc',
        component: BikeBrakeDiscComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeBrakeDiscs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-brake-disc/:id/view',
        component: BikeBrakeDiscDetailComponent,
        resolve: {
            bikeBrakeDisc: BikeBrakeDiscResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeBrakeDiscs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-brake-disc/new',
        component: BikeBrakeDiscUpdateComponent,
        resolve: {
            bikeBrakeDisc: BikeBrakeDiscResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeBrakeDiscs'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bike-brake-disc/:id/edit',
        component: BikeBrakeDiscUpdateComponent,
        resolve: {
            bikeBrakeDisc: BikeBrakeDiscResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeBrakeDiscs'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const bikeBrakeDiscPopupRoute: Routes = [
    {
        path: 'bike-brake-disc/:id/delete',
        component: BikeBrakeDiscDeletePopupComponent,
        resolve: {
            bikeBrakeDisc: BikeBrakeDiscResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BikeBrakeDiscs'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
