import { IBike } from 'app/shared/model//bike.model';

export interface IBikeBrakePad {
    id?: number;
    sku?: string;
    bikes?: IBike[];
}

export class BikeBrakePad implements IBikeBrakePad {
    constructor(public id?: number, public sku?: string, public bikes?: IBike[]) {}
}
