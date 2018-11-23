import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBikeBrakePad } from 'app/shared/model/bike-brake-pad.model';

type EntityResponseType = HttpResponse<IBikeBrakePad>;
type EntityArrayResponseType = HttpResponse<IBikeBrakePad[]>;

@Injectable({ providedIn: 'root' })
export class BikeBrakePadService {
    private resourceUrl = SERVER_API_URL + 'api/bike-brake-pads';

    constructor(private http: HttpClient) {}

    create(bikeBrakePad: IBikeBrakePad): Observable<EntityResponseType> {
        return this.http.post<IBikeBrakePad>(this.resourceUrl, bikeBrakePad, { observe: 'response' });
    }

    update(bikeBrakePad: IBikeBrakePad): Observable<EntityResponseType> {
        return this.http.put<IBikeBrakePad>(this.resourceUrl, bikeBrakePad, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBikeBrakePad>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBikeBrakePad[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
