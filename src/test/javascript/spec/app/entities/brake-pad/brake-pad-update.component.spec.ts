/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { BrakePadUpdateComponent } from 'app/entities/brake-pad/brake-pad-update.component';
import { BrakePadService } from 'app/entities/brake-pad/brake-pad.service';
import { BrakePad } from 'app/shared/model/brake-pad.model';

describe('Component Tests', () => {
    describe('BrakePad Management Update Component', () => {
        let comp: BrakePadUpdateComponent;
        let fixture: ComponentFixture<BrakePadUpdateComponent>;
        let service: BrakePadService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BrakePadUpdateComponent]
            })
                .overrideTemplate(BrakePadUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BrakePadUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BrakePadService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BrakePad(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.brakePad = entity;
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
                    const entity = new BrakePad();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.brakePad = entity;
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
