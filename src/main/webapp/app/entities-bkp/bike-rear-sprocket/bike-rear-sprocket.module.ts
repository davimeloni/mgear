import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    BikeRearSprocketComponent,
    BikeRearSprocketDetailComponent,
    BikeRearSprocketUpdateComponent,
    BikeRearSprocketDeletePopupComponent,
    BikeRearSprocketDeleteDialogComponent,
    bikeRearSprocketRoute,
    bikeRearSprocketPopupRoute
} from './';

const ENTITY_STATES = [...bikeRearSprocketRoute, ...bikeRearSprocketPopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BikeRearSprocketComponent,
        BikeRearSprocketDetailComponent,
        BikeRearSprocketUpdateComponent,
        BikeRearSprocketDeleteDialogComponent,
        BikeRearSprocketDeletePopupComponent
    ],
    entryComponents: [
        BikeRearSprocketComponent,
        BikeRearSprocketUpdateComponent,
        BikeRearSprocketDeleteDialogComponent,
        BikeRearSprocketDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappBikeRearSprocketModule {}
