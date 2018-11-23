import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ISprocket } from 'app/shared/model/sprocket.model';
import { SprocketService } from './sprocket.service';

@Component({
    selector: 'jhi-sprocket-delete-dialog',
    templateUrl: './sprocket-delete-dialog.component.html'
})
export class SprocketDeleteDialogComponent {
    sprocket: ISprocket;

    constructor(private sprocketService: SprocketService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sprocketService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'sprocketListModification',
                content: 'Deleted an sprocket'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sprocket-delete-popup',
    template: ''
})
export class SprocketDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ sprocket }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(SprocketDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.sprocket = sprocket;
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
