package com.mgearapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Sprocket.
 */
@Entity
@Table(name = "sprocket")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Sprocket extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "sku")
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

    @Column(name = "status")
    private String status;

    @Column(name = "product_group_1")
    private String productGroup1;

    @Column(name = "product_group_2")
    private String productGroup2;

    @Column(name = "countries")
    private String countries;

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

    @Column(name = "fits_makes")
    private String fitsMakes;

    @Column(name = "modelsupto")
    private Long modelsupto;

    @Column(name = "g_s_1_ean")
    private Long gS1EAN;

    @Column(name = "our_notes")
    private String ourNotes;

    @Column(name = "customer_notes")
    private String customerNotes;

    @Column(name = "weightkg", precision = 10, scale = 2)
    private BigDecimal weightkg;

    @Column(name = "pack_type")
    private String packType;

    @Column(name = "pack_length", precision = 10, scale = 2)
    private BigDecimal packLength;

    @Column(name = "pack_width", precision = 10, scale = 2)
    private BigDecimal packWidth;

    @Column(name = "pack_height", precision = 10, scale = 2)
    private BigDecimal packHeight;

    @Column(name = "pack_cubic", precision = 10, scale = 2)
    private BigDecimal packCubic;

    @Column(name = "sprocket_chain_size")
    private Long sprocketChainSize;

    @Column(name = "sprocket_teeth")
    private Long sprocketTeeth;

    @Column(name = "e_sbhc")
    private String eSBHC;

    @Column(name = "e_sid")
    private Long eSID;

    @Column(name = "e_si_dinner_teeth")
    private String eSIDinnerTeeth;

    @Column(name = "e_sbh_qty")
    private Long eSBHQty;

    @Column(name = "e_sbh_size")
    private String eSBHSize;

    @Column(name = "e_sbh_type")
    private String eSBHType;

    @Column(name = "e_s_width", precision = 10, scale = 2)
    private BigDecimal eSWidth;

    @Column(name = "toliston_ebay")
    private String tolistonEbay;

    @Column(name = "e_listing")
    private String eListing;

    @Column(name = "efor_make")
    private String eforMake;

    @Column(name = "euploaded_neto")
    private String euploadedNeto;

    @Column(name = "e_date")
    private LocalDate eDate;

    @Column(name = "echeck")
    private String echeck;

    @Column(name = "euploadede_bay")
    private String euploadedeBay;

    @Column(name = "e_bayactive")
    private String eBayactive;

    @Column(name = "e_photobucket")
    private String ePhotobucket;

    @Column(name = "e_photo_main")
    private String ePhotoMain;

    @Column(name = "e_photo_clear")
    private String ePhotoClear;

    @Column(name = "e_photo_side")
    private String ePhotoSide;

    @Column(name = "sales_status")
    private String salesStatus;

    @Column(name = "r_rp", precision = 10, scale = 2)
    private BigDecimal rRP;

    @Column(name = "e_bay", precision = 10, scale = 2)
    private BigDecimal eBay;

    @Column(name = "trade_1", precision = 10, scale = 2)
    private BigDecimal trade1;

    @Column(name = "trade_2", precision = 10, scale = 2)
    private BigDecimal trade2;

    @Column(name = "trade_3", precision = 10, scale = 2)
    private BigDecimal trade3;

    @Column(name = "distributor_nzaud")
    private String distributorNZAUD;

    @Column(name = "distributor_usd")
    private String distributorUSD;

    @Column(name = "distributor_eur")
    private String distributorEUR;

    @Column(name = "bikemate_aud")
    private String bikemateAUD;

    @Column(name = "comp_metal_gear")
    private String compMetalGear;

    @Column(name = "comp_mogema")
    private String compMogema;

    @Column(name = "comp_jt")
    private String compJT;

    @Column(name = "j_tbhc")
    private String jTBHC;

    @Column(name = "j_tid")
    private Long jTID;

    @Column(name = "j_ti_dinner_teeth")
    private Long jTIDinnerTeeth;

    @Column(name = "j_tbh_qty")
    private String jTBHQty;

    @Column(name = "j_tbh_size", precision = 10, scale = 2)
    private BigDecimal jTBHSize;

    @Column(name = "j_tbh_type")
    private String jTBHType;

    @Column(name = "j_t_width", precision = 10, scale = 2)
    private BigDecimal jTWidth;

    @Column(name = "j_t_note")
    private String jTNote;

    @Column(name = "comp_esjot")
    private String compEsjot;

    @Column(name = "comp_super_sprox")
    private String compSuperSprox;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "min_stock")
    private Long minStock;

    @Column(name = "max_stock")
    private Long maxStock;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "supplier_currency")
    private String supplierCurrency;

    @Column(name = "supplier_cost", precision = 10, scale = 2)
    private BigDecimal supplierCost;

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

    public Sprocket sku(String sku) {
        this.sku = sku;
        return this;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getActive() {
        return active;
    }

    public Sprocket active(String active) {
        this.active = active;
        return this;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getAu() {
        return au;
    }

    public Sprocket au(String au) {
        this.au = au;
        return this;
    }

    public void setAu(String au) {
        this.au = au;
    }

    public String getDe() {
        return de;
    }

    public Sprocket de(String de) {
        this.de = de;
        return this;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getMetalGearvisibility() {
        return metalGearvisibility;
    }

    public Sprocket metalGearvisibility(String metalGearvisibility) {
        this.metalGearvisibility = metalGearvisibility;
        return this;
    }

    public void setMetalGearvisibility(String metalGearvisibility) {
        this.metalGearvisibility = metalGearvisibility;
    }

    public String getBikematevisibility() {
        return bikematevisibility;
    }

    public Sprocket bikematevisibility(String bikematevisibility) {
        this.bikematevisibility = bikematevisibility;
        return this;
    }

    public void setBikematevisibility(String bikematevisibility) {
        this.bikematevisibility = bikematevisibility;
    }

    public String getMgiVisibility() {
        return mgiVisibility;
    }

    public Sprocket mgiVisibility(String mgiVisibility) {
        this.mgiVisibility = mgiVisibility;
        return this;
    }

    public void setMgiVisibility(String mgiVisibility) {
        this.mgiVisibility = mgiVisibility;
    }

    public String getStatus() {
        return status;
    }

    public Sprocket status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductGroup1() {
        return productGroup1;
    }

    public Sprocket productGroup1(String productGroup1) {
        this.productGroup1 = productGroup1;
        return this;
    }

    public void setProductGroup1(String productGroup1) {
        this.productGroup1 = productGroup1;
    }

    public String getProductGroup2() {
        return productGroup2;
    }

    public Sprocket productGroup2(String productGroup2) {
        this.productGroup2 = productGroup2;
        return this;
    }

    public void setProductGroup2(String productGroup2) {
        this.productGroup2 = productGroup2;
    }

    public String getCountries() {
        return countries;
    }

    public Sprocket countries(String countries) {
        this.countries = countries;
        return this;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getFitment() {
        return fitment;
    }

    public Sprocket fitment(String fitment) {
        this.fitment = fitment;
        return this;
    }

    public void setFitment(String fitment) {
        this.fitment = fitment;
    }

    public String getDescription() {
        return description;
    }

    public Sprocket description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public Sprocket unit(String unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getQty() {
        return qty;
    }

    public Sprocket qty(Long qty) {
        this.qty = qty;
        return this;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getBrand() {
        return brand;
    }

    public Sprocket brand(String brand) {
        this.brand = brand;
        return this;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBiketypes() {
        return biketypes;
    }

    public Sprocket biketypes(String biketypes) {
        this.biketypes = biketypes;
        return this;
    }

    public void setBiketypes(String biketypes) {
        this.biketypes = biketypes;
    }

    public String getFitsMakes() {
        return fitsMakes;
    }

    public Sprocket fitsMakes(String fitsMakes) {
        this.fitsMakes = fitsMakes;
        return this;
    }

    public void setFitsMakes(String fitsMakes) {
        this.fitsMakes = fitsMakes;
    }

    public Long getModelsupto() {
        return modelsupto;
    }

    public Sprocket modelsupto(Long modelsupto) {
        this.modelsupto = modelsupto;
        return this;
    }

    public void setModelsupto(Long modelsupto) {
        this.modelsupto = modelsupto;
    }

    public Long getgS1EAN() {
        return gS1EAN;
    }

    public Sprocket gS1EAN(Long gS1EAN) {
        this.gS1EAN = gS1EAN;
        return this;
    }

    public void setgS1EAN(Long gS1EAN) {
        this.gS1EAN = gS1EAN;
    }

    public String getOurNotes() {
        return ourNotes;
    }

    public Sprocket ourNotes(String ourNotes) {
        this.ourNotes = ourNotes;
        return this;
    }

    public void setOurNotes(String ourNotes) {
        this.ourNotes = ourNotes;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public Sprocket customerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
        return this;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
    }

    public BigDecimal getWeightkg() {
        return weightkg;
    }

    public Sprocket weightkg(BigDecimal weightkg) {
        this.weightkg = weightkg;
        return this;
    }

    public void setWeightkg(BigDecimal weightkg) {
        this.weightkg = weightkg;
    }

    public String getPackType() {
        return packType;
    }

    public Sprocket packType(String packType) {
        this.packType = packType;
        return this;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public BigDecimal getPackLength() {
        return packLength;
    }

    public Sprocket packLength(BigDecimal packLength) {
        this.packLength = packLength;
        return this;
    }

    public void setPackLength(BigDecimal packLength) {
        this.packLength = packLength;
    }

    public BigDecimal getPackWidth() {
        return packWidth;
    }

    public Sprocket packWidth(BigDecimal packWidth) {
        this.packWidth = packWidth;
        return this;
    }

    public void setPackWidth(BigDecimal packWidth) {
        this.packWidth = packWidth;
    }

    public BigDecimal getPackHeight() {
        return packHeight;
    }

    public Sprocket packHeight(BigDecimal packHeight) {
        this.packHeight = packHeight;
        return this;
    }

    public void setPackHeight(BigDecimal packHeight) {
        this.packHeight = packHeight;
    }

    public BigDecimal getPackCubic() {
        return packCubic;
    }

    public Sprocket packCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
        return this;
    }

    public void setPackCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
    }

    public Long getSprocketChainSize() {
        return sprocketChainSize;
    }

    public Sprocket sprocketChainSize(Long sprocketChainSize) {
        this.sprocketChainSize = sprocketChainSize;
        return this;
    }

    public void setSprocketChainSize(Long sprocketChainSize) {
        this.sprocketChainSize = sprocketChainSize;
    }

    public Long getSprocketTeeth() {
        return sprocketTeeth;
    }

    public Sprocket sprocketTeeth(Long sprocketTeeth) {
        this.sprocketTeeth = sprocketTeeth;
        return this;
    }

    public void setSprocketTeeth(Long sprocketTeeth) {
        this.sprocketTeeth = sprocketTeeth;
    }

    public String geteSBHC() {
        return eSBHC;
    }

    public Sprocket eSBHC(String eSBHC) {
        this.eSBHC = eSBHC;
        return this;
    }

    public void seteSBHC(String eSBHC) {
        this.eSBHC = eSBHC;
    }

    public Long geteSID() {
        return eSID;
    }

    public Sprocket eSID(Long eSID) {
        this.eSID = eSID;
        return this;
    }

    public void seteSID(Long eSID) {
        this.eSID = eSID;
    }

    public String geteSIDinnerTeeth() {
        return eSIDinnerTeeth;
    }

    public Sprocket eSIDinnerTeeth(String eSIDinnerTeeth) {
        this.eSIDinnerTeeth = eSIDinnerTeeth;
        return this;
    }

    public void seteSIDinnerTeeth(String eSIDinnerTeeth) {
        this.eSIDinnerTeeth = eSIDinnerTeeth;
    }

    public Long geteSBHQty() {
        return eSBHQty;
    }

    public Sprocket eSBHQty(Long eSBHQty) {
        this.eSBHQty = eSBHQty;
        return this;
    }

    public void seteSBHQty(Long eSBHQty) {
        this.eSBHQty = eSBHQty;
    }

    public String geteSBHSize() {
        return eSBHSize;
    }

    public Sprocket eSBHSize(String eSBHSize) {
        this.eSBHSize = eSBHSize;
        return this;
    }

    public void seteSBHSize(String eSBHSize) {
        this.eSBHSize = eSBHSize;
    }

    public String geteSBHType() {
        return eSBHType;
    }

    public Sprocket eSBHType(String eSBHType) {
        this.eSBHType = eSBHType;
        return this;
    }

    public void seteSBHType(String eSBHType) {
        this.eSBHType = eSBHType;
    }

    public BigDecimal geteSWidth() {
        return eSWidth;
    }

    public Sprocket eSWidth(BigDecimal eSWidth) {
        this.eSWidth = eSWidth;
        return this;
    }

    public void seteSWidth(BigDecimal eSWidth) {
        this.eSWidth = eSWidth;
    }

    public String getTolistonEbay() {
        return tolistonEbay;
    }

    public Sprocket tolistonEbay(String tolistonEbay) {
        this.tolistonEbay = tolistonEbay;
        return this;
    }

    public void setTolistonEbay(String tolistonEbay) {
        this.tolistonEbay = tolistonEbay;
    }

    public String geteListing() {
        return eListing;
    }

    public Sprocket eListing(String eListing) {
        this.eListing = eListing;
        return this;
    }

    public void seteListing(String eListing) {
        this.eListing = eListing;
    }

    public String getEforMake() {
        return eforMake;
    }

    public Sprocket eforMake(String eforMake) {
        this.eforMake = eforMake;
        return this;
    }

    public void setEforMake(String eforMake) {
        this.eforMake = eforMake;
    }

    public String getEuploadedNeto() {
        return euploadedNeto;
    }

    public Sprocket euploadedNeto(String euploadedNeto) {
        this.euploadedNeto = euploadedNeto;
        return this;
    }

    public void setEuploadedNeto(String euploadedNeto) {
        this.euploadedNeto = euploadedNeto;
    }

    public LocalDate geteDate() {
        return eDate;
    }

    public Sprocket eDate(LocalDate eDate) {
        this.eDate = eDate;
        return this;
    }

    public void seteDate(LocalDate eDate) {
        this.eDate = eDate;
    }

    public String getEcheck() {
        return echeck;
    }

    public Sprocket echeck(String echeck) {
        this.echeck = echeck;
        return this;
    }

    public void setEcheck(String echeck) {
        this.echeck = echeck;
    }

    public String getEuploadedeBay() {
        return euploadedeBay;
    }

    public Sprocket euploadedeBay(String euploadedeBay) {
        this.euploadedeBay = euploadedeBay;
        return this;
    }

    public void setEuploadedeBay(String euploadedeBay) {
        this.euploadedeBay = euploadedeBay;
    }

    public String geteBayactive() {
        return eBayactive;
    }

    public Sprocket eBayactive(String eBayactive) {
        this.eBayactive = eBayactive;
        return this;
    }

    public void seteBayactive(String eBayactive) {
        this.eBayactive = eBayactive;
    }

    public String getePhotobucket() {
        return ePhotobucket;
    }

    public Sprocket ePhotobucket(String ePhotobucket) {
        this.ePhotobucket = ePhotobucket;
        return this;
    }

    public void setePhotobucket(String ePhotobucket) {
        this.ePhotobucket = ePhotobucket;
    }

    public String getePhotoMain() {
        return ePhotoMain;
    }

    public Sprocket ePhotoMain(String ePhotoMain) {
        this.ePhotoMain = ePhotoMain;
        return this;
    }

    public void setePhotoMain(String ePhotoMain) {
        this.ePhotoMain = ePhotoMain;
    }

    public String getePhotoClear() {
        return ePhotoClear;
    }

    public Sprocket ePhotoClear(String ePhotoClear) {
        this.ePhotoClear = ePhotoClear;
        return this;
    }

    public void setePhotoClear(String ePhotoClear) {
        this.ePhotoClear = ePhotoClear;
    }

    public String getePhotoSide() {
        return ePhotoSide;
    }

    public Sprocket ePhotoSide(String ePhotoSide) {
        this.ePhotoSide = ePhotoSide;
        return this;
    }

    public void setePhotoSide(String ePhotoSide) {
        this.ePhotoSide = ePhotoSide;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public Sprocket salesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
        return this;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public BigDecimal getrRP() {
        return rRP;
    }

    public Sprocket rRP(BigDecimal rRP) {
        this.rRP = rRP;
        return this;
    }

    public void setrRP(BigDecimal rRP) {
        this.rRP = rRP;
    }

    public BigDecimal geteBay() {
        return eBay;
    }

    public Sprocket eBay(BigDecimal eBay) {
        this.eBay = eBay;
        return this;
    }

    public void seteBay(BigDecimal eBay) {
        this.eBay = eBay;
    }

    public BigDecimal getTrade1() {
        return trade1;
    }

    public Sprocket trade1(BigDecimal trade1) {
        this.trade1 = trade1;
        return this;
    }

    public void setTrade1(BigDecimal trade1) {
        this.trade1 = trade1;
    }

    public BigDecimal getTrade2() {
        return trade2;
    }

    public Sprocket trade2(BigDecimal trade2) {
        this.trade2 = trade2;
        return this;
    }

    public void setTrade2(BigDecimal trade2) {
        this.trade2 = trade2;
    }

    public BigDecimal getTrade3() {
        return trade3;
    }

    public Sprocket trade3(BigDecimal trade3) {
        this.trade3 = trade3;
        return this;
    }

    public void setTrade3(BigDecimal trade3) {
        this.trade3 = trade3;
    }

    public String getDistributorNZAUD() {
        return distributorNZAUD;
    }

    public Sprocket distributorNZAUD(String distributorNZAUD) {
        this.distributorNZAUD = distributorNZAUD;
        return this;
    }

    public void setDistributorNZAUD(String distributorNZAUD) {
        this.distributorNZAUD = distributorNZAUD;
    }

    public String getDistributorUSD() {
        return distributorUSD;
    }

    public Sprocket distributorUSD(String distributorUSD) {
        this.distributorUSD = distributorUSD;
        return this;
    }

    public void setDistributorUSD(String distributorUSD) {
        this.distributorUSD = distributorUSD;
    }

    public String getDistributorEUR() {
        return distributorEUR;
    }

    public Sprocket distributorEUR(String distributorEUR) {
        this.distributorEUR = distributorEUR;
        return this;
    }

    public void setDistributorEUR(String distributorEUR) {
        this.distributorEUR = distributorEUR;
    }

    public String getBikemateAUD() {
        return bikemateAUD;
    }

    public Sprocket bikemateAUD(String bikemateAUD) {
        this.bikemateAUD = bikemateAUD;
        return this;
    }

    public void setBikemateAUD(String bikemateAUD) {
        this.bikemateAUD = bikemateAUD;
    }

    public String getCompMetalGear() {
        return compMetalGear;
    }

    public Sprocket compMetalGear(String compMetalGear) {
        this.compMetalGear = compMetalGear;
        return this;
    }

    public void setCompMetalGear(String compMetalGear) {
        this.compMetalGear = compMetalGear;
    }

    public String getCompMogema() {
        return compMogema;
    }

    public Sprocket compMogema(String compMogema) {
        this.compMogema = compMogema;
        return this;
    }

    public void setCompMogema(String compMogema) {
        this.compMogema = compMogema;
    }

    public String getCompJT() {
        return compJT;
    }

    public Sprocket compJT(String compJT) {
        this.compJT = compJT;
        return this;
    }

    public void setCompJT(String compJT) {
        this.compJT = compJT;
    }

    public String getjTBHC() {
        return jTBHC;
    }

    public Sprocket jTBHC(String jTBHC) {
        this.jTBHC = jTBHC;
        return this;
    }

    public void setjTBHC(String jTBHC) {
        this.jTBHC = jTBHC;
    }

    public Long getjTID() {
        return jTID;
    }

    public Sprocket jTID(Long jTID) {
        this.jTID = jTID;
        return this;
    }

    public void setjTID(Long jTID) {
        this.jTID = jTID;
    }

    public Long getjTIDinnerTeeth() {
        return jTIDinnerTeeth;
    }

    public Sprocket jTIDinnerTeeth(Long jTIDinnerTeeth) {
        this.jTIDinnerTeeth = jTIDinnerTeeth;
        return this;
    }

    public void setjTIDinnerTeeth(Long jTIDinnerTeeth) {
        this.jTIDinnerTeeth = jTIDinnerTeeth;
    }

    public String getjTBHQty() {
        return jTBHQty;
    }

    public Sprocket jTBHQty(String jTBHQty) {
        this.jTBHQty = jTBHQty;
        return this;
    }

    public void setjTBHQty(String jTBHQty) {
        this.jTBHQty = jTBHQty;
    }

    public BigDecimal getjTBHSize() {
        return jTBHSize;
    }

    public Sprocket jTBHSize(BigDecimal jTBHSize) {
        this.jTBHSize = jTBHSize;
        return this;
    }

    public void setjTBHSize(BigDecimal jTBHSize) {
        this.jTBHSize = jTBHSize;
    }

    public String getjTBHType() {
        return jTBHType;
    }

    public Sprocket jTBHType(String jTBHType) {
        this.jTBHType = jTBHType;
        return this;
    }

    public void setjTBHType(String jTBHType) {
        this.jTBHType = jTBHType;
    }

    public BigDecimal getjTWidth() {
        return jTWidth;
    }

    public Sprocket jTWidth(BigDecimal jTWidth) {
        this.jTWidth = jTWidth;
        return this;
    }

    public void setjTWidth(BigDecimal jTWidth) {
        this.jTWidth = jTWidth;
    }

    public String getjTNote() {
        return jTNote;
    }

    public Sprocket jTNote(String jTNote) {
        this.jTNote = jTNote;
        return this;
    }

    public void setjTNote(String jTNote) {
        this.jTNote = jTNote;
    }

    public String getCompEsjot() {
        return compEsjot;
    }

    public Sprocket compEsjot(String compEsjot) {
        this.compEsjot = compEsjot;
        return this;
    }

    public void setCompEsjot(String compEsjot) {
        this.compEsjot = compEsjot;
    }

    public String getCompSuperSprox() {
        return compSuperSprox;
    }

    public Sprocket compSuperSprox(String compSuperSprox) {
        this.compSuperSprox = compSuperSprox;
        return this;
    }

    public void setCompSuperSprox(String compSuperSprox) {
        this.compSuperSprox = compSuperSprox;
    }

    public Long getStock() {
        return stock;
    }

    public Sprocket stock(Long stock) {
        this.stock = stock;
        return this;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getMinStock() {
        return minStock;
    }

    public Sprocket minStock(Long minStock) {
        this.minStock = minStock;
        return this;
    }

    public void setMinStock(Long minStock) {
        this.minStock = minStock;
    }

    public Long getMaxStock() {
        return maxStock;
    }

    public Sprocket maxStock(Long maxStock) {
        this.maxStock = maxStock;
        return this;
    }

    public void setMaxStock(Long maxStock) {
        this.maxStock = maxStock;
    }

    public String getSupplier() {
        return supplier;
    }

    public Sprocket supplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public Sprocket supplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
        return this;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCurrency() {
        return supplierCurrency;
    }

    public Sprocket supplierCurrency(String supplierCurrency) {
        this.supplierCurrency = supplierCurrency;
        return this;
    }

    public void setSupplierCurrency(String supplierCurrency) {
        this.supplierCurrency = supplierCurrency;
    }

    public BigDecimal getSupplierCost() {
        return supplierCost;
    }

    public Sprocket supplierCost(BigDecimal supplierCost) {
        this.supplierCost = supplierCost;
        return this;
    }

    public void setSupplierCost(BigDecimal supplierCost) {
        this.supplierCost = supplierCost;
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
        Sprocket sprocket = (Sprocket) o;
        if (sprocket.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sprocket.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Sprocket{" +
            "id=" + getId() +
            ", sku='" + getSku() + "'" +
            ", active='" + getActive() + "'" +
            ", au='" + getAu() + "'" +
            ", de='" + getDe() + "'" +
            ", metalGearvisibility='" + getMetalGearvisibility() + "'" +
            ", bikematevisibility='" + getBikematevisibility() + "'" +
            ", mgiVisibility='" + getMgiVisibility() + "'" +
            ", status='" + getStatus() + "'" +
            ", productGroup1='" + getProductGroup1() + "'" +
            ", productGroup2='" + getProductGroup2() + "'" +
            ", countries='" + getCountries() + "'" +
            ", fitment='" + getFitment() + "'" +
            ", description='" + getDescription() + "'" +
            ", unit='" + getUnit() + "'" +
            ", qty=" + getQty() +
            ", brand='" + getBrand() + "'" +
            ", biketypes='" + getBiketypes() + "'" +
            ", fitsMakes='" + getFitsMakes() + "'" +
            ", modelsupto=" + getModelsupto() +
            ", gS1EAN=" + getgS1EAN() +
            ", ourNotes='" + getOurNotes() + "'" +
            ", customerNotes='" + getCustomerNotes() + "'" +
            ", weightkg=" + getWeightkg() +
            ", packType='" + getPackType() + "'" +
            ", packLength=" + getPackLength() +
            ", packWidth=" + getPackWidth() +
            ", packHeight=" + getPackHeight() +
            ", packCubic=" + getPackCubic() +
            ", sprocketChainSize=" + getSprocketChainSize() +
            ", sprocketTeeth=" + getSprocketTeeth() +
            ", eSBHC='" + geteSBHC() + "'" +
            ", eSID=" + geteSID() +
            ", eSIDinnerTeeth='" + geteSIDinnerTeeth() + "'" +
            ", eSBHQty=" + geteSBHQty() +
            ", eSBHSize='" + geteSBHSize() + "'" +
            ", eSBHType='" + geteSBHType() + "'" +
            ", eSWidth=" + geteSWidth() +
            ", tolistonEbay='" + getTolistonEbay() + "'" +
            ", eListing='" + geteListing() + "'" +
            ", eforMake='" + getEforMake() + "'" +
            ", euploadedNeto='" + getEuploadedNeto() + "'" +
            ", eDate='" + geteDate() + "'" +
            ", echeck='" + getEcheck() + "'" +
            ", euploadedeBay='" + getEuploadedeBay() + "'" +
            ", eBayactive='" + geteBayactive() + "'" +
            ", ePhotobucket='" + getePhotobucket() + "'" +
            ", ePhotoMain='" + getePhotoMain() + "'" +
            ", ePhotoClear='" + getePhotoClear() + "'" +
            ", ePhotoSide='" + getePhotoSide() + "'" +
            ", salesStatus='" + getSalesStatus() + "'" +
            ", rRP=" + getrRP() +
            ", eBay=" + geteBay() +
            ", trade1=" + getTrade1() +
            ", trade2=" + getTrade2() +
            ", trade3=" + getTrade3() +
            ", distributorNZAUD='" + getDistributorNZAUD() + "'" +
            ", distributorUSD='" + getDistributorUSD() + "'" +
            ", distributorEUR='" + getDistributorEUR() + "'" +
            ", bikemateAUD='" + getBikemateAUD() + "'" +
            ", compMetalGear='" + getCompMetalGear() + "'" +
            ", compMogema='" + getCompMogema() + "'" +
            ", compJT='" + getCompJT() + "'" +
            ", jTBHC='" + getjTBHC() + "'" +
            ", jTID=" + getjTID() +
            ", jTIDinnerTeeth=" + getjTIDinnerTeeth() +
            ", jTBHQty='" + getjTBHQty() + "'" +
            ", jTBHSize=" + getjTBHSize() +
            ", jTBHType='" + getjTBHType() + "'" +
            ", jTWidth=" + getjTWidth() +
            ", jTNote='" + getjTNote() + "'" +
            ", compEsjot='" + getCompEsjot() + "'" +
            ", compSuperSprox='" + getCompSuperSprox() + "'" +
            ", stock=" + getStock() +
            ", minStock=" + getMinStock() +
            ", maxStock=" + getMaxStock() +
            ", supplier='" + getSupplier() + "'" +
            ", supplierCode='" + getSupplierCode() + "'" +
            ", supplierCurrency='" + getSupplierCurrency() + "'" +
            ", supplierCost=" + getSupplierCost() +
            "}";
    }
}
