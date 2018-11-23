import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBrakeDisc } from 'app/shared/model/brake-disc.model';
import { BrakeDiscService } from './brake-disc.service';

@Component({
    selector: 'jhi-brake-disc-delete-dialog',
    templateUrl: './brake-disc-delete-dialog.component.html'
})
export class BrakeDiscDeleteDialogComponent {
    brakeDisc: IBrakeDisc;

    constructor(private brakeDiscService: BrakeDiscService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.brakeDiscService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'brakeDiscListModification',
                content: 'Deleted an brakeDisc'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-brake-disc-delete-popup',
    template: ''
})
export class BrakeDiscDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ brakeDisc }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(BrakeDiscDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.brakeDisc = brakeDisc;
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
