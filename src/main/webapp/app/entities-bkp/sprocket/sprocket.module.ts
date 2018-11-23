import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    SprocketComponent,
    SprocketDetailComponent,
    SprocketUpdateComponent,
    SprocketDeletePopupComponent,
    SprocketDeleteDialogComponent,
    sprocketRoute,
    sprocketPopupRoute
} from './';

const ENTITY_STATES = [...sprocketRoute, ...sprocketPopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        SprocketComponent,
        SprocketDetailComponent,
        SprocketUpdateComponent,
        SprocketDeleteDialogComponent,
        SprocketDeletePopupComponent
    ],
    entryComponents: [SprocketComponent, SprocketUpdateComponent, SprocketDeleteDialogComponent, SprocketDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappSprocketModule {}
