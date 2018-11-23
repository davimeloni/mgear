package com.mgearapp.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the BrakePad entity.
 */
public class BrakePadDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private String sku;

    private String au;

    private String de;

    private String bikemateVisibility;

    private String mgiVisiblity;

    private String activeNeto;

    private String status;

    private String productGroup1;

    private String productGroup2;

    private String fitment;

    private String description;

    private String unit;

    private Long qty;

    private String brand;

    private String biketypes;

    private String models2012on;

    private Long gS1EAN;

    private String ourNotes;

    private BigDecimal weightkg;

    private String packType;

    private BigDecimal packLength;

    private BigDecimal packWidth;

    private BigDecimal packHeight;

    private BigDecimal packCubic;

    private String caliper;

    private BigDecimal alength;

    private BigDecimal awidth;

    private BigDecimal athickness;

    private BigDecimal blength;

    private BigDecimal bwidth;

    private BigDecimal bthickness;

    private String customerNotes;

    private String eListing;

    private String eforMake;

    private String euploadedNeto;

    private LocalDate eDate;

    private String echeck;

    private String euploadedeBay;

    private String ebayactive;

    private String ePhotobucket;

    private String ePhotoMain;

    private String ePhotoClear;

    private String ePhotoSide;

    private String saleStatus;

    private BigDecimal rRP;

    private BigDecimal eBay;

    private String eBC;

    private String sBS;

    private String goldfren;

    private String braking;

    private String brembo;

    private String ferodo;

    private String goodridge;

    private String premier;

    private String carbon;

    private String galfer;

    private String vesrah;

    private String lucas;

    private String newFren;

    private String dunlop;

    private String lockheed;

    private String bendix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getAu() {
        return au;
    }

    public void setAu(String au) {
        this.au = au;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getBikemateVisibility() {
        return bikemateVisibility;
    }

    public void setBikemateVisibility(String bikemateVisibility) {
        this.bikemateVisibility = bikemateVisibility;
    }

    public String getMgiVisiblity() {
        return mgiVisiblity;
    }

    public void setMgiVisiblity(String mgiVisiblity) {
        this.mgiVisiblity = mgiVisiblity;
    }

    public String getActiveNeto() {
        return activeNeto;
    }

    public void setActiveNeto(String activeNeto) {
        this.activeNeto = activeNeto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductGroup1() {
        return productGroup1;
    }

    public void setProductGroup1(String productGroup1) {
        this.productGroup1 = productGroup1;
    }

    public String getProductGroup2() {
        return productGroup2;
    }

    public void setProductGroup2(String productGroup2) {
        this.productGroup2 = productGroup2;
    }

    public String getFitment() {
        return fitment;
    }

    public void setFitment(String fitment) {
        this.fitment = fitment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBiketypes() {
        return biketypes;
    }

    public void setBiketypes(String biketypes) {
        this.biketypes = biketypes;
    }

    public String getModels2012on() {
        return models2012on;
    }

    public void setModels2012on(String models2012on) {
        this.models2012on = models2012on;
    }

    public Long getgS1EAN() {
        return gS1EAN;
    }

    public void setgS1EAN(Long gS1EAN) {
        this.gS1EAN = gS1EAN;
    }

    public String getOurNotes() {
        return ourNotes;
    }

    public void setOurNotes(String ourNotes) {
        this.ourNotes = ourNotes;
    }

    public BigDecimal getWeightkg() {
        return weightkg;
    }

    public void setWeightkg(BigDecimal weightkg) {
        this.weightkg = weightkg;
    }

    public String getPackType() {
        return packType;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public BigDecimal getPackLength() {
        return packLength;
    }

    public void setPackLength(BigDecimal packLength) {
        this.packLength = packLength;
    }

    public BigDecimal getPackWidth() {
        return packWidth;
    }

    public void setPackWidth(BigDecimal packWidth) {
        this.packWidth = packWidth;
    }

    public BigDecimal getPackHeight() {
        return packHeight;
    }

    public void setPackHeight(BigDecimal packHeight) {
        this.packHeight = packHeight;
    }

    public BigDecimal getPackCubic() {
        return packCubic;
    }

    public void setPackCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
    }

    public String getCaliper() {
        return caliper;
    }

    public void setCaliper(String caliper) {
        this.caliper = caliper;
    }

    public BigDecimal getAlength() {
        return alength;
    }

    public void setAlength(BigDecimal alength) {
        this.alength = alength;
    }

    public BigDecimal getAwidth() {
        return awidth;
    }

    public void setAwidth(BigDecimal awidth) {
        this.awidth = awidth;
    }

    public BigDecimal getAthickness() {
        return athickness;
    }

    public void setAthickness(BigDecimal athickness) {
        this.athickness = athickness;
    }

    public BigDecimal getBlength() {
        return blength;
    }

    public void setBlength(BigDecimal blength) {
        this.blength = blength;
    }

    public BigDecimal getBwidth() {
        return bwidth;
    }

    public void setBwidth(BigDecimal bwidth) {
        this.bwidth = bwidth;
    }

    public BigDecimal getBthickness() {
        return bthickness;
    }

    public void setBthickness(BigDecimal bthickness) {
        this.bthickness = bthickness;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
    }

    public String geteListing() {
        return eListing;
    }

    public void seteListing(String eListing) {
        this.eListing = eListing;
    }

    public String getEforMake() {
        return eforMake;
    }

    public void setEforMake(String eforMake) {
        this.eforMake = eforMake;
    }

    public String getEuploadedNeto() {
        return euploadedNeto;
    }

    public void setEuploadedNeto(String euploadedNeto) {
        this.euploadedNeto = euploadedNeto;
    }

    public LocalDate geteDate() {
        return eDate;
    }

    public void seteDate(LocalDate eDate) {
        this.eDate = eDate;
    }

    public String getEcheck() {
        return echeck;
    }

    public void setEcheck(String echeck) {
        this.echeck = echeck;
    }

    public String getEuploadedeBay() {
        return euploadedeBay;
    }

    public void setEuploadedeBay(String euploadedeBay) {
        this.euploadedeBay = euploadedeBay;
    }

    public String getEbayactive() {
        return ebayactive;
    }

    public void setEbayactive(String ebayactive) {
        this.ebayactive = ebayactive;
    }

    public String getePhotobucket() {
        return ePhotobucket;
    }

    public void setePhotobucket(String ePhotobucket) {
        this.ePhotobucket = ePhotobucket;
    }

    public String getePhotoMain() {
        return ePhotoMain;
    }

    public void setePhotoMain(String ePhotoMain) {
        this.ePhotoMain = ePhotoMain;
    }

    public String getePhotoClear() {
        return ePhotoClear;
    }

    public void setePhotoClear(String ePhotoClear) {
        this.ePhotoClear = ePhotoClear;
    }

    public String getePhotoSide() {
        return ePhotoSide;
    }

    public void setePhotoSide(String ePhotoSide) {
        this.ePhotoSide = ePhotoSide;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public BigDecimal getrRP() {
        return rRP;
    }

    public void setrRP(BigDecimal rRP) {
        this.rRP = rRP;
    }

    public BigDecimal geteBay() {
        return eBay;
    }

    public void seteBay(BigDecimal eBay) {
        this.eBay = eBay;
    }

    public String geteBC() {
        return eBC;
    }

    public void seteBC(String eBC) {
        this.eBC = eBC;
    }

    public String getsBS() {
        return sBS;
    }

    public void setsBS(String sBS) {
        this.sBS = sBS;
    }

    public String getGoldfren() {
        return goldfren;
    }

    public void setGoldfren(String goldfren) {
        this.goldfren = goldfren;
    }

    public String getBraking() {
        return braking;
    }

    public void setBraking(String braking) {
        this.braking = braking;
    }

    public String getBrembo() {
        return brembo;
    }

    public void setBrembo(String brembo) {
        this.brembo = brembo;
    }

    public String getFerodo() {
        return ferodo;
    }

    public void setFerodo(String ferodo) {
        this.ferodo = ferodo;
    }

    public String getGoodridge() {
        return goodridge;
    }

    public void setGoodridge(String goodridge) {
        this.goodridge = goodridge;
    }

    public String getPremier() {
        return premier;
    }

    public void setPremier(String premier) {
        this.premier = premier;
    }

    public String getCarbon() {
        return carbon;
    }

    public void setCarbon(String carbon) {
        this.carbon = carbon;
    }

    public String getGalfer() {
        return galfer;
    }

    public void setGalfer(String galfer) {
        this.galfer = galfer;
    }

    public String getVesrah() {
        return vesrah;
    }

    public void setVesrah(String vesrah) {
        this.vesrah = vesrah;
    }

    public String getLucas() {
        return lucas;
    }

    public void setLucas(String lucas) {
        this.lucas = lucas;
    }

    public String getNewFren() {
        return newFren;
    }

    public void setNewFren(String newFren) {
        this.newFren = newFren;
    }

    public String getDunlop() {
        return dunlop;
    }

    public void setDunlop(String dunlop) {
        this.dunlop = dunlop;
    }

    public String getLockheed() {
        return lockheed;
    }

    public void setLockheed(String lockheed) {
        this.lockheed = lockheed;
    }

    public String getBendix() {
        return bendix;
    }

    public void setBendix(String bendix) {
        this.bendix = bendix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BrakePadDTO brakePadDTO = (BrakePadDTO) o;
        if (brakePadDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), brakePadDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BrakePadDTO{" +
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
