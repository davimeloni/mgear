/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BikeBrakePadDetailComponent } from 'app/entities/bike-brake-pad/bike-brake-pad-detail.component';
import { BikeBrakePad } from 'app/shared/model/bike-brake-pad.model';

describe('Component Tests', () => {
    describe('BikeBrakePad Management Detail Component', () => {
        let comp: BikeBrakePadDetailComponent;
        let fixture: ComponentFixture<BikeBrakePadDetailComponent>;
        const route = ({ data: of({ bikeBrakePad: new BikeBrakePad(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeBrakePadDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BikeBrakePadDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BikeBrakePadDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.bikeBrakePad).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
