import { Moment } from 'moment';

export interface IBrakePad {
    id?: number;
    sku?: string;
    au?: string;
    de?: string;
    bikemateVisibility?: string;
    mgiVisiblity?: string;
    activeNeto?: string;
    status?: string;
    productGroup1?: string;
    productGroup2?: string;
    fitment?: string;
    description?: string;
    unit?: string;
    qty?: number;
    brand?: string;
    biketypes?: string;
    models2012on?: string;
    gS1EAN?: number;
    ourNotes?: string;
    weightkg?: number;
    packType?: string;
    packLength?: number;
    packWidth?: number;
    packHeight?: number;
    packCubic?: number;
    caliper?: string;
    alength?: number;
    awidth?: number;
    athickness?: number;
    blength?: number;
    bwidth?: number;
    bthickness?: number;
    customerNotes?: string;
    eListing?: string;
    eforMake?: string;
    euploadedNeto?: string;
    eDate?: Moment;
    echeck?: string;
    euploadedeBay?: string;
    ebayactive?: string;
    ePhotobucket?: string;
    ePhotoMain?: string;
    ePhotoClear?: string;
    ePhotoSide?: string;
    saleStatus?: string;
    rRP?: number;
    eBay?: number;
    eBC?: string;
    sBS?: string;
    goldfren?: string;
    braking?: string;
    brembo?: string;
    ferodo?: string;
    goodridge?: string;
    premier?: string;
    carbon?: string;
    galfer?: string;
    vesrah?: string;
    lucas?: string;
    newFren?: string;
    dunlop?: string;
    lockheed?: string;
    bendix?: string;
}

export class BrakePad implements IBrakePad {
    constructor(
        public id?: number,
        public sku?: string,
        public au?: string,
        public de?: string,
        public bikemateVisibility?: string,
        public mgiVisiblity?: string,
        public activeNeto?: string,
        public status?: string,
        public productGroup1?: string,
        public productGroup2?: string,
        public fitment?: string,
        public description?: string,
        public unit?: string,
        public qty?: number,
        public brand?: string,
        public biketypes?: string,
        public models2012on?: string,
        public gS1EAN?: number,
        public ourNotes?: string,
        public weightkg?: number,
        public packType?: string,
        public packLength?: number,
        public packWidth?: number,
        public packHeight?: number,
        public packCubic?: number,
        public caliper?: string,
        public alength?: number,
        public awidth?: number,
        public athickness?: number,
        public blength?: number,
        public bwidth?: number,
        public bthickness?: number,
        public customerNotes?: string,
        public eListing?: string,
        public eforMake?: string,
        public euploadedNeto?: string,
        public eDate?: Moment,
        public echeck?: string,
        public euploadedeBay?: string,
        public ebayactive?: string,
        public ePhotobucket?: string,
        public ePhotoMain?: string,
        public ePhotoClear?: string,
        public ePhotoSide?: string,
        public saleStatus?: string,
        public rRP?: number,
        public eBay?: number,
        public eBC?: string,
        public sBS?: string,
        public goldfren?: string,
        public braking?: string,
        public brembo?: string,
        public ferodo?: string,
        public goodridge?: string,
        public premier?: string,
        public carbon?: string,
        public galfer?: string,
        public vesrah?: string,
        public lucas?: string,
        public newFren?: string,
        public dunlop?: string,
        public lockheed?: string,
        public bendix?: string
    ) {}
}
