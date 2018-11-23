import { IBike } from 'app/shared/model//bike.model';

export interface IBikeRearSprocket {
    id?: number;
    sku?: string;
    bikes?: IBike[];
}

export class BikeRearSprocket implements IBikeRearSprocket {
    constructor(public id?: number, public sku?: string, public bikes?: IBike[]) {}
}
