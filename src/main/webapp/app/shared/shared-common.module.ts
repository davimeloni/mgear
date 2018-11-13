import { NgModule } from '@angular/core';

import { MgearappSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [MgearappSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [MgearappSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class MgearappSharedCommonModule {}
