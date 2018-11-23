import { IBikeFrontSprocket } from 'app/shared/model//bike-front-sprocket.model';
import { IBikeRearSprocket } from 'app/shared/model//bike-rear-sprocket.model';
import { IRearSprocketConv } from 'app/shared/model//rear-sprocket-conv.model';
import { IFrontSprocketConv } from 'app/shared/model//front-sprocket-conv.model';
import { IChain } from 'app/shared/model//chain.model';
import { IBikeBrakePad } from 'app/shared/model//bike-brake-pad.model';
import { IBikeBrakeDisc } from 'app/shared/model//bike-brake-disc.model';

export interface IBike {
    id?: number;
    visibilityAU?: string;
    visibilityEU?: string;
    inactive?: string;
    oemconfirmed?: string;
    oesource?: string;
    epid?: number;
    modeltype1?: string;
    modeltype2?: string;
    manufacturer?: string;
    strokes?: string;
    capacity?: number;
    modelName?: string;
    modelYearCode?: string;
    modelTypeCode?: string;
    year?: number;
    finalDriveType?: string;
    categoryPath?: string;
    modelNotes?: string;
    modelNotes2?: string;
    modelNotes3?: string;
    modelNotes4?: string;
    modelInfoHTML?: string;
    oemFrontBrakeSystemType?: string;
    oemFrontBrakeDiscLeft?: string;
    oemFrontBrakeDiscRight?: string;
    oemFrontBrakeDiscBolts?: string;
    oemFrontBDQTYPD?: number;
    oemFrontBrakeDiscABSRing?: string;
    oemFrontBrakeCaliper1?: string;
    oemFrontBrakeCaliper2?: string;
    oemFrontBrakeCaliperPin?: string;
    oemFrontBrakePadsFrontL?: string;
    oemFrontBrakePadsFrontR?: string;
    oemFrontShoe?: string;
    oemMidldleAxleBrakeDisc?: string;
    oemMiddleAxleBrakePads?: string;
    oemRearBrakeSystemType?: string;
    oeamRearBrakeDisc?: string;
    oeamRearBrakeDiscBolts?: string;
    oeamRearBrakeDiscBQTYPD?: number;
    oemRearBrakeCaliper?: string;
    oemRearBrakeCaliperPin?: string;
    oemRearBrakePads1?: string;
    oemRearBrakePads2?: string;
    oemShoeRear?: string;
    oemShoeRear2?: string;
    oemSlaveCylinder?: string;
    oemChainNo?: string;
    oemChainSize?: number;
    oemChainLinks?: number;
    oemFrontSprocket?: string;
    oemFrontGearing?: number;
    oemFrontGearingMin?: number;
    oemFrontGearingMax?: number;
    oemRearSprocket?: string;
    oemRearGearing?: number;
    oemRearGearingMin?: number;
    oemRearGearingMax?: number;
    finalDriveNotes?: string;
    chainConvSize?: number;
    chainConvLinks?: number;
    oemFrontWheel?: string;
    oemFrontWheelType?: string;
    oemFrontWheelFront?: number;
    oemFrontWheelTyreSize?: string;
    oemFrontHub?: string;
    oemFrontWheelbearing1?: string;
    oemFrontWheelbearing2?: string;
    oemFrontWheelSeal?: string;
    oemRearWheel?: string;
    oemRearWheelSize?: number;
    oemRearWheelTyre?: string;
    oemRearWheelBearing1?: string;
    oemRearWheelBearing2?: string;
    oemRearWheelSeal?: string;
    frontPadsDiffCaliper?: string;
    qtyBH?: number;
    handbrakeParking?: string;
    addNotesToBike?: string;
    dateAndID?: string;
    source?: string;
    tuvRequired?: string;
    tuvTypeCode?: string;
    abekba?: string;
    tuvFrontDisc?: string;
    tuvRearDisc?: string;
    bremboBrakeDiscFrontRef?: string;
    ebcBrakeDiscFrontRef?: string;
    trwBrakeDiscFrontRef?: string;
    mgearBrakeDiscFrontLeftRef?: string;
    mgearBrakeDiscFrontRightRef?: string;
    mgearBrakeDiscFrontCheck?: string;
    mgearBrakeDiscFrontLeftRef2?: string;
    mgearBrakeDiscFrontRightRef2?: string;
    mgearBrakeDiscFNeto?: string;
    motodiscBrakeDiscFNeto?: string;
    ebcBrakePadsFrontLRef?: string;
    ebcBrakePadsFrontRRef?: string;
    mgearBrakePadsFrontLRef?: string;
    mgearBrakePadsFrontRRef?: string;
    mgearBrakePadsFNeto?: string;
    motoPadBrakePadsFrontLRef?: string;
    motoPadBrakePadsFrontRRef?: string;
    motopadBrakePadsFNeto?: string;
    allBallsFCRebuildKit1?: string;
    allBallsFCPin?: string;
    allBallsFMCyRebuildKit?: string;
    allBallsFSCRebuildKit?: string;
    newfrenShoeFront?: string;
    mgearMiddleAxleBrakeDiscNeto?: string;
    mgearMiddleAxleBrakeDiscNeto2?: string;
    mgearMiddleAxleBrakePadNeto?: string;
    mgearMiddleAxleBrakePadNeto2?: string;
    mgearBrakePadsParkRef?: string;
    mgearBrakePadsParkRef2?: string;
    ebcBrakeDiscRearRef?: string;
    bremboBrakeDiscRearRef?: string;
    mgearBrakeDiscRearRef?: string;
    trwBrakeDiscRearRef?: string;
    mgearBrakeDiscRear?: string;
    allBallsRCRebuildKit1?: string;
    allBallsRearCaliperBolt?: string;
    allBallsRMCrRebuildKit?: string;
    ebcBrakePadsRearRef?: string;
    mgearBrakePadsRearNeto?: string;
    newfrenShoeRear?: string;
    allBallsRearBrakePedalKit?: string;
    allBallsCSCRebuildKit?: string;
    frontJTRefFront?: string;
    esjotRefFront?: string;
    mgearRefFront?: string;
    mogemaRefFront?: string;
    supersproxRefFront?: string;
    esjotRefRear?: string;
    jtRefRear?: string;
    mgearRefRear?: string;
    mogemaRefRear?: string;
    supersproxRefRear?: string;
    esjotRefFrontConv?: string;
    jtSprocketRef?: string;
    mgearRefFrontConv?: string;
    mogemarefFrontConv?: string;
    supersproxRefFrontConv?: string;
    conversionChain?: string;
    mgearSprocketRearConv?: string;
    esjotRefRearConv?: string;
    mgearRefRearConv?: string;
    mogemaRefRearConv?: string;
    supersproxRefRearConv?: string;
    allBallsFWBearingKit1?: string;
    allBallsFWBearingKit2?: string;
    allBallsRWBearingKit1?: string;
    allBallsRWBearingKit2?: string;
    allBallsRWBearingUpgrade?: string;
    oemSparkPlug?: string;
    oemSparkPlugQTY?: number;
    ngkSparkPlugSKUs?: string;
    oemAlternator?: string;
    oemVoltageRegulator?: string;
    arrowheadAlternator?: string;
    arrowheadAlternator2?: string;
    arrowheadCDIModule?: string;
    arrowheadChargingCoil?: string;
    arrowheadIgnitionCoil?: string;
    arrowheadStatorCoil?: string;
    arrowheadVoltageRegulator?: string;
    arrowheadPowerShiftCM?: string;
    arrowheadStarterDrive?: string;
    arrowheadStarterMotor?: string;
    arrowheadStarterRelay?: string;
    oemBattery?: string;
    ssbAGMBattery?: string;
    oemAirFilter?: string;
    knAirFilter?: string;
    motorexAirFilter?: string;
    motorexAirFilterPreoiled?: string;
    oemOilFilter1?: string;
    knOilFilter1?: string;
    oemOilFilter2?: string;
    knOilFilter2?: string;
    motionProOilFilterMagnet?: string;
    oemSteeringBearing?: string;
    oemSteeringSeal?: string;
    allBallsSBSealKit1?: string;
    allBallsSBSealKit2?: string;
    allBallsSBSealKitLower?: string;
    allBallsSBSealKitLower2?: string;
    allBallsCBSealKit?: string;
    oemForkAssemblyLeft?: string;
    oemForkAssemblyRight?: string;
    oemForkSeals?: string;
    allBallsForkSeals?: string;
    xprForkSeals?: string;
    allBallsForkBushingKit?: string;
    motionProMicroForkBleeder?: string;
    motionProCRProThottleKit?: string;
    oemCableSpeedo?: string;
    motionProCableSpeedo?: string;
    motionProCableThrottleTube?: string;
    crossproRadiatorGuard?: string;
    oemClutchFibres?: string;
    oemClutchFibresSteels?: string;
    newfrenClutchKit?: string;
    newfrenClutchSpringKits?: string;
    allBallsCMCRebuiltKit?: string;
    wisecoForgedClutchBasket?: string;
    wisecoBottemEndRebuildKit?: string;
    wrenchRERebuildKit?: string;
    oemCarbAssembly?: string;
    allBallsCarbRepairKit?: string;
    allBallsCRMidBodyGasket1?: string;
    allBallsCRMidBodyGasket2?: string;
    allBallsFuelTapRepairKit?: string;
    allBallsFuelTapRepairKit2?: string;
    fuelStarFuelValveKit?: string;
    fuelStarFuelValveKit2?: string;
    fuelStarHoseClampKit?: string;
    rgEngineCoverLHS?: string;
    rgTailTidy?: string;
    allBallsLBSealKit?: string;
    allBallsLRSBearingKit?: string;
    allBallsURSBearingKit?: string;
    allBallsULSBearingKit?: string;
    allBallsSBSealKit?: string;
    pivotWorksSTBearingKit?: string;
    pivotWorksSRebuildKit?: string;
    mpForkSealDriver?: string;
    mpValveSealInstallTool?: string;
    winderosaGasketKitTopEnd?: string;
    winderosaGasketKitOilSeals?: string;
    oemExhaustGasket?: string;
    winderosaGasketExhaust?: string;
    winderosaWaterPumpRebuildKit?: string;
    hotRodsConnectingRodKit?: string;
    hotRodsCounterBalRebuildKit?: string;
    hotRodsBERebuildKit?: string;
    hotRodsBERebuildKitSt?: string;
    hotRodsCylinderHead?: string;
    hotRodsMainBearingSealKit?: string;
    hotRodsTransmissionBearings?: string;
    hotRodsWristPinBearings?: string;
    hotRodsSOHCCamshaftStage1?: string;
    hotRodsSOHCCamshaftStage2?: string;
    hotRodsSOHCCamshaftStage3?: string;
    hotRodsDOHCCamshaftStage1Intake?: string;
    hotRodsDOHCCamshaftStage1Exhaust?: string;
    hotRodsDOHCCamshaftStage2Intake?: string;
    hotRodsDOHCCamshaftStage2Exhaust?: string;
    bikeFrontSprockets?: IBikeFrontSprocket[];
    bikeRearSprockets?: IBikeRearSprocket[];
    rearSprocketConvs?: IRearSprocketConv[];
    frontSprocketConvs?: IFrontSprocketConv[];
    chains?: IChain[];
    bikeBrakePads?: IBikeBrakePad[];
    bikeBrakeDiscs?: IBikeBrakeDisc[];
}

export class Bike implements IBike {
    constructor(
        public id?: number,
        public visibilityAU?: string,
        public visibilityEU?: string,
        public inactive?: string,
        public oemconfirmed?: string,
        public oesource?: string,
        public epid?: number,
        public modeltype1?: string,
        public modeltype2?: string,
        public manufacturer?: string,
        public strokes?: string,
        public capacity?: number,
        public modelName?: string,
        public modelYearCode?: string,
        public modelTypeCode?: string,
        public year?: number,
        public finalDriveType?: string,
        public categoryPath?: string,
        public modelNotes?: string,
        public modelNotes2?: string,
        public modelNotes3?: string,
        public modelNotes4?: string,
        public modelInfoHTML?: string,
        public oemFrontBrakeSystemType?: string,
        public oemFrontBrakeDiscLeft?: string,
        public oemFrontBrakeDiscRight?: string,
        public oemFrontBrakeDiscBolts?: string,
        public oemFrontBDQTYPD?: number,
        public oemFrontBrakeDiscABSRing?: string,
        public oemFrontBrakeCaliper1?: string,
        public oemFrontBrakeCaliper2?: string,
        public oemFrontBrakeCaliperPin?: string,
        public oemFrontBrakePadsFrontL?: string,
        public oemFrontBrakePadsFrontR?: string,
        public oemFrontShoe?: string,
        public oemMidldleAxleBrakeDisc?: string,
        public oemMiddleAxleBrakePads?: string,
        public oemRearBrakeSystemType?: string,
        public oeamRearBrakeDisc?: string,
        public oeamRearBrakeDiscBolts?: string,
        public oeamRearBrakeDiscBQTYPD?: number,
        public oemRearBrakeCaliper?: string,
        public oemRearBrakeCaliperPin?: string,
        public oemRearBrakePads1?: string,
        public oemRearBrakePads2?: string,
        public oemShoeRear?: string,
        public oemShoeRear2?: string,
        public oemSlaveCylinder?: string,
        public oemChainNo?: string,
        public oemChainSize?: number,
        public oemChainLinks?: number,
        public oemFrontSprocket?: string,
        public oemFrontGearing?: number,
        public oemFrontGearingMin?: number,
        public oemFrontGearingMax?: number,
        public oemRearSprocket?: string,
        public oemRearGearing?: number,
        public oemRearGearingMin?: number,
        public oemRearGearingMax?: number,
        public finalDriveNotes?: string,
        public chainConvSize?: number,
        public chainConvLinks?: number,
        public oemFrontWheel?: string,
        public oemFrontWheelType?: string,
        public oemFrontWheelFront?: number,
        public oemFrontWheelTyreSize?: string,
        public oemFrontHub?: string,
        public oemFrontWheelbearing1?: string,
        public oemFrontWheelbearing2?: string,
        public oemFrontWheelSeal?: string,
        public oemRearWheel?: string,
        public oemRearWheelSize?: number,
        public oemRearWheelTyre?: string,
        public oemRearWheelBearing1?: string,
        public oemRearWheelBearing2?: string,
        public oemRearWheelSeal?: string,
        public frontPadsDiffCaliper?: string,
        public qtyBH?: number,
        public handbrakeParking?: string,
        public addNotesToBike?: string,
        public dateAndID?: string,
        public source?: string,
        public tuvRequired?: string,
        public tuvTypeCode?: string,
        public abekba?: string,
        public tuvFrontDisc?: string,
        public tuvRearDisc?: string,
        public bremboBrakeDiscFrontRef?: string,
        public ebcBrakeDiscFrontRef?: string,
        public trwBrakeDiscFrontRef?: string,
        public mgearBrakeDiscFrontLeftRef?: string,
        public mgearBrakeDiscFrontRightRef?: string,
        public mgearBrakeDiscFrontCheck?: string,
        public mgearBrakeDiscFrontLeftRef2?: string,
        public mgearBrakeDiscFrontRightRef2?: string,
        public mgearBrakeDiscFNeto?: string,
        public motodiscBrakeDiscFNeto?: string,
        public ebcBrakePadsFrontLRef?: string,
        public ebcBrakePadsFrontRRef?: string,
        public mgearBrakePadsFrontLRef?: string,
        public mgearBrakePadsFrontRRef?: string,
        public mgearBrakePadsFNeto?: string,
        public motoPadBrakePadsFrontLRef?: string,
        public motoPadBrakePadsFrontRRef?: string,
        public motopadBrakePadsFNeto?: string,
        public allBallsFCRebuildKit1?: string,
        public allBallsFCPin?: string,
        public allBallsFMCyRebuildKit?: string,
        public allBallsFSCRebuildKit?: string,
        public newfrenShoeFront?: string,
        public mgearMiddleAxleBrakeDiscNeto?: string,
        public mgearMiddleAxleBrakeDiscNeto2?: string,
        public mgearMiddleAxleBrakePadNeto?: string,
        public mgearMiddleAxleBrakePadNeto2?: string,
        public mgearBrakePadsParkRef?: string,
        public mgearBrakePadsParkRef2?: string,
        public ebcBrakeDiscRearRef?: string,
        public bremboBrakeDiscRearRef?: string,
        public mgearBrakeDiscRearRef?: string,
        public trwBrakeDiscRearRef?: string,
        public mgearBrakeDiscRear?: string,
        public allBallsRCRebuildKit1?: string,
        public allBallsRearCaliperBolt?: string,
        public allBallsRMCrRebuildKit?: string,
        public ebcBrakePadsRearRef?: string,
        public mgearBrakePadsRearNeto?: string,
        public newfrenShoeRear?: string,
        public allBallsRearBrakePedalKit?: string,
        public allBallsCSCRebuildKit?: string,
        public frontJTRefFront?: string,
        public esjotRefFront?: string,
        public mgearRefFront?: string,
        public mogemaRefFront?: string,
        public supersproxRefFront?: string,
        public esjotRefRear?: string,
        public jtRefRear?: string,
        public mgearRefRear?: string,
        public mogemaRefRear?: string,
        public supersproxRefRear?: string,
        public esjotRefFrontConv?: string,
        public jtSprocketRef?: string,
        public mgearRefFrontConv?: string,
        public mogemarefFrontConv?: string,
        public supersproxRefFrontConv?: string,
        public conversionChain?: string,
        public mgearSprocketRearConv?: string,
        public esjotRefRearConv?: string,
        public mgearRefRearConv?: string,
        public mogemaRefRearConv?: string,
        public supersproxRefRearConv?: string,
        public allBallsFWBearingKit1?: string,
        public allBallsFWBearingKit2?: string,
        public allBallsRWBearingKit1?: string,
        public allBallsRWBearingKit2?: string,
        public allBallsRWBearingUpgrade?: string,
        public oemSparkPlug?: string,
        public oemSparkPlugQTY?: number,
        public ngkSparkPlugSKUs?: string,
        public oemAlternator?: string,
        public oemVoltageRegulator?: string,
        public arrowheadAlternator?: string,
        public arrowheadAlternator2?: string,
        public arrowheadCDIModule?: string,
        public arrowheadChargingCoil?: string,
        public arrowheadIgnitionCoil?: string,
        public arrowheadStatorCoil?: string,
        public arrowheadVoltageRegulator?: string,
        public arrowheadPowerShiftCM?: string,
        public arrowheadStarterDrive?: string,
        public arrowheadStarterMotor?: string,
        public arrowheadStarterRelay?: string,
        public oemBattery?: string,
        public ssbAGMBattery?: string,
        public oemAirFilter?: string,
        public knAirFilter?: string,
        public motorexAirFilter?: string,
        public motorexAirFilterPreoiled?: string,
        public oemOilFilter1?: string,
        public knOilFilter1?: string,
        public oemOilFilter2?: string,
        public knOilFilter2?: string,
        public motionProOilFilterMagnet?: string,
        public oemSteeringBearing?: string,
        public oemSteeringSeal?: string,
        public allBallsSBSealKit1?: string,
        public allBallsSBSealKit2?: string,
        public allBallsSBSealKitLower?: string,
        public allBallsSBSealKitLower2?: string,
        public allBallsCBSealKit?: string,
        public oemForkAssemblyLeft?: string,
        public oemForkAssemblyRight?: string,
        public oemForkSeals?: string,
        public allBallsForkSeals?: string,
        public xprForkSeals?: string,
        public allBallsForkBushingKit?: string,
        public motionProMicroForkBleeder?: string,
        public motionProCRProThottleKit?: string,
        public oemCableSpeedo?: string,
        public motionProCableSpeedo?: string,
        public motionProCableThrottleTube?: string,
        public crossproRadiatorGuard?: string,
        public oemClutchFibres?: string,
        public oemClutchFibresSteels?: string,
        public newfrenClutchKit?: string,
        public newfrenClutchSpringKits?: string,
        public allBallsCMCRebuiltKit?: string,
        public wisecoForgedClutchBasket?: string,
        public wisecoBottemEndRebuildKit?: string,
        public wrenchRERebuildKit?: string,
        public oemCarbAssembly?: string,
        public allBallsCarbRepairKit?: string,
        public allBallsCRMidBodyGasket1?: string,
        public allBallsCRMidBodyGasket2?: string,
        public allBallsFuelTapRepairKit?: string,
        public allBallsFuelTapRepairKit2?: string,
        public fuelStarFuelValveKit?: string,
        public fuelStarFuelValveKit2?: string,
        public fuelStarHoseClampKit?: string,
        public rgEngineCoverLHS?: string,
        public rgTailTidy?: string,
        public allBallsLBSealKit?: string,
        public allBallsLRSBearingKit?: string,
        public allBallsURSBearingKit?: string,
        public allBallsULSBearingKit?: string,
        public allBallsSBSealKit?: string,
        public pivotWorksSTBearingKit?: string,
        public pivotWorksSRebuildKit?: string,
        public mpForkSealDriver?: string,
        public mpValveSealInstallTool?: string,
        public winderosaGasketKitTopEnd?: string,
        public winderosaGasketKitOilSeals?: string,
        public oemExhaustGasket?: string,
        public winderosaGasketExhaust?: string,
        public winderosaWaterPumpRebuildKit?: string,
        public hotRodsConnectingRodKit?: string,
        public hotRodsCounterBalRebuildKit?: string,
        public hotRodsBERebuildKit?: string,
        public hotRodsBERebuildKitSt?: string,
        public hotRodsCylinderHead?: string,
        public hotRodsMainBearingSealKit?: string,
        public hotRodsTransmissionBearings?: string,
        public hotRodsWristPinBearings?: string,
        public hotRodsSOHCCamshaftStage1?: string,
        public hotRodsSOHCCamshaftStage2?: string,
        public hotRodsSOHCCamshaftStage3?: string,
        public hotRodsDOHCCamshaftStage1Intake?: string,
        public hotRodsDOHCCamshaftStage1Exhaust?: string,
        public hotRodsDOHCCamshaftStage2Intake?: string,
        public hotRodsDOHCCamshaftStage2Exhaust?: string,
        public bikeFrontSprockets?: IBikeFrontSprocket[],
        public bikeRearSprockets?: IBikeRearSprocket[],
        public rearSprocketConvs?: IRearSprocketConv[],
        public frontSprocketConvs?: IFrontSprocketConv[],
        public chains?: IChain[],
        public bikeBrakePads?: IBikeBrakePad[],
        public bikeBrakeDiscs?: IBikeBrakeDisc[]
    ) {}
}
