import { IBike } from 'app/shared/model//bike.model';

export interface IBikeBrakeDisc {
    id?: number;
    sku?: string;
    bikes?: IBike[];
}

export class BikeBrakeDisc implements IBikeBrakeDisc {
    constructor(public id?: number, public sku?: string, public bikes?: IBike[]) {}
}
