import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    BrakePadComponent,
    BrakePadDetailComponent,
    BrakePadUpdateComponent,
    BrakePadDeletePopupComponent,
    BrakePadDeleteDialogComponent,
    brakePadRoute,
    brakePadPopupRoute
} from './';

const ENTITY_STATES = [...brakePadRoute, ...brakePadPopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BrakePadComponent,
        BrakePadDetailComponent,
        BrakePadUpdateComponent,
        BrakePadDeleteDialogComponent,
        BrakePadDeletePopupComponent
    ],
    entryComponents: [BrakePadComponent, BrakePadUpdateComponent, BrakePadDeleteDialogComponent, BrakePadDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappBrakePadModule {}
