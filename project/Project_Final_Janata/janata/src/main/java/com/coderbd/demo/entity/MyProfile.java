package com.coderbd.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "myProfile")
public class MyProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    @Column(name = "user_name")
    private String username;

    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    @Column(name = "firstName")
    private String firstName;

    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    @Column(name = "lastName")
    private String lastName;

    private Double salary;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "country")
    private String country;

    @Column(name = "district")
    private String district;

    @Column(name = "presentAddress")
    private String presentAddress;

    @Column(name = "permanentAddress")
    private String permanentAddress;

    @Column(name = "contactNo",unique = true)
    private String contactNo;

    @NotNull(message = "Enter An Email Address")
    @Email
    @Column(name = "email",unique = true)
    private String email;


    public MyProfile() {
    }

    public MyProfile(@NotNull @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String username, @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String firstName, @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String lastName, Double salary, Date birthDate, String country, String district, String presentAddress, String permanentAddress, String contactNo, @NotNull(message = "Enter An Email Address") @Email String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthDate = birthDate;
        this.country = country;
        this.district = district;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.contactNo = contactNo;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
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
        MyProfile myProfile = (MyProfile) o;
        return Objects.equals(getId(), myProfile.getId()) &&
                Objects.equals(getUsername(), myProfile.getUsername()) &&
                Objects.equals(getFirstName(), myProfile.getFirstName()) &&
                Objects.equals(getLastName(), myProfile.getLastName()) &&
                Objects.equals(getSalary(), myProfile.getSalary()) &&
                Objects.equals(getBirthDate(), myProfile.getBirthDate()) &&
                Objects.equals(getCountry(), myProfile.getCountry()) &&
                Objects.equals(getDistrict(), myProfile.getDistrict()) &&
                Objects.equals(getPresentAddress(), myProfile.getPresentAddress()) &&
                Objects.equals(getPermanentAddress(), myProfile.getPermanentAddress()) &&
                Objects.equals(getContactNo(), myProfile.getContactNo()) &&
                Objects.equals(getEmail(), myProfile.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getFirstName(), getLastName(), getSalary(), getBirthDate(), getCountry(), getDistrict(), getPresentAddress(), getPermanentAddress(), getContactNo(), getEmail());
    }

    @Override
    public String toString() {
        return "MyProfile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                ", country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", presentAddress='" + presentAddress + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
