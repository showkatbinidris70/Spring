package com.coderbd.demo.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
//    @NotEmpty(message = "Please enter your name")
    private String branchName;

    @Column(name = "managerName")
    @NotEmpty(message = "Please enter Manager name")
    private String managerName;

    @Column(name = "code", unique = false)
    private String code;

    @Column(name = "country")
    private String country;

    @Column(name = "contactNo")
    private String contactNo;

    @NotNull(message = "Enter An Email Address")
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "compnany_id")
    private Company company;


    public Branch() {
    }

    public Branch(@NotEmpty(message = "Please enter your name") String branchName, @NotEmpty(message = "Please enter Manager name") String managerName, String code, String country, String contactNo, @NotNull(message = "Enter An Email Address") @Email String email, Company company) {
        this.branchName = branchName;
        this.managerName = managerName;
        this.code = code;
        this.country = country;
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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        Branch branch = (Branch) o;
        return Objects.equals(getId(), branch.getId()) &&
                Objects.equals(getBranchName(), branch.getBranchName()) &&
                Objects.equals(getManagerName(), branch.getManagerName()) &&
                Objects.equals(getCode(), branch.getCode()) &&
                Objects.equals(getCountry(), branch.getCountry()) &&
                Objects.equals(getContactNo(), branch.getContactNo()) &&
                Objects.equals(getEmail(), branch.getEmail()) &&
                Objects.equals(getCompany(), branch.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBranchName(), getManagerName(), getCode(), getCountry(), getContactNo(), getEmail(), getCompany());
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", company=" + company +
                '}';
    }
}
