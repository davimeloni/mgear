import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    FrontSprocketConvComponent,
    FrontSprocketConvDetailComponent,
    FrontSprocketConvUpdateComponent,
    FrontSprocketConvDeletePopupComponent,
    FrontSprocketConvDeleteDialogComponent,
    frontSprocketConvRoute,
    frontSprocketConvPopupRoute
} from './';

const ENTITY_STATES = [...frontSprocketConvRoute, ...frontSprocketConvPopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        FrontSprocketConvComponent,
        FrontSprocketConvDetailComponent,
        FrontSprocketConvUpdateComponent,
        FrontSprocketConvDeleteDialogComponent,
        FrontSprocketConvDeletePopupComponent
    ],
    entryComponents: [
        FrontSprocketConvComponent,
        FrontSprocketConvUpdateComponent,
        FrontSprocketConvDeleteDialogComponent,
        FrontSprocketConvDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappFrontSprocketConvModule {}
