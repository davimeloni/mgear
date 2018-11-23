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
 * A BrakePad.
 */
@Entity
@Table(name = "brake_pad")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BrakePad extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "sku", nullable = false)
    private String sku;

    @Column(name = "au")
    private String au;

    @Column(name = "de")
    private String de;

    @Column(name = "bikemate_visibility")
    private String bikemateVisibility;

    @Column(name = "mgi_visiblity")
    private String mgiVisiblity;

    @Column(name = "active_neto")
    private String activeNeto;

    @Column(name = "status")
    private String status;

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

    @Column(name = "g_s_1_ean")
    private Long gS1EAN;

    @Column(name = "our_notes")
    private String ourNotes;

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

    @Column(name = "caliper")
    private String caliper;

    @Column(name = "alength", precision = 10, scale = 2)
    private BigDecimal alength;

    @Column(name = "awidth", precision = 10, scale = 2)
    private BigDecimal awidth;

    @Column(name = "athickness", precision = 10, scale = 2)
    private BigDecimal athickness;

    @Column(name = "blength", precision = 10, scale = 2)
    private BigDecimal blength;

    @Column(name = "bwidth", precision = 10, scale = 2)
    private BigDecimal bwidth;

    @Column(name = "bthickness", precision = 10, scale = 2)
    private BigDecimal bthickness;

    @Column(name = "customer_notes")
    private String customerNotes;

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

    @Column(name = "ebayactive")
    private String ebayactive;

    @Column(name = "e_photobucket")
    private String ePhotobucket;

    @Column(name = "e_photo_main")
    private String ePhotoMain;

    @Column(name = "e_photo_clear")
    private String ePhotoClear;

    @Column(name = "e_photo_side")
    private String ePhotoSide;

    @Column(name = "sale_status")
    private String saleStatus;

    @Column(name = "r_rp", precision = 10, scale = 2)
    private BigDecimal rRP;

    @Column(name = "e_bay", precision = 10, scale = 2)
    private BigDecimal eBay;

    @Column(name = "e_bc")
    private String eBC;

    @Column(name = "s_bs")
    private String sBS;

    @Column(name = "goldfren")
    private String goldfren;

    @Column(name = "braking")
    private String braking;

    @Column(name = "brembo")
    private String brembo;

    @Column(name = "ferodo")
    private String ferodo;

    @Column(name = "goodridge")
    private String goodridge;

    @Column(name = "premier")
    private String premier;

    @Column(name = "carbon")
    private String carbon;

    @Column(name = "galfer")
    private String galfer;

    @Column(name = "vesrah")
    private String vesrah;

    @Column(name = "lucas")
    private String lucas;

    @Column(name = "new_fren")
    private String newFren;

    @Column(name = "dunlop")
    private String dunlop;

    @Column(name = "lockheed")
    private String lockheed;

    @Column(name = "bendix")
    private String bendix;

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

    public BrakePad sku(String sku) {
        this.sku = sku;
        return this;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getAu() {
        return au;
    }

    public BrakePad au(String au) {
        this.au = au;
        return this;
    }

    public void setAu(String au) {
        this.au = au;
    }

    public String getDe() {
        return de;
    }

    public BrakePad de(String de) {
        this.de = de;
        return this;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getBikemateVisibility() {
        return bikemateVisibility;
    }

    public BrakePad bikemateVisibility(String bikemateVisibility) {
        this.bikemateVisibility = bikemateVisibility;
        return this;
    }

    public void setBikemateVisibility(String bikemateVisibility) {
        this.bikemateVisibility = bikemateVisibility;
    }

    public String getMgiVisiblity() {
        return mgiVisiblity;
    }

    public BrakePad mgiVisiblity(String mgiVisiblity) {
        this.mgiVisiblity = mgiVisiblity;
        return this;
    }

    public void setMgiVisiblity(String mgiVisiblity) {
        this.mgiVisiblity = mgiVisiblity;
    }

    public String getActiveNeto() {
        return activeNeto;
    }

    public BrakePad activeNeto(String activeNeto) {
        this.activeNeto = activeNeto;
        return this;
    }

    public void setActiveNeto(String activeNeto) {
        this.activeNeto = activeNeto;
    }

    public String getStatus() {
        return status;
    }

    public BrakePad status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductGroup1() {
        return productGroup1;
    }

    public BrakePad productGroup1(String productGroup1) {
        this.productGroup1 = productGroup1;
        return this;
    }

    public void setProductGroup1(String productGroup1) {
        this.productGroup1 = productGroup1;
    }

    public String getProductGroup2() {
        return productGroup2;
    }

    public BrakePad productGroup2(String productGroup2) {
        this.productGroup2 = productGroup2;
        return this;
    }

    public void setProductGroup2(String productGroup2) {
        this.productGroup2 = productGroup2;
    }

    public String getFitment() {
        return fitment;
    }

    public BrakePad fitment(String fitment) {
        this.fitment = fitment;
        return this;
    }

    public void setFitment(String fitment) {
        this.fitment = fitment;
    }

    public String getDescription() {
        return description;
    }

    public BrakePad description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public BrakePad unit(String unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getQty() {
        return qty;
    }

    public BrakePad qty(Long qty) {
        this.qty = qty;
        return this;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getBrand() {
        return brand;
    }

    public BrakePad brand(String brand) {
        this.brand = brand;
        return this;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBiketypes() {
        return biketypes;
    }

    public BrakePad biketypes(String biketypes) {
        this.biketypes = biketypes;
        return this;
    }

    public void setBiketypes(String biketypes) {
        this.biketypes = biketypes;
    }

    public String getModels2012on() {
        return models2012on;
    }

    public BrakePad models2012on(String models2012on) {
        this.models2012on = models2012on;
        return this;
    }

    public void setModels2012on(String models2012on) {
        this.models2012on = models2012on;
    }

    public Long getgS1EAN() {
        return gS1EAN;
    }

    public BrakePad gS1EAN(Long gS1EAN) {
        this.gS1EAN = gS1EAN;
        return this;
    }

    public void setgS1EAN(Long gS1EAN) {
        this.gS1EAN = gS1EAN;
    }

    public String getOurNotes() {
        return ourNotes;
    }

    public BrakePad ourNotes(String ourNotes) {
        this.ourNotes = ourNotes;
        return this;
    }

    public void setOurNotes(String ourNotes) {
        this.ourNotes = ourNotes;
    }

    public BigDecimal getWeightkg() {
        return weightkg;
    }

    public BrakePad weightkg(BigDecimal weightkg) {
        this.weightkg = weightkg;
        return this;
    }

    public void setWeightkg(BigDecimal weightkg) {
        this.weightkg = weightkg;
    }

    public String getPackType() {
        return packType;
    }

    public BrakePad packType(String packType) {
        this.packType = packType;
        return this;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public BigDecimal getPackLength() {
        return packLength;
    }

    public BrakePad packLength(BigDecimal packLength) {
        this.packLength = packLength;
        return this;
    }

    public void setPackLength(BigDecimal packLength) {
        this.packLength = packLength;
    }

    public BigDecimal getPackWidth() {
        return packWidth;
    }

    public BrakePad packWidth(BigDecimal packWidth) {
        this.packWidth = packWidth;
        return this;
    }

    public void setPackWidth(BigDecimal packWidth) {
        this.packWidth = packWidth;
    }

    public BigDecimal getPackHeight() {
        return packHeight;
    }

    public BrakePad packHeight(BigDecimal packHeight) {
        this.packHeight = packHeight;
        return this;
    }

    public void setPackHeight(BigDecimal packHeight) {
        this.packHeight = packHeight;
    }

    public BigDecimal getPackCubic() {
        return packCubic;
    }

    public BrakePad packCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
        return this;
    }

    public void setPackCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
    }

    public String getCaliper() {
        return caliper;
    }

    public BrakePad caliper(String caliper) {
        this.caliper = caliper;
        return this;
    }

    public void setCaliper(String caliper) {
        this.caliper = caliper;
    }

    public BigDecimal getAlength() {
        return alength;
    }

    public BrakePad alength(BigDecimal alength) {
        this.alength = alength;
        return this;
    }

    public void setAlength(BigDecimal alength) {
        this.alength = alength;
    }

    public BigDecimal getAwidth() {
        return awidth;
    }

    public BrakePad awidth(BigDecimal awidth) {
        this.awidth = awidth;
        return this;
    }

    public void setAwidth(BigDecimal awidth) {
        this.awidth = awidth;
    }

    public BigDecimal getAthickness() {
        return athickness;
    }

    public BrakePad athickness(BigDecimal athickness) {
        this.athickness = athickness;
        return this;
    }

    public void setAthickness(BigDecimal athickness) {
        this.athickness = athickness;
    }

    public BigDecimal getBlength() {
        return blength;
    }

    public BrakePad blength(BigDecimal blength) {
        this.blength = blength;
        return this;
    }

    public void setBlength(BigDecimal blength) {
        this.blength = blength;
    }

    public BigDecimal getBwidth() {
        return bwidth;
    }

    public BrakePad bwidth(BigDecimal bwidth) {
        this.bwidth = bwidth;
        return this;
    }

    public void setBwidth(BigDecimal bwidth) {
        this.bwidth = bwidth;
    }

    public BigDecimal getBthickness() {
        return bthickness;
    }

    public BrakePad bthickness(BigDecimal bthickness) {
        this.bthickness = bthickness;
        return this;
    }

    public void setBthickness(BigDecimal bthickness) {
        this.bthickness = bthickness;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public BrakePad customerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
        return this;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
    }

    public String geteListing() {
        return eListing;
    }

    public BrakePad eListing(String eListing) {
        this.eListing = eListing;
        return this;
    }

    public void seteListing(String eListing) {
        this.eListing = eListing;
    }

    public String getEforMake() {
        return eforMake;
    }

    public BrakePad eforMake(String eforMake) {
        this.eforMake = eforMake;
        return this;
    }

    public void setEforMake(String eforMake) {
        this.eforMake = eforMake;
    }

    public String getEuploadedNeto() {
        return euploadedNeto;
    }

    public BrakePad euploadedNeto(String euploadedNeto) {
        this.euploadedNeto = euploadedNeto;
        return this;
    }

    public void setEuploadedNeto(String euploadedNeto) {
        this.euploadedNeto = euploadedNeto;
    }

    public LocalDate geteDate() {
        return eDate;
    }

    public BrakePad eDate(LocalDate eDate) {
        this.eDate = eDate;
        return this;
    }

    public void seteDate(LocalDate eDate) {
        this.eDate = eDate;
    }

    public String getEcheck() {
        return echeck;
    }

    public BrakePad echeck(String echeck) {
        this.echeck = echeck;
        return this;
    }

    public void setEcheck(String echeck) {
        this.echeck = echeck;
    }

    public String getEuploadedeBay() {
        return euploadedeBay;
    }

    public BrakePad euploadedeBay(String euploadedeBay) {
        this.euploadedeBay = euploadedeBay;
        return this;
    }

    public void setEuploadedeBay(String euploadedeBay) {
        this.euploadedeBay = euploadedeBay;
    }

    public String getEbayactive() {
        return ebayactive;
    }

    public BrakePad ebayactive(String ebayactive) {
        this.ebayactive = ebayactive;
        return this;
    }

    public void setEbayactive(String ebayactive) {
        this.ebayactive = ebayactive;
    }

    public String getePhotobucket() {
        return ePhotobucket;
    }

    public BrakePad ePhotobucket(String ePhotobucket) {
        this.ePhotobucket = ePhotobucket;
        return this;
    }

    public void setePhotobucket(String ePhotobucket) {
        this.ePhotobucket = ePhotobucket;
    }

    public String getePhotoMain() {
        return ePhotoMain;
    }

    public BrakePad ePhotoMain(String ePhotoMain) {
        this.ePhotoMain = ePhotoMain;
        return this;
    }

    public void setePhotoMain(String ePhotoMain) {
        this.ePhotoMain = ePhotoMain;
    }

    public String getePhotoClear() {
        return ePhotoClear;
    }

    public BrakePad ePhotoClear(String ePhotoClear) {
        this.ePhotoClear = ePhotoClear;
        return this;
    }

    public void setePhotoClear(String ePhotoClear) {
        this.ePhotoClear = ePhotoClear;
    }

    public String getePhotoSide() {
        return ePhotoSide;
    }

    public BrakePad ePhotoSide(String ePhotoSide) {
        this.ePhotoSide = ePhotoSide;
        return this;
    }

    public void setePhotoSide(String ePhotoSide) {
        this.ePhotoSide = ePhotoSide;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public BrakePad saleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
        return this;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public BigDecimal getrRP() {
        return rRP;
    }

    public BrakePad rRP(BigDecimal rRP) {
        this.rRP = rRP;
        return this;
    }

    public void setrRP(BigDecimal rRP) {
        this.rRP = rRP;
    }

    public BigDecimal geteBay() {
        return eBay;
    }

    public BrakePad eBay(BigDecimal eBay) {
        this.eBay = eBay;
        return this;
    }

    public void seteBay(BigDecimal eBay) {
        this.eBay = eBay;
    }

    public String geteBC() {
        return eBC;
    }

    public BrakePad eBC(String eBC) {
        this.eBC = eBC;
        return this;
    }

    public void seteBC(String eBC) {
        this.eBC = eBC;
    }

    public String getsBS() {
        return sBS;
    }

    public BrakePad sBS(String sBS) {
        this.sBS = sBS;
        return this;
    }

    public void setsBS(String sBS) {
        this.sBS = sBS;
    }

    public String getGoldfren() {
        return goldfren;
    }

    public BrakePad goldfren(String goldfren) {
        this.goldfren = goldfren;
        return this;
    }

    public void setGoldfren(String goldfren) {
        this.goldfren = goldfren;
    }

    public String getBraking() {
        return braking;
    }

    public BrakePad braking(String braking) {
        this.braking = braking;
        return this;
    }

    public void setBraking(String braking) {
        this.braking = braking;
    }

    public String getBrembo() {
        return brembo;
    }

    public BrakePad brembo(String brembo) {
        this.brembo = brembo;
        return this;
    }

    public void setBrembo(String brembo) {
        this.brembo = brembo;
    }

    public String getFerodo() {
        return ferodo;
    }

    public BrakePad ferodo(String ferodo) {
        this.ferodo = ferodo;
        return this;
    }

    public void setFerodo(String ferodo) {
        this.ferodo = ferodo;
    }

    public String getGoodridge() {
        return goodridge;
    }

    public BrakePad goodridge(String goodridge) {
        this.goodridge = goodridge;
        return this;
    }

    public void setGoodridge(String goodridge) {
        this.goodridge = goodridge;
    }

    public String getPremier() {
        return premier;
    }

    public BrakePad premier(String premier) {
        this.premier = premier;
        return this;
    }

    public void setPremier(String premier) {
        this.premier = premier;
    }

    public String getCarbon() {
        return carbon;
    }

    public BrakePad carbon(String carbon) {
        this.carbon = carbon;
        return this;
    }

    public void setCarbon(String carbon) {
        this.carbon = carbon;
    }

    public String getGalfer() {
        return galfer;
    }

    public BrakePad galfer(String galfer) {
        this.galfer = galfer;
        return this;
    }

    public void setGalfer(String galfer) {
        this.galfer = galfer;
    }

    public String getVesrah() {
        return vesrah;
    }

    public BrakePad vesrah(String vesrah) {
        this.vesrah = vesrah;
        return this;
    }

    public void setVesrah(String vesrah) {
        this.vesrah = vesrah;
    }

    public String getLucas() {
        return lucas;
    }

    public BrakePad lucas(String lucas) {
        this.lucas = lucas;
        return this;
    }

    public void setLucas(String lucas) {
        this.lucas = lucas;
    }

    public String getNewFren() {
        return newFren;
    }

    public BrakePad newFren(String newFren) {
        this.newFren = newFren;
        return this;
    }

    public void setNewFren(String newFren) {
        this.newFren = newFren;
    }

    public String getDunlop() {
        return dunlop;
    }

    public BrakePad dunlop(String dunlop) {
        this.dunlop = dunlop;
        return this;
    }

    public void setDunlop(String dunlop) {
        this.dunlop = dunlop;
    }

    public String getLockheed() {
        return lockheed;
    }

    public BrakePad lockheed(String lockheed) {
        this.lockheed = lockheed;
        return this;
    }

    public void setLockheed(String lockheed) {
        this.lockheed = lockheed;
    }

    public String getBendix() {
        return bendix;
    }

    public BrakePad bendix(String bendix) {
        this.bendix = bendix;
        return this;
    }

    public void setBendix(String bendix) {
        this.bendix = bendix;
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
        BrakePad brakePad = (BrakePad) o;
        if (brakePad.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), brakePad.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BrakePad{" +
            "id=" + getId() +
            ", sku='" + getSku() + "'" +
            ", au='" + getAu() + "'" +
            ", de='" + getDe() + "'" +
            ", bikemateVisibility='" + getBikemateVisibility() + "'" +
            ", mgiVisiblity='" + getMgiVisiblity() + "'" +
            ", activeNeto='" + getActiveNeto() + "'" +
            ", status='" + getStatus() + "'" +
            ", productGroup1='" + getProductGroup1() + "'" +
            ", productGroup2='" + getProductGroup2() + "'" +
            ", fitment='" + getFitment() + "'" +
            ", description='" + getDescription() + "'" +
            ", unit='" + getUnit() + "'" +
            ", qty=" + getQty() +
            ", brand='" + getBrand() + "'" +
            ", biketypes='" + getBiketypes() + "'" +
            ", models2012on='" + getModels2012on() + "'" +
            ", gS1EAN=" + getgS1EAN() +
            ", ourNotes='" + getOurNotes() + "'" +
            ", weightkg=" + getWeightkg() +
            ", packType='" + getPackType() + "'" +
            ", packLength=" + getPackLength() +
            ", packWidth=" + getPackWidth() +
            ", packHeight=" + getPackHeight() +
            ", packCubic=" + getPackCubic() +
            ", caliper='" + getCaliper() + "'" +
            ", alength=" + getAlength() +
            ", awidth=" + getAwidth() +
            ", athickness=" + getAthickness() +
            ", blength=" + getBlength() +
            ", bwidth=" + getBwidth() +
            ", bthickness=" + getBthickness() +
            ", customerNotes='" + getCustomerNotes() + "'" +
            ", eListing='" + geteListing() + "'" +
            ", eforMake='" + getEforMake() + "'" +
            ", euploadedNeto='" + getEuploadedNeto() + "'" +
            ", eDate='" + geteDate() + "'" +
            ", echeck='" + getEcheck() + "'" +
            ", euploadedeBay='" + getEuploadedeBay() + "'" +
            ", ebayactive='" + getEbayactive() + "'" +
            ", ePhotobucket='" + getePhotobucket() + "'" +
            ", ePhotoMain='" + getePhotoMain() + "'" +
            ", ePhotoClear='" + getePhotoClear() + "'" +
            ", ePhotoSide='" + getePhotoSide() + "'" +
            ", saleStatus='" + getSaleStatus() + "'" +
            ", rRP=" + getrRP() +
            ", eBay=" + geteBay() +
            ", eBC='" + geteBC() + "'" +
            ", sBS='" + getsBS() + "'" +
            ", goldfren='" + getGoldfren() + "'" +
            ", braking='" + getBraking() + "'" +
            ", brembo='" + getBrembo() + "'" +
            ", ferodo='" + getFerodo() + "'" +
            ", goodridge='" + getGoodridge() + "'" +
            ", premier='" + getPremier() + "'" +
            ", carbon='" + getCarbon() + "'" +
            ", galfer='" + getGalfer() + "'" +
            ", vesrah='" + getVesrah() + "'" +
            ", lucas='" + getLucas() + "'" +
            ", newFren='" + getNewFren() + "'" +
            ", dunlop='" + getDunlop() + "'" +
            ", lockheed='" + getLockheed() + "'" +
            ", bendix='" + getBendix() + "'" +
            "}";
    }
}
