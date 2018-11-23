import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IFrontSprocketConv } from 'app/shared/model/front-sprocket-conv.model';
import { FrontSprocketConvService } from './front-sprocket-conv.service';

@Component({
    selector: 'jhi-front-sprocket-conv-delete-dialog',
    templateUrl: './front-sprocket-conv-delete-dialog.component.html'
})
export class FrontSprocketConvDeleteDialogComponent {
    frontSprocketConv: IFrontSprocketConv;

    constructor(
        private frontSprocketConvService: FrontSprocketConvService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.frontSprocketConvService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'frontSprocketConvListModification',
                content: 'Deleted an frontSprocketConv'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-front-sprocket-conv-delete-popup',
    template: ''
})
export class FrontSprocketConvDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ frontSprocketConv }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(FrontSprocketConvDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.frontSprocketConv = frontSprocketConv;
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
