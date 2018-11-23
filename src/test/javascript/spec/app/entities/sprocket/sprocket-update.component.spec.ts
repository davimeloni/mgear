/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { SprocketUpdateComponent } from 'app/entities/sprocket/sprocket-update.component';
import { SprocketService } from 'app/entities/sprocket/sprocket.service';
import { Sprocket } from 'app/shared/model/sprocket.model';

describe('Component Tests', () => {
    describe('Sprocket Management Update Component', () => {
        let comp: SprocketUpdateComponent;
        let fixture: ComponentFixture<SprocketUpdateComponent>;
        let service: SprocketService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [SprocketUpdateComponent]
            })
                .overrideTemplate(SprocketUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(SprocketUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SprocketService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Sprocket(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.sprocket = entity;
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
                    const entity = new Sprocket();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.sprocket = entity;
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
