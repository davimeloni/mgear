/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { ChainUpdateComponent } from 'app/entities/chain/chain-update.component';
import { ChainService } from 'app/entities/chain/chain.service';
import { Chain } from 'app/shared/model/chain.model';

describe('Component Tests', () => {
    describe('Chain Management Update Component', () => {
        let comp: ChainUpdateComponent;
        let fixture: ComponentFixture<ChainUpdateComponent>;
        let service: ChainService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [ChainUpdateComponent]
            })
                .overrideTemplate(ChainUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(ChainUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ChainService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Chain(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.chain = entity;
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
                    const entity = new Chain();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.chain = entity;
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
