/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { FrontSprocketConvUpdateComponent } from 'app/entities/front-sprocket-conv/front-sprocket-conv-update.component';
import { FrontSprocketConvService } from 'app/entities/front-sprocket-conv/front-sprocket-conv.service';
import { FrontSprocketConv } from 'app/shared/model/front-sprocket-conv.model';

describe('Component Tests', () => {
    describe('FrontSprocketConv Management Update Component', () => {
        let comp: FrontSprocketConvUpdateComponent;
        let fixture: ComponentFixture<FrontSprocketConvUpdateComponent>;
        let service: FrontSprocketConvService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [FrontSprocketConvUpdateComponent]
            })
                .overrideTemplate(FrontSprocketConvUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(FrontSprocketConvUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FrontSprocketConvService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new FrontSprocketConv(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.frontSprocketConv = entity;
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
                    const entity = new FrontSprocketConv();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.frontSprocketConv = entity;
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
