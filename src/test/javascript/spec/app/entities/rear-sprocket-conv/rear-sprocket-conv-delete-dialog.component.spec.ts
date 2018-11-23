/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MgearappTestModule } from '../../../test.module';
import { RearSprocketConvDeleteDialogComponent } from 'app/entities/rear-sprocket-conv/rear-sprocket-conv-delete-dialog.component';
import { RearSprocketConvService } from 'app/entities/rear-sprocket-conv/rear-sprocket-conv.service';

describe('Component Tests', () => {
    describe('RearSprocketConv Management Delete Component', () => {
        let comp: RearSprocketConvDeleteDialogComponent;
        let fixture: ComponentFixture<RearSprocketConvDeleteDialogComponent>;
        let service: RearSprocketConvService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [RearSprocketConvDeleteDialogComponent]
            })
                .overrideTemplate(RearSprocketConvDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(RearSprocketConvDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RearSprocketConvService);
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
