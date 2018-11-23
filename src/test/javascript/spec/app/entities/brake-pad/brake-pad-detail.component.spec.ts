/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BrakePadDetailComponent } from 'app/entities/brake-pad/brake-pad-detail.component';
import { BrakePad } from 'app/shared/model/brake-pad.model';

describe('Component Tests', () => {
    describe('BrakePad Management Detail Component', () => {
        let comp: BrakePadDetailComponent;
        let fixture: ComponentFixture<BrakePadDetailComponent>;
        const route = ({ data: of({ brakePad: new BrakePad(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BrakePadDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BrakePadDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BrakePadDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.brakePad).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
