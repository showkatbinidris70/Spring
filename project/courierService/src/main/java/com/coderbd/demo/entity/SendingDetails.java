package com.coderbd.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sendingDetails")
public class SendingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String senderBranch;

    private String senderName;

    private String senderContactNo;

    private String senderAddress;

    private String senderCity;

    private String senderState;

    private String senderCountry;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendingDate = new Date();

    @ManyToOne
    @JoinColumn(name = "sendingbranch_id")
    private Branch sendingbranch;

    @ManyToOne
    @JoinColumn(name = "destinationbranch_id")
    private Branch destinationbranch;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany
    @JoinTable(
            name = "sending_packing",
            joinColumns = @JoinColumn(name = "sending_details_id"),
            inverseJoinColumns = @JoinColumn(name = "packing_id"))
    private Set<Packing> packings;
   // private Packing packing;

    public SendingDetails() {
    }

    public SendingDetails(String senderBranch, String senderName, String senderContactNo, String senderAddress, String senderCity, String senderState, String senderCountry, Date sendingDate, Branch sendingbranch, Branch destinationbranch, Employee employee, Set<Packing> packings) {
        this.senderBranch = senderBranch;
        this.senderName = senderName;
        this.senderContactNo = senderContactNo;
        this.senderAddress = senderAddress;
        this.senderCity = senderCity;
        this.senderState = senderState;
        this.senderCountry = senderCountry;
        this.sendingDate = sendingDate;
        this.sendingbranch = sendingbranch;
        this.destinationbranch = destinationbranch;
        this.employee = employee;
        this.packings = packings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderBranch() {
        return senderBranch;
    }

    public void setSenderBranch(String senderBranch) {
        this.senderBranch = senderBranch;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderContactNo() {
        return senderContactNo;
    }

    public void setSenderContactNo(String senderContactNo) {
        this.senderContactNo = senderContactNo;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderState() {
        return senderState;
    }

    public void setSenderState(String senderState) {
        this.senderState = senderState;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public Branch getSendingbranch() {
        return sendingbranch;
    }

    public void setSendingbranch(Branch sendingbranch) {
        this.sendingbranch = sendingbranch;
    }

    public Branch getDestinationbranch() {
        return destinationbranch;
    }

    public void setDestinationbranch(Branch destinationbranch) {
        this.destinationbranch = destinationbranch;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Packing> getPackings() {
        return packings;
    }

    public void setPackings(Set<Packing> packings) {
        this.packings = packings;
    }

    @Override
    public String toString() {
        return "SendingDetails{" +
                "id=" + id +
                ", senderBranch='" + senderBranch + '\'' +
                ", senderName='" + senderName + '\'' +
                ", senderContactNo='" + senderContactNo + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", senderCity='" + senderCity + '\'' +
                ", senderState='" + senderState + '\'' +
                ", senderCountry='" + senderCountry + '\'' +
                ", sendingDate=" + sendingDate +
                ", sendingbranch=" + sendingbranch +
                ", destinationbranch=" + destinationbranch +
                ", employee=" + employee +
                ", packings=" + packings +
                '}';
    }
}
