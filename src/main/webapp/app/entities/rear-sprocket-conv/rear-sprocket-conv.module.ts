import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    RearSprocketConvComponent,
    RearSprocketConvDetailComponent,
    RearSprocketConvUpdateComponent,
    RearSprocketConvDeletePopupComponent,
    RearSprocketConvDeleteDialogComponent,
    rearSprocketConvRoute,
    rearSprocketConvPopupRoute
} from './';

const ENTITY_STATES = [...rearSprocketConvRoute, ...rearSprocketConvPopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        RearSprocketConvComponent,
        RearSprocketConvDetailComponent,
        RearSprocketConvUpdateComponent,
        RearSprocketConvDeleteDialogComponent,
        RearSprocketConvDeletePopupComponent
    ],
    entryComponents: [
        RearSprocketConvComponent,
        RearSprocketConvUpdateComponent,
        RearSprocketConvDeleteDialogComponent,
        RearSprocketConvDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappRearSprocketConvModule {}
