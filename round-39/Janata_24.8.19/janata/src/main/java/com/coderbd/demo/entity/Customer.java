package com.coderbd.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
//    @NotEmpty(message = "Please enter your name")
    private String customerName;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bookingDate=new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;


    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "district")
    private String district;

    @Column(name = "address")
    private String address;

    @Column(name = "contactNo",unique = true)
    private String contactNo;

    @NotNull(message = "Enter An Email Address")
    @Email
    @Column(name = "email",unique = true)
    private String email;


    @ManyToOne
    @JoinColumn(name = "compnany_id")
    private Company company;

    public Customer() {
    }

    public Customer(@NotEmpty(message = "Please enter your name") String customerName, Date bookingDate, Date deliveryDate, String country, String state, String district, String address, String contactNo, @NotNull(message = "Enter An Email Address") @Email String email, Company company) {
        this.customerName = customerName;
        this.bookingDate = bookingDate;
        this.deliveryDate = deliveryDate;
        this.country = country;
        this.state = state;
        this.district = district;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId()) &&
                Objects.equals(getCustomerName(), customer.getCustomerName()) &&
                Objects.equals(getBookingDate(), customer.getBookingDate()) &&
                Objects.equals(getDeliveryDate(), customer.getDeliveryDate()) &&
                Objects.equals(getCountry(), customer.getCountry()) &&
                Objects.equals(getState(), customer.getState()) &&
                Objects.equals(getDistrict(), customer.getDistrict()) &&
                Objects.equals(getAddress(), customer.getAddress()) &&
                Objects.equals(getContactNo(), customer.getContactNo()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getCompany(), customer.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerName(), getBookingDate(), getDeliveryDate(), getCountry(), getState(), getDistrict(), getAddress(), getContactNo(), getEmail(), getCompany());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", bookingDate=" + bookingDate +
                ", deliveryDate=" + deliveryDate +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", company=" + company +
                '}';
    }
}
