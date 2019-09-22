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


    private String senderName;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendingDate = new Date();

    @ManyToOne
    @JoinColumn(name = "sendingbranch_id")
    private Branch sendingbranch;



//    @ManyToOne
//    @JoinColumn(name = "destinationbranch_id")
//    private Branch destinationbranch;




    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    //@OneToMany
    @ManyToMany
    @JoinTable(
            name = "sending_packing",
            joinColumns = @JoinColumn(name = "sending_details_id"),
            inverseJoinColumns = @JoinColumn(name = "packing_id"))
    private Set<Packing> packings;
   // private Packing packing;

    public SendingDetails() {
    }

    public SendingDetails(String senderName, Date sendingDate, Branch sendingbranch, Employee employee, Set<Packing> packings) {
        this.senderName = senderName;
        this.sendingDate = sendingDate;
        this.sendingbranch = sendingbranch;
        this.employee = employee;
        this.packings = packings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendingDetails that = (SendingDetails) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getSenderName(), that.getSenderName()) &&
                Objects.equals(getSendingDate(), that.getSendingDate()) &&
                Objects.equals(getSendingbranch(), that.getSendingbranch()) &&
                Objects.equals(getEmployee(), that.getEmployee()) &&
                Objects.equals(getPackings(), that.getPackings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSenderName(), getSendingDate(), getSendingbranch(), getEmployee(), getPackings());
    }

    @Override
    public String toString() {
        return "SendingDetails{" +
                "id=" + id +
                ", senderName='" + senderName + '\'' +
                ", sendingDate=" + sendingDate +
                ", sendingbranch=" + sendingbranch +
                ", employee=" + employee +
                ", packings=" + packings +
                '}';
    }
}
