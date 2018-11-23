/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MgearappTestModule } from '../../../test.module';
import { SprocketComponent } from 'app/entities/sprocket/sprocket.component';
import { SprocketService } from 'app/entities/sprocket/sprocket.service';
import { Sprocket } from 'app/shared/model/sprocket.model';

describe('Component Tests', () => {
    describe('Sprocket Management Component', () => {
        let comp: SprocketComponent;
        let fixture: ComponentFixture<SprocketComponent>;
        let service: SprocketService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [SprocketComponent],
                providers: []
            })
                .overrideTemplate(SprocketComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(SprocketComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SprocketService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Sprocket(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.sprockets[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
