import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MgearappSharedModule } from 'app/shared';
import {
    ChainComponent,
    ChainDetailComponent,
    ChainUpdateComponent,
    ChainDeletePopupComponent,
    ChainDeleteDialogComponent,
    chainRoute,
    chainPopupRoute
} from './';

const ENTITY_STATES = [...chainRoute, ...chainPopupRoute];

@NgModule({
    imports: [MgearappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [ChainComponent, ChainDetailComponent, ChainUpdateComponent, ChainDeleteDialogComponent, ChainDeletePopupComponent],
    entryComponents: [ChainComponent, ChainUpdateComponent, ChainDeleteDialogComponent, ChainDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappChainModule {}
