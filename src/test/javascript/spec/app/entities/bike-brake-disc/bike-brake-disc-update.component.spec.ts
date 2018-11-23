/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BikeBrakeDiscUpdateComponent } from 'app/entities/bike-brake-disc/bike-brake-disc-update.component';
import { BikeBrakeDiscService } from 'app/entities/bike-brake-disc/bike-brake-disc.service';
import { BikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';

describe('Component Tests', () => {
    describe('BikeBrakeDisc Management Update Component', () => {
        let comp: BikeBrakeDiscUpdateComponent;
        let fixture: ComponentFixture<BikeBrakeDiscUpdateComponent>;
        let service: BikeBrakeDiscService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeBrakeDiscUpdateComponent]
            })
                .overrideTemplate(BikeBrakeDiscUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BikeBrakeDiscUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeBrakeDiscService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BikeBrakeDisc(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bikeBrakeDisc = entity;
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
                    const entity = new BikeBrakeDisc();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bikeBrakeDisc = entity;
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
