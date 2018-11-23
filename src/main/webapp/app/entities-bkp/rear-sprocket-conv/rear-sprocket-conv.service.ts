import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRearSprocketConv } from 'app/shared/model/rear-sprocket-conv.model';

type EntityResponseType = HttpResponse<IRearSprocketConv>;
type EntityArrayResponseType = HttpResponse<IRearSprocketConv[]>;

@Injectable({ providedIn: 'root' })
export class RearSprocketConvService {
    private resourceUrl = SERVER_API_URL + 'api/rear-sprocket-convs';

    constructor(private http: HttpClient) {}

    create(rearSprocketConv: IRearSprocketConv): Observable<EntityResponseType> {
        return this.http.post<IRearSprocketConv>(this.resourceUrl, rearSprocketConv, { observe: 'response' });
    }

    update(rearSprocketConv: IRearSprocketConv): Observable<EntityResponseType> {
        return this.http.put<IRearSprocketConv>(this.resourceUrl, rearSprocketConv, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRearSprocketConv>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRearSprocketConv[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
