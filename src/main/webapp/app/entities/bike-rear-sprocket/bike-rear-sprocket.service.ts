import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBikeRearSprocket } from 'app/shared/model/bike-rear-sprocket.model';

type EntityResponseType = HttpResponse<IBikeRearSprocket>;
type EntityArrayResponseType = HttpResponse<IBikeRearSprocket[]>;

@Injectable({ providedIn: 'root' })
export class BikeRearSprocketService {
    private resourceUrl = SERVER_API_URL + 'api/bike-rear-sprockets';

    constructor(private http: HttpClient) {}

    create(bikeRearSprocket: IBikeRearSprocket): Observable<EntityResponseType> {
        return this.http.post<IBikeRearSprocket>(this.resourceUrl, bikeRearSprocket, { observe: 'response' });
    }

    update(bikeRearSprocket: IBikeRearSprocket): Observable<EntityResponseType> {
        return this.http.put<IBikeRearSprocket>(this.resourceUrl, bikeRearSprocket, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBikeRearSprocket>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBikeRearSprocket[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
