package com.coderbd.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "parcel")
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

//    @NotNull
//    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    private String parcelName;

    private String weight;

    private String height;

    private String length;

    private String sendFrom;

    private String receivedTo;

    private String productType;

    private String deliveryType;

    private String cost;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate = new Date();


    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "compnany_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "shippingDetails_id")
    private ShippingDetails shippingDetails;

    public Parcel() {
    }

    public Parcel(String parcelName, String weight, String height, String length, String sendFrom, String receivedTo, String productType, String deliveryType, String cost, Date deliveryDate, Date bookingDate, Branch branch, Company company, ShippingDetails shippingDetails) {
        this.parcelName = parcelName;
        this.weight = weight;
        this.height = height;
        this.length = length;
        this.sendFrom = sendFrom;
        this.receivedTo = receivedTo;
        this.productType = productType;
        this.deliveryType = deliveryType;
        this.cost = cost;
        this.deliveryDate = deliveryDate;
        this.bookingDate = bookingDate;
        this.branch = branch;
        this.company = company;
        this.shippingDetails = shippingDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParcelName() {
        return parcelName;
    }

    public void setParcelName(String parcelName) {
        this.parcelName = parcelName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getReceivedTo() {
        return receivedTo;
    }

    public void setReceivedTo(String receivedTo) {
        this.receivedTo = receivedTo;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Objects.equals(getId(), parcel.getId()) &&
                Objects.equals(getParcelName(), parcel.getParcelName()) &&
                Objects.equals(getWeight(), parcel.getWeight()) &&
                Objects.equals(getHeight(), parcel.getHeight()) &&
                Objects.equals(getLength(), parcel.getLength()) &&
                Objects.equals(getSendFrom(), parcel.getSendFrom()) &&
                Objects.equals(getReceivedTo(), parcel.getReceivedTo()) &&
                Objects.equals(getProductType(), parcel.getProductType()) &&
                Objects.equals(getDeliveryType(), parcel.getDeliveryType()) &&
                Objects.equals(getCost(), parcel.getCost()) &&
                Objects.equals(getDeliveryDate(), parcel.getDeliveryDate()) &&
                Objects.equals(getBookingDate(), parcel.getBookingDate()) &&
                Objects.equals(getBranch(), parcel.getBranch()) &&
                Objects.equals(getCompany(), parcel.getCompany()) &&
                Objects.equals(getShippingDetails(), parcel.getShippingDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getParcelName(), getWeight(), getHeight(), getLength(), getSendFrom(), getReceivedTo(), getProductType(), getDeliveryType(), getCost(), getDeliveryDate(), getBookingDate(), getBranch(), getCompany(), getShippingDetails());
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", parcelName='" + parcelName + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", length='" + length + '\'' +
                ", sendFrom='" + sendFrom + '\'' +
                ", receivedTo='" + receivedTo + '\'' +
                ", productType='" + productType + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", cost='" + cost + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", bookingDate=" + bookingDate +
                ", branch=" + branch +
                ", company=" + company +
                ", shippingDetails=" + shippingDetails +
                '}';
    }
}
