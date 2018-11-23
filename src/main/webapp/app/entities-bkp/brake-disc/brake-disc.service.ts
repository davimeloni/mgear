import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBrakeDisc } from 'app/shared/model/brake-disc.model';

type EntityResponseType = HttpResponse<IBrakeDisc>;
type EntityArrayResponseType = HttpResponse<IBrakeDisc[]>;

@Injectable({ providedIn: 'root' })
export class BrakeDiscService {
    private resourceUrl = SERVER_API_URL + 'api/brake-discs';

    constructor(private http: HttpClient) {}

    create(brakeDisc: IBrakeDisc): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(brakeDisc);
        return this.http
            .post<IBrakeDisc>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(brakeDisc: IBrakeDisc): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(brakeDisc);
        return this.http
            .put<IBrakeDisc>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IBrakeDisc>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IBrakeDisc[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(brakeDisc: IBrakeDisc): IBrakeDisc {
        const copy: IBrakeDisc = Object.assign({}, brakeDisc, {
            eDate: brakeDisc.eDate != null && brakeDisc.eDate.isValid() ? brakeDisc.eDate.format(DATE_FORMAT) : null,
            date: brakeDisc.date != null && brakeDisc.date.isValid() ? brakeDisc.date.format(DATE_FORMAT) : null,
            datesent: brakeDisc.datesent != null && brakeDisc.datesent.isValid() ? brakeDisc.datesent.format(DATE_FORMAT) : null,
            hAPapproved:
                brakeDisc.hAPapproved != null && brakeDisc.hAPapproved.isValid() ? brakeDisc.hAPapproved.format(DATE_FORMAT) : null,
            sHAapproved: brakeDisc.sHAapproved != null && brakeDisc.sHAapproved.isValid() ? brakeDisc.sHAapproved.format(DATE_FORMAT) : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.eDate = res.body.eDate != null ? moment(res.body.eDate) : null;
        res.body.date = res.body.date != null ? moment(res.body.date) : null;
        res.body.datesent = res.body.datesent != null ? moment(res.body.datesent) : null;
        res.body.hAPapproved = res.body.hAPapproved != null ? moment(res.body.hAPapproved) : null;
        res.body.sHAapproved = res.body.sHAapproved != null ? moment(res.body.sHAapproved) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((brakeDisc: IBrakeDisc) => {
            brakeDisc.eDate = brakeDisc.eDate != null ? moment(brakeDisc.eDate) : null;
            brakeDisc.date = brakeDisc.date != null ? moment(brakeDisc.date) : null;
            brakeDisc.datesent = brakeDisc.datesent != null ? moment(brakeDisc.datesent) : null;
            brakeDisc.hAPapproved = brakeDisc.hAPapproved != null ? moment(brakeDisc.hAPapproved) : null;
            brakeDisc.sHAapproved = brakeDisc.sHAapproved != null ? moment(brakeDisc.sHAapproved) : null;
        });
        return res;
    }
}
