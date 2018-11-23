/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { ChainDetailComponent } from 'app/entities/chain/chain-detail.component';
import { Chain } from 'app/shared/model/chain.model';

describe('Component Tests', () => {
    describe('Chain Management Detail Component', () => {
        let comp: ChainDetailComponent;
        let fixture: ComponentFixture<ChainDetailComponent>;
        const route = ({ data: of({ chain: new Chain(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [ChainDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(ChainDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(ChainDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.chain).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
