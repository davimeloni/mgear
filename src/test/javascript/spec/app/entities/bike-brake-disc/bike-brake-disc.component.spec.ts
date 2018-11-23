/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MgearappTestModule } from '../../../test.module';
import { BikeBrakeDiscComponent } from 'app/entities/bike-brake-disc/bike-brake-disc.component';
import { BikeBrakeDiscService } from 'app/entities/bike-brake-disc/bike-brake-disc.service';
import { BikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';

describe('Component Tests', () => {
    describe('BikeBrakeDisc Management Component', () => {
        let comp: BikeBrakeDiscComponent;
        let fixture: ComponentFixture<BikeBrakeDiscComponent>;
        let service: BikeBrakeDiscService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeBrakeDiscComponent],
                providers: []
            })
                .overrideTemplate(BikeBrakeDiscComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BikeBrakeDiscComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeBrakeDiscService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new BikeBrakeDisc(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.bikeBrakeDiscs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
