/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MgearappTestModule } from '../../../test.module';
import { BrakePadDeleteDialogComponent } from 'app/entities/brake-pad/brake-pad-delete-dialog.component';
import { BrakePadService } from 'app/entities/brake-pad/brake-pad.service';

describe('Component Tests', () => {
    describe('BrakePad Management Delete Component', () => {
        let comp: BrakePadDeleteDialogComponent;
        let fixture: ComponentFixture<BrakePadDeleteDialogComponent>;
        let service: BrakePadService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BrakePadDeleteDialogComponent]
            })
                .overrideTemplate(BrakePadDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BrakePadDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BrakePadService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
