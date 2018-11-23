/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BikeDetailComponent } from 'app/entities/bike/bike-detail.component';
import { Bike } from 'app/shared/model/bike.model';

describe('Component Tests', () => {
    describe('Bike Management Detail Component', () => {
        let comp: BikeDetailComponent;
        let fixture: ComponentFixture<BikeDetailComponent>;
        const route = ({ data: of({ bike: new Bike(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BikeDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BikeDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.bike).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
