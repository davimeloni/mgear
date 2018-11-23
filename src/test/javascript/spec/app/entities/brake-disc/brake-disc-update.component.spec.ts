/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BrakeDiscUpdateComponent } from 'app/entities/brake-disc/brake-disc-update.component';
import { BrakeDiscService } from 'app/entities/brake-disc/brake-disc.service';
import { BrakeDisc } from 'app/shared/model/brake-disc.model';

describe('Component Tests', () => {
    describe('BrakeDisc Management Update Component', () => {
        let comp: BrakeDiscUpdateComponent;
        let fixture: ComponentFixture<BrakeDiscUpdateComponent>;
        let service: BrakeDiscService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BrakeDiscUpdateComponent]
            })
                .overrideTemplate(BrakeDiscUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BrakeDiscUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BrakeDiscService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BrakeDisc(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.brakeDisc = entity;
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
                    const entity = new BrakeDisc();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.brakeDisc = entity;
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
