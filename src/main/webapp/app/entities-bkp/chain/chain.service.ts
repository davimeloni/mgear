import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IChain } from 'app/shared/model/chain.model';

type EntityResponseType = HttpResponse<IChain>;
type EntityArrayResponseType = HttpResponse<IChain[]>;

@Injectable({ providedIn: 'root' })
export class ChainService {
    private resourceUrl = SERVER_API_URL + 'api/chains';

    constructor(private http: HttpClient) {}

    create(chain: IChain): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(chain);
        return this.http
            .post<IChain>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(chain: IChain): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(chain);
        return this.http
            .put<IChain>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IChain>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IChain[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(chain: IChain): IChain {
        const copy: IChain = Object.assign({}, chain, {
            eDate: chain.eDate != null && chain.eDate.isValid() ? chain.eDate.format(DATE_FORMAT) : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.eDate = res.body.eDate != null ? moment(res.body.eDate) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((chain: IChain) => {
            chain.eDate = chain.eDate != null ? moment(chain.eDate) : null;
        });
        return res;
    }
}
