/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BikeRearSprocketUpdateComponent } from 'app/entities/bike-rear-sprocket/bike-rear-sprocket-update.component';
import { BikeRearSprocketService } from 'app/entities/bike-rear-sprocket/bike-rear-sprocket.service';
import { BikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';

describe('Component Tests', () => {
    describe('BikeRearSprocket Management Update Component', () => {
        let comp: BikeRearSprocketUpdateComponent;
        let fixture: ComponentFixture<BikeRearSprocketUpdateComponent>;
        let service: BikeRearSprocketService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeRearSprocketUpdateComponent]
            })
                .overrideTemplate(BikeRearSprocketUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BikeRearSprocketUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeRearSprocketService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BikeRearSprocket(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bikeRearSprocket = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BikeRearSprocket();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bikeRearSprocket = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
