import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBrakePad } from 'app/shared/model/brake-pad.model';

type EntityResponseType = HttpResponse<IBrakePad>;
type EntityArrayResponseType = HttpResponse<IBrakePad[]>;

@Injectable({ providedIn: 'root' })
export class BrakePadService {
    private resourceUrl = SERVER_API_URL + 'api/brake-pads';

    constructor(private http: HttpClient) {}

    create(brakePad: IBrakePad): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(brakePad);
        return this.http
            .post<IBrakePad>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(brakePad: IBrakePad): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(brakePad);
        return this.http
            .put<IBrakePad>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IBrakePad>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IBrakePad[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(brakePad: IBrakePad): IBrakePad {
        const copy: IBrakePad = Object.assign({}, brakePad, {
            eDate: brakePad.eDate != null && brakePad.eDate.isValid() ? brakePad.eDate.format(DATE_FORMAT) : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.eDate = res.body.eDate != null ? moment(res.body.eDate) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((brakePad: IBrakePad) => {
            brakePad.eDate = brakePad.eDate != null ? moment(brakePad.eDate) : null;
        });
        return res;
    }
}
