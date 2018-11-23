import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';
import { BikeBrakeDiscService } from './bike-brake-disc.service';

@Component({
    selector: 'jhi-bike-brake-disc-delete-dialog',
    templateUrl: './bike-brake-disc-delete-dialog.component.html'
})
export class BikeBrakeDiscDeleteDialogComponent {
    bikeBrakeDisc: IBikeBrakeDisc;

    constructor(
        private bikeBrakeDiscService: BikeBrakeDiscService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.bikeBrakeDiscService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'bikeBrakeDiscListModification',
                content: 'Deleted an bikeBrakeDisc'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-bike-brake-disc-delete-popup',
    template: ''
})
export class BikeBrakeDiscDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bikeBrakeDisc }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(BikeBrakeDiscDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.bikeBrakeDisc = bikeBrakeDisc;
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
