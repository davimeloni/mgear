import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBike } from 'app/shared/model/bike.model';

type EntityResponseType = HttpResponse<IBike>;
type EntityArrayResponseType = HttpResponse<IBike[]>;

@Injectable({ providedIn: 'root' })
export class BikeService {
    private resourceUrl = SERVER_API_URL + 'api/bikes';

    constructor(private http: HttpClient) {}

    create(bike: IBike): Observable<EntityResponseType> {
        return this.http.post<IBike>(this.resourceUrl, bike, { observe: 'response' });
    }

    update(bike: IBike): Observable<EntityResponseType> {
        return this.http.put<IBike>(this.resourceUrl, bike, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBike>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBike[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
