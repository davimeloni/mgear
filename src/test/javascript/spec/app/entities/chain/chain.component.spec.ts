/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MgearappTestModule } from '../../../test.module';
import { ChainComponent } from 'app/entities/chain/chain.component';
import { ChainService } from 'app/entities/chain/chain.service';
import { Chain } from 'app/shared/model/chain.model';

describe('Component Tests', () => {
    describe('Chain Management Component', () => {
        let comp: ChainComponent;
        let fixture: ComponentFixture<ChainComponent>;
        let service: ChainService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [ChainComponent],
                providers: []
            })
                .overrideTemplate(ChainComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(ChainComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ChainService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Chain(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.chains[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
