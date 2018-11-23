import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBikeFrontSprocket } from 'app/shared/model/bike-front-sprocket.model';

type EntityResponseType = HttpResponse<IBikeFrontSprocket>;
type EntityArrayResponseType = HttpResponse<IBikeFrontSprocket[]>;

@Injectable({ providedIn: 'root' })
export class BikeFrontSprocketService {
    private resourceUrl = SERVER_API_URL + 'api/bike-front-sprockets';

    constructor(private http: HttpClient) {}

    create(bikeFrontSprocket: IBikeFrontSprocket): Observable<EntityResponseType> {
        return this.http.post<IBikeFrontSprocket>(this.resourceUrl, bikeFrontSprocket, { observe: 'response' });
    }

    update(bikeFrontSprocket: IBikeFrontSprocket): Observable<EntityResponseType> {
        return this.http.put<IBikeFrontSprocket>(this.resourceUrl, bikeFrontSprocket, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBikeFrontSprocket>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBikeFrontSprocket[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
