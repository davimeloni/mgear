/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MgearappTestModule } from '../../../test.module';
import { BikeBrakeDiscDeleteDialogComponent } from 'app/entities/bike-brake-disc/bike-brake-disc-delete-dialog.component';
import { BikeBrakeDiscService } from 'app/entities/bike-brake-disc/bike-brake-disc.service';

describe('Component Tests', () => {
    describe('BikeBrakeDisc Management Delete Component', () => {
        let comp: BikeBrakeDiscDeleteDialogComponent;
        let fixture: ComponentFixture<BikeBrakeDiscDeleteDialogComponent>;
        let service: BikeBrakeDiscService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeBrakeDiscDeleteDialogComponent]
            })
                .overrideTemplate(BikeBrakeDiscDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BikeBrakeDiscDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeBrakeDiscService);
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
