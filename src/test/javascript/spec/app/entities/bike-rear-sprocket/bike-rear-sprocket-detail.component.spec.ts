/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BikeRearSprocketDetailComponent } from 'app/entities/bike-rear-sprocket/bike-rear-sprocket-detail.component';
import { BikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';

describe('Component Tests', () => {
    describe('BikeRearSprocket Management Detail Component', () => {
        let comp: BikeRearSprocketDetailComponent;
        let fixture: ComponentFixture<BikeRearSprocketDetailComponent>;
        const route = ({ data: of({ bikeRearSprocket: new BikeRearSprocket(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeRearSprocketDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BikeRearSprocketDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BikeRearSprocketDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.bikeRearSprocket).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
