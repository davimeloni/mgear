/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BikeBrakeDiscDetailComponent } from 'app/entities/bike-brake-disc/bike-brake-disc-detail.component';
import { BikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';

describe('Component Tests', () => {
    describe('BikeBrakeDisc Management Detail Component', () => {
        let comp: BikeBrakeDiscDetailComponent;
        let fixture: ComponentFixture<BikeBrakeDiscDetailComponent>;
        const route = ({ data: of({ bikeBrakeDisc: new BikeBrakeDisc(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeBrakeDiscDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BikeBrakeDiscDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BikeBrakeDiscDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.bikeBrakeDisc).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
