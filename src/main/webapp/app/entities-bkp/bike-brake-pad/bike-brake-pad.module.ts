import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    BikeBrakePadComponent,
    BikeBrakePadDetailComponent,
    BikeBrakePadUpdateComponent,
    BikeBrakePadDeletePopupComponent,
    BikeBrakePadDeleteDialogComponent,
    bikeBrakePadRoute,
    bikeBrakePadPopupRoute
} from './';

const ENTITY_STATES = [...bikeBrakePadRoute, ...bikeBrakePadPopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BikeBrakePadComponent,
        BikeBrakePadDetailComponent,
        BikeBrakePadUpdateComponent,
        BikeBrakePadDeleteDialogComponent,
        BikeBrakePadDeletePopupComponent
    ],
    entryComponents: [
        BikeBrakePadComponent,
        BikeBrakePadUpdateComponent,
        BikeBrakePadDeleteDialogComponent,
        BikeBrakePadDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappBikeBrakePadModule {}
