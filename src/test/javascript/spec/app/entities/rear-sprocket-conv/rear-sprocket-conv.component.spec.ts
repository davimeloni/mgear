/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MgearappTestModule } from '../../../test.module';
import { RearSprocketConvComponent } from 'app/entities/rear-sprocket-conv/rear-sprocket-conv.component';
import { RearSprocketConvService } from 'app/entities/rear-sprocket-conv/rear-sprocket-conv.service';
import { RearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';

describe('Component Tests', () => {
    describe('RearSprocketConv Management Component', () => {
        let comp: RearSprocketConvComponent;
        let fixture: ComponentFixture<RearSprocketConvComponent>;
        let service: RearSprocketConvService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [RearSprocketConvComponent],
                providers: []
            })
                .overrideTemplate(RearSprocketConvComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(RearSprocketConvComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RearSprocketConvService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new RearSprocketConv(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.rearSprocketConvs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
