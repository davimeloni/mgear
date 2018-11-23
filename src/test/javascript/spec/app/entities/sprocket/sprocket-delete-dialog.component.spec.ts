/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { MgearappTestModule } from '../../../test.module';
import { SprocketDeleteDialogComponent } from 'app/entities/sprocket/sprocket-delete-dialog.component';
import { SprocketService } from 'app/entities/sprocket/sprocket.service';

describe('Component Tests', () => {
    describe('Sprocket Management Delete Component', () => {
        let comp: SprocketDeleteDialogComponent;
        let fixture: ComponentFixture<SprocketDeleteDialogComponent>;
        let service: SprocketService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [SprocketDeleteDialogComponent]
            })
                .overrideTemplate(SprocketDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(SprocketDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SprocketService);
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
