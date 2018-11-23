import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBikeBrakeDisc } from 'app/shared/model/bike-brake-disc.model';

type EntityResponseType = HttpResponse<IBikeBrakeDisc>;
type EntityArrayResponseType = HttpResponse<IBikeBrakeDisc[]>;

@Injectable({ providedIn: 'root' })
export class BikeBrakeDiscService {
    private resourceUrl = SERVER_API_URL + 'api/bike-brake-discs';

    constructor(private http: HttpClient) {}

    create(bikeBrakeDisc: IBikeBrakeDisc): Observable<EntityResponseType> {
        return this.http.post<IBikeBrakeDisc>(this.resourceUrl, bikeBrakeDisc, { observe: 'response' });
    }

    update(bikeBrakeDisc: IBikeBrakeDisc): Observable<EntityResponseType> {
        return this.http.put<IBikeBrakeDisc>(this.resourceUrl, bikeBrakeDisc, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBikeBrakeDisc>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBikeBrakeDisc[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
