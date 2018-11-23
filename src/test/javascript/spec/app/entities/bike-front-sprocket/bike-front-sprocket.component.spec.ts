/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MgearappTestModule } from '../../../test.module';
import { BikeFrontSprocketComponent } from 'app/entities/bike-front-sprocket/bike-front-sprocket.component';
import { BikeFrontSprocketService } from 'app/entities/bike-front-sprocket/bike-front-sprocket.service';
import { BikeFrontSprocket } from 'app/shared/model/bike-front-sprocket.model';

describe('Component Tests', () => {
    describe('BikeFrontSprocket Management Component', () => {
        let comp: BikeFrontSprocketComponent;
        let fixture: ComponentFixture<BikeFrontSprocketComponent>;
        let service: BikeFrontSprocketService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeFrontSprocketComponent],
                providers: []
            })
                .overrideTemplate(BikeFrontSprocketComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BikeFrontSprocketComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeFrontSprocketService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new BikeFrontSprocket(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.bikeFrontSprockets[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
