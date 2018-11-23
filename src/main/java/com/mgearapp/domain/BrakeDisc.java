package com.mgearapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A BrakeDisc.
 */
@Entity
@Table(name = "brake_disc")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BrakeDisc extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "sku", nullable = false)
    private String sku;

    @Column(name = "active")
    private String active;

    @Column(name = "au")
    private String au;

    @Column(name = "de")
    private String de;

    @Column(name = "metal_gearvisibility")
    private String metalGearvisibility;

    @Column(name = "bikematevisibility")
    private String bikematevisibility;

    @Column(name = "mgi_visibility")
    private String mgiVisibility;

    @Column(name = "disc_status")
    private String discStatus;

    @Column(name = "product_group_1")
    private String productGroup1;

    @Column(name = "product_group_2")
    private String productGroup2;

    @Column(name = "fitment")
    private String fitment;

    @Column(name = "description")
    private String description;

    @Column(name = "unit")
    private String unit;

    @Column(name = "qty")
    private Long qty;

    @Column(name = "brand")
    private String brand;

    @Column(name = "biketypes")
    private String biketypes;

    @Column(name = "models_2012_on")
    private String models2012on;

    @Column(name = "g_s_1_ean_no")
    private Long gS1EANNo;

    @Column(name = "our_notes")
    private String ourNotes;

    @Column(name = "weight", precision = 10, scale = 2)
    private BigDecimal weight;

    @Column(name = "pack_type")
    private String packType;

    @Column(name = "pack_length", precision = 10, scale = 2)
    private BigDecimal packLength;

    @Column(name = "pack_height", precision = 10, scale = 2)
    private BigDecimal packHeight;

    @Column(name = "pack_width", precision = 10, scale = 2)
    private BigDecimal packWidth;

    @Column(name = "pack_cubic", precision = 10, scale = 2)
    private BigDecimal packCubic;

    @Column(name = "o_d")
    private Long oD;

    @Column(name = "b_hc")
    private String bHC;

    @Column(name = "b_h_qty")
    private Long bHQty;

    @Column(name = "b_h_size", precision = 10, scale = 2)
    private BigDecimal bHSize;

    @Column(name = "b_hod", precision = 10, scale = 2)
    private BigDecimal bHOD;

    @Column(name = "b_h_step", precision = 10, scale = 2)
    private BigDecimal bHStep;

    @Column(name = "b_h_type")
    private String bHType;

    @Column(name = "thickness", precision = 10, scale = 2)
    private BigDecimal thickness;

    @Column(name = "thickness_min", precision = 10, scale = 2)
    private BigDecimal thicknessMin;

    @Column(name = "jhi_offset", precision = 10, scale = 2)
    private BigDecimal offset;

    @Column(name = "brake_areawidth", precision = 10, scale = 2)
    private BigDecimal brakeAreawidth;

    @Column(name = "t_uvlhc")
    private String tUVLHC;

    @Column(name = "customer_notes")
    private String customerNotes;

    @Column(name = "e_listing")
    private String eListing;

    @Column(name = "efor_make")
    private String eforMake;

    @Column(name = "e_date")
    private LocalDate eDate;

    @Column(name = "euploaded_neto")
    private String euploadedNeto;

    @Column(name = "echeck")
    private String echeck;

    @Column(name = "euploadede_bay")
    private String euploadedeBay;

    @Column(name = "ebayactive")
    private String ebayactive;

    @Column(name = "e_photobucket")
    private String ePhotobucket;

    @Column(name = "e_photo_1")
    private String ePhoto1;

    @Column(name = "e_photo_2")
    private String ePhoto2;

    @Column(name = "e_photo_3")
    private String ePhoto3;

    @Column(name = "sale_status")
    private String saleStatus;

    @Column(name = "r_rp", precision = 10, scale = 2)
    private BigDecimal rRP;

    @Column(name = "trade_1", precision = 10, scale = 2)
    private BigDecimal trade1;

    @Column(name = "e_bay", precision = 10, scale = 2)
    private BigDecimal eBAY;

    @Column(name = "trade_2", precision = 10, scale = 2)
    private BigDecimal trade2;

    @Column(name = "trade_3", precision = 10, scale = 2)
    private BigDecimal trade3;

    @Column(name = "distributor_nzaud", precision = 10, scale = 2)
    private BigDecimal distributorNZAUD;

    @Column(name = "distributor_eur", precision = 10, scale = 2)
    private BigDecimal distributorEUR;

    @Column(name = "distributor_usd", precision = 10, scale = 2)
    private BigDecimal distributorUSD;

    @Column(name = "s_priority")
    private String sPriority;

    @Column(name = "samplefrom")
    private String samplefrom;

    @Column(name = "requestedfrom")
    private String requestedfrom;

    @Column(name = "jhi_date")
    private LocalDate date;

    @Column(name = "received")
    private String received;

    @Column(name = "camefrom")
    private String camefrom;

    @Column(name = "paidfor")
    private String paidfor;

    @Column(name = "sentto")
    private String sentto;

    @Column(name = "ship_no")
    private Long shipNo;

    @Column(name = "datesent")
    private LocalDate datesent;

    @Column(name = "samplereturn")
    private String samplereturn;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "jhi_year")
    private String year;

    @Column(name = "sample_fitment")
    private String sampleFitment;

    @Column(name = "o_em")
    private String oEM;

    @Column(name = "notesfor_production")
    private String notesforProduction;

    @Column(name = "production_code")
    private String productionCode;

    @Column(name = "h_a_papproved")
    private LocalDate hAPapproved;

    @Column(name = "s_h_aapproved")
    private LocalDate sHAapproved;

    @Column(name = "approvedby")
    private String approvedby;

    @Column(name = "notesto_drawing")
    private String notestoDrawing;

    @Column(name = "filename")
    private String filename;

    @Column(name = "c_ostusd", precision = 10, scale = 2)
    private BigDecimal cOSTUSD;

    @Column(name = "centrecolour")
    private String centrecolour;

    @Column(name = "laser")
    private String laser;

    @Column(name = "q_ty_1")
    private Long qTY1;

    @Column(name = "u_sd", precision = 10, scale = 2)
    private BigDecimal uSD;

    @Column(name = "complete_production")
    private String completeProduction;

    @Column(name = "our_noteto_production")
    private String ourNotetoProduction;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public BrakeDisc sku(String sku) {
        this.sku = sku;
        return this;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getActive() {
        return active;
    }

    public BrakeDisc active(String active) {
        this.active = active;
        return this;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getAu() {
        return au;
    }

    public BrakeDisc au(String au) {
        this.au = au;
        return this;
    }

    public void setAu(String au) {
        this.au = au;
    }

    public String getDe() {
        return de;
    }

    public BrakeDisc de(String de) {
        this.de = de;
        return this;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getMetalGearvisibility() {
        return metalGearvisibility;
    }

    public BrakeDisc metalGearvisibility(String metalGearvisibility) {
        this.metalGearvisibility = metalGearvisibility;
        return this;
    }

    public void setMetalGearvisibility(String metalGearvisibility) {
        this.metalGearvisibility = metalGearvisibility;
    }

    public String getBikematevisibility() {
        return bikematevisibility;
    }

    public BrakeDisc bikematevisibility(String bikematevisibility) {
        this.bikematevisibility = bikematevisibility;
        return this;
    }

    public void setBikematevisibility(String bikematevisibility) {
        this.bikematevisibility = bikematevisibility;
    }

    public String getMgiVisibility() {
        return mgiVisibility;
    }

    public BrakeDisc mgiVisibility(String mgiVisibility) {
        this.mgiVisibility = mgiVisibility;
        return this;
    }

    public void setMgiVisibility(String mgiVisibility) {
        this.mgiVisibility = mgiVisibility;
    }

    public String getDiscStatus() {
        return discStatus;
    }

    public BrakeDisc discStatus(String discStatus) {
        this.discStatus = discStatus;
        return this;
    }

    public void setDiscStatus(String discStatus) {
        this.discStatus = discStatus;
    }

    public String getProductGroup1() {
        return productGroup1;
    }

    public BrakeDisc productGroup1(String productGroup1) {
        this.productGroup1 = productGroup1;
        return this;
    }

    public void setProductGroup1(String productGroup1) {
        this.productGroup1 = productGroup1;
    }

    public String getProductGroup2() {
        return productGroup2;
    }

    public BrakeDisc productGroup2(String productGroup2) {
        this.productGroup2 = productGroup2;
        return this;
    }

    public void setProductGroup2(String productGroup2) {
        this.productGroup2 = productGroup2;
    }

    public String getFitment() {
        return fitment;
    }

    public BrakeDisc fitment(String fitment) {
        this.fitment = fitment;
        return this;
    }

    public void setFitment(String fitment) {
        this.fitment = fitment;
    }

    public String getDescription() {
        return description;
    }

    public BrakeDisc description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public BrakeDisc unit(String unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getQty() {
        return qty;
    }

    public BrakeDisc qty(Long qty) {
        this.qty = qty;
        return this;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getBrand() {
        return brand;
    }

    public BrakeDisc brand(String brand) {
        this.brand = brand;
        return this;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBiketypes() {
        return biketypes;
    }

    public BrakeDisc biketypes(String biketypes) {
        this.biketypes = biketypes;
        return this;
    }

    public void setBiketypes(String biketypes) {
        this.biketypes = biketypes;
    }

    public String getModels2012on() {
        return models2012on;
    }

    public BrakeDisc models2012on(String models2012on) {
        this.models2012on = models2012on;
        return this;
    }

    public void setModels2012on(String models2012on) {
        this.models2012on = models2012on;
    }

    public Long getgS1EANNo() {
        return gS1EANNo;
    }

    public BrakeDisc gS1EANNo(Long gS1EANNo) {
        this.gS1EANNo = gS1EANNo;
        return this;
    }

    public void setgS1EANNo(Long gS1EANNo) {
        this.gS1EANNo = gS1EANNo;
    }

    public String getOurNotes() {
        return ourNotes;
    }

    public BrakeDisc ourNotes(String ourNotes) {
        this.ourNotes = ourNotes;
        return this;
    }

    public void setOurNotes(String ourNotes) {
        this.ourNotes = ourNotes;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BrakeDisc weight(BigDecimal weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getPackType() {
        return packType;
    }

    public BrakeDisc packType(String packType) {
        this.packType = packType;
        return this;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public BigDecimal getPackLength() {
        return packLength;
    }

    public BrakeDisc packLength(BigDecimal packLength) {
        this.packLength = packLength;
        return this;
    }

    public void setPackLength(BigDecimal packLength) {
        this.packLength = packLength;
    }

    public BigDecimal getPackHeight() {
        return packHeight;
    }

    public BrakeDisc packHeight(BigDecimal packHeight) {
        this.packHeight = packHeight;
        return this;
    }

    public void setPackHeight(BigDecimal packHeight) {
        this.packHeight = packHeight;
    }

    public BigDecimal getPackWidth() {
        return packWidth;
    }

    public BrakeDisc packWidth(BigDecimal packWidth) {
        this.packWidth = packWidth;
        return this;
    }

    public void setPackWidth(BigDecimal packWidth) {
        this.packWidth = packWidth;
    }

    public BigDecimal getPackCubic() {
        return packCubic;
    }

    public BrakeDisc packCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
        return this;
    }

    public void setPackCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
    }

    public Long getoD() {
        return oD;
    }

    public BrakeDisc oD(Long oD) {
        this.oD = oD;
        return this;
    }

    public void setoD(Long oD) {
        this.oD = oD;
    }

    public String getbHC() {
        return bHC;
    }

    public BrakeDisc bHC(String bHC) {
        this.bHC = bHC;
        return this;
    }

    public void setbHC(String bHC) {
        this.bHC = bHC;
    }

    public Long getbHQty() {
        return bHQty;
    }

    public BrakeDisc bHQty(Long bHQty) {
        this.bHQty = bHQty;
        return this;
    }

    public void setbHQty(Long bHQty) {
        this.bHQty = bHQty;
    }

    public BigDecimal getbHSize() {
        return bHSize;
    }

    public BrakeDisc bHSize(BigDecimal bHSize) {
        this.bHSize = bHSize;
        return this;
    }

    public void setbHSize(BigDecimal bHSize) {
        this.bHSize = bHSize;
    }

    public BigDecimal getbHOD() {
        return bHOD;
    }

    public BrakeDisc bHOD(BigDecimal bHOD) {
        this.bHOD = bHOD;
        return this;
    }

    public void setbHOD(BigDecimal bHOD) {
        this.bHOD = bHOD;
    }

    public BigDecimal getbHStep() {
        return bHStep;
    }

    public BrakeDisc bHStep(BigDecimal bHStep) {
        this.bHStep = bHStep;
        return this;
    }

    public void setbHStep(BigDecimal bHStep) {
        this.bHStep = bHStep;
    }

    public String getbHType() {
        return bHType;
    }

    public BrakeDisc bHType(String bHType) {
        this.bHType = bHType;
        return this;
    }

    public void setbHType(String bHType) {
        this.bHType = bHType;
    }

    public BigDecimal getThickness() {
        return thickness;
    }

    public BrakeDisc thickness(BigDecimal thickness) {
        this.thickness = thickness;
        return this;
    }

    public void setThickness(BigDecimal thickness) {
        this.thickness = thickness;
    }

    public BigDecimal getThicknessMin() {
        return thicknessMin;
    }

    public BrakeDisc thicknessMin(BigDecimal thicknessMin) {
        this.thicknessMin = thicknessMin;
        return this;
    }

    public void setThicknessMin(BigDecimal thicknessMin) {
        this.thicknessMin = thicknessMin;
    }

    public BigDecimal getOffset() {
        return offset;
    }

    public BrakeDisc offset(BigDecimal offset) {
        this.offset = offset;
        return this;
    }

    public void setOffset(BigDecimal offset) {
        this.offset = offset;
    }

    public BigDecimal getBrakeAreawidth() {
        return brakeAreawidth;
    }

    public BrakeDisc brakeAreawidth(BigDecimal brakeAreawidth) {
        this.brakeAreawidth = brakeAreawidth;
        return this;
    }

    public void setBrakeAreawidth(BigDecimal brakeAreawidth) {
        this.brakeAreawidth = brakeAreawidth;
    }

    public String gettUVLHC() {
        return tUVLHC;
    }

    public BrakeDisc tUVLHC(String tUVLHC) {
        this.tUVLHC = tUVLHC;
        return this;
    }

    public void settUVLHC(String tUVLHC) {
        this.tUVLHC = tUVLHC;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public BrakeDisc customerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
        return this;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
    }

    public String geteListing() {
        return eListing;
    }

    public BrakeDisc eListing(String eListing) {
        this.eListing = eListing;
        return this;
    }

    public void seteListing(String eListing) {
        this.eListing = eListing;
    }

    public String getEforMake() {
        return eforMake;
    }

    public BrakeDisc eforMake(String eforMake) {
        this.eforMake = eforMake;
        return this;
    }

    public void setEforMake(String eforMake) {
        this.eforMake = eforMake;
    }

    public LocalDate geteDate() {
        return eDate;
    }

    public BrakeDisc eDate(LocalDate eDate) {
        this.eDate = eDate;
        return this;
    }

    public void seteDate(LocalDate eDate) {
        this.eDate = eDate;
    }

    public String getEuploadedNeto() {
        return euploadedNeto;
    }

    public BrakeDisc euploadedNeto(String euploadedNeto) {
        this.euploadedNeto = euploadedNeto;
        return this;
    }

    public void setEuploadedNeto(String euploadedNeto) {
        this.euploadedNeto = euploadedNeto;
    }

    public String getEcheck() {
        return echeck;
    }

    public BrakeDisc echeck(String echeck) {
        this.echeck = echeck;
        return this;
    }

    public void setEcheck(String echeck) {
        this.echeck = echeck;
    }

    public String getEuploadedeBay() {
        return euploadedeBay;
    }

    public BrakeDisc euploadedeBay(String euploadedeBay) {
        this.euploadedeBay = euploadedeBay;
        return this;
    }

    public void setEuploadedeBay(String euploadedeBay) {
        this.euploadedeBay = euploadedeBay;
    }

    public String getEbayactive() {
        return ebayactive;
    }

    public BrakeDisc ebayactive(String ebayactive) {
        this.ebayactive = ebayactive;
        return this;
    }

    public void setEbayactive(String ebayactive) {
        this.ebayactive = ebayactive;
    }

    public String getePhotobucket() {
        return ePhotobucket;
    }

    public BrakeDisc ePhotobucket(String ePhotobucket) {
        this.ePhotobucket = ePhotobucket;
        return this;
    }

    public void setePhotobucket(String ePhotobucket) {
        this.ePhotobucket = ePhotobucket;
    }

    public String getePhoto1() {
        return ePhoto1;
    }

    public BrakeDisc ePhoto1(String ePhoto1) {
        this.ePhoto1 = ePhoto1;
        return this;
    }

    public void setePhoto1(String ePhoto1) {
        this.ePhoto1 = ePhoto1;
    }

    public String getePhoto2() {
        return ePhoto2;
    }

    public BrakeDisc ePhoto2(String ePhoto2) {
        this.ePhoto2 = ePhoto2;
        return this;
    }

    public void setePhoto2(String ePhoto2) {
        this.ePhoto2 = ePhoto2;
    }

    public String getePhoto3() {
        return ePhoto3;
    }

    public BrakeDisc ePhoto3(String ePhoto3) {
        this.ePhoto3 = ePhoto3;
        return this;
    }

    public void setePhoto3(String ePhoto3) {
        this.ePhoto3 = ePhoto3;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public BrakeDisc saleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
        return this;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public BigDecimal getrRP() {
        return rRP;
    }

    public BrakeDisc rRP(BigDecimal rRP) {
        this.rRP = rRP;
        return this;
    }

    public void setrRP(BigDecimal rRP) {
        this.rRP = rRP;
    }

    public BigDecimal getTrade1() {
        return trade1;
    }

    public BrakeDisc trade1(BigDecimal trade1) {
        this.trade1 = trade1;
        return this;
    }

    public void setTrade1(BigDecimal trade1) {
        this.trade1 = trade1;
    }

    public BigDecimal geteBAY() {
        return eBAY;
    }

    public BrakeDisc eBAY(BigDecimal eBAY) {
        this.eBAY = eBAY;
        return this;
    }

    public void seteBAY(BigDecimal eBAY) {
        this.eBAY = eBAY;
    }

    public BigDecimal getTrade2() {
        return trade2;
    }

    public BrakeDisc trade2(BigDecimal trade2) {
        this.trade2 = trade2;
        return this;
    }

    public void setTrade2(BigDecimal trade2) {
        this.trade2 = trade2;
    }

    public BigDecimal getTrade3() {
        return trade3;
    }

    public BrakeDisc trade3(BigDecimal trade3) {
        this.trade3 = trade3;
        return this;
    }

    public void setTrade3(BigDecimal trade3) {
        this.trade3 = trade3;
    }

    public BigDecimal getDistributorNZAUD() {
        return distributorNZAUD;
    }

    public BrakeDisc distributorNZAUD(BigDecimal distributorNZAUD) {
        this.distributorNZAUD = distributorNZAUD;
        return this;
    }

    public void setDistributorNZAUD(BigDecimal distributorNZAUD) {
        this.distributorNZAUD = distributorNZAUD;
    }

    public BigDecimal getDistributorEUR() {
        return distributorEUR;
    }

    public BrakeDisc distributorEUR(BigDecimal distributorEUR) {
        this.distributorEUR = distributorEUR;
        return this;
    }

    public void setDistributorEUR(BigDecimal distributorEUR) {
        this.distributorEUR = distributorEUR;
    }

    public BigDecimal getDistributorUSD() {
        return distributorUSD;
    }

    public BrakeDisc distributorUSD(BigDecimal distributorUSD) {
        this.distributorUSD = distributorUSD;
        return this;
    }

    public void setDistributorUSD(BigDecimal distributorUSD) {
        this.distributorUSD = distributorUSD;
    }

    public String getsPriority() {
        return sPriority;
    }

    public BrakeDisc sPriority(String sPriority) {
        this.sPriority = sPriority;
        return this;
    }

    public void setsPriority(String sPriority) {
        this.sPriority = sPriority;
    }

    public String getSamplefrom() {
        return samplefrom;
    }

    public BrakeDisc samplefrom(String samplefrom) {
        this.samplefrom = samplefrom;
        return this;
    }

    public void setSamplefrom(String samplefrom) {
        this.samplefrom = samplefrom;
    }

    public String getRequestedfrom() {
        return requestedfrom;
    }

    public BrakeDisc requestedfrom(String requestedfrom) {
        this.requestedfrom = requestedfrom;
        return this;
    }

    public void setRequestedfrom(String requestedfrom) {
        this.requestedfrom = requestedfrom;
    }

    public LocalDate getDate() {
        return date;
    }

    public BrakeDisc date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReceived() {
        return received;
    }

    public BrakeDisc received(String received) {
        this.received = received;
        return this;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getCamefrom() {
        return camefrom;
    }

    public BrakeDisc camefrom(String camefrom) {
        this.camefrom = camefrom;
        return this;
    }

    public void setCamefrom(String camefrom) {
        this.camefrom = camefrom;
    }

    public String getPaidfor() {
        return paidfor;
    }

    public BrakeDisc paidfor(String paidfor) {
        this.paidfor = paidfor;
        return this;
    }

    public void setPaidfor(String paidfor) {
        this.paidfor = paidfor;
    }

    public String getSentto() {
        return sentto;
    }

    public BrakeDisc sentto(String sentto) {
        this.sentto = sentto;
        return this;
    }

    public void setSentto(String sentto) {
        this.sentto = sentto;
    }

    public Long getShipNo() {
        return shipNo;
    }

    public BrakeDisc shipNo(Long shipNo) {
        this.shipNo = shipNo;
        return this;
    }

    public void setShipNo(Long shipNo) {
        this.shipNo = shipNo;
    }

    public LocalDate getDatesent() {
        return datesent;
    }

    public BrakeDisc datesent(LocalDate datesent) {
        this.datesent = datesent;
        return this;
    }

    public void setDatesent(LocalDate datesent) {
        this.datesent = datesent;
    }

    public String getSamplereturn() {
        return samplereturn;
    }

    public BrakeDisc samplereturn(String samplereturn) {
        this.samplereturn = samplereturn;
        return this;
    }

    public void setSamplereturn(String samplereturn) {
        this.samplereturn = samplereturn;
    }

    public String getMake() {
        return make;
    }

    public BrakeDisc make(String make) {
        this.make = make;
        return this;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public BrakeDisc model(String model) {
        this.model = model;
        return this;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public BrakeDisc year(String year) {
        this.year = year;
        return this;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSampleFitment() {
        return sampleFitment;
    }

    public BrakeDisc sampleFitment(String sampleFitment) {
        this.sampleFitment = sampleFitment;
        return this;
    }

    public void setSampleFitment(String sampleFitment) {
        this.sampleFitment = sampleFitment;
    }

    public String getoEM() {
        return oEM;
    }

    public BrakeDisc oEM(String oEM) {
        this.oEM = oEM;
        return this;
    }

    public void setoEM(String oEM) {
        this.oEM = oEM;
    }

    public String getNotesforProduction() {
        return notesforProduction;
    }

    public BrakeDisc notesforProduction(String notesforProduction) {
        this.notesforProduction = notesforProduction;
        return this;
    }

    public void setNotesforProduction(String notesforProduction) {
        this.notesforProduction = notesforProduction;
    }

    public String getProductionCode() {
        return productionCode;
    }

    public BrakeDisc productionCode(String productionCode) {
        this.productionCode = productionCode;
        return this;
    }

    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    public LocalDate gethAPapproved() {
        return hAPapproved;
    }

    public BrakeDisc hAPapproved(LocalDate hAPapproved) {
        this.hAPapproved = hAPapproved;
        return this;
    }

    public void sethAPapproved(LocalDate hAPapproved) {
        this.hAPapproved = hAPapproved;
    }

    public LocalDate getsHAapproved() {
        return sHAapproved;
    }

    public BrakeDisc sHAapproved(LocalDate sHAapproved) {
        this.sHAapproved = sHAapproved;
        return this;
    }

    public void setsHAapproved(LocalDate sHAapproved) {
        this.sHAapproved = sHAapproved;
    }

    public String getApprovedby() {
        return approvedby;
    }

    public BrakeDisc approvedby(String approvedby) {
        this.approvedby = approvedby;
        return this;
    }

    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    public String getNotestoDrawing() {
        return notestoDrawing;
    }

    public BrakeDisc notestoDrawing(String notestoDrawing) {
        this.notestoDrawing = notestoDrawing;
        return this;
    }

    public void setNotestoDrawing(String notestoDrawing) {
        this.notestoDrawing = notestoDrawing;
    }

    public String getFilename() {
        return filename;
    }

    public BrakeDisc filename(String filename) {
        this.filename = filename;
        return this;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public BigDecimal getcOSTUSD() {
        return cOSTUSD;
    }

    public BrakeDisc cOSTUSD(BigDecimal cOSTUSD) {
        this.cOSTUSD = cOSTUSD;
        return this;
    }

    public void setcOSTUSD(BigDecimal cOSTUSD) {
        this.cOSTUSD = cOSTUSD;
    }

    public String getCentrecolour() {
        return centrecolour;
    }

    public BrakeDisc centrecolour(String centrecolour) {
        this.centrecolour = centrecolour;
        return this;
    }

    public void setCentrecolour(String centrecolour) {
        this.centrecolour = centrecolour;
    }

    public String getLaser() {
        return laser;
    }

    public BrakeDisc laser(String laser) {
        this.laser = laser;
        return this;
    }

    public void setLaser(String laser) {
        this.laser = laser;
    }

    public Long getqTY1() {
        return qTY1;
    }

    public BrakeDisc qTY1(Long qTY1) {
        this.qTY1 = qTY1;
        return this;
    }

    public void setqTY1(Long qTY1) {
        this.qTY1 = qTY1;
    }

    public BigDecimal getuSD() {
        return uSD;
    }

    public BrakeDisc uSD(BigDecimal uSD) {
        this.uSD = uSD;
        return this;
    }

    public void setuSD(BigDecimal uSD) {
        this.uSD = uSD;
    }

    public String getCompleteProduction() {
        return completeProduction;
    }

    public BrakeDisc completeProduction(String completeProduction) {
        this.completeProduction = completeProduction;
        return this;
    }

    public void setCompleteProduction(String completeProduction) {
        this.completeProduction = completeProduction;
    }

    public String getOurNotetoProduction() {
        return ourNotetoProduction;
    }

    public BrakeDisc ourNotetoProduction(String ourNotetoProduction) {
        this.ourNotetoProduction = ourNotetoProduction;
        return this;
    }

    public void setOurNotetoProduction(String ourNotetoProduction) {
        this.ourNotetoProduction = ourNotetoProduction;
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
        BrakeDisc brakeDisc = (BrakeDisc) o;
        if (brakeDisc.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), brakeDisc.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BrakeDisc{" +
            "id=" + getId() +
            ", sku='" + getSku() + "'" +
            ", active='" + getActive() + "'" +
            ", au='" + getAu() + "'" +
            ", de='" + getDe() + "'" +
            ", metalGearvisibility='" + getMetalGearvisibility() + "'" +
            ", bikematevisibility='" + getBikematevisibility() + "'" +
            ", mgiVisibility='" + getMgiVisibility() + "'" +
            ", discStatus='" + getDiscStatus() + "'" +
            ", productGroup1='" + getProductGroup1() + "'" +
            ", productGroup2='" + getProductGroup2() + "'" +
            ", fitment='" + getFitment() + "'" +
            ", description='" + getDescription() + "'" +
            ", unit='" + getUnit() + "'" +
            ", qty=" + getQty() +
            ", brand='" + getBrand() + "'" +
            ", biketypes='" + getBiketypes() + "'" +
            ", models2012on='" + getModels2012on() + "'" +
            ", gS1EANNo=" + getgS1EANNo() +
            ", ourNotes='" + getOurNotes() + "'" +
            ", weight=" + getWeight() +
            ", packType='" + getPackType() + "'" +
            ", packLength=" + getPackLength() +
            ", packHeight=" + getPackHeight() +
            ", packWidth=" + getPackWidth() +
            ", packCubic=" + getPackCubic() +
            ", oD=" + getoD() +
            ", bHC='" + getbHC() + "'" +
            ", bHQty=" + getbHQty() +
            ", bHSize=" + getbHSize() +
            ", bHOD=" + getbHOD() +
            ", bHStep=" + getbHStep() +
            ", bHType='" + getbHType() + "'" +
            ", thickness=" + getThickness() +
            ", thicknessMin=" + getThicknessMin() +
            ", offset=" + getOffset() +
            ", brakeAreawidth=" + getBrakeAreawidth() +
            ", tUVLHC='" + gettUVLHC() + "'" +
            ", customerNotes='" + getCustomerNotes() + "'" +
            ", eListing='" + geteListing() + "'" +
            ", eforMake='" + getEforMake() + "'" +
            ", eDate='" + geteDate() + "'" +
            ", euploadedNeto='" + getEuploadedNeto() + "'" +
            ", echeck='" + getEcheck() + "'" +
            ", euploadedeBay='" + getEuploadedeBay() + "'" +
            ", ebayactive='" + getEbayactive() + "'" +
            ", ePhotobucket='" + getePhotobucket() + "'" +
            ", ePhoto1='" + getePhoto1() + "'" +
            ", ePhoto2='" + getePhoto2() + "'" +
            ", ePhoto3='" + getePhoto3() + "'" +
            ", saleStatus='" + getSaleStatus() + "'" +
            ", rRP=" + getrRP() +
            ", trade1=" + getTrade1() +
            ", eBAY=" + geteBAY() +
            ", trade2=" + getTrade2() +
            ", trade3=" + getTrade3() +
            ", distributorNZAUD=" + getDistributorNZAUD() +
            ", distributorEUR=" + getDistributorEUR() +
            ", distributorUSD=" + getDistributorUSD() +
            ", sPriority='" + getsPriority() + "'" +
            ", samplefrom='" + getSamplefrom() + "'" +
            ", requestedfrom='" + getRequestedfrom() + "'" +
            ", date='" + getDate() + "'" +
            ", received='" + getReceived() + "'" +
            ", camefrom='" + getCamefrom() + "'" +
            ", paidfor='" + getPaidfor() + "'" +
            ", sentto='" + getSentto() + "'" +
            ", shipNo=" + getShipNo() +
            ", datesent='" + getDatesent() + "'" +
            ", samplereturn='" + getSamplereturn() + "'" +
            ", make='" + getMake() + "'" +
            ", model='" + getModel() + "'" +
            ", year='" + getYear() + "'" +
            ", sampleFitment='" + getSampleFitment() + "'" +
            ", oEM='" + getoEM() + "'" +
            ", notesforProduction='" + getNotesforProduction() + "'" +
            ", productionCode='" + getProductionCode() + "'" +
            ", hAPapproved='" + gethAPapproved() + "'" +
            ", sHAapproved='" + getsHAapproved() + "'" +
            ", approvedby='" + getApprovedby() + "'" +
            ", notestoDrawing='" + getNotestoDrawing() + "'" +
            ", filename='" + getFilename() + "'" +
            ", cOSTUSD=" + getcOSTUSD() +
            ", centrecolour='" + getCentrecolour() + "'" +
            ", laser='" + getLaser() + "'" +
            ", qTY1=" + getqTY1() +
            ", uSD=" + getuSD() +
            ", completeProduction='" + getCompleteProduction() + "'" +
            ", ourNotetoProduction='" + getOurNotetoProduction() + "'" +
            "}";
    }
}
