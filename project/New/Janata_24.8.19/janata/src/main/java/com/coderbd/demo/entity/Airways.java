package com.coderbd.demo.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
@Table(name = "airways")
public class Airways{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


//    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    private String airwaysName;


    @Column(name = "contactNo")
    @NotEmpty(message = "Please enter your contactNo")
    private String contactNo;

    @NotNull(message = "Enter An Email Address")
    @Email
    @Column(name = "email")
    private String email;


    public Airways() {
    }

    public Airways(@NotNull @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String airwaysName, @NotEmpty(message = "Please enter your contactNo") String contactNo, @NotNull(message = "Enter An Email Address") @Email String email) {
        this.airwaysName = airwaysName;
        this.contactNo = contactNo;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirwaysName() {
        return airwaysName;
    }

    public void setAirwaysName(String airwaysName) {
        this.airwaysName = airwaysName;
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
        Airways airways = (Airways) o;
        return Objects.equals(getId(), airways.getId()) &&
                Objects.equals(getAirwaysName(), airways.getAirwaysName()) &&
                Objects.equals(getContactNo(), airways.getContactNo()) &&
                Objects.equals(getEmail(), airways.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAirwaysName(), getContactNo(), getEmail());
    }

    @Override
    public String toString() {
        return "Airways{" +
                "id=" + id +
                ", airwaysName='" + airwaysName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
