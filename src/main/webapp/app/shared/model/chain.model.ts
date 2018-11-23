import { Moment } from 'moment';
import { IBike } from 'app/shared/model//bike.model';

export interface IChain {
    id?: number;
    sku?: string;
    active?: string;
    au?: string;
    de?: string;
    metalGearvisibility?: string;
    bikematevisibility?: string;
    mgiVisibility?: string;
    status?: string;
    productGroup1?: string;
    productGroup2?: string;
    description?: string;
    unit?: string;
    qty?: number;
    brand?: string;
    biketypes?: string;
    gS1EAN?: number;
    ourNotes?: string;
    customerNotes?: string;
    weightkg?: number;
    packType?: string;
    packLength?: number;
    packHeight?: number;
    packWidth?: number;
    maxccDirt?: number;
    packCubic?: number;
    maxccStreet?: number;
    chainSize?: number;
    chainType?: string;
    chainLinks?: number;
    chainTensileStrengthN?: string;
    chainColour?: string;
    compRK?: string;
    eListing?: string;
    eforMake?: string;
    euploadedNeto?: string;
    eDate?: Moment;
    echeck?: string;
    euploadedeBay?: string;
    eBayactive?: string;
    ePhotobucket?: string;
    ePhotoMain?: string;
    ePhotoClear?: string;
    ePhotoSide?: string;
    salesStatus?: string;
    rRP?: number;
    eBay?: number;
    trade1?: number;
    trade2?: number;
    trade3?: number;
    distributorNZAUD?: string;
    distributorUSD?: string;
    distributorEUR?: string;
    totalStock?: number;
    minStock?: number;
    maxStock?: number;
    supplier?: string;
    supplierCode?: string;
    supplierCurrency?: string;
    supplierCost?: number;
    bikes?: IBike[];
}

export class Chain implements IChain {
    constructor(
        public id?: number,
        public sku?: string,
        public active?: string,
        public au?: string,
        public de?: string,
        public metalGearvisibility?: string,
        public bikematevisibility?: string,
        public mgiVisibility?: string,
        public status?: string,
        public productGroup1?: string,
        public productGroup2?: string,
        public description?: string,
        public unit?: string,
        public qty?: number,
        public brand?: string,
        public biketypes?: string,
        public gS1EAN?: number,
        public ourNotes?: string,
        public customerNotes?: string,
        public weightkg?: number,
        public packType?: string,
        public packLength?: number,
        public packHeight?: number,
        public packWidth?: number,
        public maxccDirt?: number,
        public packCubic?: number,
        public maxccStreet?: number,
        public chainSize?: number,
        public chainType?: string,
        public chainLinks?: number,
        public chainTensileStrengthN?: string,
        public chainColour?: string,
        public compRK?: string,
        public eListing?: string,
        public eforMake?: string,
        public euploadedNeto?: string,
        public eDate?: Moment,
        public echeck?: string,
        public euploadedeBay?: string,
        public eBayactive?: string,
        public ePhotobucket?: string,
        public ePhotoMain?: string,
        public ePhotoClear?: string,
        public ePhotoSide?: string,
        public salesStatus?: string,
        public rRP?: number,
        public eBay?: number,
        public trade1?: number,
        public trade2?: number,
        public trade3?: number,
        public distributorNZAUD?: string,
        public distributorUSD?: string,
        public distributorEUR?: string,
        public totalStock?: number,
        public minStock?: number,
        public maxStock?: number,
        public supplier?: string,
        public supplierCode?: string,
        public supplierCurrency?: string,
        public supplierCost?: number,
        public bikes?: IBike[]
    ) {}
}
