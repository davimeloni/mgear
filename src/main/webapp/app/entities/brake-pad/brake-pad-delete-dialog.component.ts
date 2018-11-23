import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBrakePad } from 'app/shared/model/brake-pad.model';
import { BrakePadService } from './brake-pad.service';

@Component({
    selector: 'jhi-brake-pad-delete-dialog',
    templateUrl: './brake-pad-delete-dialog.component.html'
})
export class BrakePadDeleteDialogComponent {
    brakePad: IBrakePad;

    constructor(private brakePadService: BrakePadService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.brakePadService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'brakePadListModification',
                content: 'Deleted an brakePad'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-brake-pad-delete-popup',
    template: ''
})
export class BrakePadDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ brakePad }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(BrakePadDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.brakePad = brakePad;
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
