/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MgearappTestModule } from '../../../test.module';
import { BrakeDiscDeleteDialogComponent } from 'app/entities/brake-disc/brake-disc-delete-dialog.component';
import { BrakeDiscService } from 'app/entities/brake-disc/brake-disc.service';

describe('Component Tests', () => {
    describe('BrakeDisc Management Delete Component', () => {
        let comp: BrakeDiscDeleteDialogComponent;
        let fixture: ComponentFixture<BrakeDiscDeleteDialogComponent>;
        let service: BrakeDiscService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BrakeDiscDeleteDialogComponent]
            })
                .overrideTemplate(BrakeDiscDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BrakeDiscDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BrakeDiscService);
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
