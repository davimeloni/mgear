/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { RearSprocketConvDetailComponent } from 'app/entities/rear-sprocket-conv/rear-sprocket-conv-detail.component';
import { RearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';

describe('Component Tests', () => {
    describe('RearSprocketConv Management Detail Component', () => {
        let comp: RearSprocketConvDetailComponent;
        let fixture: ComponentFixture<RearSprocketConvDetailComponent>;
        const route = ({ data: of({ rearSprocketConv: new RearSprocketConv(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [RearSprocketConvDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(RearSprocketConvDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(RearSprocketConvDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.rearSprocketConv).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
