/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MgearappTestModule } from '../../../test.module';
import { BikeFrontSprocketDeleteDialogComponent } from 'app/entities/bike-front-sprocket/bike-front-sprocket-delete-dialog.component';
import { BikeFrontSprocketService } from 'app/entities/bike-front-sprocket/bike-front-sprocket.service';

describe('Component Tests', () => {
    describe('BikeFrontSprocket Management Delete Component', () => {
        let comp: BikeFrontSprocketDeleteDialogComponent;
        let fixture: ComponentFixture<BikeFrontSprocketDeleteDialogComponent>;
        let service: BikeFrontSprocketService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BikeFrontSprocketDeleteDialogComponent]
            })
                .overrideTemplate(BikeFrontSprocketDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BikeFrontSprocketDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BikeFrontSprocketService);
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
