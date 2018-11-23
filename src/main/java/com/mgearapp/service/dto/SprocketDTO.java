package com.mgearapp.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the Sprocket entity.
 */
public class SprocketDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    private String sku;

    private String active;

    private String au;

    private String de;

    private String metalGearvisibility;

    private String bikematevisibility;

    private String mgiVisibility;

    private String status;

    private String productGroup1;

    private String productGroup2;

    private String countries;

    private String fitment;

    private String description;

    private String unit;

    private Long qty;

    private String brand;

    private String biketypes;

    private String fitsMakes;

    private Long modelsupto;

    private Long gS1EAN;

    private String ourNotes;

    private String customerNotes;

    private BigDecimal weightkg;

    private String packType;

    private BigDecimal packLength;

    private BigDecimal packWidth;

    private BigDecimal packHeight;

    private BigDecimal packCubic;

    private Long sprocketChainSize;

    private Long sprocketTeeth;

    private String eSBHC;

    private Long eSID;

    private String eSIDinnerTeeth;

    private Long eSBHQty;

    private String eSBHSize;

    private String eSBHType;

    private BigDecimal eSWidth;

    private String tolistonEbay;

    private String eListing;

    private String eforMake;

    private String euploadedNeto;

    private LocalDate eDate;

    private String echeck;

    private String euploadedeBay;

    private String eBayactive;

    private String ePhotobucket;

    private String ePhotoMain;

    private String ePhotoClear;

    private String ePhotoSide;

    private String salesStatus;

    private BigDecimal rRP;

    private BigDecimal eBay;

    private BigDecimal trade1;

    private BigDecimal trade2;

    private BigDecimal trade3;

    private String distributorNZAUD;

    private String distributorUSD;

    private String distributorEUR;

    private String bikemateAUD;

    private String compMetalGear;

    private String compMogema;

    private String compJT;

    private String jTBHC;

    private Long jTID;

    private Long jTIDinnerTeeth;

    private String jTBHQty;

    private BigDecimal jTBHSize;

    private String jTBHType;

    private BigDecimal jTWidth;

    private String jTNote;

    private String compEsjot;

    private String compSuperSprox;

    private Long stock;

    private Long minStock;

    private Long maxStock;

    private String supplier;

    private String supplierCode;

    private String supplierCurrency;

    private BigDecimal supplierCost;

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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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

    public String getMetalGearvisibility() {
        return metalGearvisibility;
    }

    public void setMetalGearvisibility(String metalGearvisibility) {
        this.metalGearvisibility = metalGearvisibility;
    }

    public String getBikematevisibility() {
        return bikematevisibility;
    }

    public void setBikematevisibility(String bikematevisibility) {
        this.bikematevisibility = bikematevisibility;
    }

    public String getMgiVisibility() {
        return mgiVisibility;
    }

    public void setMgiVisibility(String mgiVisibility) {
        this.mgiVisibility = mgiVisibility;
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

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
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

    public String getFitsMakes() {
        return fitsMakes;
    }

    public void setFitsMakes(String fitsMakes) {
        this.fitsMakes = fitsMakes;
    }

    public Long getModelsupto() {
        return modelsupto;
    }

    public void setModelsupto(Long modelsupto) {
        this.modelsupto = modelsupto;
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

    public String getCustomerNotes() {
        return customerNotes;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
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

    public Long getSprocketChainSize() {
        return sprocketChainSize;
    }

    public void setSprocketChainSize(Long sprocketChainSize) {
        this.sprocketChainSize = sprocketChainSize;
    }

    public Long getSprocketTeeth() {
        return sprocketTeeth;
    }

    public void setSprocketTeeth(Long sprocketTeeth) {
        this.sprocketTeeth = sprocketTeeth;
    }

    public String geteSBHC() {
        return eSBHC;
    }

    public void seteSBHC(String eSBHC) {
        this.eSBHC = eSBHC;
    }

    public Long geteSID() {
        return eSID;
    }

    public void seteSID(Long eSID) {
        this.eSID = eSID;
    }

    public String geteSIDinnerTeeth() {
        return eSIDinnerTeeth;
    }

    public void seteSIDinnerTeeth(String eSIDinnerTeeth) {
        this.eSIDinnerTeeth = eSIDinnerTeeth;
    }

    public Long geteSBHQty() {
        return eSBHQty;
    }

    public void seteSBHQty(Long eSBHQty) {
        this.eSBHQty = eSBHQty;
    }

    public String geteSBHSize() {
        return eSBHSize;
    }

    public void seteSBHSize(String eSBHSize) {
        this.eSBHSize = eSBHSize;
    }

    public String geteSBHType() {
        return eSBHType;
    }

    public void seteSBHType(String eSBHType) {
        this.eSBHType = eSBHType;
    }

    public BigDecimal geteSWidth() {
        return eSWidth;
    }

    public void seteSWidth(BigDecimal eSWidth) {
        this.eSWidth = eSWidth;
    }

    public String getTolistonEbay() {
        return tolistonEbay;
    }

    public void setTolistonEbay(String tolistonEbay) {
        this.tolistonEbay = tolistonEbay;
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

    public String geteBayactive() {
        return eBayactive;
    }

    public void seteBayactive(String eBayactive) {
        this.eBayactive = eBayactive;
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

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
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

    public BigDecimal getTrade1() {
        return trade1;
    }

    public void setTrade1(BigDecimal trade1) {
        this.trade1 = trade1;
    }

    public BigDecimal getTrade2() {
        return trade2;
    }

    public void setTrade2(BigDecimal trade2) {
        this.trade2 = trade2;
    }

    public BigDecimal getTrade3() {
        return trade3;
    }

    public void setTrade3(BigDecimal trade3) {
        this.trade3 = trade3;
    }

    public String getDistributorNZAUD() {
        return distributorNZAUD;
    }

    public void setDistributorNZAUD(String distributorNZAUD) {
        this.distributorNZAUD = distributorNZAUD;
    }

    public String getDistributorUSD() {
        return distributorUSD;
    }

    public void setDistributorUSD(String distributorUSD) {
        this.distributorUSD = distributorUSD;
    }

    public String getDistributorEUR() {
        return distributorEUR;
    }

    public void setDistributorEUR(String distributorEUR) {
        this.distributorEUR = distributorEUR;
    }

    public String getBikemateAUD() {
        return bikemateAUD;
    }

    public void setBikemateAUD(String bikemateAUD) {
        this.bikemateAUD = bikemateAUD;
    }

    public String getCompMetalGear() {
        return compMetalGear;
    }

    public void setCompMetalGear(String compMetalGear) {
        this.compMetalGear = compMetalGear;
    }

    public String getCompMogema() {
        return compMogema;
    }

    public void setCompMogema(String compMogema) {
        this.compMogema = compMogema;
    }

    public String getCompJT() {
        return compJT;
    }

    public void setCompJT(String compJT) {
        this.compJT = compJT;
    }

    public String getjTBHC() {
        return jTBHC;
    }

    public void setjTBHC(String jTBHC) {
        this.jTBHC = jTBHC;
    }

    public Long getjTID() {
        return jTID;
    }

    public void setjTID(Long jTID) {
        this.jTID = jTID;
    }

    public Long getjTIDinnerTeeth() {
        return jTIDinnerTeeth;
    }

    public void setjTIDinnerTeeth(Long jTIDinnerTeeth) {
        this.jTIDinnerTeeth = jTIDinnerTeeth;
    }

    public String getjTBHQty() {
        return jTBHQty;
    }

    public void setjTBHQty(String jTBHQty) {
        this.jTBHQty = jTBHQty;
    }

    public BigDecimal getjTBHSize() {
        return jTBHSize;
    }

    public void setjTBHSize(BigDecimal jTBHSize) {
        this.jTBHSize = jTBHSize;
    }

    public String getjTBHType() {
        return jTBHType;
    }

    public void setjTBHType(String jTBHType) {
        this.jTBHType = jTBHType;
    }

    public BigDecimal getjTWidth() {
        return jTWidth;
    }

    public void setjTWidth(BigDecimal jTWidth) {
        this.jTWidth = jTWidth;
    }

    public String getjTNote() {
        return jTNote;
    }

    public void setjTNote(String jTNote) {
        this.jTNote = jTNote;
    }

    public String getCompEsjot() {
        return compEsjot;
    }

    public void setCompEsjot(String compEsjot) {
        this.compEsjot = compEsjot;
    }

    public String getCompSuperSprox() {
        return compSuperSprox;
    }

    public void setCompSuperSprox(String compSuperSprox) {
        this.compSuperSprox = compSuperSprox;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getMinStock() {
        return minStock;
    }

    public void setMinStock(Long minStock) {
        this.minStock = minStock;
    }

    public Long getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Long maxStock) {
        this.maxStock = maxStock;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCurrency() {
        return supplierCurrency;
    }

    public void setSupplierCurrency(String supplierCurrency) {
        this.supplierCurrency = supplierCurrency;
    }

    public BigDecimal getSupplierCost() {
        return supplierCost;
    }

    public void setSupplierCost(BigDecimal supplierCost) {
        this.supplierCost = supplierCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SprocketDTO sprocketDTO = (SprocketDTO) o;
        if (sprocketDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sprocketDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SprocketDTO{" +
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
