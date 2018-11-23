import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ISprocket } from 'app/shared/model/sprocket.model';

type EntityResponseType = HttpResponse<ISprocket>;
type EntityArrayResponseType = HttpResponse<ISprocket[]>;

@Injectable({ providedIn: 'root' })
export class SprocketService {
    private resourceUrl = SERVER_API_URL + 'api/sprockets';

    constructor(private http: HttpClient) {}

    create(sprocket: ISprocket): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(sprocket);
        return this.http
            .post<ISprocket>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(sprocket: ISprocket): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(sprocket);
        return this.http
            .put<ISprocket>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<ISprocket>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<ISprocket[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(sprocket: ISprocket): ISprocket {
        /*
        const copy: ISprocket = Object.assign({}, sprocket, {
            eDate: sprocket.eDate != null && sprocket.eDate.isValid() ? sprocket.eDate.format(DATE_FORMAT) : null
        });
        */
        const copy: ISprocket = Object.assign({}, sprocket);
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.eDate = res.body.eDate != null ? moment(res.body.eDate) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((sprocket: ISprocket) => {
            sprocket.eDate = sprocket.eDate != null ? moment(sprocket.eDate) : null;
        });
        return res;
    }
}
