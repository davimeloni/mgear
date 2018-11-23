import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    BikeBrakeDiscComponent,
    BikeBrakeDiscDetailComponent,
    BikeBrakeDiscUpdateComponent,
    BikeBrakeDiscDeletePopupComponent,
    BikeBrakeDiscDeleteDialogComponent,
    bikeBrakeDiscRoute,
    bikeBrakeDiscPopupRoute
} from './';

const ENTITY_STATES = [...bikeBrakeDiscRoute, ...bikeBrakeDiscPopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BikeBrakeDiscComponent,
        BikeBrakeDiscDetailComponent,
        BikeBrakeDiscUpdateComponent,
        BikeBrakeDiscDeleteDialogComponent,
        BikeBrakeDiscDeletePopupComponent
    ],
    entryComponents: [
        BikeBrakeDiscComponent,
        BikeBrakeDiscUpdateComponent,
        BikeBrakeDiscDeleteDialogComponent,
        BikeBrakeDiscDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappBikeBrakeDiscModule {}
