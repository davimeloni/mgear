package com.mgearapp.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the BrakeDisc entity.
 */
public class BrakeDiscDTO extends AbstractAuditingDTO implements Serializable {

    private Long id;

    @NotNull
    private String sku;

    private String active;

    private String au;

    private String de;

    private String metalGearvisibility;

    private String bikematevisibility;

    private String mgiVisibility;

    private String discStatus;

    private String productGroup1;

    private String productGroup2;

    private String fitment;

    private String description;

    private String unit;

    private Long qty;

    private String brand;

    private String biketypes;

    private String models2012on;

    private Long gS1EANNo;

    private String ourNotes;

    private BigDecimal weight;

    private String packType;

    private BigDecimal packLength;

    private BigDecimal packHeight;

    private BigDecimal packWidth;

    private BigDecimal packCubic;

    private Long oD;

    private String bHC;

    private Long bHQty;

    private BigDecimal bHSize;

    private BigDecimal bHOD;

    private BigDecimal bHStep;

    private String bHType;

    private BigDecimal thickness;

    private BigDecimal thicknessMin;

    private BigDecimal offset;

    private BigDecimal brakeAreawidth;

    private String tUVLHC;

    private String customerNotes;

    private String eListing;

    private String eforMake;

    private LocalDate eDate;

    private String euploadedNeto;

    private String echeck;

    private String euploadedeBay;

    private String ebayactive;

    private String ePhotobucket;

    private String ePhoto1;

    private String ePhoto2;

    private String ePhoto3;

    private String saleStatus;

    private BigDecimal rRP;

    private BigDecimal trade1;

    private BigDecimal eBAY;

    private BigDecimal trade2;

    private BigDecimal trade3;

    private BigDecimal distributorNZAUD;

    private BigDecimal distributorEUR;

    private BigDecimal distributorUSD;

    private String sPriority;

    private String samplefrom;

    private String requestedfrom;

    private LocalDate date;

    private String received;

    private String camefrom;

    private String paidfor;

    private String sentto;

    private Long shipNo;

    private LocalDate datesent;

    private String samplereturn;

    private String make;

    private String model;

    private String year;

    private String sampleFitment;

    private String oEM;

    private String notesforProduction;

    private String productionCode;

    private LocalDate hAPapproved;

    private LocalDate sHAapproved;

    private String approvedby;

    private String notestoDrawing;

    private String filename;

    private BigDecimal cOSTUSD;

    private String centrecolour;

    private String laser;

    private Long qTY1;

    private BigDecimal uSD;

    private String completeProduction;

    private String ourNotetoProduction;

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

    public String getDiscStatus() {
        return discStatus;
    }

    public void setDiscStatus(String discStatus) {
        this.discStatus = discStatus;
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

    public Long getgS1EANNo() {
        return gS1EANNo;
    }

    public void setgS1EANNo(Long gS1EANNo) {
        this.gS1EANNo = gS1EANNo;
    }

    public String getOurNotes() {
        return ourNotes;
    }

    public void setOurNotes(String ourNotes) {
        this.ourNotes = ourNotes;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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

    public BigDecimal getPackCubic() {
        return packCubic;
    }

    public void setPackCubic(BigDecimal packCubic) {
        this.packCubic = packCubic;
    }

    public Long getoD() {
        return oD;
    }

    public void setoD(Long oD) {
        this.oD = oD;
    }

    public String getbHC() {
        return bHC;
    }

    public void setbHC(String bHC) {
        this.bHC = bHC;
    }

    public Long getbHQty() {
        return bHQty;
    }

    public void setbHQty(Long bHQty) {
        this.bHQty = bHQty;
    }

    public BigDecimal getbHSize() {
        return bHSize;
    }

    public void setbHSize(BigDecimal bHSize) {
        this.bHSize = bHSize;
    }

    public BigDecimal getbHOD() {
        return bHOD;
    }

    public void setbHOD(BigDecimal bHOD) {
        this.bHOD = bHOD;
    }

    public BigDecimal getbHStep() {
        return bHStep;
    }

    public void setbHStep(BigDecimal bHStep) {
        this.bHStep = bHStep;
    }

    public String getbHType() {
        return bHType;
    }

    public void setbHType(String bHType) {
        this.bHType = bHType;
    }

    public BigDecimal getThickness() {
        return thickness;
    }

    public void setThickness(BigDecimal thickness) {
        this.thickness = thickness;
    }

    public BigDecimal getThicknessMin() {
        return thicknessMin;
    }

    public void setThicknessMin(BigDecimal thicknessMin) {
        this.thicknessMin = thicknessMin;
    }

    public BigDecimal getOffset() {
        return offset;
    }

    public void setOffset(BigDecimal offset) {
        this.offset = offset;
    }

    public BigDecimal getBrakeAreawidth() {
        return brakeAreawidth;
    }

    public void setBrakeAreawidth(BigDecimal brakeAreawidth) {
        this.brakeAreawidth = brakeAreawidth;
    }

    public String gettUVLHC() {
        return tUVLHC;
    }

    public void settUVLHC(String tUVLHC) {
        this.tUVLHC = tUVLHC;
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

    public LocalDate geteDate() {
        return eDate;
    }

    public void seteDate(LocalDate eDate) {
        this.eDate = eDate;
    }

    public String getEuploadedNeto() {
        return euploadedNeto;
    }

    public void setEuploadedNeto(String euploadedNeto) {
        this.euploadedNeto = euploadedNeto;
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

    public String getePhoto1() {
        return ePhoto1;
    }

    public void setePhoto1(String ePhoto1) {
        this.ePhoto1 = ePhoto1;
    }

    public String getePhoto2() {
        return ePhoto2;
    }

    public void setePhoto2(String ePhoto2) {
        this.ePhoto2 = ePhoto2;
    }

    public String getePhoto3() {
        return ePhoto3;
    }

    public void setePhoto3(String ePhoto3) {
        this.ePhoto3 = ePhoto3;
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

    public BigDecimal getTrade1() {
        return trade1;
    }

    public void setTrade1(BigDecimal trade1) {
        this.trade1 = trade1;
    }

    public BigDecimal geteBAY() {
        return eBAY;
    }

    public void seteBAY(BigDecimal eBAY) {
        this.eBAY = eBAY;
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

    public BigDecimal getDistributorNZAUD() {
        return distributorNZAUD;
    }

    public void setDistributorNZAUD(BigDecimal distributorNZAUD) {
        this.distributorNZAUD = distributorNZAUD;
    }

    public BigDecimal getDistributorEUR() {
        return distributorEUR;
    }

    public void setDistributorEUR(BigDecimal distributorEUR) {
        this.distributorEUR = distributorEUR;
    }

    public BigDecimal getDistributorUSD() {
        return distributorUSD;
    }

    public void setDistributorUSD(BigDecimal distributorUSD) {
        this.distributorUSD = distributorUSD;
    }

    public String getsPriority() {
        return sPriority;
    }

    public void setsPriority(String sPriority) {
        this.sPriority = sPriority;
    }

    public String getSamplefrom() {
        return samplefrom;
    }

    public void setSamplefrom(String samplefrom) {
        this.samplefrom = samplefrom;
    }

    public String getRequestedfrom() {
        return requestedfrom;
    }

    public void setRequestedfrom(String requestedfrom) {
        this.requestedfrom = requestedfrom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getCamefrom() {
        return camefrom;
    }

    public void setCamefrom(String camefrom) {
        this.camefrom = camefrom;
    }

    public String getPaidfor() {
        return paidfor;
    }

    public void setPaidfor(String paidfor) {
        this.paidfor = paidfor;
    }

    public String getSentto() {
        return sentto;
    }

    public void setSentto(String sentto) {
        this.sentto = sentto;
    }

    public Long getShipNo() {
        return shipNo;
    }

    public void setShipNo(Long shipNo) {
        this.shipNo = shipNo;
    }

    public LocalDate getDatesent() {
        return datesent;
    }

    public void setDatesent(LocalDate datesent) {
        this.datesent = datesent;
    }

    public String getSamplereturn() {
        return samplereturn;
    }

    public void setSamplereturn(String samplereturn) {
        this.samplereturn = samplereturn;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSampleFitment() {
        return sampleFitment;
    }

    public void setSampleFitment(String sampleFitment) {
        this.sampleFitment = sampleFitment;
    }

    public String getoEM() {
        return oEM;
    }

    public void setoEM(String oEM) {
        this.oEM = oEM;
    }

    public String getNotesforProduction() {
        return notesforProduction;
    }

    public void setNotesforProduction(String notesforProduction) {
        this.notesforProduction = notesforProduction;
    }

    public String getProductionCode() {
        return productionCode;
    }

    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    public LocalDate gethAPapproved() {
        return hAPapproved;
    }

    public void sethAPapproved(LocalDate hAPapproved) {
        this.hAPapproved = hAPapproved;
    }

    public LocalDate getsHAapproved() {
        return sHAapproved;
    }

    public void setsHAapproved(LocalDate sHAapproved) {
        this.sHAapproved = sHAapproved;
    }

    public String getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    public String getNotestoDrawing() {
        return notestoDrawing;
    }

    public void setNotestoDrawing(String notestoDrawing) {
        this.notestoDrawing = notestoDrawing;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public BigDecimal getcOSTUSD() {
        return cOSTUSD;
    }

    public void setcOSTUSD(BigDecimal cOSTUSD) {
        this.cOSTUSD = cOSTUSD;
    }

    public String getCentrecolour() {
        return centrecolour;
    }

    public void setCentrecolour(String centrecolour) {
        this.centrecolour = centrecolour;
    }

    public String getLaser() {
        return laser;
    }

    public void setLaser(String laser) {
        this.laser = laser;
    }

    public Long getqTY1() {
        return qTY1;
    }

    public void setqTY1(Long qTY1) {
        this.qTY1 = qTY1;
    }

    public BigDecimal getuSD() {
        return uSD;
    }

    public void setuSD(BigDecimal uSD) {
        this.uSD = uSD;
    }

    public String getCompleteProduction() {
        return completeProduction;
    }

    public void setCompleteProduction(String completeProduction) {
        this.completeProduction = completeProduction;
    }

    public String getOurNotetoProduction() {
        return ourNotetoProduction;
    }

    public void setOurNotetoProduction(String ourNotetoProduction) {
        this.ourNotetoProduction = ourNotetoProduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BrakeDiscDTO brakeDiscDTO = (BrakeDiscDTO) o;
        if (brakeDiscDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), brakeDiscDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BrakeDiscDTO{" +
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
