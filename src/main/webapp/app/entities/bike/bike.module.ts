import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ButtonModule} from 'primeng/primeng';
import {TableModule} from 'primeng/table';
import { FormsModule } from '@angular/forms';
import { MultiSelectModule } from 'primeng/multiselect';
import {ListboxModule} from 'primeng/listbox';
import {ToggleButtonModule} from 'primeng/togglebutton';
import {AccordionModule} from 'primeng/accordion';
import {DialogModule} from 'primeng/dialog';
import {DropdownModule} from 'primeng/dropdown';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {FieldsetModule} from 'primeng/fieldset';
import {ToastModule} from 'primeng/toast';
import {ProgressSpinnerModule} from 'primeng/progressspinner';
import {BlockUIModule} from 'primeng/blockui';
import {CalendarModule} from 'primeng/calendar';
import {SliderModule} from 'primeng/slider';

import { PapaParseModule } from 'ngx-papaparse';

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
    imports: [MgearappSharedModule,
        PapaParseModule,
        TableModule,
        BrowserAnimationsModule,
        ButtonModule,
        FormsModule,
        MultiSelectModule,
        PapaParseModule,
        ListboxModule,
        ToggleButtonModule,
        AccordionModule,
        DialogModule,
        DropdownModule,
        InputTextareaModule,
        FieldsetModule,
        ToastModule,
        ProgressSpinnerModule,
        BlockUIModule,
        CalendarModule,
        SliderModule,
        RouterModule.forChild(ENTITY_STATES)],
    declarations: [BikeComponent, BikeDetailComponent, BikeUpdateComponent, BikeDeleteDialogComponent, BikeDeletePopupComponent],
    entryComponents: [BikeComponent, BikeUpdateComponent, BikeDeleteDialogComponent, BikeDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MgearappBikeModule {}
