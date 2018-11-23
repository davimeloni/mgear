import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    BikeComponent,
    BikeDetailComponent,
    BikeUpdateComponent,
    BikeDeletePopupComponent,
    BikeDeleteDialogComponent,
    bikeRoute,
    bikePopupRoute
} from './';

const ENTITY_STATES = [...bikeRoute, ...bikePopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [BikeComponent, BikeDetailComponent, BikeUpdateComponent, BikeDeleteDialogComponent, BikeDeletePopupComponent],
    entryComponents: [BikeComponent, BikeUpdateComponent, BikeDeleteDialogComponent, BikeDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappBikeModule {}
