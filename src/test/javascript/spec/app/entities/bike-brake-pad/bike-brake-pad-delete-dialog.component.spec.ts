/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MgearappTestModule } from '../../../test.module';
import { BikeBrakePadDeleteDialogComponent } from 'app/entities/bike-brake-pad/bike-brake-pad-delete-dialog.component';
import { BikeBrakePadService } from 'app/entities/bike-brake-pad/bike-brake-pad.service';

describe('Component Tests', () => {
    describe('BikeBrakePad Management Delete Component', () => {
        let comp: BikeBrakePadDeleteDialogComponent;
        let fixture: ComponentFixture<BikeBrakePadDeleteDialogComponent>;
        let service: BikeBrakePadService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeBrakePadDeleteDialogComponent]
            })
                .overrideTemplate(BikeBrakePadDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BikeBrakePadDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeBrakePadService);
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
