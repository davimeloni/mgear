import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { MgearappSprocketModule } from './sprocket/sprocket.module';
import { MgearappChainModule } from './chain/chain.module';
import { MgearappBrakePadModule } from './brake-pad/brake-pad.module';
import { MgearappBrakeDiscModule } from './brake-disc/brake-disc.module';
import { MgearappBikeModule } from './bike/bike.module';
import { MgearappBikeFrontSprocketModule } from './bike-front-sprocket/bike-front-sprocket.module';
import { MgearappBikeRearSprocketModule } from './bike-rear-sprocket/bike-rear-sprocket.module';
import { MgearappRearSprocketConvModule } from './rear-sprocket-conv/rear-sprocket-conv.module';
import { MgearappFrontSprocketConvModule } from './front-sprocket-conv/front-sprocket-conv.module';
import { MgearappBikeBrakePadModule } from './bike-brake-pad/bike-brake-pad.module';
import { MgearappBikeBrakeDiscModule } from './bike-brake-disc/bike-brake-disc.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        MgearappSprocketModule,
        MgearappChainModule,
        MgearappBrakePadModule,
        MgearappBrakeDiscModule,
        MgearappBikeModule,
        MgearappBikeFrontSprocketModule,
        MgearappBikeRearSprocketModule,
        MgearappRearSprocketConvModule,
        MgearappFrontSprocketConvModule,
        MgearappBikeBrakePadModule,
        MgearappBikeBrakeDiscModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappEntityModule {}