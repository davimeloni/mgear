package com.mgearapp.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Bike entity.
 */
public class BikeDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    private String visibilityAU;

    private String visibilityEU;

    private String inactive;

    private String oemconfirmed;

    private String oesource;

    private Long epid;

    private String modeltype1;

    private String modeltype2;

    private String manufacturer;

    private String strokes;

    private Long capacity;

    private String modelName;

    private String modelYearCode;

    private String modelTypeCode;

    private Long year;

    private String finalDriveType;

    private String categoryPath;

    private String modelNotes;

    private String modelNotes2;

    private String modelNotes3;

    private String modelNotes4;

    private String modelInfoHTML;

    private String oemFrontBrakeSystemType;

    private String oemFrontBrakeDiscLeft;

    private String oemFrontBrakeDiscRight;

    private String oemFrontBrakeDiscBolts;

    private Long oemFrontBDQTYPD;

    private String oemFrontBrakeDiscABSRing;

    private String oemFrontBrakeCaliper1;

    private String oemFrontBrakeCaliper2;

    private String oemFrontBrakeCaliperPin;

    private String oemFrontBrakePadsFrontL;

    private String oemFrontBrakePadsFrontR;

    private String oemFrontShoe;

    private String oemMidldleAxleBrakeDisc;

    private String oemMiddleAxleBrakePads;

    private String oemRearBrakeSystemType;

    private String oeamRearBrakeDisc;

    private String oeamRearBrakeDiscBolts;

    private Long oeamRearBrakeDiscBQTYPD;

    private String oemRearBrakeCaliper;

    private String oemRearBrakeCaliperPin;

    private String oemRearBrakePads1;

    private String oemRearBrakePads2;

    private String oemShoeRear;

    private String oemShoeRear2;

    private String oemSlaveCylinder;

    private String oemChainNo;

    private BigDecimal oemChainSize;

    private BigDecimal oemChainLinks;

    private String oemFrontSprocket;

    private Long oemFrontGearing;

    private BigDecimal oemFrontGearingMin;

    private BigDecimal oemFrontGearingMax;

    private String oemRearSprocket;

    private BigDecimal oemRearGearing;

    private BigDecimal oemRearGearingMin;

    private BigDecimal oemRearGearingMax;

    private String finalDriveNotes;

    private BigDecimal chainConvSize;

    private BigDecimal chainConvLinks;

    private String oemFrontWheel;

    private String oemFrontWheelType;

    private BigDecimal oemFrontWheelFront;

    private String oemFrontWheelTyreSize;

    private String oemFrontHub;

    private String oemFrontWheelbearing1;

    private String oemFrontWheelbearing2;

    private String oemFrontWheelSeal;

    private String oemRearWheel;

    private BigDecimal oemRearWheelSize;

    private String oemRearWheelTyre;

    private String oemRearWheelBearing1;

    private String oemRearWheelBearing2;

    private String oemRearWheelSeal;

    private String frontPadsDiffCaliper;

    private Long qtyBH;

    private String handbrakeParking;

    private String addNotesToBike;

    private String dateAndID;

    private String source;

    private String tuvRequired;

    private String tuvTypeCode;

    private String abekba;

    private String tuvFrontDisc;

    private String tuvRearDisc;

    private String bremboBrakeDiscFrontRef;

    private String ebcBrakeDiscFrontRef;

    private String trwBrakeDiscFrontRef;

    private String mgearBrakeDiscFrontLeftRef;

    private String mgearBrakeDiscFrontRightRef;

    private String mgearBrakeDiscFrontCheck;

    private String mgearBrakeDiscFrontLeftRef2;

    private String mgearBrakeDiscFrontRightRef2;

    private String mgearBrakeDiscFNeto;

    private String motodiscBrakeDiscFNeto;

    private String ebcBrakePadsFrontLRef;

    private String ebcBrakePadsFrontRRef;

    private String mgearBrakePadsFrontLRef;

    private String mgearBrakePadsFrontRRef;

    private String mgearBrakePadsFNeto;

    private String motoPadBrakePadsFrontLRef;

    private String motoPadBrakePadsFrontRRef;

    private String motopadBrakePadsFNeto;

    private String allBallsFCRebuildKit1;

    private String allBallsFCPin;

    private String allBallsFMCyRebuildKit;

    private String allBallsFSCRebuildKit;

    private String newfrenShoeFront;

    private String mgearMiddleAxleBrakeDiscNeto;

    private String mgearMiddleAxleBrakeDiscNeto2;

    private String mgearMiddleAxleBrakePadNeto;

    private String mgearMiddleAxleBrakePadNeto2;

    private String mgearBrakePadsParkRef;

    private String mgearBrakePadsParkRef2;

    private String ebcBrakeDiscRearRef;

    private String bremboBrakeDiscRearRef;

    private String mgearBrakeDiscRearRef;

    private String trwBrakeDiscRearRef;

    private String mgearBrakeDiscRear;

    private String allBallsRCRebuildKit1;

    private String allBallsRearCaliperBolt;

    private String allBallsRMCrRebuildKit;

    private String ebcBrakePadsRearRef;

    private String mgearBrakePadsRearNeto;

    private String newfrenShoeRear;

    private String allBallsRearBrakePedalKit;

    private String allBallsCSCRebuildKit;

    private String frontJTRefFront;

    private String esjotRefFront;

    private String mgearRefFront;

    private String mogemaRefFront;

    private String supersproxRefFront;

    private String esjotRefRear;

    private String jtRefRear;

    private String mgearRefRear;

    private String mogemaRefRear;

    private String supersproxRefRear;

    private String esjotRefFrontConv;

    private String jtSprocketRef;

    private String mgearRefFrontConv;

    private String mogemarefFrontConv;

    private String supersproxRefFrontConv;

    private String conversionChain;

    private String mgearSprocketRearConv;

    private String esjotRefRearConv;

    private String mgearRefRearConv;

    private String mogemaRefRearConv;

    private String supersproxRefRearConv;

    private String allBallsFWBearingKit1;

    private String allBallsFWBearingKit2;

    private String allBallsRWBearingKit1;

    private String allBallsRWBearingKit2;

    private String allBallsRWBearingUpgrade;

    private String oemSparkPlug;

    private Long oemSparkPlugQTY;

    private String ngkSparkPlugSKUs;

    private String oemAlternator;

    private String oemVoltageRegulator;

    private String arrowheadAlternator;

    private String arrowheadAlternator2;

    private String arrowheadCDIModule;

    private String arrowheadChargingCoil;

    private String arrowheadIgnitionCoil;

    private String arrowheadStatorCoil;

    private String arrowheadVoltageRegulator;

    private String arrowheadPowerShiftCM;

    private String arrowheadStarterDrive;

    private String arrowheadStarterMotor;

    private String arrowheadStarterRelay;

    private String oemBattery;

    private String ssbAGMBattery;

    private String oemAirFilter;

    private String knAirFilter;

    private String motorexAirFilter;

    private String motorexAirFilterPreoiled;

    private String oemOilFilter1;

    private String knOilFilter1;

    private String oemOilFilter2;

    private String knOilFilter2;

    private String motionProOilFilterMagnet;

    private String oemSteeringBearing;

    private String oemSteeringSeal;

    private String allBallsSBSealKit1;

    private String allBallsSBSealKit2;

    private String allBallsSBSealKitLower;

    private String allBallsSBSealKitLower2;

    private String allBallsCBSealKit;

    private String oemForkAssemblyLeft;

    private String oemForkAssemblyRight;

    private String oemForkSeals;

    private String allBallsForkSeals;

    private String xprForkSeals;

    private String allBallsForkBushingKit;

    private String motionProMicroForkBleeder;

    private String motionProCRProThottleKit;

    private String oemCableSpeedo;

    private String motionProCableSpeedo;

    private String motionProCableThrottleTube;

    private String crossproRadiatorGuard;

    private String oemClutchFibres;

    private String oemClutchFibresSteels;

    private String newfrenClutchKit;

    private String newfrenClutchSpringKits;

    private String allBallsCMCRebuiltKit;

    private String wisecoForgedClutchBasket;

    private String wisecoBottemEndRebuildKit;

    private String wrenchRERebuildKit;

    private String oemCarbAssembly;

    private String allBallsCarbRepairKit;

    private String allBallsCRMidBodyGasket1;

    private String allBallsCRMidBodyGasket2;

    private String allBallsFuelTapRepairKit;

    private String allBallsFuelTapRepairKit2;

    private String fuelStarFuelValveKit;

    private String fuelStarFuelValveKit2;

    private String fuelStarHoseClampKit;

    private String rgEngineCoverLHS;

    private String rgTailTidy;

    private String allBallsLBSealKit;

    private String allBallsLRSBearingKit;

    private String allBallsURSBearingKit;

    private String allBallsULSBearingKit;

    private String allBallsSBSealKit;

    private String pivotWorksSTBearingKit;

    private String pivotWorksSRebuildKit;

    private String mpForkSealDriver;

    private String mpValveSealInstallTool;

    private String winderosaGasketKitTopEnd;

    private String winderosaGasketKitOilSeals;

    private String oemExhaustGasket;

    private String winderosaGasketExhaust;

    private String winderosaWaterPumpRebuildKit;

    private String hotRodsConnectingRodKit;

    private String hotRodsCounterBalRebuildKit;

    private String hotRodsBERebuildKit;

    private String hotRodsBERebuildKitSt;

    private String hotRodsCylinderHead;

    private String hotRodsMainBearingSealKit;

    private String hotRodsTransmissionBearings;

    private String hotRodsWristPinBearings;

    private String hotRodsSOHCCamshaftStage1;

    private String hotRodsSOHCCamshaftStage2;

    private String hotRodsSOHCCamshaftStage3;

    private String hotRodsDOHCCamshaftStage1Intake;

    private String hotRodsDOHCCamshaftStage1Exhaust;

    private String hotRodsDOHCCamshaftStage2Intake;

    private String hotRodsDOHCCamshaftStage2Exhaust;

    private Set<BikeFrontSprocketDTO> bikeFrontSprockets = new HashSet<>();

    private Set<BikeRearSprocketDTO> bikeRearSprockets = new HashSet<>();

    private Set<RearSprocketConvDTO> rearSprocketConvs = new HashSet<>();

    private Set<FrontSprocketConvDTO> frontSprocketConvs = new HashSet<>();

    private Set<ChainDTO> chains = new HashSet<>();

    private Set<BikeBrakePadDTO> bikeBrakePads = new HashSet<>();

    private Set<BikeBrakeDiscDTO> bikeBrakeDiscs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisibilityAU() {
        return visibilityAU;
    }

    public void setVisibilityAU(String visibilityAU) {
        this.visibilityAU = visibilityAU;
    }

    public String getVisibilityEU() {
        return visibilityEU;
    }

    public void setVisibilityEU(String visibilityEU) {
        this.visibilityEU = visibilityEU;
    }

    public String getInactive() {
        return inactive;
    }

    public void setInactive(String inactive) {
        this.inactive = inactive;
    }

    public String getOemconfirmed() {
        return oemconfirmed;
    }

    public void setOemconfirmed(String oemconfirmed) {
        this.oemconfirmed = oemconfirmed;
    }

    public String getOesource() {
        return oesource;
    }

    public void setOesource(String oesource) {
        this.oesource = oesource;
    }

    public Long getEpid() {
        return epid;
    }

    public void setEpid(Long epid) {
        this.epid = epid;
    }

    public String getModeltype1() {
        return modeltype1;
    }

    public void setModeltype1(String modeltype1) {
        this.modeltype1 = modeltype1;
    }

    public String getModeltype2() {
        return modeltype2;
    }

    public void setModeltype2(String modeltype2) {
        this.modeltype2 = modeltype2;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getStrokes() {
        return strokes;
    }

    public void setStrokes(String strokes) {
        this.strokes = strokes;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelYearCode() {
        return modelYearCode;
    }

    public void setModelYearCode(String modelYearCode) {
        this.modelYearCode = modelYearCode;
    }

    public String getModelTypeCode() {
        return modelTypeCode;
    }

    public void setModelTypeCode(String modelTypeCode) {
        this.modelTypeCode = modelTypeCode;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getFinalDriveType() {
        return finalDriveType;
    }

    public void setFinalDriveType(String finalDriveType) {
        this.finalDriveType = finalDriveType;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getModelNotes() {
        return modelNotes;
    }

    public void setModelNotes(String modelNotes) {
        this.modelNotes = modelNotes;
    }

    public String getModelNotes2() {
        return modelNotes2;
    }

    public void setModelNotes2(String modelNotes2) {
        this.modelNotes2 = modelNotes2;
    }

    public String getModelNotes3() {
        return modelNotes3;
    }

    public void setModelNotes3(String modelNotes3) {
        this.modelNotes3 = modelNotes3;
    }

    public String getModelNotes4() {
        return modelNotes4;
    }

    public void setModelNotes4(String modelNotes4) {
        this.modelNotes4 = modelNotes4;
    }

    public String getModelInfoHTML() {
        return modelInfoHTML;
    }

    public void setModelInfoHTML(String modelInfoHTML) {
        this.modelInfoHTML = modelInfoHTML;
    }

    public String getOemFrontBrakeSystemType() {
        return oemFrontBrakeSystemType;
    }

    public void setOemFrontBrakeSystemType(String oemFrontBrakeSystemType) {
        this.oemFrontBrakeSystemType = oemFrontBrakeSystemType;
    }

    public String getOemFrontBrakeDiscLeft() {
        return oemFrontBrakeDiscLeft;
    }

    public void setOemFrontBrakeDiscLeft(String oemFrontBrakeDiscLeft) {
        this.oemFrontBrakeDiscLeft = oemFrontBrakeDiscLeft;
    }

    public String getOemFrontBrakeDiscRight() {
        return oemFrontBrakeDiscRight;
    }

    public void setOemFrontBrakeDiscRight(String oemFrontBrakeDiscRight) {
        this.oemFrontBrakeDiscRight = oemFrontBrakeDiscRight;
    }

    public String getOemFrontBrakeDiscBolts() {
        return oemFrontBrakeDiscBolts;
    }

    public void setOemFrontBrakeDiscBolts(String oemFrontBrakeDiscBolts) {
        this.oemFrontBrakeDiscBolts = oemFrontBrakeDiscBolts;
    }

    public Long getOemFrontBDQTYPD() {
        return oemFrontBDQTYPD;
    }

    public void setOemFrontBDQTYPD(Long oemFrontBDQTYPD) {
        this.oemFrontBDQTYPD = oemFrontBDQTYPD;
    }

    public String getOemFrontBrakeDiscABSRing() {
        return oemFrontBrakeDiscABSRing;
    }

    public void setOemFrontBrakeDiscABSRing(String oemFrontBrakeDiscABSRing) {
        this.oemFrontBrakeDiscABSRing = oemFrontBrakeDiscABSRing;
    }

    public String getOemFrontBrakeCaliper1() {
        return oemFrontBrakeCaliper1;
    }

    public void setOemFrontBrakeCaliper1(String oemFrontBrakeCaliper1) {
        this.oemFrontBrakeCaliper1 = oemFrontBrakeCaliper1;
    }

    public String getOemFrontBrakeCaliper2() {
        return oemFrontBrakeCaliper2;
    }

    public void setOemFrontBrakeCaliper2(String oemFrontBrakeCaliper2) {
        this.oemFrontBrakeCaliper2 = oemFrontBrakeCaliper2;
    }

    public String getOemFrontBrakeCaliperPin() {
        return oemFrontBrakeCaliperPin;
    }

    public void setOemFrontBrakeCaliperPin(String oemFrontBrakeCaliperPin) {
        this.oemFrontBrakeCaliperPin = oemFrontBrakeCaliperPin;
    }

    public String getOemFrontBrakePadsFrontL() {
        return oemFrontBrakePadsFrontL;
    }

    public void setOemFrontBrakePadsFrontL(String oemFrontBrakePadsFrontL) {
        this.oemFrontBrakePadsFrontL = oemFrontBrakePadsFrontL;
    }

    public String getOemFrontBrakePadsFrontR() {
        return oemFrontBrakePadsFrontR;
    }

    public void setOemFrontBrakePadsFrontR(String oemFrontBrakePadsFrontR) {
        this.oemFrontBrakePadsFrontR = oemFrontBrakePadsFrontR;
    }

    public String getOemFrontShoe() {
        return oemFrontShoe;
    }

    public void setOemFrontShoe(String oemFrontShoe) {
        this.oemFrontShoe = oemFrontShoe;
    }

    public String getOemMidldleAxleBrakeDisc() {
        return oemMidldleAxleBrakeDisc;
    }

    public void setOemMidldleAxleBrakeDisc(String oemMidldleAxleBrakeDisc) {
        this.oemMidldleAxleBrakeDisc = oemMidldleAxleBrakeDisc;
    }

    public String getOemMiddleAxleBrakePads() {
        return oemMiddleAxleBrakePads;
    }

    public void setOemMiddleAxleBrakePads(String oemMiddleAxleBrakePads) {
        this.oemMiddleAxleBrakePads = oemMiddleAxleBrakePads;
    }

    public String getOemRearBrakeSystemType() {
        return oemRearBrakeSystemType;
    }

    public void setOemRearBrakeSystemType(String oemRearBrakeSystemType) {
        this.oemRearBrakeSystemType = oemRearBrakeSystemType;
    }

    public String getOeamRearBrakeDisc() {
        return oeamRearBrakeDisc;
    }

    public void setOeamRearBrakeDisc(String oeamRearBrakeDisc) {
        this.oeamRearBrakeDisc = oeamRearBrakeDisc;
    }

    public String getOeamRearBrakeDiscBolts() {
        return oeamRearBrakeDiscBolts;
    }

    public void setOeamRearBrakeDiscBolts(String oeamRearBrakeDiscBolts) {
        this.oeamRearBrakeDiscBolts = oeamRearBrakeDiscBolts;
    }

    public Long getOeamRearBrakeDiscBQTYPD() {
        return oeamRearBrakeDiscBQTYPD;
    }

    public void setOeamRearBrakeDiscBQTYPD(Long oeamRearBrakeDiscBQTYPD) {
        this.oeamRearBrakeDiscBQTYPD = oeamRearBrakeDiscBQTYPD;
    }

    public String getOemRearBrakeCaliper() {
        return oemRearBrakeCaliper;
    }

    public void setOemRearBrakeCaliper(String oemRearBrakeCaliper) {
        this.oemRearBrakeCaliper = oemRearBrakeCaliper;
    }

    public String getOemRearBrakeCaliperPin() {
        return oemRearBrakeCaliperPin;
    }

    public void setOemRearBrakeCaliperPin(String oemRearBrakeCaliperPin) {
        this.oemRearBrakeCaliperPin = oemRearBrakeCaliperPin;
    }

    public String getOemRearBrakePads1() {
        return oemRearBrakePads1;
    }

    public void setOemRearBrakePads1(String oemRearBrakePads1) {
        this.oemRearBrakePads1 = oemRearBrakePads1;
    }

    public String getOemRearBrakePads2() {
        return oemRearBrakePads2;
    }

    public void setOemRearBrakePads2(String oemRearBrakePads2) {
        this.oemRearBrakePads2 = oemRearBrakePads2;
    }

    public String getOemShoeRear() {
        return oemShoeRear;
    }

    public void setOemShoeRear(String oemShoeRear) {
        this.oemShoeRear = oemShoeRear;
    }

    public String getOemShoeRear2() {
        return oemShoeRear2;
    }

    public void setOemShoeRear2(String oemShoeRear2) {
        this.oemShoeRear2 = oemShoeRear2;
    }

    public String getOemSlaveCylinder() {
        return oemSlaveCylinder;
    }

    public void setOemSlaveCylinder(String oemSlaveCylinder) {
        this.oemSlaveCylinder = oemSlaveCylinder;
    }

    public String getOemChainNo() {
        return oemChainNo;
    }

    public void setOemChainNo(String oemChainNo) {
        this.oemChainNo = oemChainNo;
    }

    public BigDecimal getOemChainSize() {
        return oemChainSize;
    }

    public void setOemChainSize(BigDecimal oemChainSize) {
        this.oemChainSize = oemChainSize;
    }

    public BigDecimal getOemChainLinks() {
        return oemChainLinks;
    }

    public void setOemChainLinks(BigDecimal oemChainLinks) {
        this.oemChainLinks = oemChainLinks;
    }

    public String getOemFrontSprocket() {
        return oemFrontSprocket;
    }

    public void setOemFrontSprocket(String oemFrontSprocket) {
        this.oemFrontSprocket = oemFrontSprocket;
    }

    public Long getOemFrontGearing() {
        return oemFrontGearing;
    }

    public void setOemFrontGearing(Long oemFrontGearing) {
        this.oemFrontGearing = oemFrontGearing;
    }

    public BigDecimal getOemFrontGearingMin() {
        return oemFrontGearingMin;
    }

    public void setOemFrontGearingMin(BigDecimal oemFrontGearingMin) {
        this.oemFrontGearingMin = oemFrontGearingMin;
    }

    public BigDecimal getOemFrontGearingMax() {
        return oemFrontGearingMax;
    }

    public void setOemFrontGearingMax(BigDecimal oemFrontGearingMax) {
        this.oemFrontGearingMax = oemFrontGearingMax;
    }

    public String getOemRearSprocket() {
        return oemRearSprocket;
    }

    public void setOemRearSprocket(String oemRearSprocket) {
        this.oemRearSprocket = oemRearSprocket;
    }

    public BigDecimal getOemRearGearing() {
        return oemRearGearing;
    }

    public void setOemRearGearing(BigDecimal oemRearGearing) {
        this.oemRearGearing = oemRearGearing;
    }

    public BigDecimal getOemRearGearingMin() {
        return oemRearGearingMin;
    }

    public void setOemRearGearingMin(BigDecimal oemRearGearingMin) {
        this.oemRearGearingMin = oemRearGearingMin;
    }

    public BigDecimal getOemRearGearingMax() {
        return oemRearGearingMax;
    }

    public void setOemRearGearingMax(BigDecimal oemRearGearingMax) {
        this.oemRearGearingMax = oemRearGearingMax;
    }

    public String getFinalDriveNotes() {
        return finalDriveNotes;
    }

    public void setFinalDriveNotes(String finalDriveNotes) {
        this.finalDriveNotes = finalDriveNotes;
    }

    public BigDecimal getChainConvSize() {
        return chainConvSize;
    }

    public void setChainConvSize(BigDecimal chainConvSize) {
        this.chainConvSize = chainConvSize;
    }

    public BigDecimal getChainConvLinks() {
        return chainConvLinks;
    }

    public void setChainConvLinks(BigDecimal chainConvLinks) {
        this.chainConvLinks = chainConvLinks;
    }

    public String getOemFrontWheel() {
        return oemFrontWheel;
    }

    public void setOemFrontWheel(String oemFrontWheel) {
        this.oemFrontWheel = oemFrontWheel;
    }

    public String getOemFrontWheelType() {
        return oemFrontWheelType;
    }

    public void setOemFrontWheelType(String oemFrontWheelType) {
        this.oemFrontWheelType = oemFrontWheelType;
    }

    public BigDecimal getOemFrontWheelFront() {
        return oemFrontWheelFront;
    }

    public void setOemFrontWheelFront(BigDecimal oemFrontWheelFront) {
        this.oemFrontWheelFront = oemFrontWheelFront;
    }

    public String getOemFrontWheelTyreSize() {
        return oemFrontWheelTyreSize;
    }

    public void setOemFrontWheelTyreSize(String oemFrontWheelTyreSize) {
        this.oemFrontWheelTyreSize = oemFrontWheelTyreSize;
    }

    public String getOemFrontHub() {
        return oemFrontHub;
    }

    public void setOemFrontHub(String oemFrontHub) {
        this.oemFrontHub = oemFrontHub;
    }

    public String getOemFrontWheelbearing1() {
        return oemFrontWheelbearing1;
    }

    public void setOemFrontWheelbearing1(String oemFrontWheelbearing1) {
        this.oemFrontWheelbearing1 = oemFrontWheelbearing1;
    }

    public String getOemFrontWheelbearing2() {
        return oemFrontWheelbearing2;
    }

    public void setOemFrontWheelbearing2(String oemFrontWheelbearing2) {
        this.oemFrontWheelbearing2 = oemFrontWheelbearing2;
    }

    public String getOemFrontWheelSeal() {
        return oemFrontWheelSeal;
    }

    public void setOemFrontWheelSeal(String oemFrontWheelSeal) {
        this.oemFrontWheelSeal = oemFrontWheelSeal;
    }

    public String getOemRearWheel() {
        return oemRearWheel;
    }

    public void setOemRearWheel(String oemRearWheel) {
        this.oemRearWheel = oemRearWheel;
    }

    public BigDecimal getOemRearWheelSize() {
        return oemRearWheelSize;
    }

    public void setOemRearWheelSize(BigDecimal oemRearWheelSize) {
        this.oemRearWheelSize = oemRearWheelSize;
    }

    public String getOemRearWheelTyre() {
        return oemRearWheelTyre;
    }

    public void setOemRearWheelTyre(String oemRearWheelTyre) {
        this.oemRearWheelTyre = oemRearWheelTyre;
    }

    public String getOemRearWheelBearing1() {
        return oemRearWheelBearing1;
    }

    public void setOemRearWheelBearing1(String oemRearWheelBearing1) {
        this.oemRearWheelBearing1 = oemRearWheelBearing1;
    }

    public String getOemRearWheelBearing2() {
        return oemRearWheelBearing2;
    }

    public void setOemRearWheelBearing2(String oemRearWheelBearing2) {
        this.oemRearWheelBearing2 = oemRearWheelBearing2;
    }

    public String getOemRearWheelSeal() {
        return oemRearWheelSeal;
    }

    public void setOemRearWheelSeal(String oemRearWheelSeal) {
        this.oemRearWheelSeal = oemRearWheelSeal;
    }

    public String getFrontPadsDiffCaliper() {
        return frontPadsDiffCaliper;
    }

    public void setFrontPadsDiffCaliper(String frontPadsDiffCaliper) {
        this.frontPadsDiffCaliper = frontPadsDiffCaliper;
    }

    public Long getQtyBH() {
        return qtyBH;
    }

    public void setQtyBH(Long qtyBH) {
        this.qtyBH = qtyBH;
    }

    public String getHandbrakeParking() {
        return handbrakeParking;
    }

    public void setHandbrakeParking(String handbrakeParking) {
        this.handbrakeParking = handbrakeParking;
    }

    public String getAddNotesToBike() {
        return addNotesToBike;
    }

    public void setAddNotesToBike(String addNotesToBike) {
        this.addNotesToBike = addNotesToBike;
    }

    public String getDateAndID() {
        return dateAndID;
    }

    public void setDateAndID(String dateAndID) {
        this.dateAndID = dateAndID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTuvRequired() {
        return tuvRequired;
    }

    public void setTuvRequired(String tuvRequired) {
        this.tuvRequired = tuvRequired;
    }

    public String getTuvTypeCode() {
        return tuvTypeCode;
    }

    public void setTuvTypeCode(String tuvTypeCode) {
        this.tuvTypeCode = tuvTypeCode;
    }

    public String getAbekba() {
        return abekba;
    }

    public void setAbekba(String abekba) {
        this.abekba = abekba;
    }

    public String getTuvFrontDisc() {
        return tuvFrontDisc;
    }

    public void setTuvFrontDisc(String tuvFrontDisc) {
        this.tuvFrontDisc = tuvFrontDisc;
    }

    public String getTuvRearDisc() {
        return tuvRearDisc;
    }

    public void setTuvRearDisc(String tuvRearDisc) {
        this.tuvRearDisc = tuvRearDisc;
    }

    public String getBremboBrakeDiscFrontRef() {
        return bremboBrakeDiscFrontRef;
    }

    public void setBremboBrakeDiscFrontRef(String bremboBrakeDiscFrontRef) {
        this.bremboBrakeDiscFrontRef = bremboBrakeDiscFrontRef;
    }

    public String getEbcBrakeDiscFrontRef() {
        return ebcBrakeDiscFrontRef;
    }

    public void setEbcBrakeDiscFrontRef(String ebcBrakeDiscFrontRef) {
        this.ebcBrakeDiscFrontRef = ebcBrakeDiscFrontRef;
    }

    public String getTrwBrakeDiscFrontRef() {
        return trwBrakeDiscFrontRef;
    }

    public void setTrwBrakeDiscFrontRef(String trwBrakeDiscFrontRef) {
        this.trwBrakeDiscFrontRef = trwBrakeDiscFrontRef;
    }

    public String getMgearBrakeDiscFrontLeftRef() {
        return mgearBrakeDiscFrontLeftRef;
    }

    public void setMgearBrakeDiscFrontLeftRef(String mgearBrakeDiscFrontLeftRef) {
        this.mgearBrakeDiscFrontLeftRef = mgearBrakeDiscFrontLeftRef;
    }

    public String getMgearBrakeDiscFrontRightRef() {
        return mgearBrakeDiscFrontRightRef;
    }

    public void setMgearBrakeDiscFrontRightRef(String mgearBrakeDiscFrontRightRef) {
        this.mgearBrakeDiscFrontRightRef = mgearBrakeDiscFrontRightRef;
    }

    public String getMgearBrakeDiscFrontCheck() {
        return mgearBrakeDiscFrontCheck;
    }

    public void setMgearBrakeDiscFrontCheck(String mgearBrakeDiscFrontCheck) {
        this.mgearBrakeDiscFrontCheck = mgearBrakeDiscFrontCheck;
    }

    public String getMgearBrakeDiscFrontLeftRef2() {
        return mgearBrakeDiscFrontLeftRef2;
    }

    public void setMgearBrakeDiscFrontLeftRef2(String mgearBrakeDiscFrontLeftRef2) {
        this.mgearBrakeDiscFrontLeftRef2 = mgearBrakeDiscFrontLeftRef2;
    }

    public String getMgearBrakeDiscFrontRightRef2() {
        return mgearBrakeDiscFrontRightRef2;
    }

    public void setMgearBrakeDiscFrontRightRef2(String mgearBrakeDiscFrontRightRef2) {
        this.mgearBrakeDiscFrontRightRef2 = mgearBrakeDiscFrontRightRef2;
    }

    public String getMgearBrakeDiscFNeto() {
        return mgearBrakeDiscFNeto;
    }

    public void setMgearBrakeDiscFNeto(String mgearBrakeDiscFNeto) {
        this.mgearBrakeDiscFNeto = mgearBrakeDiscFNeto;
    }

    public String getMotodiscBrakeDiscFNeto() {
        return motodiscBrakeDiscFNeto;
    }

    public void setMotodiscBrakeDiscFNeto(String motodiscBrakeDiscFNeto) {
        this.motodiscBrakeDiscFNeto = motodiscBrakeDiscFNeto;
    }

    public String getEbcBrakePadsFrontLRef() {
        return ebcBrakePadsFrontLRef;
    }

    public void setEbcBrakePadsFrontLRef(String ebcBrakePadsFrontLRef) {
        this.ebcBrakePadsFrontLRef = ebcBrakePadsFrontLRef;
    }

    public String getEbcBrakePadsFrontRRef() {
        return ebcBrakePadsFrontRRef;
    }

    public void setEbcBrakePadsFrontRRef(String ebcBrakePadsFrontRRef) {
        this.ebcBrakePadsFrontRRef = ebcBrakePadsFrontRRef;
    }

    public String getMgearBrakePadsFrontLRef() {
        return mgearBrakePadsFrontLRef;
    }

    public void setMgearBrakePadsFrontLRef(String mgearBrakePadsFrontLRef) {
        this.mgearBrakePadsFrontLRef = mgearBrakePadsFrontLRef;
    }

    public String getMgearBrakePadsFrontRRef() {
        return mgearBrakePadsFrontRRef;
    }

    public void setMgearBrakePadsFrontRRef(String mgearBrakePadsFrontRRef) {
        this.mgearBrakePadsFrontRRef = mgearBrakePadsFrontRRef;
    }

    public String getMgearBrakePadsFNeto() {
        return mgearBrakePadsFNeto;
    }

    public void setMgearBrakePadsFNeto(String mgearBrakePadsFNeto) {
        this.mgearBrakePadsFNeto = mgearBrakePadsFNeto;
    }

    public String getMotoPadBrakePadsFrontLRef() {
        return motoPadBrakePadsFrontLRef;
    }

    public void setMotoPadBrakePadsFrontLRef(String motoPadBrakePadsFrontLRef) {
        this.motoPadBrakePadsFrontLRef = motoPadBrakePadsFrontLRef;
    }

    public String getMotoPadBrakePadsFrontRRef() {
        return motoPadBrakePadsFrontRRef;
    }

    public void setMotoPadBrakePadsFrontRRef(String motoPadBrakePadsFrontRRef) {
        this.motoPadBrakePadsFrontRRef = motoPadBrakePadsFrontRRef;
    }

    public String getMotopadBrakePadsFNeto() {
        return motopadBrakePadsFNeto;
    }

    public void setMotopadBrakePadsFNeto(String motopadBrakePadsFNeto) {
        this.motopadBrakePadsFNeto = motopadBrakePadsFNeto;
    }

    public String getAllBallsFCRebuildKit1() {
        return allBallsFCRebuildKit1;
    }

    public void setAllBallsFCRebuildKit1(String allBallsFCRebuildKit1) {
        this.allBallsFCRebuildKit1 = allBallsFCRebuildKit1;
    }

    public String getAllBallsFCPin() {
        return allBallsFCPin;
    }

    public void setAllBallsFCPin(String allBallsFCPin) {
        this.allBallsFCPin = allBallsFCPin;
    }

    public String getAllBallsFMCyRebuildKit() {
        return allBallsFMCyRebuildKit;
    }

    public void setAllBallsFMCyRebuildKit(String allBallsFMCyRebuildKit) {
        this.allBallsFMCyRebuildKit = allBallsFMCyRebuildKit;
    }

    public String getAllBallsFSCRebuildKit() {
        return allBallsFSCRebuildKit;
    }

    public void setAllBallsFSCRebuildKit(String allBallsFSCRebuildKit) {
        this.allBallsFSCRebuildKit = allBallsFSCRebuildKit;
    }

    public String getNewfrenShoeFront() {
        return newfrenShoeFront;
    }

    public void setNewfrenShoeFront(String newfrenShoeFront) {
        this.newfrenShoeFront = newfrenShoeFront;
    }

    public String getMgearMiddleAxleBrakeDiscNeto() {
        return mgearMiddleAxleBrakeDiscNeto;
    }

    public void setMgearMiddleAxleBrakeDiscNeto(String mgearMiddleAxleBrakeDiscNeto) {
        this.mgearMiddleAxleBrakeDiscNeto = mgearMiddleAxleBrakeDiscNeto;
    }

    public String getMgearMiddleAxleBrakeDiscNeto2() {
        return mgearMiddleAxleBrakeDiscNeto2;
    }

    public void setMgearMiddleAxleBrakeDiscNeto2(String mgearMiddleAxleBrakeDiscNeto2) {
        this.mgearMiddleAxleBrakeDiscNeto2 = mgearMiddleAxleBrakeDiscNeto2;
    }

    public String getMgearMiddleAxleBrakePadNeto() {
        return mgearMiddleAxleBrakePadNeto;
    }

    public void setMgearMiddleAxleBrakePadNeto(String mgearMiddleAxleBrakePadNeto) {
        this.mgearMiddleAxleBrakePadNeto = mgearMiddleAxleBrakePadNeto;
    }

    public String getMgearMiddleAxleBrakePadNeto2() {
        return mgearMiddleAxleBrakePadNeto2;
    }

    public void setMgearMiddleAxleBrakePadNeto2(String mgearMiddleAxleBrakePadNeto2) {
        this.mgearMiddleAxleBrakePadNeto2 = mgearMiddleAxleBrakePadNeto2;
    }

    public String getMgearBrakePadsParkRef() {
        return mgearBrakePadsParkRef;
    }

    public void setMgearBrakePadsParkRef(String mgearBrakePadsParkRef) {
        this.mgearBrakePadsParkRef = mgearBrakePadsParkRef;
    }

    public String getMgearBrakePadsParkRef2() {
        return mgearBrakePadsParkRef2;
    }

    public void setMgearBrakePadsParkRef2(String mgearBrakePadsParkRef2) {
        this.mgearBrakePadsParkRef2 = mgearBrakePadsParkRef2;
    }

    public String getEbcBrakeDiscRearRef() {
        return ebcBrakeDiscRearRef;
    }

    public void setEbcBrakeDiscRearRef(String ebcBrakeDiscRearRef) {
        this.ebcBrakeDiscRearRef = ebcBrakeDiscRearRef;
    }

    public String getBremboBrakeDiscRearRef() {
        return bremboBrakeDiscRearRef;
    }

    public void setBremboBrakeDiscRearRef(String bremboBrakeDiscRearRef) {
        this.bremboBrakeDiscRearRef = bremboBrakeDiscRearRef;
    }

    public String getMgearBrakeDiscRearRef() {
        return mgearBrakeDiscRearRef;
    }

    public void setMgearBrakeDiscRearRef(String mgearBrakeDiscRearRef) {
        this.mgearBrakeDiscRearRef = mgearBrakeDiscRearRef;
    }

    public String getTrwBrakeDiscRearRef() {
        return trwBrakeDiscRearRef;
    }

    public void setTrwBrakeDiscRearRef(String trwBrakeDiscRearRef) {
        this.trwBrakeDiscRearRef = trwBrakeDiscRearRef;
    }

    public String getMgearBrakeDiscRear() {
        return mgearBrakeDiscRear;
    }

    public void setMgearBrakeDiscRear(String mgearBrakeDiscRear) {
        this.mgearBrakeDiscRear = mgearBrakeDiscRear;
    }

    public String getAllBallsRCRebuildKit1() {
        return allBallsRCRebuildKit1;
    }

    public void setAllBallsRCRebuildKit1(String allBallsRCRebuildKit1) {
        this.allBallsRCRebuildKit1 = allBallsRCRebuildKit1;
    }

    public String getAllBallsRearCaliperBolt() {
        return allBallsRearCaliperBolt;
    }

    public void setAllBallsRearCaliperBolt(String allBallsRearCaliperBolt) {
        this.allBallsRearCaliperBolt = allBallsRearCaliperBolt;
    }

    public String getAllBallsRMCrRebuildKit() {
        return allBallsRMCrRebuildKit;
    }

    public void setAllBallsRMCrRebuildKit(String allBallsRMCrRebuildKit) {
        this.allBallsRMCrRebuildKit = allBallsRMCrRebuildKit;
    }

    public String getEbcBrakePadsRearRef() {
        return ebcBrakePadsRearRef;
    }

    public void setEbcBrakePadsRearRef(String ebcBrakePadsRearRef) {
        this.ebcBrakePadsRearRef = ebcBrakePadsRearRef;
    }

    public String getMgearBrakePadsRearNeto() {
        return mgearBrakePadsRearNeto;
    }

    public void setMgearBrakePadsRearNeto(String mgearBrakePadsRearNeto) {
        this.mgearBrakePadsRearNeto = mgearBrakePadsRearNeto;
    }

    public String getNewfrenShoeRear() {
        return newfrenShoeRear;
    }

    public void setNewfrenShoeRear(String newfrenShoeRear) {
        this.newfrenShoeRear = newfrenShoeRear;
    }

    public String getAllBallsRearBrakePedalKit() {
        return allBallsRearBrakePedalKit;
    }

    public void setAllBallsRearBrakePedalKit(String allBallsRearBrakePedalKit) {
        this.allBallsRearBrakePedalKit = allBallsRearBrakePedalKit;
    }

    public String getAllBallsCSCRebuildKit() {
        return allBallsCSCRebuildKit;
    }

    public void setAllBallsCSCRebuildKit(String allBallsCSCRebuildKit) {
        this.allBallsCSCRebuildKit = allBallsCSCRebuildKit;
    }

    public String getFrontJTRefFront() {
        return frontJTRefFront;
    }

    public void setFrontJTRefFront(String frontJTRefFront) {
        this.frontJTRefFront = frontJTRefFront;
    }

    public String getEsjotRefFront() {
        return esjotRefFront;
    }

    public void setEsjotRefFront(String esjotRefFront) {
        this.esjotRefFront = esjotRefFront;
    }

    public String getMgearRefFront() {
        return mgearRefFront;
    }

    public void setMgearRefFront(String mgearRefFront) {
        this.mgearRefFront = mgearRefFront;
    }

    public String getMogemaRefFront() {
        return mogemaRefFront;
    }

    public void setMogemaRefFront(String mogemaRefFront) {
        this.mogemaRefFront = mogemaRefFront;
    }

    public String getSupersproxRefFront() {
        return supersproxRefFront;
    }

    public void setSupersproxRefFront(String supersproxRefFront) {
        this.supersproxRefFront = supersproxRefFront;
    }

    public String getEsjotRefRear() {
        return esjotRefRear;
    }

    public void setEsjotRefRear(String esjotRefRear) {
        this.esjotRefRear = esjotRefRear;
    }

    public String getJtRefRear() {
        return jtRefRear;
    }

    public void setJtRefRear(String jtRefRear) {
        this.jtRefRear = jtRefRear;
    }

    public String getMgearRefRear() {
        return mgearRefRear;
    }

    public void setMgearRefRear(String mgearRefRear) {
        this.mgearRefRear = mgearRefRear;
    }

    public String getMogemaRefRear() {
        return mogemaRefRear;
    }

    public void setMogemaRefRear(String mogemaRefRear) {
        this.mogemaRefRear = mogemaRefRear;
    }

    public String getSupersproxRefRear() {
        return supersproxRefRear;
    }

    public void setSupersproxRefRear(String supersproxRefRear) {
        this.supersproxRefRear = supersproxRefRear;
    }

    public String getEsjotRefFrontConv() {
        return esjotRefFrontConv;
    }

    public void setEsjotRefFrontConv(String esjotRefFrontConv) {
        this.esjotRefFrontConv = esjotRefFrontConv;
    }

    public String getJtSprocketRef() {
        return jtSprocketRef;
    }

    public void setJtSprocketRef(String jtSprocketRef) {
        this.jtSprocketRef = jtSprocketRef;
    }

    public String getMgearRefFrontConv() {
        return mgearRefFrontConv;
    }

    public void setMgearRefFrontConv(String mgearRefFrontConv) {
        this.mgearRefFrontConv = mgearRefFrontConv;
    }

    public String getMogemarefFrontConv() {
        return mogemarefFrontConv;
    }

    public void setMogemarefFrontConv(String mogemarefFrontConv) {
        this.mogemarefFrontConv = mogemarefFrontConv;
    }

    public String getSupersproxRefFrontConv() {
        return supersproxRefFrontConv;
    }

    public void setSupersproxRefFrontConv(String supersproxRefFrontConv) {
        this.supersproxRefFrontConv = supersproxRefFrontConv;
    }

    public String getConversionChain() {
        return conversionChain;
    }

    public void setConversionChain(String conversionChain) {
        this.conversionChain = conversionChain;
    }

    public String getMgearSprocketRearConv() {
        return mgearSprocketRearConv;
    }

    public void setMgearSprocketRearConv(String mgearSprocketRearConv) {
        this.mgearSprocketRearConv = mgearSprocketRearConv;
    }

    public String getEsjotRefRearConv() {
        return esjotRefRearConv;
    }

    public void setEsjotRefRearConv(String esjotRefRearConv) {
        this.esjotRefRearConv = esjotRefRearConv;
    }

    public String getMgearRefRearConv() {
        return mgearRefRearConv;
    }

    public void setMgearRefRearConv(String mgearRefRearConv) {
        this.mgearRefRearConv = mgearRefRearConv;
    }

    public String getMogemaRefRearConv() {
        return mogemaRefRearConv;
    }

    public void setMogemaRefRearConv(String mogemaRefRearConv) {
        this.mogemaRefRearConv = mogemaRefRearConv;
    }

    public String getSupersproxRefRearConv() {
        return supersproxRefRearConv;
    }

    public void setSupersproxRefRearConv(String supersproxRefRearConv) {
        this.supersproxRefRearConv = supersproxRefRearConv;
    }

    public String getAllBallsFWBearingKit1() {
        return allBallsFWBearingKit1;
    }

    public void setAllBallsFWBearingKit1(String allBallsFWBearingKit1) {
        this.allBallsFWBearingKit1 = allBallsFWBearingKit1;
    }

    public String getAllBallsFWBearingKit2() {
        return allBallsFWBearingKit2;
    }

    public void setAllBallsFWBearingKit2(String allBallsFWBearingKit2) {
        this.allBallsFWBearingKit2 = allBallsFWBearingKit2;
    }

    public String getAllBallsRWBearingKit1() {
        return allBallsRWBearingKit1;
    }

    public void setAllBallsRWBearingKit1(String allBallsRWBearingKit1) {
        this.allBallsRWBearingKit1 = allBallsRWBearingKit1;
    }

    public String getAllBallsRWBearingKit2() {
        return allBallsRWBearingKit2;
    }

    public void setAllBallsRWBearingKit2(String allBallsRWBearingKit2) {
        this.allBallsRWBearingKit2 = allBallsRWBearingKit2;
    }

    public String getAllBallsRWBearingUpgrade() {
        return allBallsRWBearingUpgrade;
    }

    public void setAllBallsRWBearingUpgrade(String allBallsRWBearingUpgrade) {
        this.allBallsRWBearingUpgrade = allBallsRWBearingUpgrade;
    }

    public String getOemSparkPlug() {
        return oemSparkPlug;
    }

    public void setOemSparkPlug(String oemSparkPlug) {
        this.oemSparkPlug = oemSparkPlug;
    }

    public Long getOemSparkPlugQTY() {
        return oemSparkPlugQTY;
    }

    public void setOemSparkPlugQTY(Long oemSparkPlugQTY) {
        this.oemSparkPlugQTY = oemSparkPlugQTY;
    }

    public String getNgkSparkPlugSKUs() {
        return ngkSparkPlugSKUs;
    }

    public void setNgkSparkPlugSKUs(String ngkSparkPlugSKUs) {
        this.ngkSparkPlugSKUs = ngkSparkPlugSKUs;
    }

    public String getOemAlternator() {
        return oemAlternator;
    }

    public void setOemAlternator(String oemAlternator) {
        this.oemAlternator = oemAlternator;
    }

    public String getOemVoltageRegulator() {
        return oemVoltageRegulator;
    }

    public void setOemVoltageRegulator(String oemVoltageRegulator) {
        this.oemVoltageRegulator = oemVoltageRegulator;
    }

    public String getArrowheadAlternator() {
        return arrowheadAlternator;
    }

    public void setArrowheadAlternator(String arrowheadAlternator) {
        this.arrowheadAlternator = arrowheadAlternator;
    }

    public String getArrowheadAlternator2() {
        return arrowheadAlternator2;
    }

    public void setArrowheadAlternator2(String arrowheadAlternator2) {
        this.arrowheadAlternator2 = arrowheadAlternator2;
    }

    public String getArrowheadCDIModule() {
        return arrowheadCDIModule;
    }

    public void setArrowheadCDIModule(String arrowheadCDIModule) {
        this.arrowheadCDIModule = arrowheadCDIModule;
    }

    public String getArrowheadChargingCoil() {
        return arrowheadChargingCoil;
    }

    public void setArrowheadChargingCoil(String arrowheadChargingCoil) {
        this.arrowheadChargingCoil = arrowheadChargingCoil;
    }

    public String getArrowheadIgnitionCoil() {
        return arrowheadIgnitionCoil;
    }

    public void setArrowheadIgnitionCoil(String arrowheadIgnitionCoil) {
        this.arrowheadIgnitionCoil = arrowheadIgnitionCoil;
    }

    public String getArrowheadStatorCoil() {
        return arrowheadStatorCoil;
    }

    public void setArrowheadStatorCoil(String arrowheadStatorCoil) {
        this.arrowheadStatorCoil = arrowheadStatorCoil;
    }

    public String getArrowheadVoltageRegulator() {
        return arrowheadVoltageRegulator;
    }

    public void setArrowheadVoltageRegulator(String arrowheadVoltageRegulator) {
        this.arrowheadVoltageRegulator = arrowheadVoltageRegulator;
    }

    public String getArrowheadPowerShiftCM() {
        return arrowheadPowerShiftCM;
    }

    public void setArrowheadPowerShiftCM(String arrowheadPowerShiftCM) {
        this.arrowheadPowerShiftCM = arrowheadPowerShiftCM;
    }

    public String getArrowheadStarterDrive() {
        return arrowheadStarterDrive;
    }

    public void setArrowheadStarterDrive(String arrowheadStarterDrive) {
        this.arrowheadStarterDrive = arrowheadStarterDrive;
    }

    public String getArrowheadStarterMotor() {
        return arrowheadStarterMotor;
    }

    public void setArrowheadStarterMotor(String arrowheadStarterMotor) {
        this.arrowheadStarterMotor = arrowheadStarterMotor;
    }

    public String getArrowheadStarterRelay() {
        return arrowheadStarterRelay;
    }

    public void setArrowheadStarterRelay(String arrowheadStarterRelay) {
        this.arrowheadStarterRelay = arrowheadStarterRelay;
    }

    public String getOemBattery() {
        return oemBattery;
    }

    public void setOemBattery(String oemBattery) {
        this.oemBattery = oemBattery;
    }

    public String getSsbAGMBattery() {
        return ssbAGMBattery;
    }

    public void setSsbAGMBattery(String ssbAGMBattery) {
        this.ssbAGMBattery = ssbAGMBattery;
    }

    public String getOemAirFilter() {
        return oemAirFilter;
    }

    public void setOemAirFilter(String oemAirFilter) {
        this.oemAirFilter = oemAirFilter;
    }

    public String getKnAirFilter() {
        return knAirFilter;
    }

    public void setKnAirFilter(String knAirFilter) {
        this.knAirFilter = knAirFilter;
    }

    public String getMotorexAirFilter() {
        return motorexAirFilter;
    }

    public void setMotorexAirFilter(String motorexAirFilter) {
        this.motorexAirFilter = motorexAirFilter;
    }

    public String getMotorexAirFilterPreoiled() {
        return motorexAirFilterPreoiled;
    }

    public void setMotorexAirFilterPreoiled(String motorexAirFilterPreoiled) {
        this.motorexAirFilterPreoiled = motorexAirFilterPreoiled;
    }

    public String getOemOilFilter1() {
        return oemOilFilter1;
    }

    public void setOemOilFilter1(String oemOilFilter1) {
        this.oemOilFilter1 = oemOilFilter1;
    }

    public String getKnOilFilter1() {
        return knOilFilter1;
    }

    public void setKnOilFilter1(String knOilFilter1) {
        this.knOilFilter1 = knOilFilter1;
    }

    public String getOemOilFilter2() {
        return oemOilFilter2;
    }

    public void setOemOilFilter2(String oemOilFilter2) {
        this.oemOilFilter2 = oemOilFilter2;
    }

    public String getKnOilFilter2() {
        return knOilFilter2;
    }

    public void setKnOilFilter2(String knOilFilter2) {
        this.knOilFilter2 = knOilFilter2;
    }

    public String getMotionProOilFilterMagnet() {
        return motionProOilFilterMagnet;
    }

    public void setMotionProOilFilterMagnet(String motionProOilFilterMagnet) {
        this.motionProOilFilterMagnet = motionProOilFilterMagnet;
    }

    public String getOemSteeringBearing() {
        return oemSteeringBearing;
    }

    public void setOemSteeringBearing(String oemSteeringBearing) {
        this.oemSteeringBearing = oemSteeringBearing;
    }

    public String getOemSteeringSeal() {
        return oemSteeringSeal;
    }

    public void setOemSteeringSeal(String oemSteeringSeal) {
        this.oemSteeringSeal = oemSteeringSeal;
    }

    public String getAllBallsSBSealKit1() {
        return allBallsSBSealKit1;
    }

    public void setAllBallsSBSealKit1(String allBallsSBSealKit1) {
        this.allBallsSBSealKit1 = allBallsSBSealKit1;
    }

    public String getAllBallsSBSealKit2() {
        return allBallsSBSealKit2;
    }

    public void setAllBallsSBSealKit2(String allBallsSBSealKit2) {
        this.allBallsSBSealKit2 = allBallsSBSealKit2;
    }

    public String getAllBallsSBSealKitLower() {
        return allBallsSBSealKitLower;
    }

    public void setAllBallsSBSealKitLower(String allBallsSBSealKitLower) {
        this.allBallsSBSealKitLower = allBallsSBSealKitLower;
    }

    public String getAllBallsSBSealKitLower2() {
        return allBallsSBSealKitLower2;
    }

    public void setAllBallsSBSealKitLower2(String allBallsSBSealKitLower2) {
        this.allBallsSBSealKitLower2 = allBallsSBSealKitLower2;
    }

    public String getAllBallsCBSealKit() {
        return allBallsCBSealKit;
    }

    public void setAllBallsCBSealKit(String allBallsCBSealKit) {
        this.allBallsCBSealKit = allBallsCBSealKit;
    }

    public String getOemForkAssemblyLeft() {
        return oemForkAssemblyLeft;
    }

    public void setOemForkAssemblyLeft(String oemForkAssemblyLeft) {
        this.oemForkAssemblyLeft = oemForkAssemblyLeft;
    }

    public String getOemForkAssemblyRight() {
        return oemForkAssemblyRight;
    }

    public void setOemForkAssemblyRight(String oemForkAssemblyRight) {
        this.oemForkAssemblyRight = oemForkAssemblyRight;
    }

    public String getOemForkSeals() {
        return oemForkSeals;
    }

    public void setOemForkSeals(String oemForkSeals) {
        this.oemForkSeals = oemForkSeals;
    }

    public String getAllBallsForkSeals() {
        return allBallsForkSeals;
    }

    public void setAllBallsForkSeals(String allBallsForkSeals) {
        this.allBallsForkSeals = allBallsForkSeals;
    }

    public String getXprForkSeals() {
        return xprForkSeals;
    }

    public void setXprForkSeals(String xprForkSeals) {
        this.xprForkSeals = xprForkSeals;
    }

    public String getAllBallsForkBushingKit() {
        return allBallsForkBushingKit;
    }

    public void setAllBallsForkBushingKit(String allBallsForkBushingKit) {
        this.allBallsForkBushingKit = allBallsForkBushingKit;
    }

    public String getMotionProMicroForkBleeder() {
        return motionProMicroForkBleeder;
    }

    public void setMotionProMicroForkBleeder(String motionProMicroForkBleeder) {
        this.motionProMicroForkBleeder = motionProMicroForkBleeder;
    }

    public String getMotionProCRProThottleKit() {
        return motionProCRProThottleKit;
    }

    public void setMotionProCRProThottleKit(String motionProCRProThottleKit) {
        this.motionProCRProThottleKit = motionProCRProThottleKit;
    }

    public String getOemCableSpeedo() {
        return oemCableSpeedo;
    }

    public void setOemCableSpeedo(String oemCableSpeedo) {
        this.oemCableSpeedo = oemCableSpeedo;
    }

    public String getMotionProCableSpeedo() {
        return motionProCableSpeedo;
    }

    public void setMotionProCableSpeedo(String motionProCableSpeedo) {
        this.motionProCableSpeedo = motionProCableSpeedo;
    }

    public String getMotionProCableThrottleTube() {
        return motionProCableThrottleTube;
    }

    public void setMotionProCableThrottleTube(String motionProCableThrottleTube) {
        this.motionProCableThrottleTube = motionProCableThrottleTube;
    }

    public String getCrossproRadiatorGuard() {
        return crossproRadiatorGuard;
    }

    public void setCrossproRadiatorGuard(String crossproRadiatorGuard) {
        this.crossproRadiatorGuard = crossproRadiatorGuard;
    }

    public String getOemClutchFibres() {
        return oemClutchFibres;
    }

    public void setOemClutchFibres(String oemClutchFibres) {
        this.oemClutchFibres = oemClutchFibres;
    }

    public String getOemClutchFibresSteels() {
        return oemClutchFibresSteels;
    }

    public void setOemClutchFibresSteels(String oemClutchFibresSteels) {
        this.oemClutchFibresSteels = oemClutchFibresSteels;
    }

    public String getNewfrenClutchKit() {
        return newfrenClutchKit;
    }

    public void setNewfrenClutchKit(String newfrenClutchKit) {
        this.newfrenClutchKit = newfrenClutchKit;
    }

    public String getNewfrenClutchSpringKits() {
        return newfrenClutchSpringKits;
    }

    public void setNewfrenClutchSpringKits(String newfrenClutchSpringKits) {
        this.newfrenClutchSpringKits = newfrenClutchSpringKits;
    }

    public String getAllBallsCMCRebuiltKit() {
        return allBallsCMCRebuiltKit;
    }

    public void setAllBallsCMCRebuiltKit(String allBallsCMCRebuiltKit) {
        this.allBallsCMCRebuiltKit = allBallsCMCRebuiltKit;
    }

    public String getWisecoForgedClutchBasket() {
        return wisecoForgedClutchBasket;
    }

    public void setWisecoForgedClutchBasket(String wisecoForgedClutchBasket) {
        this.wisecoForgedClutchBasket = wisecoForgedClutchBasket;
    }

    public String getWisecoBottemEndRebuildKit() {
        return wisecoBottemEndRebuildKit;
    }

    public void setWisecoBottemEndRebuildKit(String wisecoBottemEndRebuildKit) {
        this.wisecoBottemEndRebuildKit = wisecoBottemEndRebuildKit;
    }

    public String getWrenchRERebuildKit() {
        return wrenchRERebuildKit;
    }

    public void setWrenchRERebuildKit(String wrenchRERebuildKit) {
        this.wrenchRERebuildKit = wrenchRERebuildKit;
    }

    public String getOemCarbAssembly() {
        return oemCarbAssembly;
    }

    public void setOemCarbAssembly(String oemCarbAssembly) {
        this.oemCarbAssembly = oemCarbAssembly;
    }

    public String getAllBallsCarbRepairKit() {
        return allBallsCarbRepairKit;
    }

    public void setAllBallsCarbRepairKit(String allBallsCarbRepairKit) {
        this.allBallsCarbRepairKit = allBallsCarbRepairKit;
    }

    public String getAllBallsCRMidBodyGasket1() {
        return allBallsCRMidBodyGasket1;
    }

    public void setAllBallsCRMidBodyGasket1(String allBallsCRMidBodyGasket1) {
        this.allBallsCRMidBodyGasket1 = allBallsCRMidBodyGasket1;
    }

    public String getAllBallsCRMidBodyGasket2() {
        return allBallsCRMidBodyGasket2;
    }

    public void setAllBallsCRMidBodyGasket2(String allBallsCRMidBodyGasket2) {
        this.allBallsCRMidBodyGasket2 = allBallsCRMidBodyGasket2;
    }

    public String getAllBallsFuelTapRepairKit() {
        return allBallsFuelTapRepairKit;
    }

    public void setAllBallsFuelTapRepairKit(String allBallsFuelTapRepairKit) {
        this.allBallsFuelTapRepairKit = allBallsFuelTapRepairKit;
    }

    public String getAllBallsFuelTapRepairKit2() {
        return allBallsFuelTapRepairKit2;
    }

    public void setAllBallsFuelTapRepairKit2(String allBallsFuelTapRepairKit2) {
        this.allBallsFuelTapRepairKit2 = allBallsFuelTapRepairKit2;
    }

    public String getFuelStarFuelValveKit() {
        return fuelStarFuelValveKit;
    }

    public void setFuelStarFuelValveKit(String fuelStarFuelValveKit) {
        this.fuelStarFuelValveKit = fuelStarFuelValveKit;
    }

    public String getFuelStarFuelValveKit2() {
        return fuelStarFuelValveKit2;
    }

    public void setFuelStarFuelValveKit2(String fuelStarFuelValveKit2) {
        this.fuelStarFuelValveKit2 = fuelStarFuelValveKit2;
    }

    public String getFuelStarHoseClampKit() {
        return fuelStarHoseClampKit;
    }

    public void setFuelStarHoseClampKit(String fuelStarHoseClampKit) {
        this.fuelStarHoseClampKit = fuelStarHoseClampKit;
    }

    public String getRgEngineCoverLHS() {
        return rgEngineCoverLHS;
    }

    public void setRgEngineCoverLHS(String rgEngineCoverLHS) {
        this.rgEngineCoverLHS = rgEngineCoverLHS;
    }

    public String getRgTailTidy() {
        return rgTailTidy;
    }

    public void setRgTailTidy(String rgTailTidy) {
        this.rgTailTidy = rgTailTidy;
    }

    public String getAllBallsLBSealKit() {
        return allBallsLBSealKit;
    }

    public void setAllBallsLBSealKit(String allBallsLBSealKit) {
        this.allBallsLBSealKit = allBallsLBSealKit;
    }

    public String getAllBallsLRSBearingKit() {
        return allBallsLRSBearingKit;
    }

    public void setAllBallsLRSBearingKit(String allBallsLRSBearingKit) {
        this.allBallsLRSBearingKit = allBallsLRSBearingKit;
    }

    public String getAllBallsURSBearingKit() {
        return allBallsURSBearingKit;
    }

    public void setAllBallsURSBearingKit(String allBallsURSBearingKit) {
        this.allBallsURSBearingKit = allBallsURSBearingKit;
    }

    public String getAllBallsULSBearingKit() {
        return allBallsULSBearingKit;
    }

    public void setAllBallsULSBearingKit(String allBallsULSBearingKit) {
        this.allBallsULSBearingKit = allBallsULSBearingKit;
    }

    public String getAllBallsSBSealKit() {
        return allBallsSBSealKit;
    }

    public void setAllBallsSBSealKit(String allBallsSBSealKit) {
        this.allBallsSBSealKit = allBallsSBSealKit;
    }

    public String getPivotWorksSTBearingKit() {
        return pivotWorksSTBearingKit;
    }

    public void setPivotWorksSTBearingKit(String pivotWorksSTBearingKit) {
        this.pivotWorksSTBearingKit = pivotWorksSTBearingKit;
    }

    public String getPivotWorksSRebuildKit() {
        return pivotWorksSRebuildKit;
    }

    public void setPivotWorksSRebuildKit(String pivotWorksSRebuildKit) {
        this.pivotWorksSRebuildKit = pivotWorksSRebuildKit;
    }

    public String getMpForkSealDriver() {
        return mpForkSealDriver;
    }

    public void setMpForkSealDriver(String mpForkSealDriver) {
        this.mpForkSealDriver = mpForkSealDriver;
    }

    public String getMpValveSealInstallTool() {
        return mpValveSealInstallTool;
    }

    public void setMpValveSealInstallTool(String mpValveSealInstallTool) {
        this.mpValveSealInstallTool = mpValveSealInstallTool;
    }

    public String getWinderosaGasketKitTopEnd() {
        return winderosaGasketKitTopEnd;
    }

    public void setWinderosaGasketKitTopEnd(String winderosaGasketKitTopEnd) {
        this.winderosaGasketKitTopEnd = winderosaGasketKitTopEnd;
    }

    public String getWinderosaGasketKitOilSeals() {
        return winderosaGasketKitOilSeals;
    }

    public void setWinderosaGasketKitOilSeals(String winderosaGasketKitOilSeals) {
        this.winderosaGasketKitOilSeals = winderosaGasketKitOilSeals;
    }

    public String getOemExhaustGasket() {
        return oemExhaustGasket;
    }

    public void setOemExhaustGasket(String oemExhaustGasket) {
        this.oemExhaustGasket = oemExhaustGasket;
    }

    public String getWinderosaGasketExhaust() {
        return winderosaGasketExhaust;
    }

    public void setWinderosaGasketExhaust(String winderosaGasketExhaust) {
        this.winderosaGasketExhaust = winderosaGasketExhaust;
    }

    public String getWinderosaWaterPumpRebuildKit() {
        return winderosaWaterPumpRebuildKit;
    }

    public void setWinderosaWaterPumpRebuildKit(String winderosaWaterPumpRebuildKit) {
        this.winderosaWaterPumpRebuildKit = winderosaWaterPumpRebuildKit;
    }

    public String getHotRodsConnectingRodKit() {
        return hotRodsConnectingRodKit;
    }

    public void setHotRodsConnectingRodKit(String hotRodsConnectingRodKit) {
        this.hotRodsConnectingRodKit = hotRodsConnectingRodKit;
    }

    public String getHotRodsCounterBalRebuildKit() {
        return hotRodsCounterBalRebuildKit;
    }

    public void setHotRodsCounterBalRebuildKit(String hotRodsCounterBalRebuildKit) {
        this.hotRodsCounterBalRebuildKit = hotRodsCounterBalRebuildKit;
    }

    public String getHotRodsBERebuildKit() {
        return hotRodsBERebuildKit;
    }

    public void setHotRodsBERebuildKit(String hotRodsBERebuildKit) {
        this.hotRodsBERebuildKit = hotRodsBERebuildKit;
    }

    public String getHotRodsBERebuildKitSt() {
        return hotRodsBERebuildKitSt;
    }

    public void setHotRodsBERebuildKitSt(String hotRodsBERebuildKitSt) {
        this.hotRodsBERebuildKitSt = hotRodsBERebuildKitSt;
    }

    public String getHotRodsCylinderHead() {
        return hotRodsCylinderHead;
    }

    public void setHotRodsCylinderHead(String hotRodsCylinderHead) {
        this.hotRodsCylinderHead = hotRodsCylinderHead;
    }

    public String getHotRodsMainBearingSealKit() {
        return hotRodsMainBearingSealKit;
    }

    public void setHotRodsMainBearingSealKit(String hotRodsMainBearingSealKit) {
        this.hotRodsMainBearingSealKit = hotRodsMainBearingSealKit;
    }

    public String getHotRodsTransmissionBearings() {
        return hotRodsTransmissionBearings;
    }

    public void setHotRodsTransmissionBearings(String hotRodsTransmissionBearings) {
        this.hotRodsTransmissionBearings = hotRodsTransmissionBearings;
    }

    public String getHotRodsWristPinBearings() {
        return hotRodsWristPinBearings;
    }

    public void setHotRodsWristPinBearings(String hotRodsWristPinBearings) {
        this.hotRodsWristPinBearings = hotRodsWristPinBearings;
    }

    public String getHotRodsSOHCCamshaftStage1() {
        return hotRodsSOHCCamshaftStage1;
    }

    public void setHotRodsSOHCCamshaftStage1(String hotRodsSOHCCamshaftStage1) {
        this.hotRodsSOHCCamshaftStage1 = hotRodsSOHCCamshaftStage1;
    }

    public String getHotRodsSOHCCamshaftStage2() {
        return hotRodsSOHCCamshaftStage2;
    }

    public void setHotRodsSOHCCamshaftStage2(String hotRodsSOHCCamshaftStage2) {
        this.hotRodsSOHCCamshaftStage2 = hotRodsSOHCCamshaftStage2;
    }

    public String getHotRodsSOHCCamshaftStage3() {
        return hotRodsSOHCCamshaftStage3;
    }

    public void setHotRodsSOHCCamshaftStage3(String hotRodsSOHCCamshaftStage3) {
        this.hotRodsSOHCCamshaftStage3 = hotRodsSOHCCamshaftStage3;
    }

    public String getHotRodsDOHCCamshaftStage1Intake() {
        return hotRodsDOHCCamshaftStage1Intake;
    }

    public void setHotRodsDOHCCamshaftStage1Intake(String hotRodsDOHCCamshaftStage1Intake) {
        this.hotRodsDOHCCamshaftStage1Intake = hotRodsDOHCCamshaftStage1Intake;
    }

    public String getHotRodsDOHCCamshaftStage1Exhaust() {
        return hotRodsDOHCCamshaftStage1Exhaust;
    }

    public void setHotRodsDOHCCamshaftStage1Exhaust(String hotRodsDOHCCamshaftStage1Exhaust) {
        this.hotRodsDOHCCamshaftStage1Exhaust = hotRodsDOHCCamshaftStage1Exhaust;
    }

    public String getHotRodsDOHCCamshaftStage2Intake() {
        return hotRodsDOHCCamshaftStage2Intake;
    }

    public void setHotRodsDOHCCamshaftStage2Intake(String hotRodsDOHCCamshaftStage2Intake) {
        this.hotRodsDOHCCamshaftStage2Intake = hotRodsDOHCCamshaftStage2Intake;
    }

    public String getHotRodsDOHCCamshaftStage2Exhaust() {
        return hotRodsDOHCCamshaftStage2Exhaust;
    }

    public void setHotRodsDOHCCamshaftStage2Exhaust(String hotRodsDOHCCamshaftStage2Exhaust) {
        this.hotRodsDOHCCamshaftStage2Exhaust = hotRodsDOHCCamshaftStage2Exhaust;
    }

    public Set<BikeFrontSprocketDTO> getBikeFrontSprockets() {
        return bikeFrontSprockets;
    }

    public void setBikeFrontSprockets(Set<BikeFrontSprocketDTO> bikeFrontSprockets) {
        this.bikeFrontSprockets = bikeFrontSprockets;
    }

    public Set<BikeRearSprocketDTO> getBikeRearSprockets() {
        return bikeRearSprockets;
    }

    public void setBikeRearSprockets(Set<BikeRearSprocketDTO> bikeRearSprockets) {
        this.bikeRearSprockets = bikeRearSprockets;
    }

    public Set<RearSprocketConvDTO> getRearSprocketConvs() {
        return rearSprocketConvs;
    }

    public void setRearSprocketConvs(Set<RearSprocketConvDTO> rearSprocketConvs) {
        this.rearSprocketConvs = rearSprocketConvs;
    }

    public Set<FrontSprocketConvDTO> getFrontSprocketConvs() {
        return frontSprocketConvs;
    }

    public void setFrontSprocketConvs(Set<FrontSprocketConvDTO> frontSprocketConvs) {
        this.frontSprocketConvs = frontSprocketConvs;
    }

    public Set<ChainDTO> getChains() {
        return chains;
    }

    public void setChains(Set<ChainDTO> chains) {
        this.chains = chains;
    }

    public Set<BikeBrakePadDTO> getBikeBrakePads() {
        return bikeBrakePads;
    }

    public void setBikeBrakePads(Set<BikeBrakePadDTO> bikeBrakePads) {
        this.bikeBrakePads = bikeBrakePads;
    }

    public Set<BikeBrakeDiscDTO> getBikeBrakeDiscs() {
        return bikeBrakeDiscs;
    }

    public void setBikeBrakeDiscs(Set<BikeBrakeDiscDTO> bikeBrakeDiscs) {
        this.bikeBrakeDiscs = bikeBrakeDiscs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BikeDTO bikeDTO = (BikeDTO) o;
        if (bikeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bikeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BikeDTO{" +
            "id=" + getId() +
            ", visibilityAU='" + getVisibilityAU() + "'" +
            ", visibilityEU='" + getVisibilityEU() + "'" +
            ", inactive='" + getInactive() + "'" +
            ", oemconfirmed='" + getOemconfirmed() + "'" +
            ", oesource='" + getOesource() + "'" +
            ", epid=" + getEpid() +
            ", modeltype1='" + getModeltype1() + "'" +
            ", modeltype2='" + getModeltype2() + "'" +
            ", manufacturer='" + getManufacturer() + "'" +
            ", strokes='" + getStrokes() + "'" +
            ", capacity=" + getCapacity() +
            ", modelName='" + getModelName() + "'" +
            ", modelYearCode='" + getModelYearCode() + "'" +
            ", modelTypeCode='" + getModelTypeCode() + "'" +
            ", year=" + getYear() +
            ", finalDriveType='" + getFinalDriveType() + "'" +
            ", categoryPath='" + getCategoryPath() + "'" +
            ", modelNotes='" + getModelNotes() + "'" +
            ", modelNotes2='" + getModelNotes2() + "'" +
            ", modelNotes3='" + getModelNotes3() + "'" +
            ", modelNotes4='" + getModelNotes4() + "'" +
            ", modelInfoHTML='" + getModelInfoHTML() + "'" +
            ", oemFrontBrakeSystemType='" + getOemFrontBrakeSystemType() + "'" +
            ", oemFrontBrakeDiscLeft='" + getOemFrontBrakeDiscLeft() + "'" +
            ", oemFrontBrakeDiscRight='" + getOemFrontBrakeDiscRight() + "'" +
            ", oemFrontBrakeDiscBolts='" + getOemFrontBrakeDiscBolts() + "'" +
            ", oemFrontBDQTYPD=" + getOemFrontBDQTYPD() +
            ", oemFrontBrakeDiscABSRing='" + getOemFrontBrakeDiscABSRing() + "'" +
            ", oemFrontBrakeCaliper1='" + getOemFrontBrakeCaliper1() + "'" +
            ", oemFrontBrakeCaliper2='" + getOemFrontBrakeCaliper2() + "'" +
            ", oemFrontBrakeCaliperPin='" + getOemFrontBrakeCaliperPin() + "'" +
            ", oemFrontBrakePadsFrontL='" + getOemFrontBrakePadsFrontL() + "'" +
            ", oemFrontBrakePadsFrontR='" + getOemFrontBrakePadsFrontR() + "'" +
            ", oemFrontShoe='" + getOemFrontShoe() + "'" +
            ", oemMidldleAxleBrakeDisc='" + getOemMidldleAxleBrakeDisc() + "'" +
            ", oemMiddleAxleBrakePads='" + getOemMiddleAxleBrakePads() + "'" +
            ", oemRearBrakeSystemType='" + getOemRearBrakeSystemType() + "'" +
            ", oeamRearBrakeDisc='" + getOeamRearBrakeDisc() + "'" +
            ", oeamRearBrakeDiscBolts='" + getOeamRearBrakeDiscBolts() + "'" +
            ", oeamRearBrakeDiscBQTYPD=" + getOeamRearBrakeDiscBQTYPD() +
            ", oemRearBrakeCaliper='" + getOemRearBrakeCaliper() + "'" +
            ", oemRearBrakeCaliperPin='" + getOemRearBrakeCaliperPin() + "'" +
            ", oemRearBrakePads1='" + getOemRearBrakePads1() + "'" +
            ", oemRearBrakePads2='" + getOemRearBrakePads2() + "'" +
            ", oemShoeRear='" + getOemShoeRear() + "'" +
            ", oemShoeRear2='" + getOemShoeRear2() + "'" +
            ", oemSlaveCylinder='" + getOemSlaveCylinder() + "'" +
            ", oemChainNo='" + getOemChainNo() + "'" +
            ", oemChainSize=" + getOemChainSize() +
            ", oemChainLinks=" + getOemChainLinks() +
            ", oemFrontSprocket='" + getOemFrontSprocket() + "'" +
            ", oemFrontGearing=" + getOemFrontGearing() +
            ", oemFrontGearingMin=" + getOemFrontGearingMin() +
            ", oemFrontGearingMax=" + getOemFrontGearingMax() +
            ", oemRearSprocket='" + getOemRearSprocket() + "'" +
            ", oemRearGearing=" + getOemRearGearing() +
            ", oemRearGearingMin=" + getOemRearGearingMin() +
            ", oemRearGearingMax=" + getOemRearGearingMax() +
            ", finalDriveNotes='" + getFinalDriveNotes() + "'" +
            ", chainConvSize=" + getChainConvSize() +
            ", chainConvLinks=" + getChainConvLinks() +
            ", oemFrontWheel='" + getOemFrontWheel() + "'" +
            ", oemFrontWheelType='" + getOemFrontWheelType() + "'" +
            ", oemFrontWheelFront=" + getOemFrontWheelFront() +
            ", oemFrontWheelTyreSize='" + getOemFrontWheelTyreSize() + "'" +
            ", oemFrontHub='" + getOemFrontHub() + "'" +
            ", oemFrontWheelbearing1='" + getOemFrontWheelbearing1() + "'" +
            ", oemFrontWheelbearing2='" + getOemFrontWheelbearing2() + "'" +
            ", oemFrontWheelSeal='" + getOemFrontWheelSeal() + "'" +
            ", oemRearWheel='" + getOemRearWheel() + "'" +
            ", oemRearWheelSize=" + getOemRearWheelSize() +
            ", oemRearWheelTyre='" + getOemRearWheelTyre() + "'" +
            ", oemRearWheelBearing1='" + getOemRearWheelBearing1() + "'" +
            ", oemRearWheelBearing2='" + getOemRearWheelBearing2() + "'" +
            ", oemRearWheelSeal='" + getOemRearWheelSeal() + "'" +
            ", frontPadsDiffCaliper='" + getFrontPadsDiffCaliper() + "'" +
            ", qtyBH=" + getQtyBH() +
            ", handbrakeParking='" + getHandbrakeParking() + "'" +
            ", addNotesToBike='" + getAddNotesToBike() + "'" +
            ", dateAndID='" + getDateAndID() + "'" +
            ", source='" + getSource() + "'" +
            ", tuvRequired='" + getTuvRequired() + "'" +
            ", tuvTypeCode='" + getTuvTypeCode() + "'" +
            ", abekba='" + getAbekba() + "'" +
            ", tuvFrontDisc='" + getTuvFrontDisc() + "'" +
            ", tuvRearDisc='" + getTuvRearDisc() + "'" +
            ", bremboBrakeDiscFrontRef='" + getBremboBrakeDiscFrontRef() + "'" +
            ", ebcBrakeDiscFrontRef='" + getEbcBrakeDiscFrontRef() + "'" +
            ", trwBrakeDiscFrontRef='" + getTrwBrakeDiscFrontRef() + "'" +
            ", mgearBrakeDiscFrontLeftRef='" + getMgearBrakeDiscFrontLeftRef() + "'" +
            ", mgearBrakeDiscFrontRightRef='" + getMgearBrakeDiscFrontRightRef() + "'" +
            ", mgearBrakeDiscFrontCheck='" + getMgearBrakeDiscFrontCheck() + "'" +
            ", mgearBrakeDiscFrontLeftRef2='" + getMgearBrakeDiscFrontLeftRef2() + "'" +
            ", mgearBrakeDiscFrontRightRef2='" + getMgearBrakeDiscFrontRightRef2() + "'" +
            ", mgearBrakeDiscFNeto='" + getMgearBrakeDiscFNeto() + "'" +
            ", motodiscBrakeDiscFNeto='" + getMotodiscBrakeDiscFNeto() + "'" +
            ", ebcBrakePadsFrontLRef='" + getEbcBrakePadsFrontLRef() + "'" +
            ", ebcBrakePadsFrontRRef='" + getEbcBrakePadsFrontRRef() + "'" +
            ", mgearBrakePadsFrontLRef='" + getMgearBrakePadsFrontLRef() + "'" +
            ", mgearBrakePadsFrontRRef='" + getMgearBrakePadsFrontRRef() + "'" +
            ", mgearBrakePadsFNeto='" + getMgearBrakePadsFNeto() + "'" +
            ", motoPadBrakePadsFrontLRef='" + getMotoPadBrakePadsFrontLRef() + "'" +
            ", motoPadBrakePadsFrontRRef='" + getMotoPadBrakePadsFrontRRef() + "'" +
            ", motopadBrakePadsFNeto='" + getMotopadBrakePadsFNeto() + "'" +
            ", allBallsFCRebuildKit1='" + getAllBallsFCRebuildKit1() + "'" +
            ", allBallsFCPin='" + getAllBallsFCPin() + "'" +
            ", allBallsFMCyRebuildKit='" + getAllBallsFMCyRebuildKit() + "'" +
            ", allBallsFSCRebuildKit='" + getAllBallsFSCRebuildKit() + "'" +
            ", newfrenShoeFront='" + getNewfrenShoeFront() + "'" +
            ", mgearMiddleAxleBrakeDiscNeto='" + getMgearMiddleAxleBrakeDiscNeto() + "'" +
            ", mgearMiddleAxleBrakeDiscNeto2='" + getMgearMiddleAxleBrakeDiscNeto2() + "'" +
            ", mgearMiddleAxleBrakePadNeto='" + getMgearMiddleAxleBrakePadNeto() + "'" +
            ", mgearMiddleAxleBrakePadNeto2='" + getMgearMiddleAxleBrakePadNeto2() + "'" +
            ", mgearBrakePadsParkRef='" + getMgearBrakePadsParkRef() + "'" +
            ", mgearBrakePadsParkRef2='" + getMgearBrakePadsParkRef2() + "'" +
            ", ebcBrakeDiscRearRef='" + getEbcBrakeDiscRearRef() + "'" +
            ", bremboBrakeDiscRearRef='" + getBremboBrakeDiscRearRef() + "'" +
            ", mgearBrakeDiscRearRef='" + getMgearBrakeDiscRearRef() + "'" +
            ", trwBrakeDiscRearRef='" + getTrwBrakeDiscRearRef() + "'" +
            ", mgearBrakeDiscRear='" + getMgearBrakeDiscRear() + "'" +
            ", allBallsRCRebuildKit1='" + getAllBallsRCRebuildKit1() + "'" +
            ", allBallsRearCaliperBolt='" + getAllBallsRearCaliperBolt() + "'" +
            ", allBallsRMCrRebuildKit='" + getAllBallsRMCrRebuildKit() + "'" +
            ", ebcBrakePadsRearRef='" + getEbcBrakePadsRearRef() + "'" +
            ", mgearBrakePadsRearNeto='" + getMgearBrakePadsRearNeto() + "'" +
            ", newfrenShoeRear='" + getNewfrenShoeRear() + "'" +
            ", allBallsRearBrakePedalKit='" + getAllBallsRearBrakePedalKit() + "'" +
            ", allBallsCSCRebuildKit='" + getAllBallsCSCRebuildKit() + "'" +
            ", frontJTRefFront='" + getFrontJTRefFront() + "'" +
            ", esjotRefFront='" + getEsjotRefFront() + "'" +
            ", mgearRefFront='" + getMgearRefFront() + "'" +
            ", mogemaRefFront='" + getMogemaRefFront() + "'" +
            ", supersproxRefFront='" + getSupersproxRefFront() + "'" +
            ", esjotRefRear='" + getEsjotRefRear() + "'" +
            ", jtRefRear='" + getJtRefRear() + "'" +
            ", mgearRefRear='" + getMgearRefRear() + "'" +
            ", mogemaRefRear='" + getMogemaRefRear() + "'" +
            ", supersproxRefRear='" + getSupersproxRefRear() + "'" +
            ", esjotRefFrontConv='" + getEsjotRefFrontConv() + "'" +
            ", jtSprocketRef='" + getJtSprocketRef() + "'" +
            ", mgearRefFrontConv='" + getMgearRefFrontConv() + "'" +
            ", mogemarefFrontConv='" + getMogemarefFrontConv() + "'" +
            ", supersproxRefFrontConv='" + getSupersproxRefFrontConv() + "'" +
            ", conversionChain='" + getConversionChain() + "'" +
            ", mgearSprocketRearConv='" + getMgearSprocketRearConv() + "'" +
            ", esjotRefRearConv='" + getEsjotRefRearConv() + "'" +
            ", mgearRefRearConv='" + getMgearRefRearConv() + "'" +
            ", mogemaRefRearConv='" + getMogemaRefRearConv() + "'" +
            ", supersproxRefRearConv='" + getSupersproxRefRearConv() + "'" +
            ", allBallsFWBearingKit1='" + getAllBallsFWBearingKit1() + "'" +
            ", allBallsFWBearingKit2='" + getAllBallsFWBearingKit2() + "'" +
            ", allBallsRWBearingKit1='" + getAllBallsRWBearingKit1() + "'" +
            ", allBallsRWBearingKit2='" + getAllBallsRWBearingKit2() + "'" +
            ", allBallsRWBearingUpgrade='" + getAllBallsRWBearingUpgrade() + "'" +
            ", oemSparkPlug='" + getOemSparkPlug() + "'" +
            ", oemSparkPlugQTY=" + getOemSparkPlugQTY() +
            ", ngkSparkPlugSKUs='" + getNgkSparkPlugSKUs() + "'" +
            ", oemAlternator='" + getOemAlternator() + "'" +
            ", oemVoltageRegulator='" + getOemVoltageRegulator() + "'" +
            ", arrowheadAlternator='" + getArrowheadAlternator() + "'" +
            ", arrowheadAlternator2='" + getArrowheadAlternator2() + "'" +
            ", arrowheadCDIModule='" + getArrowheadCDIModule() + "'" +
            ", arrowheadChargingCoil='" + getArrowheadChargingCoil() + "'" +
            ", arrowheadIgnitionCoil='" + getArrowheadIgnitionCoil() + "'" +
            ", arrowheadStatorCoil='" + getArrowheadStatorCoil() + "'" +
            ", arrowheadVoltageRegulator='" + getArrowheadVoltageRegulator() + "'" +
            ", arrowheadPowerShiftCM='" + getArrowheadPowerShiftCM() + "'" +
            ", arrowheadStarterDrive='" + getArrowheadStarterDrive() + "'" +
            ", arrowheadStarterMotor='" + getArrowheadStarterMotor() + "'" +
            ", arrowheadStarterRelay='" + getArrowheadStarterRelay() + "'" +
            ", oemBattery='" + getOemBattery() + "'" +
            ", ssbAGMBattery='" + getSsbAGMBattery() + "'" +
            ", oemAirFilter='" + getOemAirFilter() + "'" +
            ", knAirFilter='" + getKnAirFilter() + "'" +
            ", motorexAirFilter='" + getMotorexAirFilter() + "'" +
            ", motorexAirFilterPreoiled='" + getMotorexAirFilterPreoiled() + "'" +
            ", oemOilFilter1='" + getOemOilFilter1() + "'" +
            ", knOilFilter1='" + getKnOilFilter1() + "'" +
            ", oemOilFilter2='" + getOemOilFilter2() + "'" +
            ", knOilFilter2='" + getKnOilFilter2() + "'" +
            ", motionProOilFilterMagnet='" + getMotionProOilFilterMagnet() + "'" +
            ", oemSteeringBearing='" + getOemSteeringBearing() + "'" +
            ", oemSteeringSeal='" + getOemSteeringSeal() + "'" +
            ", allBallsSBSealKit1='" + getAllBallsSBSealKit1() + "'" +
            ", allBallsSBSealKit2='" + getAllBallsSBSealKit2() + "'" +
            ", allBallsSBSealKitLower='" + getAllBallsSBSealKitLower() + "'" +
            ", allBallsSBSealKitLower2='" + getAllBallsSBSealKitLower2() + "'" +
            ", allBallsCBSealKit='" + getAllBallsCBSealKit() + "'" +
            ", oemForkAssemblyLeft='" + getOemForkAssemblyLeft() + "'" +
            ", oemForkAssemblyRight='" + getOemForkAssemblyRight() + "'" +
            ", oemForkSeals='" + getOemForkSeals() + "'" +
            ", allBallsForkSeals='" + getAllBallsForkSeals() + "'" +
            ", xprForkSeals='" + getXprForkSeals() + "'" +
            ", allBallsForkBushingKit='" + getAllBallsForkBushingKit() + "'" +
            ", motionProMicroForkBleeder='" + getMotionProMicroForkBleeder() + "'" +
            ", motionProCRProThottleKit='" + getMotionProCRProThottleKit() + "'" +
            ", oemCableSpeedo='" + getOemCableSpeedo() + "'" +
            ", motionProCableSpeedo='" + getMotionProCableSpeedo() + "'" +
            ", motionProCableThrottleTube='" + getMotionProCableThrottleTube() + "'" +
            ", crossproRadiatorGuard='" + getCrossproRadiatorGuard() + "'" +
            ", oemClutchFibres='" + getOemClutchFibres() + "'" +
            ", oemClutchFibresSteels='" + getOemClutchFibresSteels() + "'" +
            ", newfrenClutchKit='" + getNewfrenClutchKit() + "'" +
            ", newfrenClutchSpringKits='" + getNewfrenClutchSpringKits() + "'" +
            ", allBallsCMCRebuiltKit='" + getAllBallsCMCRebuiltKit() + "'" +
            ", wisecoForgedClutchBasket='" + getWisecoForgedClutchBasket() + "'" +
            ", wisecoBottemEndRebuildKit='" + getWisecoBottemEndRebuildKit() + "'" +
            ", wrenchRERebuildKit='" + getWrenchRERebuildKit() + "'" +
            ", oemCarbAssembly='" + getOemCarbAssembly() + "'" +
            ", allBallsCarbRepairKit='" + getAllBallsCarbRepairKit() + "'" +
            ", allBallsCRMidBodyGasket1='" + getAllBallsCRMidBodyGasket1() + "'" +
            ", allBallsCRMidBodyGasket2='" + getAllBallsCRMidBodyGasket2() + "'" +
            ", allBallsFuelTapRepairKit='" + getAllBallsFuelTapRepairKit() + "'" +
            ", allBallsFuelTapRepairKit2='" + getAllBallsFuelTapRepairKit2() + "'" +
            ", fuelStarFuelValveKit='" + getFuelStarFuelValveKit() + "'" +
            ", fuelStarFuelValveKit2='" + getFuelStarFuelValveKit2() + "'" +
            ", fuelStarHoseClampKit='" + getFuelStarHoseClampKit() + "'" +
            ", rgEngineCoverLHS='" + getRgEngineCoverLHS() + "'" +
            ", rgTailTidy='" + getRgTailTidy() + "'" +
            ", allBallsLBSealKit='" + getAllBallsLBSealKit() + "'" +
            ", allBallsLRSBearingKit='" + getAllBallsLRSBearingKit() + "'" +
            ", allBallsURSBearingKit='" + getAllBallsURSBearingKit() + "'" +
            ", allBallsULSBearingKit='" + getAllBallsULSBearingKit() + "'" +
            ", allBallsSBSealKit='" + getAllBallsSBSealKit() + "'" +
            ", pivotWorksSTBearingKit='" + getPivotWorksSTBearingKit() + "'" +
            ", pivotWorksSRebuildKit='" + getPivotWorksSRebuildKit() + "'" +
            ", mpForkSealDriver='" + getMpForkSealDriver() + "'" +
            ", mpValveSealInstallTool='" + getMpValveSealInstallTool() + "'" +
            ", winderosaGasketKitTopEnd='" + getWinderosaGasketKitTopEnd() + "'" +
            ", winderosaGasketKitOilSeals='" + getWinderosaGasketKitOilSeals() + "'" +
            ", oemExhaustGasket='" + getOemExhaustGasket() + "'" +
            ", winderosaGasketExhaust='" + getWinderosaGasketExhaust() + "'" +
            ", winderosaWaterPumpRebuildKit='" + getWinderosaWaterPumpRebuildKit() + "'" +
            ", hotRodsConnectingRodKit='" + getHotRodsConnectingRodKit() + "'" +
            ", hotRodsCounterBalRebuildKit='" + getHotRodsCounterBalRebuildKit() + "'" +
            ", hotRodsBERebuildKit='" + getHotRodsBERebuildKit() + "'" +
            ", hotRodsBERebuildKitSt='" + getHotRodsBERebuildKitSt() + "'" +
            ", hotRodsCylinderHead='" + getHotRodsCylinderHead() + "'" +
            ", hotRodsMainBearingSealKit='" + getHotRodsMainBearingSealKit() + "'" +
            ", hotRodsTransmissionBearings='" + getHotRodsTransmissionBearings() + "'" +
            ", hotRodsWristPinBearings='" + getHotRodsWristPinBearings() + "'" +
            ", hotRodsSOHCCamshaftStage1='" + getHotRodsSOHCCamshaftStage1() + "'" +
            ", hotRodsSOHCCamshaftStage2='" + getHotRodsSOHCCamshaftStage2() + "'" +
            ", hotRodsSOHCCamshaftStage3='" + getHotRodsSOHCCamshaftStage3() + "'" +
            ", hotRodsDOHCCamshaftStage1Intake='" + getHotRodsDOHCCamshaftStage1Intake() + "'" +
            ", hotRodsDOHCCamshaftStage1Exhaust='" + getHotRodsDOHCCamshaftStage1Exhaust() + "'" +
            ", hotRodsDOHCCamshaftStage2Intake='" + getHotRodsDOHCCamshaftStage2Intake() + "'" +
            ", hotRodsDOHCCamshaftStage2Exhaust='" + getHotRodsDOHCCamshaftStage2Exhaust() + "'" +
            "}";
    }
}
