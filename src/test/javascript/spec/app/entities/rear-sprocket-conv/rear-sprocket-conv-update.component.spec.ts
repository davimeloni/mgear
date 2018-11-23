/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { RearSprocketConvUpdateComponent } from 'app/entities/rear-sprocket-conv/rear-sprocket-conv-update.component';
import { RearSprocketConvService } from 'app/entities/rear-sprocket-conv/rear-sprocket-conv.service';
import { RearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';

describe('Component Tests', () => {
    describe('RearSprocketConv Management Update Component', () => {
        let comp: RearSprocketConvUpdateComponent;
        let fixture: ComponentFixture<RearSprocketConvUpdateComponent>;
        let service: RearSprocketConvService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [RearSprocketConvUpdateComponent]
            })
                .overrideTemplate(RearSprocketConvUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(RearSprocketConvUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RearSprocketConvService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new RearSprocketConv(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.rearSprocketConv = entity;
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
                    const entity = new RearSprocketConv();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.rearSprocketConv = entity;
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
