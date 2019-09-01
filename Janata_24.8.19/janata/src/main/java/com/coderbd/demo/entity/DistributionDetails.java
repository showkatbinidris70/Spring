package com.coderbd.demo.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "distributionDetails")
public class DistributionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "parcelName")
    private String parcelName;

    @Column(name = "customerDetails")
    private String customerDetails;

    @Column(name = "weight")
    private String weight;

    @Column(name = "height")
    private String height;

    @Column(name = "lenght")
    private String lenght;

    private String deliveryType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;

    public DistributionDetails() {
    }

    public DistributionDetails(String parcelName, String customerDetails, String weight, String height, String lenght, String deliveryType, Date bookingDate, Date deliveryDate) {
        this.parcelName = parcelName;
        this.customerDetails = customerDetails;
        this.weight = weight;
        this.height = height;
        this.lenght = lenght;
        this.deliveryType = deliveryType;
        this.bookingDate = bookingDate;
        this.deliveryDate = deliveryDate;
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

    public String getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(String customerDetails) {
        this.customerDetails = customerDetails;
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

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "DistributionDetails{" +
                "id=" + id +
                ", parcelName='" + parcelName + '\'' +
                ", customerDetails='" + customerDetails + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", lenght='" + lenght + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", bookingDate=" + bookingDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
