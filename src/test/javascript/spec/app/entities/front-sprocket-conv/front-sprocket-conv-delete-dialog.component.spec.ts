/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MgearappTestModule } from '../../../test.module';
import { FrontSprocketConvDeleteDialogComponent } from 'app/entities/front-sprocket-conv/front-sprocket-conv-delete-dialog.component';
import { FrontSprocketConvService } from 'app/entities/front-sprocket-conv/front-sprocket-conv.service';

describe('Component Tests', () => {
    describe('FrontSprocketConv Management Delete Component', () => {
        let comp: FrontSprocketConvDeleteDialogComponent;
        let fixture: ComponentFixture<FrontSprocketConvDeleteDialogComponent>;
        let service: FrontSprocketConvService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [FrontSprocketConvDeleteDialogComponent]
            })
                .overrideTemplate(FrontSprocketConvDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(FrontSprocketConvDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FrontSprocketConvService);
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
