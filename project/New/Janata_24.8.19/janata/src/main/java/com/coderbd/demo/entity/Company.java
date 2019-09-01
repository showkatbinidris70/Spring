package com.coderbd.demo.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
//    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    private String companyName;

    @Column(name = "regNo", unique = true)
    private String regNo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date estdDate;

    @Column(name = "location")
    private String location;

    @Column(name = "address")
    private String address;

    @Column(name = "contactNo", unique = true)
    private String contactNo;

    @NotNull(message = "Enter An Email Address")
    @Email
    @Column(name = "email", unique = true)
    private String email;


    public Company() {
    }

    public Company(@Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String companyName, String regNo, Date estdDate, String location, String address, String contactNo, @NotNull(message = "Enter An Email Address") @Email String email) {
        this.companyName = companyName;
        this.regNo = regNo;
        this.estdDate = estdDate;
        this.location = location;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public Date getEstdDate() {
        return estdDate;
    }

    public void setEstdDate(Date estdDate) {
        this.estdDate = estdDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(getId(), company.getId()) &&
                Objects.equals(getCompanyName(), company.getCompanyName()) &&
                Objects.equals(getRegNo(), company.getRegNo()) &&
                Objects.equals(getEstdDate(), company.getEstdDate()) &&
                Objects.equals(getLocation(), company.getLocation()) &&
                Objects.equals(getAddress(), company.getAddress()) &&
                Objects.equals(getContactNo(), company.getContactNo()) &&
                Objects.equals(getEmail(), company.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCompanyName(), getRegNo(), getEstdDate(), getLocation(), getAddress(), getContactNo(), getEmail());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", regNo='" + regNo + '\'' +
                ", estdDate=" + estdDate +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}
