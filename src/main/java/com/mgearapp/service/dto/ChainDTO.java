package com.mgearapp.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the Chain entity.
 */
public class ChainDTO extends AbstractAuditingDTO implements Serializable {

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

    private String description;

    private String unit;

    private Long qty;

    private String brand;

    private String biketypes;

    private Long gS1EAN;

    private String ourNotes;

    private String customerNotes;

    private BigDecimal weightkg;

    private String packType;

    private BigDecimal packLength;

    private BigDecimal packHeight;

    private BigDecimal packWidth;

    private Long maxccDirt;

    private BigDecimal packCubic;

    private Long maxccStreet;

    private Long chainSize;

    private String chainType;

    private Long chainLinks;

    private String chainTensileStrengthN;

    private String chainColour;

    private String compRK;

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

    private Long totalStock;

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

    public BigDecimal getPackHeight() {
        return packHeight;
    }

    public void setPackHeight(BigDecimal packHeight) {
        this.packHeight = packHeight;
    }

    public BigDecimal getPackWidth() {
        return packWidth;
    }

    public void setPackWidth(BigDecimal packWidth) {
        this.packWidth = packWidth;
    }

    public Long getMaxccDirt() {
        return maxccDirt;
    }

    public void setMaxccDirt(Long maxccDirt) {
        this.maxccDirt = maxccDirt;
    }

    public BigDecimal getPackCubic() {
        return packCubic;
    }

    public void setPackCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
    }

    public Long getMaxccStreet() {
        return maxccStreet;
    }

    public void setMaxccStreet(Long maxccStreet) {
        this.maxccStreet = maxccStreet;
    }

    public Long getChainSize() {
        return chainSize;
    }

    public void setChainSize(Long chainSize) {
        this.chainSize = chainSize;
    }

    public String getChainType() {
        return chainType;
    }

    public void setChainType(String chainType) {
        this.chainType = chainType;
    }

    public Long getChainLinks() {
        return chainLinks;
    }

    public void setChainLinks(Long chainLinks) {
        this.chainLinks = chainLinks;
    }

    public String getChainTensileStrengthN() {
        return chainTensileStrengthN;
    }

    public void setChainTensileStrengthN(String chainTensileStrengthN) {
        this.chainTensileStrengthN = chainTensileStrengthN;
    }

    public String getChainColour() {
        return chainColour;
    }

    public void setChainColour(String chainColour) {
        this.chainColour = chainColour;
    }

    public String getCompRK() {
        return compRK;
    }

    public void setCompRK(String compRK) {
        this.compRK = compRK;
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

    public Long getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Long totalStock) {
        this.totalStock = totalStock;
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

        ChainDTO chainDTO = (ChainDTO) o;
        if (chainDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), chainDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ChainDTO{" +
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
            ", description='" + getDescription() + "'" +
            ", unit='" + getUnit() + "'" +
            ", qty=" + getQty() +
            ", brand='" + getBrand() + "'" +
            ", biketypes='" + getBiketypes() + "'" +
            ", gS1EAN=" + getgS1EAN() +
            ", ourNotes='" + getOurNotes() + "'" +
            ", customerNotes='" + getCustomerNotes() + "'" +
            ", weightkg=" + getWeightkg() +
            ", packType='" + getPackType() + "'" +
            ", packLength=" + getPackLength() +
            ", packHeight=" + getPackHeight() +
            ", packWidth=" + getPackWidth() +
            ", maxccDirt=" + getMaxccDirt() +
            ", packCubic=" + getPackCubic() +
            ", maxccStreet=" + getMaxccStreet() +
            ", chainSize=" + getChainSize() +
            ", chainType='" + getChainType() + "'" +
            ", chainLinks=" + getChainLinks() +
            ", chainTensileStrengthN='" + getChainTensileStrengthN() + "'" +
            ", chainColour='" + getChainColour() + "'" +
            ", compRK='" + getCompRK() + "'" +
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
            ", totalStock=" + getTotalStock() +
            ", minStock=" + getMinStock() +
            ", maxStock=" + getMaxStock() +
            ", supplier='" + getSupplier() + "'" +
            ", supplierCode='" + getSupplierCode() + "'" +
            ", supplierCurrency='" + getSupplierCurrency() + "'" +
            ", supplierCost=" + getSupplierCost() +
            "}";
    }
}
