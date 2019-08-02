package com.coderbd.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    private String companyName;

    @Column(name = "regNo", nullable = false, unique = true)
    private String regNo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date estdDate;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contactNo", nullable = false, unique = true)
    private String contactNo;

    @NotNull(message = "Enter An Email Address")
    @Email
    @Column(name = "email", unique = true)
    private String email;


    private Set<Company> Companies;

    public Company() {
    }

    public Company(@Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String name, String regNo, Date estdDate, String location, String address, String contactNo, @NotNull(message = "Enter An Email Address") @Email String email, Set<Company> companies) {
        this.companyName = name;
        this.regNo = regNo;
        this.estdDate = estdDate;
        this.location = location;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
        Companies = companies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return companyName;
    }

    public void setName(String name) {
        this.companyName = name;
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

    public Set<Company> getCompanies() {
        return Companies;
    }

    public void setCompanies(Set<Company> companies) {
        Companies = companies;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(regNo, company.regNo) &&
                Objects.equals(estdDate, company.estdDate) &&
                Objects.equals(location, company.location) &&
                Objects.equals(address, company.address) &&
                Objects.equals(contactNo, company.contactNo) &&
                Objects.equals(email, company.email) &&
                Objects.equals(Companies, company.Companies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, regNo, estdDate, location, address, contactNo, email, Companies);
    }


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + companyName + '\'' +
                ", regNo='" + regNo + '\'' +
                ", estdDate=" + estdDate +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", Companies=" + Companies +
                '}';
    }
}
