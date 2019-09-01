package com.coderbd.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shippingDetails")
public class ShippingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    private String recieverName;


    private String flightNo;


    private String roadNo;


    private String city;


    private String state;


    private String country;


    @Column(name = "email", unique = true)
    private String mobileNo;


    public ShippingDetails() {
    }

    public ShippingDetails(String recieverName, String flightNo, String roadNo, String city, String state, String country, String mobileNo) {
        this.recieverName = recieverName;
        this.flightNo = flightNo;
        this.roadNo = roadNo;
        this.city = city;
        this.state = state;
        this.country = country;
        this.mobileNo = mobileNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecieverName() {
        return recieverName;
    }

    public void setRecieverName(String recieverName) {
        this.recieverName = recieverName;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getRoadNo() {
        return roadNo;
    }

    public void setRoadNo(String roadNo) {
        this.roadNo = roadNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingDetails that = (ShippingDetails) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getRecieverName(), that.getRecieverName()) &&
                Objects.equals(getFlightNo(), that.getFlightNo()) &&
                Objects.equals(getRoadNo(), that.getRoadNo()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getState(), that.getState()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getMobileNo(), that.getMobileNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRecieverName(), getFlightNo(), getRoadNo(), getCity(), getState(), getCountry(), getMobileNo());
    }

    @Override
    public String toString() {
        return "ShippingDetails{" +
                "id=" + id +
                ", recieverName='" + recieverName + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", roadNo='" + roadNo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
