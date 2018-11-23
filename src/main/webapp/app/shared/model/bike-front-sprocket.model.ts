import { IBike } from 'app/shared/model//bike.model';

export interface IBikeFrontSprocket {
    id?: number;
    sku?: string;
    bikes?: IBike[];
}

export class BikeFrontSprocket implements IBikeFrontSprocket {
    constructor(public id?: number, public sku?: string, public bikes?: IBike[]) {}
}
