/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MgearappTestModule } from '../../../test.module';
import { FrontSprocketConvComponent } from 'app/entities/front-sprocket-conv/front-sprocket-conv.component';
import { FrontSprocketConvService } from 'app/entities/front-sprocket-conv/front-sprocket-conv.service';
import { FrontSprocketConv } from 'app/shared/model/front-sprocket-conv.model';

describe('Component Tests', () => {
    describe('FrontSprocketConv Management Component', () => {
        let comp: FrontSprocketConvComponent;
        let fixture: ComponentFixture<FrontSprocketConvComponent>;
        let service: FrontSprocketConvService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [FrontSprocketConvComponent],
                providers: []
            })
                .overrideTemplate(FrontSprocketConvComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(FrontSprocketConvComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FrontSprocketConvService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new FrontSprocketConv(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.frontSprocketConvs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
