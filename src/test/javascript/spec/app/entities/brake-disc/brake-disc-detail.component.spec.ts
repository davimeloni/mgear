/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BrakeDiscDetailComponent } from 'app/entities/brake-disc/brake-disc-detail.component';
import { BrakeDisc } from 'app/shared/model/brake-disc.model';

describe('Component Tests', () => {
    describe('BrakeDisc Management Detail Component', () => {
        let comp: BrakeDiscDetailComponent;
        let fixture: ComponentFixture<BrakeDiscDetailComponent>;
        const route = ({ data: of({ brakeDisc: new BrakeDisc(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BrakeDiscDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BrakeDiscDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BrakeDiscDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.brakeDisc).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
