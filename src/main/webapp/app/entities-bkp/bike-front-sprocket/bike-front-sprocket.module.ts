import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    BikeFrontSprocketComponent,
    BikeFrontSprocketDetailComponent,
    BikeFrontSprocketUpdateComponent,
    BikeFrontSprocketDeletePopupComponent,
    BikeFrontSprocketDeleteDialogComponent,
    bikeFrontSprocketRoute,
    bikeFrontSprocketPopupRoute
} from './';

const ENTITY_STATES = [...bikeFrontSprocketRoute, ...bikeFrontSprocketPopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BikeFrontSprocketComponent,
        BikeFrontSprocketDetailComponent,
        BikeFrontSprocketUpdateComponent,
        BikeFrontSprocketDeleteDialogComponent,
        BikeFrontSprocketDeletePopupComponent
    ],
    entryComponents: [
        BikeFrontSprocketComponent,
        BikeFrontSprocketUpdateComponent,
        BikeFrontSprocketDeleteDialogComponent,
        BikeFrontSprocketDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappBikeFrontSprocketModule {}
