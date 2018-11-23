import { IBike } from 'app/shared/model//bike.model';

export interface IRearSprocketConv {
    id?: number;
    sku?: string;
    bikes?: IBike[];
}

export class RearSprocketConv implements IRearSprocketConv {
    constructor(public id?: number, public sku?: string, public bikes?: IBike[]) {}
}
