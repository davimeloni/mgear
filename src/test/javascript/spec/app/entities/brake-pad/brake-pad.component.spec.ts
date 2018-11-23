/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MgearappTestModule } from '../../../test.module';
import { BrakePadComponent } from 'app/entities/brake-pad/brake-pad.component';
import { BrakePadService } from 'app/entities/brake-pad/brake-pad.service';
import { BrakePad } from 'app/shared/model/brake-pad.model';

describe('Component Tests', () => {
    describe('BrakePad Management Component', () => {
        let comp: BrakePadComponent;
        let fixture: ComponentFixture<BrakePadComponent>;
        let service: BrakePadService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BrakePadComponent],
                providers: []
            })
                .overrideTemplate(BrakePadComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BrakePadComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BrakePadService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new BrakePad(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.brakePads[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
