/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BikeFrontSprocketDetailComponent } from 'app/entities/bike-front-sprocket/bike-front-sprocket-detail.component';
import { BikeFrontSprocket } from 'app/shared/model/bike-front-sprocket.model';

describe('Component Tests', () => {
    describe('BikeFrontSprocket Management Detail Component', () => {
        let comp: BikeFrontSprocketDetailComponent;
        let fixture: ComponentFixture<BikeFrontSprocketDetailComponent>;
        const route = ({ data: of({ bikeFrontSprocket: new BikeFrontSprocket(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeFrontSprocketDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BikeFrontSprocketDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BikeFrontSprocketDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.bikeFrontSprocket).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
