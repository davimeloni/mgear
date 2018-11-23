/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MgearappTestModule } from '../../../test.module';
import { BikeBrakePadComponent } from 'app/entities/bike-brake-pad/bike-brake-pad.component';
import { BikeBrakePadService } from 'app/entities/bike-brake-pad/bike-brake-pad.service';
import { BikeBrakePad } from 'app/shared/model/bike-brake-pad.model';

describe('Component Tests', () => {
    describe('BikeBrakePad Management Component', () => {
        let comp: BikeBrakePadComponent;
        let fixture: ComponentFixture<BikeBrakePadComponent>;
        let service: BikeBrakePadService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeBrakePadComponent],
                providers: []
            })
                .overrideTemplate(BikeBrakePadComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BikeBrakePadComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeBrakePadService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new BikeBrakePad(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.bikeBrakePads[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
