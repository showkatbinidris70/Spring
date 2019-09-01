package com.coderbd.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "packing")
public class Packing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String packingCode;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendDate = new Date();

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "compnany_id")
    private Company company;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "packing_parcel",
            joinColumns = @JoinColumn(name = "packing_id"),
            inverseJoinColumns = @JoinColumn(name = "parcel_id"))
    private Set<Parcel> parcels;

    public Packing() {
    }

    public Packing(String packingCode, Date sendDate, Branch branch, Company company, Set<Parcel> parcels) {
        this.packingCode = packingCode;
        this.sendDate = sendDate;
        this.branch = branch;
        this.company = company;
        this.parcels = parcels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPackingCode() {
        return packingCode;
    }

    public void setPackingCode(String packingCode) {
        this.packingCode = packingCode;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
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

    public Set<Parcel> getParcels() {
        return parcels;
    }

    public void setParcels(Set<Parcel> parcels) {
        this.parcels = parcels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packing packing = (Packing) o;
        return Objects.equals(getId(), packing.getId()) &&
                Objects.equals(getPackingCode(), packing.getPackingCode()) &&
                Objects.equals(getSendDate(), packing.getSendDate()) &&
                Objects.equals(getBranch(), packing.getBranch()) &&
                Objects.equals(getCompany(), packing.getCompany()) &&
                Objects.equals(getParcels(), packing.getParcels());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPackingCode(), getSendDate(), getBranch(), getCompany(), getParcels());
    }

    @Override
    public String toString() {
        return "Packing{" +
                "id=" + id +
                ", packingCode='" + packingCode + '\'' +
                ", sendDate=" + sendDate +
                ", branch=" + branch +
                ", company=" + company +
                ", parcels=" + parcels +
                '}';
    }
}
