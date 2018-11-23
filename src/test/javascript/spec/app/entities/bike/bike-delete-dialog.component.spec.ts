/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MgearappTestModule } from '../../../test.module';
import { BikeDeleteDialogComponent } from 'app/entities/bike/bike-delete-dialog.component';
import { BikeService } from 'app/entities/bike/bike.service';

describe('Component Tests', () => {
    describe('Bike Management Delete Component', () => {
        let comp: BikeDeleteDialogComponent;
        let fixture: ComponentFixture<BikeDeleteDialogComponent>;
        let service: BikeService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeDeleteDialogComponent]
            })
                .overrideTemplate(BikeDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BikeDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeService);
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
