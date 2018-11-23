import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    BrakeDiscComponent,
    BrakeDiscDetailComponent,
    BrakeDiscUpdateComponent,
    BrakeDiscDeletePopupComponent,
    BrakeDiscDeleteDialogComponent,
    brakeDiscRoute,
    brakeDiscPopupRoute
} from './';

const ENTITY_STATES = [...brakeDiscRoute, ...brakeDiscPopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BrakeDiscComponent,
        BrakeDiscDetailComponent,
        BrakeDiscUpdateComponent,
        BrakeDiscDeleteDialogComponent,
        BrakeDiscDeletePopupComponent
    ],
    entryComponents: [BrakeDiscComponent, BrakeDiscUpdateComponent, BrakeDiscDeleteDialogComponent, BrakeDiscDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappBrakeDiscModule {}
