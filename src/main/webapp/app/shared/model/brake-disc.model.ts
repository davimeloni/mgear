import { Moment } from 'moment';

export interface IBrakeDisc {
    id?: number;
    sku?: string;
    active?: string;
    au?: string;
    de?: string;
    metalGearvisibility?: string;
    bikematevisibility?: string;
    mgiVisibility?: string;
    discStatus?: string;
    productGroup1?: string;
    productGroup2?: string;
    fitment?: string;
    description?: string;
    unit?: string;
    qty?: number;
    brand?: string;
    biketypes?: string;
    models2012on?: string;
    gS1EANNo?: number;
    ourNotes?: string;
    weight?: number;
    packType?: string;
    packLength?: number;
    packHeight?: number;
    packWidth?: number;
    packCubic?: number;
    oD?: number;
    bHC?: string;
    bHQty?: number;
    bHSize?: number;
    bHOD?: number;
    bHStep?: number;
    bHType?: string;
    thickness?: number;
    thicknessMin?: number;
    offset?: number;
    brakeAreawidth?: number;
    tUVLHC?: string;
    customerNotes?: string;
    eListing?: string;
    eforMake?: string;
    eDate?: Moment;
    euploadedNeto?: string;
    echeck?: string;
    euploadedeBay?: string;
    ebayactive?: string;
    ePhotobucket?: string;
    ePhoto1?: string;
    ePhoto2?: string;
    ePhoto3?: string;
    saleStatus?: string;
    rRP?: number;
    trade1?: number;
    eBAY?: number;
    trade2?: number;
    trade3?: number;
    distributorNZAUD?: number;
    distributorEUR?: number;
    distributorUSD?: number;
    sPriority?: string;
    samplefrom?: string;
    requestedfrom?: string;
    date?: Moment;
    received?: string;
    camefrom?: string;
    paidfor?: string;
    sentto?: string;
    shipNo?: number;
    datesent?: Moment;
    samplereturn?: string;
    make?: string;
    model?: string;
    year?: string;
    sampleFitment?: string;
    oEM?: string;
    notesforProduction?: string;
    productionCode?: string;
    hAPapproved?: Moment;
    sHAapproved?: Moment;
    approvedby?: string;
    notestoDrawing?: string;
    filename?: string;
    cOSTUSD?: number;
    centrecolour?: string;
    laser?: string;
    qTY1?: number;
    uSD?: number;
    completeProduction?: string;
    ourNotetoProduction?: string;
}

export class BrakeDisc implements IBrakeDisc {
    constructor(
        public id?: number,
        public sku?: string,
        public active?: string,
        public au?: string,
        public de?: string,
        public metalGearvisibility?: string,
        public bikematevisibility?: string,
        public mgiVisibility?: string,
        public discStatus?: string,
        public productGroup1?: string,
        public productGroup2?: string,
        public fitment?: string,
        public description?: string,
        public unit?: string,
        public qty?: number,
        public brand?: string,
        public biketypes?: string,
        public models2012on?: string,
        public gS1EANNo?: number,
        public ourNotes?: string,
        public weight?: number,
        public packType?: string,
        public packLength?: number,
        public packHeight?: number,
        public packWidth?: number,
        public packCubic?: number,
        public oD?: number,
        public bHC?: string,
        public bHQty?: number,
        public bHSize?: number,
        public bHOD?: number,
        public bHStep?: number,
        public bHType?: string,
        public thickness?: number,
        public thicknessMin?: number,
        public offset?: number,
        public brakeAreawidth?: number,
        public tUVLHC?: string,
        public customerNotes?: string,
        public eListing?: string,
        public eforMake?: string,
        public eDate?: Moment,
        public euploadedNeto?: string,
        public echeck?: string,
        public euploadedeBay?: string,
        public ebayactive?: string,
        public ePhotobucket?: string,
        public ePhoto1?: string,
        public ePhoto2?: string,
        public ePhoto3?: string,
        public saleStatus?: string,
        public rRP?: number,
        public trade1?: number,
        public eBAY?: number,
        public trade2?: number,
        public trade3?: number,
        public distributorNZAUD?: number,
        public distributorEUR?: number,
        public distributorUSD?: number,
        public sPriority?: string,
        public samplefrom?: string,
        public requestedfrom?: string,
        public date?: Moment,
        public received?: string,
        public camefrom?: string,
        public paidfor?: string,
        public sentto?: string,
        public shipNo?: number,
        public datesent?: Moment,
        public samplereturn?: string,
        public make?: string,
        public model?: string,
        public year?: string,
        public sampleFitment?: string,
        public oEM?: string,
        public notesforProduction?: string,
        public productionCode?: string,
        public hAPapproved?: Moment,
        public sHAapproved?: Moment,
        public approvedby?: string,
        public notestoDrawing?: string,
        public filename?: string,
        public cOSTUSD?: number,
        public centrecolour?: string,
        public laser?: string,
        public qTY1?: number,
        public uSD?: number,
        public completeProduction?: string,
        public ourNotetoProduction?: string
    ) {}
}
