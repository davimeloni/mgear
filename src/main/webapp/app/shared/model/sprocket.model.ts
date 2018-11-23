import { Moment } from 'moment';

export interface ISprocket {
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
    countries?: string;
    fitment?: string;
    description?: string;
    unit?: string;
    qty?: number;
    brand?: string;
    biketypes?: string;
    fitsMakes?: string;
    modelsupto?: number;
    gS1EAN?: number;
    ourNotes?: string;
    customerNotes?: string;
    weightkg?: number;
    packType?: string;
    packLength?: number;
    packWidth?: number;
    packHeight?: number;
    packCubic?: number;
    sprocketChainSize?: number;
    sprocketTeeth?: number;
    eSBHC?: string;
    eSID?: number;
    eSIDinnerTeeth?: string;
    eSBHQty?: number;
    eSBHSize?: string;
    eSBHType?: string;
    eSWidth?: number;
    tolistonEbay?: string;
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
    bikemateAUD?: string;
    compMetalGear?: string;
    compMogema?: string;
    compJT?: string;
    jTBHC?: string;
    jTID?: number;
    jTIDinnerTeeth?: number;
    jTBHQty?: string;
    jTBHSize?: number;
    jTBHType?: string;
    jTWidth?: number;
    jTNote?: string;
    compEsjot?: string;
    compSuperSprox?: string;
    stock?: number;
    minStock?: number;
    maxStock?: number;
    supplier?: string;
    supplierCode?: string;
    supplierCurrency?: string;
    supplierCost?: number;
}

export class Sprocket implements ISprocket {
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
        public countries?: string,
        public fitment?: string,
        public description?: string,
        public unit?: string,
        public qty?: number,
        public brand?: string,
        public biketypes?: string,
        public fitsMakes?: string,
        public modelsupto?: number,
        public gS1EAN?: number,
        public ourNotes?: string,
        public customerNotes?: string,
        public weightkg?: number,
        public packType?: string,
        public packLength?: number,
        public packWidth?: number,
        public packHeight?: number,
        public packCubic?: number,
        public sprocketChainSize?: number,
        public sprocketTeeth?: number,
        public eSBHC?: string,
        public eSID?: number,
        public eSIDinnerTeeth?: string,
        public eSBHQty?: number,
        public eSBHSize?: string,
        public eSBHType?: string,
        public eSWidth?: number,
        public tolistonEbay?: string,
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
        public bikemateAUD?: string,
        public compMetalGear?: string,
        public compMogema?: string,
        public compJT?: string,
        public jTBHC?: string,
        public jTID?: number,
        public jTIDinnerTeeth?: number,
        public jTBHQty?: string,
        public jTBHSize?: number,
        public jTBHType?: string,
        public jTWidth?: number,
        public jTNote?: string,
        public compEsjot?: string,
        public compSuperSprox?: string,
        public stock?: number,
        public minStock?: number,
        public maxStock?: number,
        public supplier?: string,
        public supplierCode?: string,
        public supplierCurrency?: string,
        public supplierCost?: number
    ) {}
}
