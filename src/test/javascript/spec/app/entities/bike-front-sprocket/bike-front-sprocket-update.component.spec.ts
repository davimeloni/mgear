/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BikeFrontSprocketUpdateComponent } from 'app/entities/bike-front-sprocket/bike-front-sprocket-update.component';
import { BikeFrontSprocketService } from 'app/entities/bike-front-sprocket/bike-front-sprocket.service';
import { BikeFrontSprocket } from 'app/shared/model/bike-front-sprocket.model';

describe('Component Tests', () => {
    describe('BikeFrontSprocket Management Update Component', () => {
        let comp: BikeFrontSprocketUpdateComponent;
        let fixture: ComponentFixture<BikeFrontSprocketUpdateComponent>;
        let service: BikeFrontSprocketService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeFrontSprocketUpdateComponent]
            })
                .overrideTemplate(BikeFrontSprocketUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BikeFrontSprocketUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeFrontSprocketService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BikeFrontSprocket(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bikeFrontSprocket = entity;
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
                    const entity = new BikeFrontSprocket();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bikeFrontSprocket = entity;
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
