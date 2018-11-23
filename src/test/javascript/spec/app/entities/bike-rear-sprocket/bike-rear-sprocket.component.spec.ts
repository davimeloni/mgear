/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MgearappTestModule } from '../../../test.module';
import { BikeRearSprocketComponent } from 'app/entities/bike-rear-sprocket/bike-rear-sprocket.component';
import { BikeRearSprocketService } from 'app/entities/bike-rear-sprocket/bike-rear-sprocket.service';
import { BikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';

describe('Component Tests', () => {
    describe('BikeRearSprocket Management Component', () => {
        let comp: BikeRearSprocketComponent;
        let fixture: ComponentFixture<BikeRearSprocketComponent>;
        let service: BikeRearSprocketService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeRearSprocketComponent],
                providers: []
            })
                .overrideTemplate(BikeRearSprocketComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BikeRearSprocketComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeRearSprocketService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new BikeRearSprocket(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.bikeRearSprockets[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
