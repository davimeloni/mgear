/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { FrontSprocketConvDetailComponent } from 'app/entities/front-sprocket-conv/front-sprocket-conv-detail.component';
import { FrontSprocketConv } from 'app/shared/model/front-sprocket-conv.model';

describe('Component Tests', () => {
    describe('FrontSprocketConv Management Detail Component', () => {
        let comp: FrontSprocketConvDetailComponent;
        let fixture: ComponentFixture<FrontSprocketConvDetailComponent>;
        const route = ({ data: of({ frontSprocketConv: new FrontSprocketConv(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [FrontSprocketConvDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(FrontSprocketConvDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(FrontSprocketConvDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.frontSprocketConv).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
