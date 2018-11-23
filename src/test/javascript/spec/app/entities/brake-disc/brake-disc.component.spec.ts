/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MgearappTestModule } from '../../../test.module';
import { BrakeDiscComponent } from 'app/entities/brake-disc/brake-disc.component';
import { BrakeDiscService } from 'app/entities/brake-disc/brake-disc.service';
import { BrakeDisc } from 'app/shared/model/brake-disc.model';

describe('Component Tests', () => {
    describe('BrakeDisc Management Component', () => {
        let comp: BrakeDiscComponent;
        let fixture: ComponentFixture<BrakeDiscComponent>;
        let service: BrakeDiscService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [BrakeDiscComponent],
                providers: []
            })
                .overrideTemplate(BrakeDiscComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BrakeDiscComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BrakeDiscService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new BrakeDisc(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.brakeDiscs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
