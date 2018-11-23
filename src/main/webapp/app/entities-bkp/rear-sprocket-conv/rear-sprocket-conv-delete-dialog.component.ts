import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';
import { RearSprocketConvService } from './rear-sprocket-conv.service';

@Component({
    selector: 'jhi-rear-sprocket-conv-delete-dialog',
    templateUrl: './rear-sprocket-conv-delete-dialog.component.html'
})
export class RearSprocketConvDeleteDialogComponent {
    rearSprocketConv: IRearSprocketConv;

    constructor(
        private rearSprocketConvService: RearSprocketConvService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rearSprocketConvService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'rearSprocketConvListModification',
                content: 'Deleted an rearSprocketConv'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rear-sprocket-conv-delete-popup',
    template: ''
})
export class RearSprocketConvDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ rearSprocketConv }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(RearSprocketConvDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.rearSprocketConv = rearSprocketConv;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
