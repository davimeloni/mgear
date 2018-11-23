import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';
import { BikeRearSprocketService } from './bike-rear-sprocket.service';

@Component({
    selector: 'jhi-bike-rear-sprocket-delete-dialog',
    templateUrl: './bike-rear-sprocket-delete-dialog.component.html'
})
export class BikeRearSprocketDeleteDialogComponent {
    bikeRearSprocket: IBikeRearSprocket;

    constructor(
        private bikeRearSprocketService: BikeRearSprocketService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.bikeRearSprocketService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'bikeRearSprocketListModification',
                content: 'Deleted an bikeRearSprocket'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-bike-rear-sprocket-delete-popup',
    template: ''
})
export class BikeRearSprocketDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bikeRearSprocket }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(BikeRearSprocketDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.bikeRearSprocket = bikeRearSprocket;
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
