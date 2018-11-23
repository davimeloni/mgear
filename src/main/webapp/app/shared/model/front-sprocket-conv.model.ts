import { IBike } from 'app/shared/model//bike.model';

export interface IFrontSprocketConv {
    id?: number;
    sku?: string;
    bikes?: IBike[];
}

export class FrontSprocketConv implements IFrontSprocketConv {
    constructor(public id?: number, public sku?: string, public bikes?: IBike[]) {}
}
