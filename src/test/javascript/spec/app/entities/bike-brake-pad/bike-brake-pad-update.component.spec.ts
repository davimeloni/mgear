/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BikeBrakePadUpdateComponent } from 'app/entities/bike-brake-pad/bike-brake-pad-update.component';
import { BikeBrakePadService } from 'app/entities/bike-brake-pad/bike-brake-pad.service';
import { BikeBrakePad } from 'app/shared/model/bike-brake-pad.model';

describe('Component Tests', () => {
    describe('BikeBrakePad Management Update Component', () => {
        let comp: BikeBrakePadUpdateComponent;
        let fixture: ComponentFixture<BikeBrakePadUpdateComponent>;
        let service: BikeBrakePadService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeBrakePadUpdateComponent]
            })
                .overrideTemplate(BikeBrakePadUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BikeBrakePadUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeBrakePadService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BikeBrakePad(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bikeBrakePad = entity;
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
                    const entity = new BikeBrakePad();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bikeBrakePad = entity;
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
