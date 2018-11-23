/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { MgearappTestModule } from '../../../test.module';
import { SprocketDetailComponent } from 'app/entities/sprocket/sprocket-detail.component';
import { Sprocket } from 'app/shared/model/sprocket.model';

describe('Component Tests', () => {
    describe('Sprocket Management Detail Component', () => {
        let comp: SprocketDetailComponent;
        let fixture: ComponentFixture<SprocketDetailComponent>;
        const route = ({ data: of({ sprocket: new Sprocket(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MgearappTestModule],
                declarations: [SprocketDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(SprocketDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(SprocketDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.sprocket).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
