package com.mgearapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Bike.
 */
@Entity
@Table(name = "bike")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Bike extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "visibility_au")
    private String visibilityAU;

    @Column(name = "visibility_eu")
    private String visibilityEU;

    @Column(name = "inactive")
    private String inactive;

    @Column(name = "oemconfirmed")
    private String oemconfirmed;

    @Column(name = "oesource")
    private String oesource;

    @Column(name = "epid")
    private Long epid;

    @Column(name = "modeltype_1")
    private String modeltype1;

    @Column(name = "modeltype_2")
    private String modeltype2;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "strokes")
    private String strokes;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "model_year_code")
    private String modelYearCode;

    @Column(name = "model_type_code")
    private String modelTypeCode;

    @Column(name = "jhi_year")
    private Long year;

    @Column(name = "final_drive_type")
    private String finalDriveType;

    @Column(name = "category_path")
    private String categoryPath;

    @Column(name = "model_notes")
    private String modelNotes;

    @Column(name = "model_notes_2")
    private String modelNotes2;

    @Column(name = "model_notes_3")
    private String modelNotes3;

    @Column(name = "model_notes_4")
    private String modelNotes4;

    @Column(name = "model_info_html")
    private String modelInfoHTML;

    @Column(name = "oem_front_brake_system_type")
    private String oemFrontBrakeSystemType;

    @Column(name = "oem_front_brake_disc_left")
    private String oemFrontBrakeDiscLeft;

    @Column(name = "oem_front_brake_disc_right")
    private String oemFrontBrakeDiscRight;

    @Column(name = "oem_front_brake_disc_bolts")
    private String oemFrontBrakeDiscBolts;

    @Column(name = "oem_front_bdqtypd")
    private Long oemFrontBDQTYPD;

    @Column(name = "oem_front_brake_disc_abs_ring")
    private String oemFrontBrakeDiscABSRing;

    @Column(name = "oem_front_brake_caliper_1")
    private String oemFrontBrakeCaliper1;

    @Column(name = "oem_front_brake_caliper_2")
    private String oemFrontBrakeCaliper2;

    @Column(name = "oem_front_brake_caliper_pin")
    private String oemFrontBrakeCaliperPin;

    @Column(name = "oem_front_brake_pads_front_l")
    private String oemFrontBrakePadsFrontL;

    @Column(name = "oem_front_brake_pads_front_r")
    private String oemFrontBrakePadsFrontR;

    @Column(name = "oem_front_shoe")
    private String oemFrontShoe;

    @Column(name = "oem_midldle_axle_brake_disc")
    private String oemMidldleAxleBrakeDisc;

    @Column(name = "oem_middle_axle_brake_pads")
    private String oemMiddleAxleBrakePads;

    @Column(name = "oem_rear_brake_system_type")
    private String oemRearBrakeSystemType;

    @Column(name = "oeam_rear_brake_disc")
    private String oeamRearBrakeDisc;

    @Column(name = "oeam_rear_brake_disc_bolts")
    private String oeamRearBrakeDiscBolts;

    @Column(name = "oeam_rear_brake_disc_bqtypd")
    private Long oeamRearBrakeDiscBQTYPD;

    @Column(name = "oem_rear_brake_caliper")
    private String oemRearBrakeCaliper;

    @Column(name = "oem_rear_brake_caliper_pin")
    private String oemRearBrakeCaliperPin;

    @Column(name = "oem_rear_brake_pads_1")
    private String oemRearBrakePads1;

    @Column(name = "oem_rear_brake_pads_2")
    private String oemRearBrakePads2;

    @Column(name = "oem_shoe_rear")
    private String oemShoeRear;

    @Column(name = "oem_shoe_rear_2")
    private String oemShoeRear2;

    @Column(name = "oem_slave_cylinder")
    private String oemSlaveCylinder;

    @Column(name = "oem_chain_no")
    private String oemChainNo;

    @Column(name = "oem_chain_size", precision = 10, scale = 2)
    private BigDecimal oemChainSize;

    @Column(name = "oem_chain_links", precision = 10, scale = 2)
    private BigDecimal oemChainLinks;

    @Column(name = "oem_front_sprocket")
    private String oemFrontSprocket;

    @Column(name = "oem_front_gearing")
    private Long oemFrontGearing;

    @Column(name = "oem_front_gearing_min", precision = 10, scale = 2)
    private BigDecimal oemFrontGearingMin;

    @Column(name = "oem_front_gearing_max", precision = 10, scale = 2)
    private BigDecimal oemFrontGearingMax;

    @Column(name = "oem_rear_sprocket")
    private String oemRearSprocket;

    @Column(name = "oem_rear_gearing", precision = 10, scale = 2)
    private BigDecimal oemRearGearing;

    @Column(name = "oem_rear_gearing_min", precision = 10, scale = 2)
    private BigDecimal oemRearGearingMin;

    @Column(name = "oem_rear_gearing_max", precision = 10, scale = 2)
    private BigDecimal oemRearGearingMax;

    @Column(name = "final_drive_notes")
    private String finalDriveNotes;

    @Column(name = "chain_conv_size", precision = 10, scale = 2)
    private BigDecimal chainConvSize;

    @Column(name = "chain_conv_links", precision = 10, scale = 2)
    private BigDecimal chainConvLinks;

    @Column(name = "oem_front_wheel")
    private String oemFrontWheel;

    @Column(name = "oem_front_wheel_type")
    private String oemFrontWheelType;

    @Column(name = "oem_front_wheel_front", precision = 10, scale = 2)
    private BigDecimal oemFrontWheelFront;

    @Column(name = "oem_front_wheel_tyre_size")
    private String oemFrontWheelTyreSize;

    @Column(name = "oem_front_hub")
    private String oemFrontHub;

    @Column(name = "oem_front_wheelbearing_1")
    private String oemFrontWheelbearing1;

    @Column(name = "oem_front_wheelbearing_2")
    private String oemFrontWheelbearing2;

    @Column(name = "oem_front_wheel_seal")
    private String oemFrontWheelSeal;

    @Column(name = "oem_rear_wheel")
    private String oemRearWheel;

    @Column(name = "oem_rear_wheel_size", precision = 10, scale = 2)
    private BigDecimal oemRearWheelSize;

    @Column(name = "oem_rear_wheel_tyre")
    private String oemRearWheelTyre;

    @Column(name = "oem_rear_wheel_bearing_1")
    private String oemRearWheelBearing1;

    @Column(name = "oem_rear_wheel_bearing_2")
    private String oemRearWheelBearing2;

    @Column(name = "oem_rear_wheel_seal")
    private String oemRearWheelSeal;

    @Column(name = "front_pads_diff_caliper")
    private String frontPadsDiffCaliper;

    @Column(name = "qty_bh")
    private Long qtyBH;

    @Column(name = "handbrake_parking")
    private String handbrakeParking;

    @Column(name = "add_notes_to_bike")
    private String addNotesToBike;

    @Column(name = "date_and_id")
    private String dateAndID;

    @Column(name = "source")
    private String source;

    @Column(name = "tuv_required")
    private String tuvRequired;

    @Column(name = "tuv_type_code")
    private String tuvTypeCode;

    @Column(name = "abekba")
    private String abekba;

    @Column(name = "tuv_front_disc")
    private String tuvFrontDisc;

    @Column(name = "tuv_rear_disc")
    private String tuvRearDisc;

    @Column(name = "brembo_brake_disc_front_ref")
    private String bremboBrakeDiscFrontRef;

    @Column(name = "ebc_brake_disc_front_ref")
    private String ebcBrakeDiscFrontRef;

    @Column(name = "trw_brake_disc_front_ref")
    private String trwBrakeDiscFrontRef;

    @Column(name = "mgear_brake_disc_front_left_ref")
    private String mgearBrakeDiscFrontLeftRef;

    @Column(name = "mgear_brake_disc_front_right_ref")
    private String mgearBrakeDiscFrontRightRef;

    @Column(name = "mgear_brake_disc_front_check")
    private String mgearBrakeDiscFrontCheck;

    @Column(name = "mgear_brake_disc_front_left_ref_2")
    private String mgearBrakeDiscFrontLeftRef2;

    @Column(name = "mgear_brake_disc_front_right_ref_2")
    private String mgearBrakeDiscFrontRightRef2;

    @Column(name = "mgear_brake_disc_f_neto")
    private String mgearBrakeDiscFNeto;

    @Column(name = "motodisc_brake_disc_f_neto")
    private String motodiscBrakeDiscFNeto;

    @Column(name = "ebc_brake_pads_front_l_ref")
    private String ebcBrakePadsFrontLRef;

    @Column(name = "ebc_brake_pads_front_r_ref")
    private String ebcBrakePadsFrontRRef;

    @Column(name = "mgear_brake_pads_front_l_ref")
    private String mgearBrakePadsFrontLRef;

    @Column(name = "mgear_brake_pads_front_r_ref")
    private String mgearBrakePadsFrontRRef;

    @Column(name = "mgear_brake_pads_f_neto")
    private String mgearBrakePadsFNeto;

    @Column(name = "moto_pad_brake_pads_front_l_ref")
    private String motoPadBrakePadsFrontLRef;

    @Column(name = "moto_pad_brake_pads_front_r_ref")
    private String motoPadBrakePadsFrontRRef;

    @Column(name = "motopad_brake_pads_f_neto")
    private String motopadBrakePadsFNeto;

    @Column(name = "all_balls_fc_rebuild_kit_1")
    private String allBallsFCRebuildKit1;

    @Column(name = "all_balls_fc_pin")
    private String allBallsFCPin;

    @Column(name = "all_balls_fm_cy_rebuild_kit")
    private String allBallsFMCyRebuildKit;

    @Column(name = "all_balls_fsc_rebuild_kit")
    private String allBallsFSCRebuildKit;

    @Column(name = "newfren_shoe_front")
    private String newfrenShoeFront;

    @Column(name = "mgear_middle_axle_brake_disc_neto")
    private String mgearMiddleAxleBrakeDiscNeto;

    @Column(name = "mgear_middle_axle_brake_disc_neto_2")
    private String mgearMiddleAxleBrakeDiscNeto2;

    @Column(name = "mgear_middle_axle_brake_pad_neto")
    private String mgearMiddleAxleBrakePadNeto;

    @Column(name = "mgear_middle_axle_brake_pad_neto_2")
    private String mgearMiddleAxleBrakePadNeto2;

    @Column(name = "mgear_brake_pads_park_ref")
    private String mgearBrakePadsParkRef;

    @Column(name = "mgear_brake_pads_park_ref_2")
    private String mgearBrakePadsParkRef2;

    @Column(name = "ebc_brake_disc_rear_ref")
    private String ebcBrakeDiscRearRef;

    @Column(name = "brembo_brake_disc_rear_ref")
    private String bremboBrakeDiscRearRef;

    @Column(name = "mgear_brake_disc_rear_ref")
    private String mgearBrakeDiscRearRef;

    @Column(name = "trw_brake_disc_rear_ref")
    private String trwBrakeDiscRearRef;

    @Column(name = "mgear_brake_disc_rear")
    private String mgearBrakeDiscRear;

    @Column(name = "all_balls_rc_rebuild_kit_1")
    private String allBallsRCRebuildKit1;

    @Column(name = "all_balls_rear_caliper_bolt")
    private String allBallsRearCaliperBolt;

    @Column(name = "all_balls_rm_cr_rebuild_kit")
    private String allBallsRMCrRebuildKit;

    @Column(name = "ebc_brake_pads_rear_ref")
    private String ebcBrakePadsRearRef;

    @Column(name = "mgear_brake_pads_rear_neto")
    private String mgearBrakePadsRearNeto;

    @Column(name = "newfren_shoe_rear")
    private String newfrenShoeRear;

    @Column(name = "all_balls_rear_brake_pedal_kit")
    private String allBallsRearBrakePedalKit;

    @Column(name = "all_balls_csc_rebuild_kit")
    private String allBallsCSCRebuildKit;

    @Column(name = "front_jt_ref_front")
    private String frontJTRefFront;

    @Column(name = "esjot_ref_front")
    private String esjotRefFront;

    @Column(name = "mgear_ref_front")
    private String mgearRefFront;

    @Column(name = "mogema_ref_front")
    private String mogemaRefFront;

    @Column(name = "supersprox_ref_front")
    private String supersproxRefFront;

    @Column(name = "esjot_ref_rear")
    private String esjotRefRear;

    @Column(name = "jt_ref_rear")
    private String jtRefRear;

    @Column(name = "mgear_ref_rear")
    private String mgearRefRear;

    @Column(name = "mogema_ref_rear")
    private String mogemaRefRear;

    @Column(name = "supersprox_ref_rear")
    private String supersproxRefRear;

    @Column(name = "esjot_ref_front_conv")
    private String esjotRefFrontConv;

    @Column(name = "jt_sprocket_ref")
    private String jtSprocketRef;

    @Column(name = "mgear_ref_front_conv")
    private String mgearRefFrontConv;

    @Column(name = "mogemaref_front_conv")
    private String mogemarefFrontConv;

    @Column(name = "supersprox_ref_front_conv")
    private String supersproxRefFrontConv;

    @Column(name = "conversion_chain")
    private String conversionChain;

    @Column(name = "mgear_sprocket_rear_conv")
    private String mgearSprocketRearConv;

    @Column(name = "esjot_ref_rear_conv")
    private String esjotRefRearConv;

    @Column(name = "mgear_ref_rear_conv")
    private String mgearRefRearConv;

    @Column(name = "mogema_ref_rear_conv")
    private String mogemaRefRearConv;

    @Column(name = "supersprox_ref_rear_conv")
    private String supersproxRefRearConv;

    @Column(name = "all_balls_fw_bearing_kit_1")
    private String allBallsFWBearingKit1;

    @Column(name = "all_balls_fw_bearing_kit_2")
    private String allBallsFWBearingKit2;

    @Column(name = "all_balls_rw_bearing_kit_1")
    private String allBallsRWBearingKit1;

    @Column(name = "all_balls_rw_bearing_kit_2")
    private String allBallsRWBearingKit2;

    @Column(name = "all_balls_rw_bearing_upgrade")
    private String allBallsRWBearingUpgrade;

    @Column(name = "oem_spark_plug")
    private String oemSparkPlug;

    @Column(name = "oem_spark_plug_qty")
    private Long oemSparkPlugQTY;

    @Column(name = "ngk_spark_plug_sk_us")
    private String ngkSparkPlugSKUs;

    @Column(name = "oem_alternator")
    private String oemAlternator;

    @Column(name = "oem_voltage_regulator")
    private String oemVoltageRegulator;

    @Column(name = "arrowhead_alternator")
    private String arrowheadAlternator;

    @Column(name = "arrowhead_alternator_2")
    private String arrowheadAlternator2;

    @Column(name = "arrowhead_cdi_module")
    private String arrowheadCDIModule;

    @Column(name = "arrowhead_charging_coil")
    private String arrowheadChargingCoil;

    @Column(name = "arrowhead_ignition_coil")
    private String arrowheadIgnitionCoil;

    @Column(name = "arrowhead_stator_coil")
    private String arrowheadStatorCoil;

    @Column(name = "arrowhead_voltage_regulator")
    private String arrowheadVoltageRegulator;

    @Column(name = "arrowhead_power_shift_cm")
    private String arrowheadPowerShiftCM;

    @Column(name = "arrowhead_starter_drive")
    private String arrowheadStarterDrive;

    @Column(name = "arrowhead_starter_motor")
    private String arrowheadStarterMotor;

    @Column(name = "arrowhead_starter_relay")
    private String arrowheadStarterRelay;

    @Column(name = "oem_battery")
    private String oemBattery;

    @Column(name = "ssb_agm_battery")
    private String ssbAGMBattery;

    @Column(name = "oem_air_filter")
    private String oemAirFilter;

    @Column(name = "kn_air_filter")
    private String knAirFilter;

    @Column(name = "motorex_air_filter")
    private String motorexAirFilter;

    @Column(name = "motorex_air_filter_preoiled")
    private String motorexAirFilterPreoiled;

    @Column(name = "oem_oil_filter_1")
    private String oemOilFilter1;

    @Column(name = "kn_oil_filter_1")
    private String knOilFilter1;

    @Column(name = "oem_oil_filter_2")
    private String oemOilFilter2;

    @Column(name = "kn_oil_filter_2")
    private String knOilFilter2;

    @Column(name = "motion_pro_oil_filter_magnet")
    private String motionProOilFilterMagnet;

    @Column(name = "oem_steering_bearing")
    private String oemSteeringBearing;

    @Column(name = "oem_steering_seal")
    private String oemSteeringSeal;

    @Column(name = "all_balls_sb_seal_kit_1")
    private String allBallsSBSealKit1;

    @Column(name = "all_balls_sb_seal_kit_2")
    private String allBallsSBSealKit2;

    @Column(name = "all_balls_sb_seal_kit_lower")
    private String allBallsSBSealKitLower;

    @Column(name = "all_balls_sb_seal_kit_lower_2")
    private String allBallsSBSealKitLower2;

    @Column(name = "all_balls_cb_seal_kit")
    private String allBallsCBSealKit;

    @Column(name = "oem_fork_assembly_left")
    private String oemForkAssemblyLeft;

    @Column(name = "oem_fork_assembly_right")
    private String oemForkAssemblyRight;

    @Column(name = "oem_fork_seals")
    private String oemForkSeals;

    @Column(name = "all_balls_fork_seals")
    private String allBallsForkSeals;

    @Column(name = "xpr_fork_seals")
    private String xprForkSeals;

    @Column(name = "all_balls_fork_bushing_kit")
    private String allBallsForkBushingKit;

    @Column(name = "motion_pro_micro_fork_bleeder")
    private String motionProMicroForkBleeder;

    @Column(name = "motion_pro_cr_pro_thottle_kit")
    private String motionProCRProThottleKit;

    @Column(name = "oem_cable_speedo")
    private String oemCableSpeedo;

    @Column(name = "motion_pro_cable_speedo")
    private String motionProCableSpeedo;

    @Column(name = "motion_pro_cable_throttle_tube")
    private String motionProCableThrottleTube;

    @Column(name = "crosspro_radiator_guard")
    private String crossproRadiatorGuard;

    @Column(name = "oem_clutch_fibres")
    private String oemClutchFibres;

    @Column(name = "oem_clutch_fibres_steels")
    private String oemClutchFibresSteels;

    @Column(name = "newfren_clutch_kit")
    private String newfrenClutchKit;

    @Column(name = "newfren_clutch_spring_kits")
    private String newfrenClutchSpringKits;

    @Column(name = "all_balls_cmc_rebuilt_kit")
    private String allBallsCMCRebuiltKit;

    @Column(name = "wiseco_forged_clutch_basket")
    private String wisecoForgedClutchBasket;

    @Column(name = "wiseco_bottem_end_rebuild_kit")
    private String wisecoBottemEndRebuildKit;

    @Column(name = "wrench_re_rebuild_kit")
    private String wrenchRERebuildKit;

    @Column(name = "oem_carb_assembly")
    private String oemCarbAssembly;

    @Column(name = "all_balls_carb_repair_kit")
    private String allBallsCarbRepairKit;

    @Column(name = "all_balls_cr_mid_body_gasket_1")
    private String allBallsCRMidBodyGasket1;

    @Column(name = "all_balls_cr_mid_body_gasket_2")
    private String allBallsCRMidBodyGasket2;

    @Column(name = "all_balls_fuel_tap_repair_kit")
    private String allBallsFuelTapRepairKit;

    @Column(name = "all_balls_fuel_tap_repair_kit_2")
    private String allBallsFuelTapRepairKit2;

    @Column(name = "fuel_star_fuel_valve_kit")
    private String fuelStarFuelValveKit;

    @Column(name = "fuel_star_fuel_valve_kit_2")
    private String fuelStarFuelValveKit2;

    @Column(name = "fuel_star_hose_clamp_kit")
    private String fuelStarHoseClampKit;

    @Column(name = "rg_engine_cover_lhs")
    private String rgEngineCoverLHS;

    @Column(name = "rg_tail_tidy")
    private String rgTailTidy;

    @Column(name = "all_balls_lb_seal_kit")
    private String allBallsLBSealKit;

    @Column(name = "all_balls_lrs_bearing_kit")
    private String allBallsLRSBearingKit;

    @Column(name = "all_balls_urs_bearing_kit")
    private String allBallsURSBearingKit;

    @Column(name = "all_balls_uls_bearing_kit")
    private String allBallsULSBearingKit;

    @Column(name = "all_balls_sb_seal_kit")
    private String allBallsSBSealKit;

    @Column(name = "pivot_works_st_bearing_kit")
    private String pivotWorksSTBearingKit;

    @Column(name = "pivot_works_s_rebuild_kit")
    private String pivotWorksSRebuildKit;

    @Column(name = "mp_fork_seal_driver")
    private String mpForkSealDriver;

    @Column(name = "mp_valve_seal_install_tool")
    private String mpValveSealInstallTool;

    @Column(name = "winderosa_gasket_kit_top_end")
    private String winderosaGasketKitTopEnd;

    @Column(name = "winderosa_gasket_kit_oil_seals")
    private String winderosaGasketKitOilSeals;

    @Column(name = "oem_exhaust_gasket")
    private String oemExhaustGasket;

    @Column(name = "winderosa_gasket_exhaust")
    private String winderosaGasketExhaust;

    @Column(name = "winderosa_water_pump_rebuild_kit")
    private String winderosaWaterPumpRebuildKit;

    @Column(name = "hot_rods_connecting_rod_kit")
    private String hotRodsConnectingRodKit;

    @Column(name = "hot_rods_counter_bal_rebuild_kit")
    private String hotRodsCounterBalRebuildKit;

    @Column(name = "hot_rods_be_rebuild_kit")
    private String hotRodsBERebuildKit;

    @Column(name = "hot_rods_be_rebuild_kit_st")
    private String hotRodsBERebuildKitSt;

    @Column(name = "hot_rods_cylinder_head")
    private String hotRodsCylinderHead;

    @Column(name = "hot_rods_main_bearing_seal_kit")
    private String hotRodsMainBearingSealKit;

    @Column(name = "hot_rods_transmission_bearings")
    private String hotRodsTransmissionBearings;

    @Column(name = "hot_rods_wrist_pin_bearings")
    private String hotRodsWristPinBearings;

    @Column(name = "hot_rods_sohc_camshaft_stage_1")
    private String hotRodsSOHCCamshaftStage1;

    @Column(name = "hot_rods_sohc_camshaft_stage_2")
    private String hotRodsSOHCCamshaftStage2;

    @Column(name = "hot_rods_sohc_camshaft_stage_3")
    private String hotRodsSOHCCamshaftStage3;

    @Column(name = "hot_rods_dohc_camshaft_stage_1_intake")
    private String hotRodsDOHCCamshaftStage1Intake;

    @Column(name = "hot_rods_dohc_camshaft_stage_1_exhaust")
    private String hotRodsDOHCCamshaftStage1Exhaust;

    @Column(name = "hot_rods_dohc_camshaft_stage_2_intake")
    private String hotRodsDOHCCamshaftStage2Intake;

    @Column(name = "hot_rods_dohc_camshaft_stage_2_exhaust")
    private String hotRodsDOHCCamshaftStage2Exhaust;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "bike_bike_front_sprocket",
               joinColumns = @JoinColumn(name = "bikes_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "bike_front_sprockets_id", referencedColumnName = "id"))
    private Set<BikeFrontSprocket> bikeFrontSprockets = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "bike_bike_rear_sprocket",
               joinColumns = @JoinColumn(name = "bikes_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "bike_rear_sprockets_id", referencedColumnName = "id"))
    private Set<BikeRearSprocket> bikeRearSprockets = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "bike_rear_sprocket_conv",
               joinColumns = @JoinColumn(name = "bikes_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "rear_sprocket_convs_id", referencedColumnName = "id"))
    private Set<RearSprocketConv> rearSprocketConvs = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "bike_front_sprocket_conv",
               joinColumns = @JoinColumn(name = "bikes_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "front_sprocket_convs_id", referencedColumnName = "id"))
    private Set<FrontSprocketConv> frontSprocketConvs = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "bike_chain",
               joinColumns = @JoinColumn(name = "bikes_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "chains_id", referencedColumnName = "id"))
    private Set<Chain> chains = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "bike_bike_brake_pad",
               joinColumns = @JoinColumn(name = "bikes_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "bike_brake_pads_id", referencedColumnName = "id"))
    private Set<BikeBrakePad> bikeBrakePads = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "bike_bike_brake_disc",
               joinColumns = @JoinColumn(name = "bikes_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "bike_brake_discs_id", referencedColumnName = "id"))
    private Set<BikeBrakeDisc> bikeBrakeDiscs = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisibilityAU() {
        return visibilityAU;
    }

    public Bike visibilityAU(String visibilityAU) {
        this.visibilityAU = visibilityAU;
        return this;
    }

    public void setVisibilityAU(String visibilityAU) {
        this.visibilityAU = visibilityAU;
    }

    public String getVisibilityEU() {
        return visibilityEU;
    }

    public Bike visibilityEU(String visibilityEU) {
        this.visibilityEU = visibilityEU;
        return this;
    }

    public void setVisibilityEU(String visibilityEU) {
        this.visibilityEU = visibilityEU;
    }

    public String getInactive() {
        return inactive;
    }

    public Bike inactive(String inactive) {
        this.inactive = inactive;
        return this;
    }

    public void setInactive(String inactive) {
        this.inactive = inactive;
    }

    public String getOemconfirmed() {
        return oemconfirmed;
    }

    public Bike oemconfirmed(String oemconfirmed) {
        this.oemconfirmed = oemconfirmed;
        return this;
    }

    public void setOemconfirmed(String oemconfirmed) {
        this.oemconfirmed = oemconfirmed;
    }

    public String getOesource() {
        return oesource;
    }

    public Bike oesource(String oesource) {
        this.oesource = oesource;
        return this;
    }

    public void setOesource(String oesource) {
        this.oesource = oesource;
    }

    public Long getEpid() {
        return epid;
    }

    public Bike epid(Long epid) {
        this.epid = epid;
        return this;
    }

    public void setEpid(Long epid) {
        this.epid = epid;
    }

    public String getModeltype1() {
        return modeltype1;
    }

    public Bike modeltype1(String modeltype1) {
        this.modeltype1 = modeltype1;
        return this;
    }

    public void setModeltype1(String modeltype1) {
        this.modeltype1 = modeltype1;
    }

    public String getModeltype2() {
        return modeltype2;
    }

    public Bike modeltype2(String modeltype2) {
        this.modeltype2 = modeltype2;
        return this;
    }

    public void setModeltype2(String modeltype2) {
        this.modeltype2 = modeltype2;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Bike manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getStrokes() {
        return strokes;
    }

    public Bike strokes(String strokes) {
        this.strokes = strokes;
        return this;
    }

    public void setStrokes(String strokes) {
        this.strokes = strokes;
    }

    public Long getCapacity() {
        return capacity;
    }

    public Bike capacity(Long capacity) {
        this.capacity = capacity;
        return this;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getModelName() {
        return modelName;
    }

    public Bike modelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelYearCode() {
        return modelYearCode;
    }

    public Bike modelYearCode(String modelYearCode) {
        this.modelYearCode = modelYearCode;
        return this;
    }

    public void setModelYearCode(String modelYearCode) {
        this.modelYearCode = modelYearCode;
    }

    public String getModelTypeCode() {
        return modelTypeCode;
    }

    public Bike modelTypeCode(String modelTypeCode) {
        this.modelTypeCode = modelTypeCode;
        return this;
    }

    public void setModelTypeCode(String modelTypeCode) {
        this.modelTypeCode = modelTypeCode;
    }

    public Long getYear() {
        return year;
    }

    public Bike year(Long year) {
        this.year = year;
        return this;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getFinalDriveType() {
        return finalDriveType;
    }

    public Bike finalDriveType(String finalDriveType) {
        this.finalDriveType = finalDriveType;
        return this;
    }

    public void setFinalDriveType(String finalDriveType) {
        this.finalDriveType = finalDriveType;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public Bike categoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
        return this;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getModelNotes() {
        return modelNotes;
    }

    public Bike modelNotes(String modelNotes) {
        this.modelNotes = modelNotes;
        return this;
    }

    public void setModelNotes(String modelNotes) {
        this.modelNotes = modelNotes;
    }

    public String getModelNotes2() {
        return modelNotes2;
    }

    public Bike modelNotes2(String modelNotes2) {
        this.modelNotes2 = modelNotes2;
        return this;
    }

    public void setModelNotes2(String modelNotes2) {
        this.modelNotes2 = modelNotes2;
    }

    public String getModelNotes3() {
        return modelNotes3;
    }

    public Bike modelNotes3(String modelNotes3) {
        this.modelNotes3 = modelNotes3;
        return this;
    }

    public void setModelNotes3(String modelNotes3) {
        this.modelNotes3 = modelNotes3;
    }

    public String getModelNotes4() {
        return modelNotes4;
    }

    public Bike modelNotes4(String modelNotes4) {
        this.modelNotes4 = modelNotes4;
        return this;
    }

    public void setModelNotes4(String modelNotes4) {
        this.modelNotes4 = modelNotes4;
    }

    public String getModelInfoHTML() {
        return modelInfoHTML;
    }

    public Bike modelInfoHTML(String modelInfoHTML) {
        this.modelInfoHTML = modelInfoHTML;
        return this;
    }

    public void setModelInfoHTML(String modelInfoHTML) {
        this.modelInfoHTML = modelInfoHTML;
    }

    public String getOemFrontBrakeSystemType() {
        return oemFrontBrakeSystemType;
    }

    public Bike oemFrontBrakeSystemType(String oemFrontBrakeSystemType) {
        this.oemFrontBrakeSystemType = oemFrontBrakeSystemType;
        return this;
    }

    public void setOemFrontBrakeSystemType(String oemFrontBrakeSystemType) {
        this.oemFrontBrakeSystemType = oemFrontBrakeSystemType;
    }

    public String getOemFrontBrakeDiscLeft() {
        return oemFrontBrakeDiscLeft;
    }

    public Bike oemFrontBrakeDiscLeft(String oemFrontBrakeDiscLeft) {
        this.oemFrontBrakeDiscLeft = oemFrontBrakeDiscLeft;
        return this;
    }

    public void setOemFrontBrakeDiscLeft(String oemFrontBrakeDiscLeft) {
        this.oemFrontBrakeDiscLeft = oemFrontBrakeDiscLeft;
    }

    public String getOemFrontBrakeDiscRight() {
        return oemFrontBrakeDiscRight;
    }

    public Bike oemFrontBrakeDiscRight(String oemFrontBrakeDiscRight) {
        this.oemFrontBrakeDiscRight = oemFrontBrakeDiscRight;
        return this;
    }

    public void setOemFrontBrakeDiscRight(String oemFrontBrakeDiscRight) {
        this.oemFrontBrakeDiscRight = oemFrontBrakeDiscRight;
    }

    public String getOemFrontBrakeDiscBolts() {
        return oemFrontBrakeDiscBolts;
    }

    public Bike oemFrontBrakeDiscBolts(String oemFrontBrakeDiscBolts) {
        this.oemFrontBrakeDiscBolts = oemFrontBrakeDiscBolts;
        return this;
    }

    public void setOemFrontBrakeDiscBolts(String oemFrontBrakeDiscBolts) {
        this.oemFrontBrakeDiscBolts = oemFrontBrakeDiscBolts;
    }

    public Long getOemFrontBDQTYPD() {
        return oemFrontBDQTYPD;
    }

    public Bike oemFrontBDQTYPD(Long oemFrontBDQTYPD) {
        this.oemFrontBDQTYPD = oemFrontBDQTYPD;
        return this;
    }

    public void setOemFrontBDQTYPD(Long oemFrontBDQTYPD) {
        this.oemFrontBDQTYPD = oemFrontBDQTYPD;
    }

    public String getOemFrontBrakeDiscABSRing() {
        return oemFrontBrakeDiscABSRing;
    }

    public Bike oemFrontBrakeDiscABSRing(String oemFrontBrakeDiscABSRing) {
        this.oemFrontBrakeDiscABSRing = oemFrontBrakeDiscABSRing;
        return this;
    }

    public void setOemFrontBrakeDiscABSRing(String oemFrontBrakeDiscABSRing) {
        this.oemFrontBrakeDiscABSRing = oemFrontBrakeDiscABSRing;
    }

    public String getOemFrontBrakeCaliper1() {
        return oemFrontBrakeCaliper1;
    }

    public Bike oemFrontBrakeCaliper1(String oemFrontBrakeCaliper1) {
        this.oemFrontBrakeCaliper1 = oemFrontBrakeCaliper1;
        return this;
    }

    public void setOemFrontBrakeCaliper1(String oemFrontBrakeCaliper1) {
        this.oemFrontBrakeCaliper1 = oemFrontBrakeCaliper1;
    }

    public String getOemFrontBrakeCaliper2() {
        return oemFrontBrakeCaliper2;
    }

    public Bike oemFrontBrakeCaliper2(String oemFrontBrakeCaliper2) {
        this.oemFrontBrakeCaliper2 = oemFrontBrakeCaliper2;
        return this;
    }

    public void setOemFrontBrakeCaliper2(String oemFrontBrakeCaliper2) {
        this.oemFrontBrakeCaliper2 = oemFrontBrakeCaliper2;
    }

    public String getOemFrontBrakeCaliperPin() {
        return oemFrontBrakeCaliperPin;
    }

    public Bike oemFrontBrakeCaliperPin(String oemFrontBrakeCaliperPin) {
        this.oemFrontBrakeCaliperPin = oemFrontBrakeCaliperPin;
        return this;
    }

    public void setOemFrontBrakeCaliperPin(String oemFrontBrakeCaliperPin) {
        this.oemFrontBrakeCaliperPin = oemFrontBrakeCaliperPin;
    }

    public String getOemFrontBrakePadsFrontL() {
        return oemFrontBrakePadsFrontL;
    }

    public Bike oemFrontBrakePadsFrontL(String oemFrontBrakePadsFrontL) {
        this.oemFrontBrakePadsFrontL = oemFrontBrakePadsFrontL;
        return this;
    }

    public void setOemFrontBrakePadsFrontL(String oemFrontBrakePadsFrontL) {
        this.oemFrontBrakePadsFrontL = oemFrontBrakePadsFrontL;
    }

    public String getOemFrontBrakePadsFrontR() {
        return oemFrontBrakePadsFrontR;
    }

    public Bike oemFrontBrakePadsFrontR(String oemFrontBrakePadsFrontR) {
        this.oemFrontBrakePadsFrontR = oemFrontBrakePadsFrontR;
        return this;
    }

    public void setOemFrontBrakePadsFrontR(String oemFrontBrakePadsFrontR) {
        this.oemFrontBrakePadsFrontR = oemFrontBrakePadsFrontR;
    }

    public String getOemFrontShoe() {
        return oemFrontShoe;
    }

    public Bike oemFrontShoe(String oemFrontShoe) {
        this.oemFrontShoe = oemFrontShoe;
        return this;
    }

    public void setOemFrontShoe(String oemFrontShoe) {
        this.oemFrontShoe = oemFrontShoe;
    }

    public String getOemMidldleAxleBrakeDisc() {
        return oemMidldleAxleBrakeDisc;
    }

    public Bike oemMidldleAxleBrakeDisc(String oemMidldleAxleBrakeDisc) {
        this.oemMidldleAxleBrakeDisc = oemMidldleAxleBrakeDisc;
        return this;
    }

    public void setOemMidldleAxleBrakeDisc(String oemMidldleAxleBrakeDisc) {
        this.oemMidldleAxleBrakeDisc = oemMidldleAxleBrakeDisc;
    }

    public String getOemMiddleAxleBrakePads() {
        return oemMiddleAxleBrakePads;
    }

    public Bike oemMiddleAxleBrakePads(String oemMiddleAxleBrakePads) {
        this.oemMiddleAxleBrakePads = oemMiddleAxleBrakePads;
        return this;
    }

    public void setOemMiddleAxleBrakePads(String oemMiddleAxleBrakePads) {
        this.oemMiddleAxleBrakePads = oemMiddleAxleBrakePads;
    }

    public String getOemRearBrakeSystemType() {
        return oemRearBrakeSystemType;
    }

    public Bike oemRearBrakeSystemType(String oemRearBrakeSystemType) {
        this.oemRearBrakeSystemType = oemRearBrakeSystemType;
        return this;
    }

    public void setOemRearBrakeSystemType(String oemRearBrakeSystemType) {
        this.oemRearBrakeSystemType = oemRearBrakeSystemType;
    }

    public String getOeamRearBrakeDisc() {
        return oeamRearBrakeDisc;
    }

    public Bike oeamRearBrakeDisc(String oeamRearBrakeDisc) {
        this.oeamRearBrakeDisc = oeamRearBrakeDisc;
        return this;
    }

    public void setOeamRearBrakeDisc(String oeamRearBrakeDisc) {
        this.oeamRearBrakeDisc = oeamRearBrakeDisc;
    }

    public String getOeamRearBrakeDiscBolts() {
        return oeamRearBrakeDiscBolts;
    }

    public Bike oeamRearBrakeDiscBolts(String oeamRearBrakeDiscBolts) {
        this.oeamRearBrakeDiscBolts = oeamRearBrakeDiscBolts;
        return this;
    }

    public void setOeamRearBrakeDiscBolts(String oeamRearBrakeDiscBolts) {
        this.oeamRearBrakeDiscBolts = oeamRearBrakeDiscBolts;
    }

    public Long getOeamRearBrakeDiscBQTYPD() {
        return oeamRearBrakeDiscBQTYPD;
    }

    public Bike oeamRearBrakeDiscBQTYPD(Long oeamRearBrakeDiscBQTYPD) {
        this.oeamRearBrakeDiscBQTYPD = oeamRearBrakeDiscBQTYPD;
        return this;
    }

    public void setOeamRearBrakeDiscBQTYPD(Long oeamRearBrakeDiscBQTYPD) {
        this.oeamRearBrakeDiscBQTYPD = oeamRearBrakeDiscBQTYPD;
    }

    public String getOemRearBrakeCaliper() {
        return oemRearBrakeCaliper;
    }

    public Bike oemRearBrakeCaliper(String oemRearBrakeCaliper) {
        this.oemRearBrakeCaliper = oemRearBrakeCaliper;
        return this;
    }

    public void setOemRearBrakeCaliper(String oemRearBrakeCaliper) {
        this.oemRearBrakeCaliper = oemRearBrakeCaliper;
    }

    public String getOemRearBrakeCaliperPin() {
        return oemRearBrakeCaliperPin;
    }

    public Bike oemRearBrakeCaliperPin(String oemRearBrakeCaliperPin) {
        this.oemRearBrakeCaliperPin = oemRearBrakeCaliperPin;
        return this;
    }

    public void setOemRearBrakeCaliperPin(String oemRearBrakeCaliperPin) {
        this.oemRearBrakeCaliperPin = oemRearBrakeCaliperPin;
    }

    public String getOemRearBrakePads1() {
        return oemRearBrakePads1;
    }

    public Bike oemRearBrakePads1(String oemRearBrakePads1) {
        this.oemRearBrakePads1 = oemRearBrakePads1;
        return this;
    }

    public void setOemRearBrakePads1(String oemRearBrakePads1) {
        this.oemRearBrakePads1 = oemRearBrakePads1;
    }

    public String getOemRearBrakePads2() {
        return oemRearBrakePads2;
    }

    public Bike oemRearBrakePads2(String oemRearBrakePads2) {
        this.oemRearBrakePads2 = oemRearBrakePads2;
        return this;
    }

    public void setOemRearBrakePads2(String oemRearBrakePads2) {
        this.oemRearBrakePads2 = oemRearBrakePads2;
    }

    public String getOemShoeRear() {
        return oemShoeRear;
    }

    public Bike oemShoeRear(String oemShoeRear) {
        this.oemShoeRear = oemShoeRear;
        return this;
    }

    public void setOemShoeRear(String oemShoeRear) {
        this.oemShoeRear = oemShoeRear;
    }

    public String getOemShoeRear2() {
        return oemShoeRear2;
    }

    public Bike oemShoeRear2(String oemShoeRear2) {
        this.oemShoeRear2 = oemShoeRear2;
        return this;
    }

    public void setOemShoeRear2(String oemShoeRear2) {
        this.oemShoeRear2 = oemShoeRear2;
    }

    public String getOemSlaveCylinder() {
        return oemSlaveCylinder;
    }

    public Bike oemSlaveCylinder(String oemSlaveCylinder) {
        this.oemSlaveCylinder = oemSlaveCylinder;
        return this;
    }

    public void setOemSlaveCylinder(String oemSlaveCylinder) {
        this.oemSlaveCylinder = oemSlaveCylinder;
    }

    public String getOemChainNo() {
        return oemChainNo;
    }

    public Bike oemChainNo(String oemChainNo) {
        this.oemChainNo = oemChainNo;
        return this;
    }

    public void setOemChainNo(String oemChainNo) {
        this.oemChainNo = oemChainNo;
    }

    public BigDecimal getOemChainSize() {
        return oemChainSize;
    }

    public Bike oemChainSize(BigDecimal oemChainSize) {
        this.oemChainSize = oemChainSize;
        return this;
    }

    public void setOemChainSize(BigDecimal oemChainSize) {
        this.oemChainSize = oemChainSize;
    }

    public BigDecimal getOemChainLinks() {
        return oemChainLinks;
    }

    public Bike oemChainLinks(BigDecimal oemChainLinks) {
        this.oemChainLinks = oemChainLinks;
        return this;
    }

    public void setOemChainLinks(BigDecimal oemChainLinks) {
        this.oemChainLinks = oemChainLinks;
    }

    public String getOemFrontSprocket() {
        return oemFrontSprocket;
    }

    public Bike oemFrontSprocket(String oemFrontSprocket) {
        this.oemFrontSprocket = oemFrontSprocket;
        return this;
    }

    public void setOemFrontSprocket(String oemFrontSprocket) {
        this.oemFrontSprocket = oemFrontSprocket;
    }

    public Long getOemFrontGearing() {
        return oemFrontGearing;
    }

    public Bike oemFrontGearing(Long oemFrontGearing) {
        this.oemFrontGearing = oemFrontGearing;
        return this;
    }

    public void setOemFrontGearing(Long oemFrontGearing) {
        this.oemFrontGearing = oemFrontGearing;
    }

    public BigDecimal getOemFrontGearingMin() {
        return oemFrontGearingMin;
    }

    public Bike oemFrontGearingMin(BigDecimal oemFrontGearingMin) {
        this.oemFrontGearingMin = oemFrontGearingMin;
        return this;
    }

    public void setOemFrontGearingMin(BigDecimal oemFrontGearingMin) {
        this.oemFrontGearingMin = oemFrontGearingMin;
    }

    public BigDecimal getOemFrontGearingMax() {
        return oemFrontGearingMax;
    }

    public Bike oemFrontGearingMax(BigDecimal oemFrontGearingMax) {
        this.oemFrontGearingMax = oemFrontGearingMax;
        return this;
    }

    public void setOemFrontGearingMax(BigDecimal oemFrontGearingMax) {
        this.oemFrontGearingMax = oemFrontGearingMax;
    }

    public String getOemRearSprocket() {
        return oemRearSprocket;
    }

    public Bike oemRearSprocket(String oemRearSprocket) {
        this.oemRearSprocket = oemRearSprocket;
        return this;
    }

    public void setOemRearSprocket(String oemRearSprocket) {
        this.oemRearSprocket = oemRearSprocket;
    }

    public BigDecimal getOemRearGearing() {
        return oemRearGearing;
    }

    public Bike oemRearGearing(BigDecimal oemRearGearing) {
        this.oemRearGearing = oemRearGearing;
        return this;
    }

    public void setOemRearGearing(BigDecimal oemRearGearing) {
        this.oemRearGearing = oemRearGearing;
    }

    public BigDecimal getOemRearGearingMin() {
        return oemRearGearingMin;
    }

    public Bike oemRearGearingMin(BigDecimal oemRearGearingMin) {
        this.oemRearGearingMin = oemRearGearingMin;
        return this;
    }

    public void setOemRearGearingMin(BigDecimal oemRearGearingMin) {
        this.oemRearGearingMin = oemRearGearingMin;
    }

    public BigDecimal getOemRearGearingMax() {
        return oemRearGearingMax;
    }

    public Bike oemRearGearingMax(BigDecimal oemRearGearingMax) {
        this.oemRearGearingMax = oemRearGearingMax;
        return this;
    }

    public void setOemRearGearingMax(BigDecimal oemRearGearingMax) {
        this.oemRearGearingMax = oemRearGearingMax;
    }

    public String getFinalDriveNotes() {
        return finalDriveNotes;
    }

    public Bike finalDriveNotes(String finalDriveNotes) {
        this.finalDriveNotes = finalDriveNotes;
        return this;
    }

    public void setFinalDriveNotes(String finalDriveNotes) {
        this.finalDriveNotes = finalDriveNotes;
    }

    public BigDecimal getChainConvSize() {
        return chainConvSize;
    }

    public Bike chainConvSize(BigDecimal chainConvSize) {
        this.chainConvSize = chainConvSize;
        return this;
    }

    public void setChainConvSize(BigDecimal chainConvSize) {
        this.chainConvSize = chainConvSize;
    }

    public BigDecimal getChainConvLinks() {
        return chainConvLinks;
    }

    public Bike chainConvLinks(BigDecimal chainConvLinks) {
        this.chainConvLinks = chainConvLinks;
        return this;
    }

    public void setChainConvLinks(BigDecimal chainConvLinks) {
        this.chainConvLinks = chainConvLinks;
    }

    public String getOemFrontWheel() {
        return oemFrontWheel;
    }

    public Bike oemFrontWheel(String oemFrontWheel) {
        this.oemFrontWheel = oemFrontWheel;
        return this;
    }

    public void setOemFrontWheel(String oemFrontWheel) {
        this.oemFrontWheel = oemFrontWheel;
    }

    public String getOemFrontWheelType() {
        return oemFrontWheelType;
    }

    public Bike oemFrontWheelType(String oemFrontWheelType) {
        this.oemFrontWheelType = oemFrontWheelType;
        return this;
    }

    public void setOemFrontWheelType(String oemFrontWheelType) {
        this.oemFrontWheelType = oemFrontWheelType;
    }

    public BigDecimal getOemFrontWheelFront() {
        return oemFrontWheelFront;
    }

    public Bike oemFrontWheelFront(BigDecimal oemFrontWheelFront) {
        this.oemFrontWheelFront = oemFrontWheelFront;
        return this;
    }

    public void setOemFrontWheelFront(BigDecimal oemFrontWheelFront) {
        this.oemFrontWheelFront = oemFrontWheelFront;
    }

    public String getOemFrontWheelTyreSize() {
        return oemFrontWheelTyreSize;
    }

    public Bike oemFrontWheelTyreSize(String oemFrontWheelTyreSize) {
        this.oemFrontWheelTyreSize = oemFrontWheelTyreSize;
        return this;
    }

    public void setOemFrontWheelTyreSize(String oemFrontWheelTyreSize) {
        this.oemFrontWheelTyreSize = oemFrontWheelTyreSize;
    }

    public String getOemFrontHub() {
        return oemFrontHub;
    }

    public Bike oemFrontHub(String oemFrontHub) {
        this.oemFrontHub = oemFrontHub;
        return this;
    }

    public void setOemFrontHub(String oemFrontHub) {
        this.oemFrontHub = oemFrontHub;
    }

    public String getOemFrontWheelbearing1() {
        return oemFrontWheelbearing1;
    }

    public Bike oemFrontWheelbearing1(String oemFrontWheelbearing1) {
        this.oemFrontWheelbearing1 = oemFrontWheelbearing1;
        return this;
    }

    public void setOemFrontWheelbearing1(String oemFrontWheelbearing1) {
        this.oemFrontWheelbearing1 = oemFrontWheelbearing1;
    }

    public String getOemFrontWheelbearing2() {
        return oemFrontWheelbearing2;
    }

    public Bike oemFrontWheelbearing2(String oemFrontWheelbearing2) {
        this.oemFrontWheelbearing2 = oemFrontWheelbearing2;
        return this;
    }

    public void setOemFrontWheelbearing2(String oemFrontWheelbearing2) {
        this.oemFrontWheelbearing2 = oemFrontWheelbearing2;
    }

    public String getOemFrontWheelSeal() {
        return oemFrontWheelSeal;
    }

    public Bike oemFrontWheelSeal(String oemFrontWheelSeal) {
        this.oemFrontWheelSeal = oemFrontWheelSeal;
        return this;
    }

    public void setOemFrontWheelSeal(String oemFrontWheelSeal) {
        this.oemFrontWheelSeal = oemFrontWheelSeal;
    }

    public String getOemRearWheel() {
        return oemRearWheel;
    }

    public Bike oemRearWheel(String oemRearWheel) {
        this.oemRearWheel = oemRearWheel;
        return this;
    }

    public void setOemRearWheel(String oemRearWheel) {
        this.oemRearWheel = oemRearWheel;
    }

    public BigDecimal getOemRearWheelSize() {
        return oemRearWheelSize;
    }

    public Bike oemRearWheelSize(BigDecimal oemRearWheelSize) {
        this.oemRearWheelSize = oemRearWheelSize;
        return this;
    }

    public void setOemRearWheelSize(BigDecimal oemRearWheelSize) {
        this.oemRearWheelSize = oemRearWheelSize;
    }

    public String getOemRearWheelTyre() {
        return oemRearWheelTyre;
    }

    public Bike oemRearWheelTyre(String oemRearWheelTyre) {
        this.oemRearWheelTyre = oemRearWheelTyre;
        return this;
    }

    public void setOemRearWheelTyre(String oemRearWheelTyre) {
        this.oemRearWheelTyre = oemRearWheelTyre;
    }

    public String getOemRearWheelBearing1() {
        return oemRearWheelBearing1;
    }

    public Bike oemRearWheelBearing1(String oemRearWheelBearing1) {
        this.oemRearWheelBearing1 = oemRearWheelBearing1;
        return this;
    }

    public void setOemRearWheelBearing1(String oemRearWheelBearing1) {
        this.oemRearWheelBearing1 = oemRearWheelBearing1;
    }

    public String getOemRearWheelBearing2() {
        return oemRearWheelBearing2;
    }

    public Bike oemRearWheelBearing2(String oemRearWheelBearing2) {
        this.oemRearWheelBearing2 = oemRearWheelBearing2;
        return this;
    }

    public void setOemRearWheelBearing2(String oemRearWheelBearing2) {
        this.oemRearWheelBearing2 = oemRearWheelBearing2;
    }

    public String getOemRearWheelSeal() {
        return oemRearWheelSeal;
    }

    public Bike oemRearWheelSeal(String oemRearWheelSeal) {
        this.oemRearWheelSeal = oemRearWheelSeal;
        return this;
    }

    public void setOemRearWheelSeal(String oemRearWheelSeal) {
        this.oemRearWheelSeal = oemRearWheelSeal;
    }

    public String getFrontPadsDiffCaliper() {
        return frontPadsDiffCaliper;
    }

    public Bike frontPadsDiffCaliper(String frontPadsDiffCaliper) {
        this.frontPadsDiffCaliper = frontPadsDiffCaliper;
        return this;
    }

    public void setFrontPadsDiffCaliper(String frontPadsDiffCaliper) {
        this.frontPadsDiffCaliper = frontPadsDiffCaliper;
    }

    public Long getQtyBH() {
        return qtyBH;
    }

    public Bike qtyBH(Long qtyBH) {
        this.qtyBH = qtyBH;
        return this;
    }

    public void setQtyBH(Long qtyBH) {
        this.qtyBH = qtyBH;
    }

    public String getHandbrakeParking() {
        return handbrakeParking;
    }

    public Bike handbrakeParking(String handbrakeParking) {
        this.handbrakeParking = handbrakeParking;
        return this;
    }

    public void setHandbrakeParking(String handbrakeParking) {
        this.handbrakeParking = handbrakeParking;
    }

    public String getAddNotesToBike() {
        return addNotesToBike;
    }

    public Bike addNotesToBike(String addNotesToBike) {
        this.addNotesToBike = addNotesToBike;
        return this;
    }

    public void setAddNotesToBike(String addNotesToBike) {
        this.addNotesToBike = addNotesToBike;
    }

    public String getDateAndID() {
        return dateAndID;
    }

    public Bike dateAndID(String dateAndID) {
        this.dateAndID = dateAndID;
        return this;
    }

    public void setDateAndID(String dateAndID) {
        this.dateAndID = dateAndID;
    }

    public String getSource() {
        return source;
    }

    public Bike source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTuvRequired() {
        return tuvRequired;
    }

    public Bike tuvRequired(String tuvRequired) {
        this.tuvRequired = tuvRequired;
        return this;
    }

    public void setTuvRequired(String tuvRequired) {
        this.tuvRequired = tuvRequired;
    }

    public String getTuvTypeCode() {
        return tuvTypeCode;
    }

    public Bike tuvTypeCode(String tuvTypeCode) {
        this.tuvTypeCode = tuvTypeCode;
        return this;
    }

    public void setTuvTypeCode(String tuvTypeCode) {
        this.tuvTypeCode = tuvTypeCode;
    }

    public String getAbekba() {
        return abekba;
    }

    public Bike abekba(String abekba) {
        this.abekba = abekba;
        return this;
    }

    public void setAbekba(String abekba) {
        this.abekba = abekba;
    }

    public String getTuvFrontDisc() {
        return tuvFrontDisc;
    }

    public Bike tuvFrontDisc(String tuvFrontDisc) {
        this.tuvFrontDisc = tuvFrontDisc;
        return this;
    }

    public void setTuvFrontDisc(String tuvFrontDisc) {
        this.tuvFrontDisc = tuvFrontDisc;
    }

    public String getTuvRearDisc() {
        return tuvRearDisc;
    }

    public Bike tuvRearDisc(String tuvRearDisc) {
        this.tuvRearDisc = tuvRearDisc;
        return this;
    }

    public void setTuvRearDisc(String tuvRearDisc) {
        this.tuvRearDisc = tuvRearDisc;
    }

    public String getBremboBrakeDiscFrontRef() {
        return bremboBrakeDiscFrontRef;
    }

    public Bike bremboBrakeDiscFrontRef(String bremboBrakeDiscFrontRef) {
        this.bremboBrakeDiscFrontRef = bremboBrakeDiscFrontRef;
        return this;
    }

    public void setBremboBrakeDiscFrontRef(String bremboBrakeDiscFrontRef) {
        this.bremboBrakeDiscFrontRef = bremboBrakeDiscFrontRef;
    }

    public String getEbcBrakeDiscFrontRef() {
        return ebcBrakeDiscFrontRef;
    }

    public Bike ebcBrakeDiscFrontRef(String ebcBrakeDiscFrontRef) {
        this.ebcBrakeDiscFrontRef = ebcBrakeDiscFrontRef;
        return this;
    }

    public void setEbcBrakeDiscFrontRef(String ebcBrakeDiscFrontRef) {
        this.ebcBrakeDiscFrontRef = ebcBrakeDiscFrontRef;
    }

    public String getTrwBrakeDiscFrontRef() {
        return trwBrakeDiscFrontRef;
    }

    public Bike trwBrakeDiscFrontRef(String trwBrakeDiscFrontRef) {
        this.trwBrakeDiscFrontRef = trwBrakeDiscFrontRef;
        return this;
    }

    public void setTrwBrakeDiscFrontRef(String trwBrakeDiscFrontRef) {
        this.trwBrakeDiscFrontRef = trwBrakeDiscFrontRef;
    }

    public String getMgearBrakeDiscFrontLeftRef() {
        return mgearBrakeDiscFrontLeftRef;
    }

    public Bike mgearBrakeDiscFrontLeftRef(String mgearBrakeDiscFrontLeftRef) {
        this.mgearBrakeDiscFrontLeftRef = mgearBrakeDiscFrontLeftRef;
        return this;
    }

    public void setMgearBrakeDiscFrontLeftRef(String mgearBrakeDiscFrontLeftRef) {
        this.mgearBrakeDiscFrontLeftRef = mgearBrakeDiscFrontLeftRef;
    }

    public String getMgearBrakeDiscFrontRightRef() {
        return mgearBrakeDiscFrontRightRef;
    }

    public Bike mgearBrakeDiscFrontRightRef(String mgearBrakeDiscFrontRightRef) {
        this.mgearBrakeDiscFrontRightRef = mgearBrakeDiscFrontRightRef;
        return this;
    }

    public void setMgearBrakeDiscFrontRightRef(String mgearBrakeDiscFrontRightRef) {
        this.mgearBrakeDiscFrontRightRef = mgearBrakeDiscFrontRightRef;
    }

    public String getMgearBrakeDiscFrontCheck() {
        return mgearBrakeDiscFrontCheck;
    }

    public Bike mgearBrakeDiscFrontCheck(String mgearBrakeDiscFrontCheck) {
        this.mgearBrakeDiscFrontCheck = mgearBrakeDiscFrontCheck;
        return this;
    }

    public void setMgearBrakeDiscFrontCheck(String mgearBrakeDiscFrontCheck) {
        this.mgearBrakeDiscFrontCheck = mgearBrakeDiscFrontCheck;
    }

    public String getMgearBrakeDiscFrontLeftRef2() {
        return mgearBrakeDiscFrontLeftRef2;
    }

    public Bike mgearBrakeDiscFrontLeftRef2(String mgearBrakeDiscFrontLeftRef2) {
        this.mgearBrakeDiscFrontLeftRef2 = mgearBrakeDiscFrontLeftRef2;
        return this;
    }

    public void setMgearBrakeDiscFrontLeftRef2(String mgearBrakeDiscFrontLeftRef2) {
        this.mgearBrakeDiscFrontLeftRef2 = mgearBrakeDiscFrontLeftRef2;
    }

    public String getMgearBrakeDiscFrontRightRef2() {
        return mgearBrakeDiscFrontRightRef2;
    }

    public Bike mgearBrakeDiscFrontRightRef2(String mgearBrakeDiscFrontRightRef2) {
        this.mgearBrakeDiscFrontRightRef2 = mgearBrakeDiscFrontRightRef2;
        return this;
    }

    public void setMgearBrakeDiscFrontRightRef2(String mgearBrakeDiscFrontRightRef2) {
        this.mgearBrakeDiscFrontRightRef2 = mgearBrakeDiscFrontRightRef2;
    }

    public String getMgearBrakeDiscFNeto() {
        return mgearBrakeDiscFNeto;
    }

    public Bike mgearBrakeDiscFNeto(String mgearBrakeDiscFNeto) {
        this.mgearBrakeDiscFNeto = mgearBrakeDiscFNeto;
        return this;
    }

    public void setMgearBrakeDiscFNeto(String mgearBrakeDiscFNeto) {
        this.mgearBrakeDiscFNeto = mgearBrakeDiscFNeto;
    }

    public String getMotodiscBrakeDiscFNeto() {
        return motodiscBrakeDiscFNeto;
    }

    public Bike motodiscBrakeDiscFNeto(String motodiscBrakeDiscFNeto) {
        this.motodiscBrakeDiscFNeto = motodiscBrakeDiscFNeto;
        return this;
    }

    public void setMotodiscBrakeDiscFNeto(String motodiscBrakeDiscFNeto) {
        this.motodiscBrakeDiscFNeto = motodiscBrakeDiscFNeto;
    }

    public String getEbcBrakePadsFrontLRef() {
        return ebcBrakePadsFrontLRef;
    }

    public Bike ebcBrakePadsFrontLRef(String ebcBrakePadsFrontLRef) {
        this.ebcBrakePadsFrontLRef = ebcBrakePadsFrontLRef;
        return this;
    }

    public void setEbcBrakePadsFrontLRef(String ebcBrakePadsFrontLRef) {
        this.ebcBrakePadsFrontLRef = ebcBrakePadsFrontLRef;
    }

    public String getEbcBrakePadsFrontRRef() {
        return ebcBrakePadsFrontRRef;
    }

    public Bike ebcBrakePadsFrontRRef(String ebcBrakePadsFrontRRef) {
        this.ebcBrakePadsFrontRRef = ebcBrakePadsFrontRRef;
        return this;
    }

    public void setEbcBrakePadsFrontRRef(String ebcBrakePadsFrontRRef) {
        this.ebcBrakePadsFrontRRef = ebcBrakePadsFrontRRef;
    }

    public String getMgearBrakePadsFrontLRef() {
        return mgearBrakePadsFrontLRef;
    }

    public Bike mgearBrakePadsFrontLRef(String mgearBrakePadsFrontLRef) {
        this.mgearBrakePadsFrontLRef = mgearBrakePadsFrontLRef;
        return this;
    }

    public void setMgearBrakePadsFrontLRef(String mgearBrakePadsFrontLRef) {
        this.mgearBrakePadsFrontLRef = mgearBrakePadsFrontLRef;
    }

    public String getMgearBrakePadsFrontRRef() {
        return mgearBrakePadsFrontRRef;
    }

    public Bike mgearBrakePadsFrontRRef(String mgearBrakePadsFrontRRef) {
        this.mgearBrakePadsFrontRRef = mgearBrakePadsFrontRRef;
        return this;
    }

    public void setMgearBrakePadsFrontRRef(String mgearBrakePadsFrontRRef) {
        this.mgearBrakePadsFrontRRef = mgearBrakePadsFrontRRef;
    }

    public String getMgearBrakePadsFNeto() {
        return mgearBrakePadsFNeto;
    }

    public Bike mgearBrakePadsFNeto(String mgearBrakePadsFNeto) {
        this.mgearBrakePadsFNeto = mgearBrakePadsFNeto;
        return this;
    }

    public void setMgearBrakePadsFNeto(String mgearBrakePadsFNeto) {
        this.mgearBrakePadsFNeto = mgearBrakePadsFNeto;
    }

    public String getMotoPadBrakePadsFrontLRef() {
        return motoPadBrakePadsFrontLRef;
    }

    public Bike motoPadBrakePadsFrontLRef(String motoPadBrakePadsFrontLRef) {
        this.motoPadBrakePadsFrontLRef = motoPadBrakePadsFrontLRef;
        return this;
    }

    public void setMotoPadBrakePadsFrontLRef(String motoPadBrakePadsFrontLRef) {
        this.motoPadBrakePadsFrontLRef = motoPadBrakePadsFrontLRef;
    }

    public String getMotoPadBrakePadsFrontRRef() {
        return motoPadBrakePadsFrontRRef;
    }

    public Bike motoPadBrakePadsFrontRRef(String motoPadBrakePadsFrontRRef) {
        this.motoPadBrakePadsFrontRRef = motoPadBrakePadsFrontRRef;
        return this;
    }

    public void setMotoPadBrakePadsFrontRRef(String motoPadBrakePadsFrontRRef) {
        this.motoPadBrakePadsFrontRRef = motoPadBrakePadsFrontRRef;
    }

    public String getMotopadBrakePadsFNeto() {
        return motopadBrakePadsFNeto;
    }

    public Bike motopadBrakePadsFNeto(String motopadBrakePadsFNeto) {
        this.motopadBrakePadsFNeto = motopadBrakePadsFNeto;
        return this;
    }

    public void setMotopadBrakePadsFNeto(String motopadBrakePadsFNeto) {
        this.motopadBrakePadsFNeto = motopadBrakePadsFNeto;
    }

    public String getAllBallsFCRebuildKit1() {
        return allBallsFCRebuildKit1;
    }

    public Bike allBallsFCRebuildKit1(String allBallsFCRebuildKit1) {
        this.allBallsFCRebuildKit1 = allBallsFCRebuildKit1;
        return this;
    }

    public void setAllBallsFCRebuildKit1(String allBallsFCRebuildKit1) {
        this.allBallsFCRebuildKit1 = allBallsFCRebuildKit1;
    }

    public String getAllBallsFCPin() {
        return allBallsFCPin;
    }

    public Bike allBallsFCPin(String allBallsFCPin) {
        this.allBallsFCPin = allBallsFCPin;
        return this;
    }

    public void setAllBallsFCPin(String allBallsFCPin) {
        this.allBallsFCPin = allBallsFCPin;
    }

    public String getAllBallsFMCyRebuildKit() {
        return allBallsFMCyRebuildKit;
    }

    public Bike allBallsFMCyRebuildKit(String allBallsFMCyRebuildKit) {
        this.allBallsFMCyRebuildKit = allBallsFMCyRebuildKit;
        return this;
    }

    public void setAllBallsFMCyRebuildKit(String allBallsFMCyRebuildKit) {
        this.allBallsFMCyRebuildKit = allBallsFMCyRebuildKit;
    }

    public String getAllBallsFSCRebuildKit() {
        return allBallsFSCRebuildKit;
    }

    public Bike allBallsFSCRebuildKit(String allBallsFSCRebuildKit) {
        this.allBallsFSCRebuildKit = allBallsFSCRebuildKit;
        return this;
    }

    public void setAllBallsFSCRebuildKit(String allBallsFSCRebuildKit) {
        this.allBallsFSCRebuildKit = allBallsFSCRebuildKit;
    }

    public String getNewfrenShoeFront() {
        return newfrenShoeFront;
    }

    public Bike newfrenShoeFront(String newfrenShoeFront) {
        this.newfrenShoeFront = newfrenShoeFront;
        return this;
    }

    public void setNewfrenShoeFront(String newfrenShoeFront) {
        this.newfrenShoeFront = newfrenShoeFront;
    }

    public String getMgearMiddleAxleBrakeDiscNeto() {
        return mgearMiddleAxleBrakeDiscNeto;
    }

    public Bike mgearMiddleAxleBrakeDiscNeto(String mgearMiddleAxleBrakeDiscNeto) {
        this.mgearMiddleAxleBrakeDiscNeto = mgearMiddleAxleBrakeDiscNeto;
        return this;
    }

    public void setMgearMiddleAxleBrakeDiscNeto(String mgearMiddleAxleBrakeDiscNeto) {
        this.mgearMiddleAxleBrakeDiscNeto = mgearMiddleAxleBrakeDiscNeto;
    }

    public String getMgearMiddleAxleBrakeDiscNeto2() {
        return mgearMiddleAxleBrakeDiscNeto2;
    }

    public Bike mgearMiddleAxleBrakeDiscNeto2(String mgearMiddleAxleBrakeDiscNeto2) {
        this.mgearMiddleAxleBrakeDiscNeto2 = mgearMiddleAxleBrakeDiscNeto2;
        return this;
    }

    public void setMgearMiddleAxleBrakeDiscNeto2(String mgearMiddleAxleBrakeDiscNeto2) {
        this.mgearMiddleAxleBrakeDiscNeto2 = mgearMiddleAxleBrakeDiscNeto2;
    }

    public String getMgearMiddleAxleBrakePadNeto() {
        return mgearMiddleAxleBrakePadNeto;
    }

    public Bike mgearMiddleAxleBrakePadNeto(String mgearMiddleAxleBrakePadNeto) {
        this.mgearMiddleAxleBrakePadNeto = mgearMiddleAxleBrakePadNeto;
        return this;
    }

    public void setMgearMiddleAxleBrakePadNeto(String mgearMiddleAxleBrakePadNeto) {
        this.mgearMiddleAxleBrakePadNeto = mgearMiddleAxleBrakePadNeto;
    }

    public String getMgearMiddleAxleBrakePadNeto2() {
        return mgearMiddleAxleBrakePadNeto2;
    }

    public Bike mgearMiddleAxleBrakePadNeto2(String mgearMiddleAxleBrakePadNeto2) {
        this.mgearMiddleAxleBrakePadNeto2 = mgearMiddleAxleBrakePadNeto2;
        return this;
    }

    public void setMgearMiddleAxleBrakePadNeto2(String mgearMiddleAxleBrakePadNeto2) {
        this.mgearMiddleAxleBrakePadNeto2 = mgearMiddleAxleBrakePadNeto2;
    }

    public String getMgearBrakePadsParkRef() {
        return mgearBrakePadsParkRef;
    }

    public Bike mgearBrakePadsParkRef(String mgearBrakePadsParkRef) {
        this.mgearBrakePadsParkRef = mgearBrakePadsParkRef;
        return this;
    }

    public void setMgearBrakePadsParkRef(String mgearBrakePadsParkRef) {
        this.mgearBrakePadsParkRef = mgearBrakePadsParkRef;
    }

    public String getMgearBrakePadsParkRef2() {
        return mgearBrakePadsParkRef2;
    }

    public Bike mgearBrakePadsParkRef2(String mgearBrakePadsParkRef2) {
        this.mgearBrakePadsParkRef2 = mgearBrakePadsParkRef2;
        return this;
    }

    public void setMgearBrakePadsParkRef2(String mgearBrakePadsParkRef2) {
        this.mgearBrakePadsParkRef2 = mgearBrakePadsParkRef2;
    }

    public String getEbcBrakeDiscRearRef() {
        return ebcBrakeDiscRearRef;
    }

    public Bike ebcBrakeDiscRearRef(String ebcBrakeDiscRearRef) {
        this.ebcBrakeDiscRearRef = ebcBrakeDiscRearRef;
        return this;
    }

    public void setEbcBrakeDiscRearRef(String ebcBrakeDiscRearRef) {
        this.ebcBrakeDiscRearRef = ebcBrakeDiscRearRef;
    }

    public String getBremboBrakeDiscRearRef() {
        return bremboBrakeDiscRearRef;
    }

    public Bike bremboBrakeDiscRearRef(String bremboBrakeDiscRearRef) {
        this.bremboBrakeDiscRearRef = bremboBrakeDiscRearRef;
        return this;
    }

    public void setBremboBrakeDiscRearRef(String bremboBrakeDiscRearRef) {
        this.bremboBrakeDiscRearRef = bremboBrakeDiscRearRef;
    }

    public String getMgearBrakeDiscRearRef() {
        return mgearBrakeDiscRearRef;
    }

    public Bike mgearBrakeDiscRearRef(String mgearBrakeDiscRearRef) {
        this.mgearBrakeDiscRearRef = mgearBrakeDiscRearRef;
        return this;
    }

    public void setMgearBrakeDiscRearRef(String mgearBrakeDiscRearRef) {
        this.mgearBrakeDiscRearRef = mgearBrakeDiscRearRef;
    }

    public String getTrwBrakeDiscRearRef() {
        return trwBrakeDiscRearRef;
    }

    public Bike trwBrakeDiscRearRef(String trwBrakeDiscRearRef) {
        this.trwBrakeDiscRearRef = trwBrakeDiscRearRef;
        return this;
    }

    public void setTrwBrakeDiscRearRef(String trwBrakeDiscRearRef) {
        this.trwBrakeDiscRearRef = trwBrakeDiscRearRef;
    }

    public String getMgearBrakeDiscRear() {
        return mgearBrakeDiscRear;
    }

    public Bike mgearBrakeDiscRear(String mgearBrakeDiscRear) {
        this.mgearBrakeDiscRear = mgearBrakeDiscRear;
        return this;
    }

    public void setMgearBrakeDiscRear(String mgearBrakeDiscRear) {
        this.mgearBrakeDiscRear = mgearBrakeDiscRear;
    }

    public String getAllBallsRCRebuildKit1() {
        return allBallsRCRebuildKit1;
    }

    public Bike allBallsRCRebuildKit1(String allBallsRCRebuildKit1) {
        this.allBallsRCRebuildKit1 = allBallsRCRebuildKit1;
        return this;
    }

    public void setAllBallsRCRebuildKit1(String allBallsRCRebuildKit1) {
        this.allBallsRCRebuildKit1 = allBallsRCRebuildKit1;
    }

    public String getAllBallsRearCaliperBolt() {
        return allBallsRearCaliperBolt;
    }

    public Bike allBallsRearCaliperBolt(String allBallsRearCaliperBolt) {
        this.allBallsRearCaliperBolt = allBallsRearCaliperBolt;
        return this;
    }

    public void setAllBallsRearCaliperBolt(String allBallsRearCaliperBolt) {
        this.allBallsRearCaliperBolt = allBallsRearCaliperBolt;
    }

    public String getAllBallsRMCrRebuildKit() {
        return allBallsRMCrRebuildKit;
    }

    public Bike allBallsRMCrRebuildKit(String allBallsRMCrRebuildKit) {
        this.allBallsRMCrRebuildKit = allBallsRMCrRebuildKit;
        return this;
    }

    public void setAllBallsRMCrRebuildKit(String allBallsRMCrRebuildKit) {
        this.allBallsRMCrRebuildKit = allBallsRMCrRebuildKit;
    }

    public String getEbcBrakePadsRearRef() {
        return ebcBrakePadsRearRef;
    }

    public Bike ebcBrakePadsRearRef(String ebcBrakePadsRearRef) {
        this.ebcBrakePadsRearRef = ebcBrakePadsRearRef;
        return this;
    }

    public void setEbcBrakePadsRearRef(String ebcBrakePadsRearRef) {
        this.ebcBrakePadsRearRef = ebcBrakePadsRearRef;
    }

    public String getMgearBrakePadsRearNeto() {
        return mgearBrakePadsRearNeto;
    }

    public Bike mgearBrakePadsRearNeto(String mgearBrakePadsRearNeto) {
        this.mgearBrakePadsRearNeto = mgearBrakePadsRearNeto;
        return this;
    }

    public void setMgearBrakePadsRearNeto(String mgearBrakePadsRearNeto) {
        this.mgearBrakePadsRearNeto = mgearBrakePadsRearNeto;
    }

    public String getNewfrenShoeRear() {
        return newfrenShoeRear;
    }

    public Bike newfrenShoeRear(String newfrenShoeRear) {
        this.newfrenShoeRear = newfrenShoeRear;
        return this;
    }

    public void setNewfrenShoeRear(String newfrenShoeRear) {
        this.newfrenShoeRear = newfrenShoeRear;
    }

    public String getAllBallsRearBrakePedalKit() {
        return allBallsRearBrakePedalKit;
    }

    public Bike allBallsRearBrakePedalKit(String allBallsRearBrakePedalKit) {
        this.allBallsRearBrakePedalKit = allBallsRearBrakePedalKit;
        return this;
    }

    public void setAllBallsRearBrakePedalKit(String allBallsRearBrakePedalKit) {
        this.allBallsRearBrakePedalKit = allBallsRearBrakePedalKit;
    }

    public String getAllBallsCSCRebuildKit() {
        return allBallsCSCRebuildKit;
    }

    public Bike allBallsCSCRebuildKit(String allBallsCSCRebuildKit) {
        this.allBallsCSCRebuildKit = allBallsCSCRebuildKit;
        return this;
    }

    public void setAllBallsCSCRebuildKit(String allBallsCSCRebuildKit) {
        this.allBallsCSCRebuildKit = allBallsCSCRebuildKit;
    }

    public String getFrontJTRefFront() {
        return frontJTRefFront;
    }

    public Bike frontJTRefFront(String frontJTRefFront) {
        this.frontJTRefFront = frontJTRefFront;
        return this;
    }

    public void setFrontJTRefFront(String frontJTRefFront) {
        this.frontJTRefFront = frontJTRefFront;
    }

    public String getEsjotRefFront() {
        return esjotRefFront;
    }

    public Bike esjotRefFront(String esjotRefFront) {
        this.esjotRefFront = esjotRefFront;
        return this;
    }

    public void setEsjotRefFront(String esjotRefFront) {
        this.esjotRefFront = esjotRefFront;
    }

    public String getMgearRefFront() {
        return mgearRefFront;
    }

    public Bike mgearRefFront(String mgearRefFront) {
        this.mgearRefFront = mgearRefFront;
        return this;
    }

    public void setMgearRefFront(String mgearRefFront) {
        this.mgearRefFront = mgearRefFront;
    }

    public String getMogemaRefFront() {
        return mogemaRefFront;
    }

    public Bike mogemaRefFront(String mogemaRefFront) {
        this.mogemaRefFront = mogemaRefFront;
        return this;
    }

    public void setMogemaRefFront(String mogemaRefFront) {
        this.mogemaRefFront = mogemaRefFront;
    }

    public String getSupersproxRefFront() {
        return supersproxRefFront;
    }

    public Bike supersproxRefFront(String supersproxRefFront) {
        this.supersproxRefFront = supersproxRefFront;
        return this;
    }

    public void setSupersproxRefFront(String supersproxRefFront) {
        this.supersproxRefFront = supersproxRefFront;
    }

    public String getEsjotRefRear() {
        return esjotRefRear;
    }

    public Bike esjotRefRear(String esjotRefRear) {
        this.esjotRefRear = esjotRefRear;
        return this;
    }

    public void setEsjotRefRear(String esjotRefRear) {
        this.esjotRefRear = esjotRefRear;
    }

    public String getJtRefRear() {
        return jtRefRear;
    }

    public Bike jtRefRear(String jtRefRear) {
        this.jtRefRear = jtRefRear;
        return this;
    }

    public void setJtRefRear(String jtRefRear) {
        this.jtRefRear = jtRefRear;
    }

    public String getMgearRefRear() {
        return mgearRefRear;
    }

    public Bike mgearRefRear(String mgearRefRear) {
        this.mgearRefRear = mgearRefRear;
        return this;
    }

    public void setMgearRefRear(String mgearRefRear) {
        this.mgearRefRear = mgearRefRear;
    }

    public String getMogemaRefRear() {
        return mogemaRefRear;
    }

    public Bike mogemaRefRear(String mogemaRefRear) {
        this.mogemaRefRear = mogemaRefRear;
        return this;
    }

    public void setMogemaRefRear(String mogemaRefRear) {
        this.mogemaRefRear = mogemaRefRear;
    }

    public String getSupersproxRefRear() {
        return supersproxRefRear;
    }

    public Bike supersproxRefRear(String supersproxRefRear) {
        this.supersproxRefRear = supersproxRefRear;
        return this;
    }

    public void setSupersproxRefRear(String supersproxRefRear) {
        this.supersproxRefRear = supersproxRefRear;
    }

    public String getEsjotRefFrontConv() {
        return esjotRefFrontConv;
    }

    public Bike esjotRefFrontConv(String esjotRefFrontConv) {
        this.esjotRefFrontConv = esjotRefFrontConv;
        return this;
    }

    public void setEsjotRefFrontConv(String esjotRefFrontConv) {
        this.esjotRefFrontConv = esjotRefFrontConv;
    }

    public String getJtSprocketRef() {
        return jtSprocketRef;
    }

    public Bike jtSprocketRef(String jtSprocketRef) {
        this.jtSprocketRef = jtSprocketRef;
        return this;
    }

    public void setJtSprocketRef(String jtSprocketRef) {
        this.jtSprocketRef = jtSprocketRef;
    }

    public String getMgearRefFrontConv() {
        return mgearRefFrontConv;
    }

    public Bike mgearRefFrontConv(String mgearRefFrontConv) {
        this.mgearRefFrontConv = mgearRefFrontConv;
        return this;
    }

    public void setMgearRefFrontConv(String mgearRefFrontConv) {
        this.mgearRefFrontConv = mgearRefFrontConv;
    }

    public String getMogemarefFrontConv() {
        return mogemarefFrontConv;
    }

    public Bike mogemarefFrontConv(String mogemarefFrontConv) {
        this.mogemarefFrontConv = mogemarefFrontConv;
        return this;
    }

    public void setMogemarefFrontConv(String mogemarefFrontConv) {
        this.mogemarefFrontConv = mogemarefFrontConv;
    }

    public String getSupersproxRefFrontConv() {
        return supersproxRefFrontConv;
    }

    public Bike supersproxRefFrontConv(String supersproxRefFrontConv) {
        this.supersproxRefFrontConv = supersproxRefFrontConv;
        return this;
    }

    public void setSupersproxRefFrontConv(String supersproxRefFrontConv) {
        this.supersproxRefFrontConv = supersproxRefFrontConv;
    }

    public String getConversionChain() {
        return conversionChain;
    }

    public Bike conversionChain(String conversionChain) {
        this.conversionChain = conversionChain;
        return this;
    }

    public void setConversionChain(String conversionChain) {
        this.conversionChain = conversionChain;
    }

    public String getMgearSprocketRearConv() {
        return mgearSprocketRearConv;
    }

    public Bike mgearSprocketRearConv(String mgearSprocketRearConv) {
        this.mgearSprocketRearConv = mgearSprocketRearConv;
        return this;
    }

    public void setMgearSprocketRearConv(String mgearSprocketRearConv) {
        this.mgearSprocketRearConv = mgearSprocketRearConv;
    }

    public String getEsjotRefRearConv() {
        return esjotRefRearConv;
    }

    public Bike esjotRefRearConv(String esjotRefRearConv) {
        this.esjotRefRearConv = esjotRefRearConv;
        return this;
    }

    public void setEsjotRefRearConv(String esjotRefRearConv) {
        this.esjotRefRearConv = esjotRefRearConv;
    }

    public String getMgearRefRearConv() {
        return mgearRefRearConv;
    }

    public Bike mgearRefRearConv(String mgearRefRearConv) {
        this.mgearRefRearConv = mgearRefRearConv;
        return this;
    }

    public void setMgearRefRearConv(String mgearRefRearConv) {
        this.mgearRefRearConv = mgearRefRearConv;
    }

    public String getMogemaRefRearConv() {
        return mogemaRefRearConv;
    }

    public Bike mogemaRefRearConv(String mogemaRefRearConv) {
        this.mogemaRefRearConv = mogemaRefRearConv;
        return this;
    }

    public void setMogemaRefRearConv(String mogemaRefRearConv) {
        this.mogemaRefRearConv = mogemaRefRearConv;
    }

    public String getSupersproxRefRearConv() {
        return supersproxRefRearConv;
    }

    public Bike supersproxRefRearConv(String supersproxRefRearConv) {
        this.supersproxRefRearConv = supersproxRefRearConv;
        return this;
    }

    public void setSupersproxRefRearConv(String supersproxRefRearConv) {
        this.supersproxRefRearConv = supersproxRefRearConv;
    }

    public String getAllBallsFWBearingKit1() {
        return allBallsFWBearingKit1;
    }

    public Bike allBallsFWBearingKit1(String allBallsFWBearingKit1) {
        this.allBallsFWBearingKit1 = allBallsFWBearingKit1;
        return this;
    }

    public void setAllBallsFWBearingKit1(String allBallsFWBearingKit1) {
        this.allBallsFWBearingKit1 = allBallsFWBearingKit1;
    }

    public String getAllBallsFWBearingKit2() {
        return allBallsFWBearingKit2;
    }

    public Bike allBallsFWBearingKit2(String allBallsFWBearingKit2) {
        this.allBallsFWBearingKit2 = allBallsFWBearingKit2;
        return this;
    }

    public void setAllBallsFWBearingKit2(String allBallsFWBearingKit2) {
        this.allBallsFWBearingKit2 = allBallsFWBearingKit2;
    }

    public String getAllBallsRWBearingKit1() {
        return allBallsRWBearingKit1;
    }

    public Bike allBallsRWBearingKit1(String allBallsRWBearingKit1) {
        this.allBallsRWBearingKit1 = allBallsRWBearingKit1;
        return this;
    }

    public void setAllBallsRWBearingKit1(String allBallsRWBearingKit1) {
        this.allBallsRWBearingKit1 = allBallsRWBearingKit1;
    }

    public String getAllBallsRWBearingKit2() {
        return allBallsRWBearingKit2;
    }

    public Bike allBallsRWBearingKit2(String allBallsRWBearingKit2) {
        this.allBallsRWBearingKit2 = allBallsRWBearingKit2;
        return this;
    }

    public void setAllBallsRWBearingKit2(String allBallsRWBearingKit2) {
        this.allBallsRWBearingKit2 = allBallsRWBearingKit2;
    }

    public String getAllBallsRWBearingUpgrade() {
        return allBallsRWBearingUpgrade;
    }

    public Bike allBallsRWBearingUpgrade(String allBallsRWBearingUpgrade) {
        this.allBallsRWBearingUpgrade = allBallsRWBearingUpgrade;
        return this;
    }

    public void setAllBallsRWBearingUpgrade(String allBallsRWBearingUpgrade) {
        this.allBallsRWBearingUpgrade = allBallsRWBearingUpgrade;
    }

    public String getOemSparkPlug() {
        return oemSparkPlug;
    }

    public Bike oemSparkPlug(String oemSparkPlug) {
        this.oemSparkPlug = oemSparkPlug;
        return this;
    }

    public void setOemSparkPlug(String oemSparkPlug) {
        this.oemSparkPlug = oemSparkPlug;
    }

    public Long getOemSparkPlugQTY() {
        return oemSparkPlugQTY;
    }

    public Bike oemSparkPlugQTY(Long oemSparkPlugQTY) {
        this.oemSparkPlugQTY = oemSparkPlugQTY;
        return this;
    }

    public void setOemSparkPlugQTY(Long oemSparkPlugQTY) {
        this.oemSparkPlugQTY = oemSparkPlugQTY;
    }

    public String getNgkSparkPlugSKUs() {
        return ngkSparkPlugSKUs;
    }

    public Bike ngkSparkPlugSKUs(String ngkSparkPlugSKUs) {
        this.ngkSparkPlugSKUs = ngkSparkPlugSKUs;
        return this;
    }

    public void setNgkSparkPlugSKUs(String ngkSparkPlugSKUs) {
        this.ngkSparkPlugSKUs = ngkSparkPlugSKUs;
    }

    public String getOemAlternator() {
        return oemAlternator;
    }

    public Bike oemAlternator(String oemAlternator) {
        this.oemAlternator = oemAlternator;
        return this;
    }

    public void setOemAlternator(String oemAlternator) {
        this.oemAlternator = oemAlternator;
    }

    public String getOemVoltageRegulator() {
        return oemVoltageRegulator;
    }

    public Bike oemVoltageRegulator(String oemVoltageRegulator) {
        this.oemVoltageRegulator = oemVoltageRegulator;
        return this;
    }

    public void setOemVoltageRegulator(String oemVoltageRegulator) {
        this.oemVoltageRegulator = oemVoltageRegulator;
    }

    public String getArrowheadAlternator() {
        return arrowheadAlternator;
    }

    public Bike arrowheadAlternator(String arrowheadAlternator) {
        this.arrowheadAlternator = arrowheadAlternator;
        return this;
    }

    public void setArrowheadAlternator(String arrowheadAlternator) {
        this.arrowheadAlternator = arrowheadAlternator;
    }

    public String getArrowheadAlternator2() {
        return arrowheadAlternator2;
    }

    public Bike arrowheadAlternator2(String arrowheadAlternator2) {
        this.arrowheadAlternator2 = arrowheadAlternator2;
        return this;
    }

    public void setArrowheadAlternator2(String arrowheadAlternator2) {
        this.arrowheadAlternator2 = arrowheadAlternator2;
    }

    public String getArrowheadCDIModule() {
        return arrowheadCDIModule;
    }

    public Bike arrowheadCDIModule(String arrowheadCDIModule) {
        this.arrowheadCDIModule = arrowheadCDIModule;
        return this;
    }

    public void setArrowheadCDIModule(String arrowheadCDIModule) {
        this.arrowheadCDIModule = arrowheadCDIModule;
    }

    public String getArrowheadChargingCoil() {
        return arrowheadChargingCoil;
    }

    public Bike arrowheadChargingCoil(String arrowheadChargingCoil) {
        this.arrowheadChargingCoil = arrowheadChargingCoil;
        return this;
    }

    public void setArrowheadChargingCoil(String arrowheadChargingCoil) {
        this.arrowheadChargingCoil = arrowheadChargingCoil;
    }

    public String getArrowheadIgnitionCoil() {
        return arrowheadIgnitionCoil;
    }

    public Bike arrowheadIgnitionCoil(String arrowheadIgnitionCoil) {
        this.arrowheadIgnitionCoil = arrowheadIgnitionCoil;
        return this;
    }

    public void setArrowheadIgnitionCoil(String arrowheadIgnitionCoil) {
        this.arrowheadIgnitionCoil = arrowheadIgnitionCoil;
    }

    public String getArrowheadStatorCoil() {
        return arrowheadStatorCoil;
    }

    public Bike arrowheadStatorCoil(String arrowheadStatorCoil) {
        this.arrowheadStatorCoil = arrowheadStatorCoil;
        return this;
    }

    public void setArrowheadStatorCoil(String arrowheadStatorCoil) {
        this.arrowheadStatorCoil = arrowheadStatorCoil;
    }

    public String getArrowheadVoltageRegulator() {
        return arrowheadVoltageRegulator;
    }

    public Bike arrowheadVoltageRegulator(String arrowheadVoltageRegulator) {
        this.arrowheadVoltageRegulator = arrowheadVoltageRegulator;
        return this;
    }

    public void setArrowheadVoltageRegulator(String arrowheadVoltageRegulator) {
        this.arrowheadVoltageRegulator = arrowheadVoltageRegulator;
    }

    public String getArrowheadPowerShiftCM() {
        return arrowheadPowerShiftCM;
    }

    public Bike arrowheadPowerShiftCM(String arrowheadPowerShiftCM) {
        this.arrowheadPowerShiftCM = arrowheadPowerShiftCM;
        return this;
    }

    public void setArrowheadPowerShiftCM(String arrowheadPowerShiftCM) {
        this.arrowheadPowerShiftCM = arrowheadPowerShiftCM;
    }

    public String getArrowheadStarterDrive() {
        return arrowheadStarterDrive;
    }

    public Bike arrowheadStarterDrive(String arrowheadStarterDrive) {
        this.arrowheadStarterDrive = arrowheadStarterDrive;
        return this;
    }

    public void setArrowheadStarterDrive(String arrowheadStarterDrive) {
        this.arrowheadStarterDrive = arrowheadStarterDrive;
    }

    public String getArrowheadStarterMotor() {
        return arrowheadStarterMotor;
    }

    public Bike arrowheadStarterMotor(String arrowheadStarterMotor) {
        this.arrowheadStarterMotor = arrowheadStarterMotor;
        return this;
    }

    public void setArrowheadStarterMotor(String arrowheadStarterMotor) {
        this.arrowheadStarterMotor = arrowheadStarterMotor;
    }

    public String getArrowheadStarterRelay() {
        return arrowheadStarterRelay;
    }

    public Bike arrowheadStarterRelay(String arrowheadStarterRelay) {
        this.arrowheadStarterRelay = arrowheadStarterRelay;
        return this;
    }

    public void setArrowheadStarterRelay(String arrowheadStarterRelay) {
        this.arrowheadStarterRelay = arrowheadStarterRelay;
    }

    public String getOemBattery() {
        return oemBattery;
    }

    public Bike oemBattery(String oemBattery) {
        this.oemBattery = oemBattery;
        return this;
    }

    public void setOemBattery(String oemBattery) {
        this.oemBattery = oemBattery;
    }

    public String getSsbAGMBattery() {
        return ssbAGMBattery;
    }

    public Bike ssbAGMBattery(String ssbAGMBattery) {
        this.ssbAGMBattery = ssbAGMBattery;
        return this;
    }

    public void setSsbAGMBattery(String ssbAGMBattery) {
        this.ssbAGMBattery = ssbAGMBattery;
    }

    public String getOemAirFilter() {
        return oemAirFilter;
    }

    public Bike oemAirFilter(String oemAirFilter) {
        this.oemAirFilter = oemAirFilter;
        return this;
    }

    public void setOemAirFilter(String oemAirFilter) {
        this.oemAirFilter = oemAirFilter;
    }

    public String getKnAirFilter() {
        return knAirFilter;
    }

    public Bike knAirFilter(String knAirFilter) {
        this.knAirFilter = knAirFilter;
        return this;
    }

    public void setKnAirFilter(String knAirFilter) {
        this.knAirFilter = knAirFilter;
    }

    public String getMotorexAirFilter() {
        return motorexAirFilter;
    }

    public Bike motorexAirFilter(String motorexAirFilter) {
        this.motorexAirFilter = motorexAirFilter;
        return this;
    }

    public void setMotorexAirFilter(String motorexAirFilter) {
        this.motorexAirFilter = motorexAirFilter;
    }

    public String getMotorexAirFilterPreoiled() {
        return motorexAirFilterPreoiled;
    }

    public Bike motorexAirFilterPreoiled(String motorexAirFilterPreoiled) {
        this.motorexAirFilterPreoiled = motorexAirFilterPreoiled;
        return this;
    }

    public void setMotorexAirFilterPreoiled(String motorexAirFilterPreoiled) {
        this.motorexAirFilterPreoiled = motorexAirFilterPreoiled;
    }

    public String getOemOilFilter1() {
        return oemOilFilter1;
    }

    public Bike oemOilFilter1(String oemOilFilter1) {
        this.oemOilFilter1 = oemOilFilter1;
        return this;
    }

    public void setOemOilFilter1(String oemOilFilter1) {
        this.oemOilFilter1 = oemOilFilter1;
    }

    public String getKnOilFilter1() {
        return knOilFilter1;
    }

    public Bike knOilFilter1(String knOilFilter1) {
        this.knOilFilter1 = knOilFilter1;
        return this;
    }

    public void setKnOilFilter1(String knOilFilter1) {
        this.knOilFilter1 = knOilFilter1;
    }

    public String getOemOilFilter2() {
        return oemOilFilter2;
    }

    public Bike oemOilFilter2(String oemOilFilter2) {
        this.oemOilFilter2 = oemOilFilter2;
        return this;
    }

    public void setOemOilFilter2(String oemOilFilter2) {
        this.oemOilFilter2 = oemOilFilter2;
    }

    public String getKnOilFilter2() {
        return knOilFilter2;
    }

    public Bike knOilFilter2(String knOilFilter2) {
        this.knOilFilter2 = knOilFilter2;
        return this;
    }

    public void setKnOilFilter2(String knOilFilter2) {
        this.knOilFilter2 = knOilFilter2;
    }

    public String getMotionProOilFilterMagnet() {
        return motionProOilFilterMagnet;
    }

    public Bike motionProOilFilterMagnet(String motionProOilFilterMagnet) {
        this.motionProOilFilterMagnet = motionProOilFilterMagnet;
        return this;
    }

    public void setMotionProOilFilterMagnet(String motionProOilFilterMagnet) {
        this.motionProOilFilterMagnet = motionProOilFilterMagnet;
    }

    public String getOemSteeringBearing() {
        return oemSteeringBearing;
    }

    public Bike oemSteeringBearing(String oemSteeringBearing) {
        this.oemSteeringBearing = oemSteeringBearing;
        return this;
    }

    public void setOemSteeringBearing(String oemSteeringBearing) {
        this.oemSteeringBearing = oemSteeringBearing;
    }

    public String getOemSteeringSeal() {
        return oemSteeringSeal;
    }

    public Bike oemSteeringSeal(String oemSteeringSeal) {
        this.oemSteeringSeal = oemSteeringSeal;
        return this;
    }

    public void setOemSteeringSeal(String oemSteeringSeal) {
        this.oemSteeringSeal = oemSteeringSeal;
    }

    public String getAllBallsSBSealKit1() {
        return allBallsSBSealKit1;
    }

    public Bike allBallsSBSealKit1(String allBallsSBSealKit1) {
        this.allBallsSBSealKit1 = allBallsSBSealKit1;
        return this;
    }

    public void setAllBallsSBSealKit1(String allBallsSBSealKit1) {
        this.allBallsSBSealKit1 = allBallsSBSealKit1;
    }

    public String getAllBallsSBSealKit2() {
        return allBallsSBSealKit2;
    }

    public Bike allBallsSBSealKit2(String allBallsSBSealKit2) {
        this.allBallsSBSealKit2 = allBallsSBSealKit2;
        return this;
    }

    public void setAllBallsSBSealKit2(String allBallsSBSealKit2) {
        this.allBallsSBSealKit2 = allBallsSBSealKit2;
    }

    public String getAllBallsSBSealKitLower() {
        return allBallsSBSealKitLower;
    }

    public Bike allBallsSBSealKitLower(String allBallsSBSealKitLower) {
        this.allBallsSBSealKitLower = allBallsSBSealKitLower;
        return this;
    }

    public void setAllBallsSBSealKitLower(String allBallsSBSealKitLower) {
        this.allBallsSBSealKitLower = allBallsSBSealKitLower;
    }

    public String getAllBallsSBSealKitLower2() {
        return allBallsSBSealKitLower2;
    }

    public Bike allBallsSBSealKitLower2(String allBallsSBSealKitLower2) {
        this.allBallsSBSealKitLower2 = allBallsSBSealKitLower2;
        return this;
    }

    public void setAllBallsSBSealKitLower2(String allBallsSBSealKitLower2) {
        this.allBallsSBSealKitLower2 = allBallsSBSealKitLower2;
    }

    public String getAllBallsCBSealKit() {
        return allBallsCBSealKit;
    }

    public Bike allBallsCBSealKit(String allBallsCBSealKit) {
        this.allBallsCBSealKit = allBallsCBSealKit;
        return this;
    }

    public void setAllBallsCBSealKit(String allBallsCBSealKit) {
        this.allBallsCBSealKit = allBallsCBSealKit;
    }

    public String getOemForkAssemblyLeft() {
        return oemForkAssemblyLeft;
    }

    public Bike oemForkAssemblyLeft(String oemForkAssemblyLeft) {
        this.oemForkAssemblyLeft = oemForkAssemblyLeft;
        return this;
    }

    public void setOemForkAssemblyLeft(String oemForkAssemblyLeft) {
        this.oemForkAssemblyLeft = oemForkAssemblyLeft;
    }

    public String getOemForkAssemblyRight() {
        return oemForkAssemblyRight;
    }

    public Bike oemForkAssemblyRight(String oemForkAssemblyRight) {
        this.oemForkAssemblyRight = oemForkAssemblyRight;
        return this;
    }

    public void setOemForkAssemblyRight(String oemForkAssemblyRight) {
        this.oemForkAssemblyRight = oemForkAssemblyRight;
    }

    public String getOemForkSeals() {
        return oemForkSeals;
    }

    public Bike oemForkSeals(String oemForkSeals) {
        this.oemForkSeals = oemForkSeals;
        return this;
    }

    public void setOemForkSeals(String oemForkSeals) {
        this.oemForkSeals = oemForkSeals;
    }

    public String getAllBallsForkSeals() {
        return allBallsForkSeals;
    }

    public Bike allBallsForkSeals(String allBallsForkSeals) {
        this.allBallsForkSeals = allBallsForkSeals;
        return this;
    }

    public void setAllBallsForkSeals(String allBallsForkSeals) {
        this.allBallsForkSeals = allBallsForkSeals;
    }

    public String getXprForkSeals() {
        return xprForkSeals;
    }

    public Bike xprForkSeals(String xprForkSeals) {
        this.xprForkSeals = xprForkSeals;
        return this;
    }

    public void setXprForkSeals(String xprForkSeals) {
        this.xprForkSeals = xprForkSeals;
    }

    public String getAllBallsForkBushingKit() {
        return allBallsForkBushingKit;
    }

    public Bike allBallsForkBushingKit(String allBallsForkBushingKit) {
        this.allBallsForkBushingKit = allBallsForkBushingKit;
        return this;
    }

    public void setAllBallsForkBushingKit(String allBallsForkBushingKit) {
        this.allBallsForkBushingKit = allBallsForkBushingKit;
    }

    public String getMotionProMicroForkBleeder() {
        return motionProMicroForkBleeder;
    }

    public Bike motionProMicroForkBleeder(String motionProMicroForkBleeder) {
        this.motionProMicroForkBleeder = motionProMicroForkBleeder;
        return this;
    }

    public void setMotionProMicroForkBleeder(String motionProMicroForkBleeder) {
        this.motionProMicroForkBleeder = motionProMicroForkBleeder;
    }

    public String getMotionProCRProThottleKit() {
        return motionProCRProThottleKit;
    }

    public Bike motionProCRProThottleKit(String motionProCRProThottleKit) {
        this.motionProCRProThottleKit = motionProCRProThottleKit;
        return this;
    }

    public void setMotionProCRProThottleKit(String motionProCRProThottleKit) {
        this.motionProCRProThottleKit = motionProCRProThottleKit;
    }

    public String getOemCableSpeedo() {
        return oemCableSpeedo;
    }

    public Bike oemCableSpeedo(String oemCableSpeedo) {
        this.oemCableSpeedo = oemCableSpeedo;
        return this;
    }

    public void setOemCableSpeedo(String oemCableSpeedo) {
        this.oemCableSpeedo = oemCableSpeedo;
    }

    public String getMotionProCableSpeedo() {
        return motionProCableSpeedo;
    }

    public Bike motionProCableSpeedo(String motionProCableSpeedo) {
        this.motionProCableSpeedo = motionProCableSpeedo;
        return this;
    }

    public void setMotionProCableSpeedo(String motionProCableSpeedo) {
        this.motionProCableSpeedo = motionProCableSpeedo;
    }

    public String getMotionProCableThrottleTube() {
        return motionProCableThrottleTube;
    }

    public Bike motionProCableThrottleTube(String motionProCableThrottleTube) {
        this.motionProCableThrottleTube = motionProCableThrottleTube;
        return this;
    }

    public void setMotionProCableThrottleTube(String motionProCableThrottleTube) {
        this.motionProCableThrottleTube = motionProCableThrottleTube;
    }

    public String getCrossproRadiatorGuard() {
        return crossproRadiatorGuard;
    }

    public Bike crossproRadiatorGuard(String crossproRadiatorGuard) {
        this.crossproRadiatorGuard = crossproRadiatorGuard;
        return this;
    }

    public void setCrossproRadiatorGuard(String crossproRadiatorGuard) {
        this.crossproRadiatorGuard = crossproRadiatorGuard;
    }

    public String getOemClutchFibres() {
        return oemClutchFibres;
    }

    public Bike oemClutchFibres(String oemClutchFibres) {
        this.oemClutchFibres = oemClutchFibres;
        return this;
    }

    public void setOemClutchFibres(String oemClutchFibres) {
        this.oemClutchFibres = oemClutchFibres;
    }

    public String getOemClutchFibresSteels() {
        return oemClutchFibresSteels;
    }

    public Bike oemClutchFibresSteels(String oemClutchFibresSteels) {
        this.oemClutchFibresSteels = oemClutchFibresSteels;
        return this;
    }

    public void setOemClutchFibresSteels(String oemClutchFibresSteels) {
        this.oemClutchFibresSteels = oemClutchFibresSteels;
    }

    public String getNewfrenClutchKit() {
        return newfrenClutchKit;
    }

    public Bike newfrenClutchKit(String newfrenClutchKit) {
        this.newfrenClutchKit = newfrenClutchKit;
        return this;
    }

    public void setNewfrenClutchKit(String newfrenClutchKit) {
        this.newfrenClutchKit = newfrenClutchKit;
    }

    public String getNewfrenClutchSpringKits() {
        return newfrenClutchSpringKits;
    }

    public Bike newfrenClutchSpringKits(String newfrenClutchSpringKits) {
        this.newfrenClutchSpringKits = newfrenClutchSpringKits;
        return this;
    }

    public void setNewfrenClutchSpringKits(String newfrenClutchSpringKits) {
        this.newfrenClutchSpringKits = newfrenClutchSpringKits;
    }

    public String getAllBallsCMCRebuiltKit() {
        return allBallsCMCRebuiltKit;
    }

    public Bike allBallsCMCRebuiltKit(String allBallsCMCRebuiltKit) {
        this.allBallsCMCRebuiltKit = allBallsCMCRebuiltKit;
        return this;
    }

    public void setAllBallsCMCRebuiltKit(String allBallsCMCRebuiltKit) {
        this.allBallsCMCRebuiltKit = allBallsCMCRebuiltKit;
    }

    public String getWisecoForgedClutchBasket() {
        return wisecoForgedClutchBasket;
    }

    public Bike wisecoForgedClutchBasket(String wisecoForgedClutchBasket) {
        this.wisecoForgedClutchBasket = wisecoForgedClutchBasket;
        return this;
    }

    public void setWisecoForgedClutchBasket(String wisecoForgedClutchBasket) {
        this.wisecoForgedClutchBasket = wisecoForgedClutchBasket;
    }

    public String getWisecoBottemEndRebuildKit() {
        return wisecoBottemEndRebuildKit;
    }

    public Bike wisecoBottemEndRebuildKit(String wisecoBottemEndRebuildKit) {
        this.wisecoBottemEndRebuildKit = wisecoBottemEndRebuildKit;
        return this;
    }

    public void setWisecoBottemEndRebuildKit(String wisecoBottemEndRebuildKit) {
        this.wisecoBottemEndRebuildKit = wisecoBottemEndRebuildKit;
    }

    public String getWrenchRERebuildKit() {
        return wrenchRERebuildKit;
    }

    public Bike wrenchRERebuildKit(String wrenchRERebuildKit) {
        this.wrenchRERebuildKit = wrenchRERebuildKit;
        return this;
    }

    public void setWrenchRERebuildKit(String wrenchRERebuildKit) {
        this.wrenchRERebuildKit = wrenchRERebuildKit;
    }

    public String getOemCarbAssembly() {
        return oemCarbAssembly;
    }

    public Bike oemCarbAssembly(String oemCarbAssembly) {
        this.oemCarbAssembly = oemCarbAssembly;
        return this;
    }

    public void setOemCarbAssembly(String oemCarbAssembly) {
        this.oemCarbAssembly = oemCarbAssembly;
    }

    public String getAllBallsCarbRepairKit() {
        return allBallsCarbRepairKit;
    }

    public Bike allBallsCarbRepairKit(String allBallsCarbRepairKit) {
        this.allBallsCarbRepairKit = allBallsCarbRepairKit;
        return this;
    }

    public void setAllBallsCarbRepairKit(String allBallsCarbRepairKit) {
        this.allBallsCarbRepairKit = allBallsCarbRepairKit;
    }

    public String getAllBallsCRMidBodyGasket1() {
        return allBallsCRMidBodyGasket1;
    }

    public Bike allBallsCRMidBodyGasket1(String allBallsCRMidBodyGasket1) {
        this.allBallsCRMidBodyGasket1 = allBallsCRMidBodyGasket1;
        return this;
    }

    public void setAllBallsCRMidBodyGasket1(String allBallsCRMidBodyGasket1) {
        this.allBallsCRMidBodyGasket1 = allBallsCRMidBodyGasket1;
    }

    public String getAllBallsCRMidBodyGasket2() {
        return allBallsCRMidBodyGasket2;
    }

    public Bike allBallsCRMidBodyGasket2(String allBallsCRMidBodyGasket2) {
        this.allBallsCRMidBodyGasket2 = allBallsCRMidBodyGasket2;
        return this;
    }

    public void setAllBallsCRMidBodyGasket2(String allBallsCRMidBodyGasket2) {
        this.allBallsCRMidBodyGasket2 = allBallsCRMidBodyGasket2;
    }

    public String getAllBallsFuelTapRepairKit() {
        return allBallsFuelTapRepairKit;
    }

    public Bike allBallsFuelTapRepairKit(String allBallsFuelTapRepairKit) {
        this.allBallsFuelTapRepairKit = allBallsFuelTapRepairKit;
        return this;
    }

    public void setAllBallsFuelTapRepairKit(String allBallsFuelTapRepairKit) {
        this.allBallsFuelTapRepairKit = allBallsFuelTapRepairKit;
    }

    public String getAllBallsFuelTapRepairKit2() {
        return allBallsFuelTapRepairKit2;
    }

    public Bike allBallsFuelTapRepairKit2(String allBallsFuelTapRepairKit2) {
        this.allBallsFuelTapRepairKit2 = allBallsFuelTapRepairKit2;
        return this;
    }

    public void setAllBallsFuelTapRepairKit2(String allBallsFuelTapRepairKit2) {
        this.allBallsFuelTapRepairKit2 = allBallsFuelTapRepairKit2;
    }

    public String getFuelStarFuelValveKit() {
        return fuelStarFuelValveKit;
    }

    public Bike fuelStarFuelValveKit(String fuelStarFuelValveKit) {
        this.fuelStarFuelValveKit = fuelStarFuelValveKit;
        return this;
    }

    public void setFuelStarFuelValveKit(String fuelStarFuelValveKit) {
        this.fuelStarFuelValveKit = fuelStarFuelValveKit;
    }

    public String getFuelStarFuelValveKit2() {
        return fuelStarFuelValveKit2;
    }

    public Bike fuelStarFuelValveKit2(String fuelStarFuelValveKit2) {
        this.fuelStarFuelValveKit2 = fuelStarFuelValveKit2;
        return this;
    }

    public void setFuelStarFuelValveKit2(String fuelStarFuelValveKit2) {
        this.fuelStarFuelValveKit2 = fuelStarFuelValveKit2;
    }

    public String getFuelStarHoseClampKit() {
        return fuelStarHoseClampKit;
    }

    public Bike fuelStarHoseClampKit(String fuelStarHoseClampKit) {
        this.fuelStarHoseClampKit = fuelStarHoseClampKit;
        return this;
    }

    public void setFuelStarHoseClampKit(String fuelStarHoseClampKit) {
        this.fuelStarHoseClampKit = fuelStarHoseClampKit;
    }

    public String getRgEngineCoverLHS() {
        return rgEngineCoverLHS;
    }

    public Bike rgEngineCoverLHS(String rgEngineCoverLHS) {
        this.rgEngineCoverLHS = rgEngineCoverLHS;
        return this;
    }

    public void setRgEngineCoverLHS(String rgEngineCoverLHS) {
        this.rgEngineCoverLHS = rgEngineCoverLHS;
    }

    public String getRgTailTidy() {
        return rgTailTidy;
    }

    public Bike rgTailTidy(String rgTailTidy) {
        this.rgTailTidy = rgTailTidy;
        return this;
    }

    public void setRgTailTidy(String rgTailTidy) {
        this.rgTailTidy = rgTailTidy;
    }

    public String getAllBallsLBSealKit() {
        return allBallsLBSealKit;
    }

    public Bike allBallsLBSealKit(String allBallsLBSealKit) {
        this.allBallsLBSealKit = allBallsLBSealKit;
        return this;
    }

    public void setAllBallsLBSealKit(String allBallsLBSealKit) {
        this.allBallsLBSealKit = allBallsLBSealKit;
    }

    public String getAllBallsLRSBearingKit() {
        return allBallsLRSBearingKit;
    }

    public Bike allBallsLRSBearingKit(String allBallsLRSBearingKit) {
        this.allBallsLRSBearingKit = allBallsLRSBearingKit;
        return this;
    }

    public void setAllBallsLRSBearingKit(String allBallsLRSBearingKit) {
        this.allBallsLRSBearingKit = allBallsLRSBearingKit;
    }

    public String getAllBallsURSBearingKit() {
        return allBallsURSBearingKit;
    }

    public Bike allBallsURSBearingKit(String allBallsURSBearingKit) {
        this.allBallsURSBearingKit = allBallsURSBearingKit;
        return this;
    }

    public void setAllBallsURSBearingKit(String allBallsURSBearingKit) {
        this.allBallsURSBearingKit = allBallsURSBearingKit;
    }

    public String getAllBallsULSBearingKit() {
        return allBallsULSBearingKit;
    }

    public Bike allBallsULSBearingKit(String allBallsULSBearingKit) {
        this.allBallsULSBearingKit = allBallsULSBearingKit;
        return this;
    }

    public void setAllBallsULSBearingKit(String allBallsULSBearingKit) {
        this.allBallsULSBearingKit = allBallsULSBearingKit;
    }

    public String getAllBallsSBSealKit() {
        return allBallsSBSealKit;
    }

    public Bike allBallsSBSealKit(String allBallsSBSealKit) {
        this.allBallsSBSealKit = allBallsSBSealKit;
        return this;
    }

    public void setAllBallsSBSealKit(String allBallsSBSealKit) {
        this.allBallsSBSealKit = allBallsSBSealKit;
    }

    public String getPivotWorksSTBearingKit() {
        return pivotWorksSTBearingKit;
    }

    public Bike pivotWorksSTBearingKit(String pivotWorksSTBearingKit) {
        this.pivotWorksSTBearingKit = pivotWorksSTBearingKit;
        return this;
    }

    public void setPivotWorksSTBearingKit(String pivotWorksSTBearingKit) {
        this.pivotWorksSTBearingKit = pivotWorksSTBearingKit;
    }

    public String getPivotWorksSRebuildKit() {
        return pivotWorksSRebuildKit;
    }

    public Bike pivotWorksSRebuildKit(String pivotWorksSRebuildKit) {
        this.pivotWorksSRebuildKit = pivotWorksSRebuildKit;
        return this;
    }

    public void setPivotWorksSRebuildKit(String pivotWorksSRebuildKit) {
        this.pivotWorksSRebuildKit = pivotWorksSRebuildKit;
    }

    public String getMpForkSealDriver() {
        return mpForkSealDriver;
    }

    public Bike mpForkSealDriver(String mpForkSealDriver) {
        this.mpForkSealDriver = mpForkSealDriver;
        return this;
    }

    public void setMpForkSealDriver(String mpForkSealDriver) {
        this.mpForkSealDriver = mpForkSealDriver;
    }

    public String getMpValveSealInstallTool() {
        return mpValveSealInstallTool;
    }

    public Bike mpValveSealInstallTool(String mpValveSealInstallTool) {
        this.mpValveSealInstallTool = mpValveSealInstallTool;
        return this;
    }

    public void setMpValveSealInstallTool(String mpValveSealInstallTool) {
        this.mpValveSealInstallTool = mpValveSealInstallTool;
    }

    public String getWinderosaGasketKitTopEnd() {
        return winderosaGasketKitTopEnd;
    }

    public Bike winderosaGasketKitTopEnd(String winderosaGasketKitTopEnd) {
        this.winderosaGasketKitTopEnd = winderosaGasketKitTopEnd;
        return this;
    }

    public void setWinderosaGasketKitTopEnd(String winderosaGasketKitTopEnd) {
        this.winderosaGasketKitTopEnd = winderosaGasketKitTopEnd;
    }

    public String getWinderosaGasketKitOilSeals() {
        return winderosaGasketKitOilSeals;
    }

    public Bike winderosaGasketKitOilSeals(String winderosaGasketKitOilSeals) {
        this.winderosaGasketKitOilSeals = winderosaGasketKitOilSeals;
        return this;
    }

    public void setWinderosaGasketKitOilSeals(String winderosaGasketKitOilSeals) {
        this.winderosaGasketKitOilSeals = winderosaGasketKitOilSeals;
    }

    public String getOemExhaustGasket() {
        return oemExhaustGasket;
    }

    public Bike oemExhaustGasket(String oemExhaustGasket) {
        this.oemExhaustGasket = oemExhaustGasket;
        return this;
    }

    public void setOemExhaustGasket(String oemExhaustGasket) {
        this.oemExhaustGasket = oemExhaustGasket;
    }

    public String getWinderosaGasketExhaust() {
        return winderosaGasketExhaust;
    }

    public Bike winderosaGasketExhaust(String winderosaGasketExhaust) {
        this.winderosaGasketExhaust = winderosaGasketExhaust;
        return this;
    }

    public void setWinderosaGasketExhaust(String winderosaGasketExhaust) {
        this.winderosaGasketExhaust = winderosaGasketExhaust;
    }

    public String getWinderosaWaterPumpRebuildKit() {
        return winderosaWaterPumpRebuildKit;
    }

    public Bike winderosaWaterPumpRebuildKit(String winderosaWaterPumpRebuildKit) {
        this.winderosaWaterPumpRebuildKit = winderosaWaterPumpRebuildKit;
        return this;
    }

    public void setWinderosaWaterPumpRebuildKit(String winderosaWaterPumpRebuildKit) {
        this.winderosaWaterPumpRebuildKit = winderosaWaterPumpRebuildKit;
    }

    public String getHotRodsConnectingRodKit() {
        return hotRodsConnectingRodKit;
    }

    public Bike hotRodsConnectingRodKit(String hotRodsConnectingRodKit) {
        this.hotRodsConnectingRodKit = hotRodsConnectingRodKit;
        return this;
    }

    public void setHotRodsConnectingRodKit(String hotRodsConnectingRodKit) {
        this.hotRodsConnectingRodKit = hotRodsConnectingRodKit;
    }

    public String getHotRodsCounterBalRebuildKit() {
        return hotRodsCounterBalRebuildKit;
    }

    public Bike hotRodsCounterBalRebuildKit(String hotRodsCounterBalRebuildKit) {
        this.hotRodsCounterBalRebuildKit = hotRodsCounterBalRebuildKit;
        return this;
    }

    public void setHotRodsCounterBalRebuildKit(String hotRodsCounterBalRebuildKit) {
        this.hotRodsCounterBalRebuildKit = hotRodsCounterBalRebuildKit;
    }

    public String getHotRodsBERebuildKit() {
        return hotRodsBERebuildKit;
    }

    public Bike hotRodsBERebuildKit(String hotRodsBERebuildKit) {
        this.hotRodsBERebuildKit = hotRodsBERebuildKit;
        return this;
    }

    public void setHotRodsBERebuildKit(String hotRodsBERebuildKit) {
        this.hotRodsBERebuildKit = hotRodsBERebuildKit;
    }

    public String getHotRodsBERebuildKitSt() {
        return hotRodsBERebuildKitSt;
    }

    public Bike hotRodsBERebuildKitSt(String hotRodsBERebuildKitSt) {
        this.hotRodsBERebuildKitSt = hotRodsBERebuildKitSt;
        return this;
    }

    public void setHotRodsBERebuildKitSt(String hotRodsBERebuildKitSt) {
        this.hotRodsBERebuildKitSt = hotRodsBERebuildKitSt;
    }

    public String getHotRodsCylinderHead() {
        return hotRodsCylinderHead;
    }

    public Bike hotRodsCylinderHead(String hotRodsCylinderHead) {
        this.hotRodsCylinderHead = hotRodsCylinderHead;
        return this;
    }

    public void setHotRodsCylinderHead(String hotRodsCylinderHead) {
        this.hotRodsCylinderHead = hotRodsCylinderHead;
    }

    public String getHotRodsMainBearingSealKit() {
        return hotRodsMainBearingSealKit;
    }

    public Bike hotRodsMainBearingSealKit(String hotRodsMainBearingSealKit) {
        this.hotRodsMainBearingSealKit = hotRodsMainBearingSealKit;
        return this;
    }

    public void setHotRodsMainBearingSealKit(String hotRodsMainBearingSealKit) {
        this.hotRodsMainBearingSealKit = hotRodsMainBearingSealKit;
    }

    public String getHotRodsTransmissionBearings() {
        return hotRodsTransmissionBearings;
    }

    public Bike hotRodsTransmissionBearings(String hotRodsTransmissionBearings) {
        this.hotRodsTransmissionBearings = hotRodsTransmissionBearings;
        return this;
    }

    public void setHotRodsTransmissionBearings(String hotRodsTransmissionBearings) {
        this.hotRodsTransmissionBearings = hotRodsTransmissionBearings;
    }

    public String getHotRodsWristPinBearings() {
        return hotRodsWristPinBearings;
    }

    public Bike hotRodsWristPinBearings(String hotRodsWristPinBearings) {
        this.hotRodsWristPinBearings = hotRodsWristPinBearings;
        return this;
    }

    public void setHotRodsWristPinBearings(String hotRodsWristPinBearings) {
        this.hotRodsWristPinBearings = hotRodsWristPinBearings;
    }

    public String getHotRodsSOHCCamshaftStage1() {
        return hotRodsSOHCCamshaftStage1;
    }

    public Bike hotRodsSOHCCamshaftStage1(String hotRodsSOHCCamshaftStage1) {
        this.hotRodsSOHCCamshaftStage1 = hotRodsSOHCCamshaftStage1;
        return this;
    }

    public void setHotRodsSOHCCamshaftStage1(String hotRodsSOHCCamshaftStage1) {
        this.hotRodsSOHCCamshaftStage1 = hotRodsSOHCCamshaftStage1;
    }

    public String getHotRodsSOHCCamshaftStage2() {
        return hotRodsSOHCCamshaftStage2;
    }

    public Bike hotRodsSOHCCamshaftStage2(String hotRodsSOHCCamshaftStage2) {
        this.hotRodsSOHCCamshaftStage2 = hotRodsSOHCCamshaftStage2;
        return this;
    }

    public void setHotRodsSOHCCamshaftStage2(String hotRodsSOHCCamshaftStage2) {
        this.hotRodsSOHCCamshaftStage2 = hotRodsSOHCCamshaftStage2;
    }

    public String getHotRodsSOHCCamshaftStage3() {
        return hotRodsSOHCCamshaftStage3;
    }

    public Bike hotRodsSOHCCamshaftStage3(String hotRodsSOHCCamshaftStage3) {
        this.hotRodsSOHCCamshaftStage3 = hotRodsSOHCCamshaftStage3;
        return this;
    }

    public void setHotRodsSOHCCamshaftStage3(String hotRodsSOHCCamshaftStage3) {
        this.hotRodsSOHCCamshaftStage3 = hotRodsSOHCCamshaftStage3;
    }

    public String getHotRodsDOHCCamshaftStage1Intake() {
        return hotRodsDOHCCamshaftStage1Intake;
    }

    public Bike hotRodsDOHCCamshaftStage1Intake(String hotRodsDOHCCamshaftStage1Intake) {
        this.hotRodsDOHCCamshaftStage1Intake = hotRodsDOHCCamshaftStage1Intake;
        return this;
    }

    public void setHotRodsDOHCCamshaftStage1Intake(String hotRodsDOHCCamshaftStage1Intake) {
        this.hotRodsDOHCCamshaftStage1Intake = hotRodsDOHCCamshaftStage1Intake;
    }

    public String getHotRodsDOHCCamshaftStage1Exhaust() {
        return hotRodsDOHCCamshaftStage1Exhaust;
    }

    public Bike hotRodsDOHCCamshaftStage1Exhaust(String hotRodsDOHCCamshaftStage1Exhaust) {
        this.hotRodsDOHCCamshaftStage1Exhaust = hotRodsDOHCCamshaftStage1Exhaust;
        return this;
    }

    public void setHotRodsDOHCCamshaftStage1Exhaust(String hotRodsDOHCCamshaftStage1Exhaust) {
        this.hotRodsDOHCCamshaftStage1Exhaust = hotRodsDOHCCamshaftStage1Exhaust;
    }

    public String getHotRodsDOHCCamshaftStage2Intake() {
        return hotRodsDOHCCamshaftStage2Intake;
    }

    public Bike hotRodsDOHCCamshaftStage2Intake(String hotRodsDOHCCamshaftStage2Intake) {
        this.hotRodsDOHCCamshaftStage2Intake = hotRodsDOHCCamshaftStage2Intake;
        return this;
    }

    public void setHotRodsDOHCCamshaftStage2Intake(String hotRodsDOHCCamshaftStage2Intake) {
        this.hotRodsDOHCCamshaftStage2Intake = hotRodsDOHCCamshaftStage2Intake;
    }

    public String getHotRodsDOHCCamshaftStage2Exhaust() {
        return hotRodsDOHCCamshaftStage2Exhaust;
    }

    public Bike hotRodsDOHCCamshaftStage2Exhaust(String hotRodsDOHCCamshaftStage2Exhaust) {
        this.hotRodsDOHCCamshaftStage2Exhaust = hotRodsDOHCCamshaftStage2Exhaust;
        return this;
    }

    public void setHotRodsDOHCCamshaftStage2Exhaust(String hotRodsDOHCCamshaftStage2Exhaust) {
        this.hotRodsDOHCCamshaftStage2Exhaust = hotRodsDOHCCamshaftStage2Exhaust;
    }

    public Set<BikeFrontSprocket> getBikeFrontSprockets() {
        return bikeFrontSprockets;
    }

    public Bike bikeFrontSprockets(Set<BikeFrontSprocket> bikeFrontSprockets) {
        this.bikeFrontSprockets = bikeFrontSprockets;
        return this;
    }

    public Bike addBikeFrontSprocket(BikeFrontSprocket bikeFrontSprocket) {
        this.bikeFrontSprockets.add(bikeFrontSprocket);
        bikeFrontSprocket.getBikes().add(this);
        return this;
    }

    public Bike removeBikeFrontSprocket(BikeFrontSprocket bikeFrontSprocket) {
        this.bikeFrontSprockets.remove(bikeFrontSprocket);
        bikeFrontSprocket.getBikes().remove(this);
        return this;
    }

    public void setBikeFrontSprockets(Set<BikeFrontSprocket> bikeFrontSprockets) {
        this.bikeFrontSprockets = bikeFrontSprockets;
    }

    public Set<BikeRearSprocket> getBikeRearSprockets() {
        return bikeRearSprockets;
    }

    public Bike bikeRearSprockets(Set<BikeRearSprocket> bikeRearSprockets) {
        this.bikeRearSprockets = bikeRearSprockets;
        return this;
    }

    public Bike addBikeRearSprocket(BikeRearSprocket bikeRearSprocket) {
        this.bikeRearSprockets.add(bikeRearSprocket);
        bikeRearSprocket.getBikes().add(this);
        return this;
    }

    public Bike removeBikeRearSprocket(BikeRearSprocket bikeRearSprocket) {
        this.bikeRearSprockets.remove(bikeRearSprocket);
        bikeRearSprocket.getBikes().remove(this);
        return this;
    }

    public void setBikeRearSprockets(Set<BikeRearSprocket> bikeRearSprockets) {
        this.bikeRearSprockets = bikeRearSprockets;
    }

    public Set<RearSprocketConv> getRearSprocketConvs() {
        return rearSprocketConvs;
    }

    public Bike rearSprocketConvs(Set<RearSprocketConv> rearSprocketConvs) {
        this.rearSprocketConvs = rearSprocketConvs;
        return this;
    }

    public Bike addRearSprocketConv(RearSprocketConv rearSprocketConv) {
        this.rearSprocketConvs.add(rearSprocketConv);
        rearSprocketConv.getBikes().add(this);
        return this;
    }

    public Bike removeRearSprocketConv(RearSprocketConv rearSprocketConv) {
        this.rearSprocketConvs.remove(rearSprocketConv);
        rearSprocketConv.getBikes().remove(this);
        return this;
    }

    public void setRearSprocketConvs(Set<RearSprocketConv> rearSprocketConvs) {
        this.rearSprocketConvs = rearSprocketConvs;
    }

    public Set<FrontSprocketConv> getFrontSprocketConvs() {
        return frontSprocketConvs;
    }

    public Bike frontSprocketConvs(Set<FrontSprocketConv> frontSprocketConvs) {
        this.frontSprocketConvs = frontSprocketConvs;
        return this;
    }

    public Bike addFrontSprocketConv(FrontSprocketConv frontSprocketConv) {
        this.frontSprocketConvs.add(frontSprocketConv);
        frontSprocketConv.getBikes().add(this);
        return this;
    }

    public Bike removeFrontSprocketConv(FrontSprocketConv frontSprocketConv) {
        this.frontSprocketConvs.remove(frontSprocketConv);
        frontSprocketConv.getBikes().remove(this);
        return this;
    }

    public void setFrontSprocketConvs(Set<FrontSprocketConv> frontSprocketConvs) {
        this.frontSprocketConvs = frontSprocketConvs;
    }

    public Set<Chain> getChains() {
        return chains;
    }

    public Bike chains(Set<Chain> chains) {
        this.chains = chains;
        return this;
    }

    public Bike addChain(Chain chain) {
        this.chains.add(chain);
        chain.getBikes().add(this);
        return this;
    }

    public Bike removeChain(Chain chain) {
        this.chains.remove(chain);
        chain.getBikes().remove(this);
        return this;
    }

    public void setChains(Set<Chain> chains) {
        this.chains = chains;
    }

    public Set<BikeBrakePad> getBikeBrakePads() {
        return bikeBrakePads;
    }

    public Bike bikeBrakePads(Set<BikeBrakePad> bikeBrakePads) {
        this.bikeBrakePads = bikeBrakePads;
        return this;
    }

    public Bike addBikeBrakePad(BikeBrakePad bikeBrakePad) {
        this.bikeBrakePads.add(bikeBrakePad);
        bikeBrakePad.getBikes().add(this);
        return this;
    }

    public Bike removeBikeBrakePad(BikeBrakePad bikeBrakePad) {
        this.bikeBrakePads.remove(bikeBrakePad);
        bikeBrakePad.getBikes().remove(this);
        return this;
    }

    public void setBikeBrakePads(Set<BikeBrakePad> bikeBrakePads) {
        this.bikeBrakePads = bikeBrakePads;
    }

    public Set<BikeBrakeDisc> getBikeBrakeDiscs() {
        return bikeBrakeDiscs;
    }

    public Bike bikeBrakeDiscs(Set<BikeBrakeDisc> bikeBrakeDiscs) {
        this.bikeBrakeDiscs = bikeBrakeDiscs;
        return this;
    }

    public Bike addBikeBrakeDisc(BikeBrakeDisc bikeBrakeDisc) {
        this.bikeBrakeDiscs.add(bikeBrakeDisc);
        bikeBrakeDisc.getBikes().add(this);
        return this;
    }

    public Bike removeBikeBrakeDisc(BikeBrakeDisc bikeBrakeDisc) {
        this.bikeBrakeDiscs.remove(bikeBrakeDisc);
        bikeBrakeDisc.getBikes().remove(this);
        return this;
    }

    public void setBikeBrakeDiscs(Set<BikeBrakeDisc> bikeBrakeDiscs) {
        this.bikeBrakeDiscs = bikeBrakeDiscs;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bike bike = (Bike) o;
        if (bike.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bike.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Bike{" +
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
