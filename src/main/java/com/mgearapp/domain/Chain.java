package com.mgearapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Chain.
 */
@Entity
@Table(name = "chain")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Chain extends AbstractAuditingEntity implements Serializable {

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

    @Column(name = "pack_height", precision = 10, scale = 2)
    private BigDecimal packHeight;

    @Column(name = "pack_width", precision = 10, scale = 2)
    private BigDecimal packWidth;

    @Column(name = "maxcc_dirt")
    private Long maxccDirt;

    @Column(name = "pack_cubic", precision = 10, scale = 2)
    private BigDecimal packCubic;

    @Column(name = "maxcc_street")
    private Long maxccStreet;

    @Column(name = "chain_size")
    private Long chainSize;

    @Column(name = "chain_type")
    private String chainType;

    @Column(name = "chain_links")
    private Long chainLinks;

    @Column(name = "chain_tensile_strength_n")
    private String chainTensileStrengthN;

    @Column(name = "chain_colour")
    private String chainColour;

    @Column(name = "comp_rk")
    private String compRK;

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

    @Column(name = "total_stock")
    private Long totalStock;

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

    @ManyToMany(mappedBy = "chains")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Bike> bikes = new HashSet<>();

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

    public Chain sku(String sku) {
        this.sku = sku;
        return this;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getActive() {
        return active;
    }

    public Chain active(String active) {
        this.active = active;
        return this;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getAu() {
        return au;
    }

    public Chain au(String au) {
        this.au = au;
        return this;
    }

    public void setAu(String au) {
        this.au = au;
    }

    public String getDe() {
        return de;
    }

    public Chain de(String de) {
        this.de = de;
        return this;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getMetalGearvisibility() {
        return metalGearvisibility;
    }

    public Chain metalGearvisibility(String metalGearvisibility) {
        this.metalGearvisibility = metalGearvisibility;
        return this;
    }

    public void setMetalGearvisibility(String metalGearvisibility) {
        this.metalGearvisibility = metalGearvisibility;
    }

    public String getBikematevisibility() {
        return bikematevisibility;
    }

    public Chain bikematevisibility(String bikematevisibility) {
        this.bikematevisibility = bikematevisibility;
        return this;
    }

    public void setBikematevisibility(String bikematevisibility) {
        this.bikematevisibility = bikematevisibility;
    }

    public String getMgiVisibility() {
        return mgiVisibility;
    }

    public Chain mgiVisibility(String mgiVisibility) {
        this.mgiVisibility = mgiVisibility;
        return this;
    }

    public void setMgiVisibility(String mgiVisibility) {
        this.mgiVisibility = mgiVisibility;
    }

    public String getStatus() {
        return status;
    }

    public Chain status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductGroup1() {
        return productGroup1;
    }

    public Chain productGroup1(String productGroup1) {
        this.productGroup1 = productGroup1;
        return this;
    }

    public void setProductGroup1(String productGroup1) {
        this.productGroup1 = productGroup1;
    }

    public String getProductGroup2() {
        return productGroup2;
    }

    public Chain productGroup2(String productGroup2) {
        this.productGroup2 = productGroup2;
        return this;
    }

    public void setProductGroup2(String productGroup2) {
        this.productGroup2 = productGroup2;
    }

    public String getDescription() {
        return description;
    }

    public Chain description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public Chain unit(String unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getQty() {
        return qty;
    }

    public Chain qty(Long qty) {
        this.qty = qty;
        return this;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getBrand() {
        return brand;
    }

    public Chain brand(String brand) {
        this.brand = brand;
        return this;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBiketypes() {
        return biketypes;
    }

    public Chain biketypes(String biketypes) {
        this.biketypes = biketypes;
        return this;
    }

    public void setBiketypes(String biketypes) {
        this.biketypes = biketypes;
    }

    public Long getgS1EAN() {
        return gS1EAN;
    }

    public Chain gS1EAN(Long gS1EAN) {
        this.gS1EAN = gS1EAN;
        return this;
    }

    public void setgS1EAN(Long gS1EAN) {
        this.gS1EAN = gS1EAN;
    }

    public String getOurNotes() {
        return ourNotes;
    }

    public Chain ourNotes(String ourNotes) {
        this.ourNotes = ourNotes;
        return this;
    }

    public void setOurNotes(String ourNotes) {
        this.ourNotes = ourNotes;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public Chain customerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
        return this;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
    }

    public BigDecimal getWeightkg() {
        return weightkg;
    }

    public Chain weightkg(BigDecimal weightkg) {
        this.weightkg = weightkg;
        return this;
    }

    public void setWeightkg(BigDecimal weightkg) {
        this.weightkg = weightkg;
    }

    public String getPackType() {
        return packType;
    }

    public Chain packType(String packType) {
        this.packType = packType;
        return this;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public BigDecimal getPackLength() {
        return packLength;
    }

    public Chain packLength(BigDecimal packLength) {
        this.packLength = packLength;
        return this;
    }

    public void setPackLength(BigDecimal packLength) {
        this.packLength = packLength;
    }

    public BigDecimal getPackHeight() {
        return packHeight;
    }

    public Chain packHeight(BigDecimal packHeight) {
        this.packHeight = packHeight;
        return this;
    }

    public void setPackHeight(BigDecimal packHeight) {
        this.packHeight = packHeight;
    }

    public BigDecimal getPackWidth() {
        return packWidth;
    }

    public Chain packWidth(BigDecimal packWidth) {
        this.packWidth = packWidth;
        return this;
    }

    public void setPackWidth(BigDecimal packWidth) {
        this.packWidth = packWidth;
    }

    public Long getMaxccDirt() {
        return maxccDirt;
    }

    public Chain maxccDirt(Long maxccDirt) {
        this.maxccDirt = maxccDirt;
        return this;
    }

    public void setMaxccDirt(Long maxccDirt) {
        this.maxccDirt = maxccDirt;
    }

    public BigDecimal getPackCubic() {
        return packCubic;
    }

    public Chain packCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
        return this;
    }

    public void setPackCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
    }

    public Long getMaxccStreet() {
        return maxccStreet;
    }

    public Chain maxccStreet(Long maxccStreet) {
        this.maxccStreet = maxccStreet;
        return this;
    }

    public void setMaxccStreet(Long maxccStreet) {
        this.maxccStreet = maxccStreet;
    }

    public Long getChainSize() {
        return chainSize;
    }

    public Chain chainSize(Long chainSize) {
        this.chainSize = chainSize;
        return this;
    }

    public void setChainSize(Long chainSize) {
        this.chainSize = chainSize;
    }

    public String getChainType() {
        return chainType;
    }

    public Chain chainType(String chainType) {
        this.chainType = chainType;
        return this;
    }

    public void setChainType(String chainType) {
        this.chainType = chainType;
    }

    public Long getChainLinks() {
        return chainLinks;
    }

    public Chain chainLinks(Long chainLinks) {
        this.chainLinks = chainLinks;
        return this;
    }

    public void setChainLinks(Long chainLinks) {
        this.chainLinks = chainLinks;
    }

    public String getChainTensileStrengthN() {
        return chainTensileStrengthN;
    }

    public Chain chainTensileStrengthN(String chainTensileStrengthN) {
        this.chainTensileStrengthN = chainTensileStrengthN;
        return this;
    }

    public void setChainTensileStrengthN(String chainTensileStrengthN) {
        this.chainTensileStrengthN = chainTensileStrengthN;
    }

    public String getChainColour() {
        return chainColour;
    }

    public Chain chainColour(String chainColour) {
        this.chainColour = chainColour;
        return this;
    }

    public void setChainColour(String chainColour) {
        this.chainColour = chainColour;
    }

    public String getCompRK() {
        return compRK;
    }

    public Chain compRK(String compRK) {
        this.compRK = compRK;
        return this;
    }

    public void setCompRK(String compRK) {
        this.compRK = compRK;
    }

    public String geteListing() {
        return eListing;
    }

    public Chain eListing(String eListing) {
        this.eListing = eListing;
        return this;
    }

    public void seteListing(String eListing) {
        this.eListing = eListing;
    }

    public String getEforMake() {
        return eforMake;
    }

    public Chain eforMake(String eforMake) {
        this.eforMake = eforMake;
        return this;
    }

    public void setEforMake(String eforMake) {
        this.eforMake = eforMake;
    }

    public String getEuploadedNeto() {
        return euploadedNeto;
    }

    public Chain euploadedNeto(String euploadedNeto) {
        this.euploadedNeto = euploadedNeto;
        return this;
    }

    public void setEuploadedNeto(String euploadedNeto) {
        this.euploadedNeto = euploadedNeto;
    }

    public LocalDate geteDate() {
        return eDate;
    }

    public Chain eDate(LocalDate eDate) {
        this.eDate = eDate;
        return this;
    }

    public void seteDate(LocalDate eDate) {
        this.eDate = eDate;
    }

    public String getEcheck() {
        return echeck;
    }

    public Chain echeck(String echeck) {
        this.echeck = echeck;
        return this;
    }

    public void setEcheck(String echeck) {
        this.echeck = echeck;
    }

    public String getEuploadedeBay() {
        return euploadedeBay;
    }

    public Chain euploadedeBay(String euploadedeBay) {
        this.euploadedeBay = euploadedeBay;
        return this;
    }

    public void setEuploadedeBay(String euploadedeBay) {
        this.euploadedeBay = euploadedeBay;
    }

    public String geteBayactive() {
        return eBayactive;
    }

    public Chain eBayactive(String eBayactive) {
        this.eBayactive = eBayactive;
        return this;
    }

    public void seteBayactive(String eBayactive) {
        this.eBayactive = eBayactive;
    }

    public String getePhotobucket() {
        return ePhotobucket;
    }

    public Chain ePhotobucket(String ePhotobucket) {
        this.ePhotobucket = ePhotobucket;
        return this;
    }

    public void setePhotobucket(String ePhotobucket) {
        this.ePhotobucket = ePhotobucket;
    }

    public String getePhotoMain() {
        return ePhotoMain;
    }

    public Chain ePhotoMain(String ePhotoMain) {
        this.ePhotoMain = ePhotoMain;
        return this;
    }

    public void setePhotoMain(String ePhotoMain) {
        this.ePhotoMain = ePhotoMain;
    }

    public String getePhotoClear() {
        return ePhotoClear;
    }

    public Chain ePhotoClear(String ePhotoClear) {
        this.ePhotoClear = ePhotoClear;
        return this;
    }

    public void setePhotoClear(String ePhotoClear) {
        this.ePhotoClear = ePhotoClear;
    }

    public String getePhotoSide() {
        return ePhotoSide;
    }

    public Chain ePhotoSide(String ePhotoSide) {
        this.ePhotoSide = ePhotoSide;
        return this;
    }

    public void setePhotoSide(String ePhotoSide) {
        this.ePhotoSide = ePhotoSide;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public Chain salesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
        return this;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public BigDecimal getrRP() {
        return rRP;
    }

    public Chain rRP(BigDecimal rRP) {
        this.rRP = rRP;
        return this;
    }

    public void setrRP(BigDecimal rRP) {
        this.rRP = rRP;
    }

    public BigDecimal geteBay() {
        return eBay;
    }

    public Chain eBay(BigDecimal eBay) {
        this.eBay = eBay;
        return this;
    }

    public void seteBay(BigDecimal eBay) {
        this.eBay = eBay;
    }

    public BigDecimal getTrade1() {
        return trade1;
    }

    public Chain trade1(BigDecimal trade1) {
        this.trade1 = trade1;
        return this;
    }

    public void setTrade1(BigDecimal trade1) {
        this.trade1 = trade1;
    }

    public BigDecimal getTrade2() {
        return trade2;
    }

    public Chain trade2(BigDecimal trade2) {
        this.trade2 = trade2;
        return this;
    }

    public void setTrade2(BigDecimal trade2) {
        this.trade2 = trade2;
    }

    public BigDecimal getTrade3() {
        return trade3;
    }

    public Chain trade3(BigDecimal trade3) {
        this.trade3 = trade3;
        return this;
    }

    public void setTrade3(BigDecimal trade3) {
        this.trade3 = trade3;
    }

    public String getDistributorNZAUD() {
        return distributorNZAUD;
    }

    public Chain distributorNZAUD(String distributorNZAUD) {
        this.distributorNZAUD = distributorNZAUD;
        return this;
    }

    public void setDistributorNZAUD(String distributorNZAUD) {
        this.distributorNZAUD = distributorNZAUD;
    }

    public String getDistributorUSD() {
        return distributorUSD;
    }

    public Chain distributorUSD(String distributorUSD) {
        this.distributorUSD = distributorUSD;
        return this;
    }

    public void setDistributorUSD(String distributorUSD) {
        this.distributorUSD = distributorUSD;
    }

    public String getDistributorEUR() {
        return distributorEUR;
    }

    public Chain distributorEUR(String distributorEUR) {
        this.distributorEUR = distributorEUR;
        return this;
    }

    public void setDistributorEUR(String distributorEUR) {
        this.distributorEUR = distributorEUR;
    }

    public Long getTotalStock() {
        return totalStock;
    }

    public Chain totalStock(Long totalStock) {
        this.totalStock = totalStock;
        return this;
    }

    public void setTotalStock(Long totalStock) {
        this.totalStock = totalStock;
    }

    public Long getMinStock() {
        return minStock;
    }

    public Chain minStock(Long minStock) {
        this.minStock = minStock;
        return this;
    }

    public void setMinStock(Long minStock) {
        this.minStock = minStock;
    }

    public Long getMaxStock() {
        return maxStock;
    }

    public Chain maxStock(Long maxStock) {
        this.maxStock = maxStock;
        return this;
    }

    public void setMaxStock(Long maxStock) {
        this.maxStock = maxStock;
    }

    public String getSupplier() {
        return supplier;
    }

    public Chain supplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public Chain supplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
        return this;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCurrency() {
        return supplierCurrency;
    }

    public Chain supplierCurrency(String supplierCurrency) {
        this.supplierCurrency = supplierCurrency;
        return this;
    }

    public void setSupplierCurrency(String supplierCurrency) {
        this.supplierCurrency = supplierCurrency;
    }

    public BigDecimal getSupplierCost() {
        return supplierCost;
    }

    public Chain supplierCost(BigDecimal supplierCost) {
        this.supplierCost = supplierCost;
        return this;
    }

    public void setSupplierCost(BigDecimal supplierCost) {
        this.supplierCost = supplierCost;
    }

    public Set<Bike> getBikes() {
        return bikes;
    }

    public Chain bikes(Set<Bike> bikes) {
        this.bikes = bikes;
        return this;
    }

    public Chain addBike(Bike bike) {
        this.bikes.add(bike);
        bike.getChains().add(this);
        return this;
    }

    public Chain removeBike(Bike bike) {
        this.bikes.remove(bike);
        bike.getChains().remove(this);
        return this;
    }

    public void setBikes(Set<Bike> bikes) {
        this.bikes = bikes;
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
        Chain chain = (Chain) o;
        if (chain.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), chain.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Chain{" +
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
