import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBikeBrakePad } from 'app/shared/model/bike-brake-pad.model';
import { BikeBrakePadService } from './bike-brake-pad.service';

@Component({
    selector: 'jhi-bike-brake-pad-delete-dialog',
    templateUrl: './bike-brake-pad-delete-dialog.component.html'
})
export class BikeBrakePadDeleteDialogComponent {
    bikeBrakePad: IBikeBrakePad;

    constructor(
        private bikeBrakePadService: BikeBrakePadService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.bikeBrakePadService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'bikeBrakePadListModification',
                content: 'Deleted an bikeBrakePad'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-bike-brake-pad-delete-popup',
    template: ''
})
export class BikeBrakePadDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bikeBrakePad }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(BikeBrakePadDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.bikeBrakePad = bikeBrakePad;
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
