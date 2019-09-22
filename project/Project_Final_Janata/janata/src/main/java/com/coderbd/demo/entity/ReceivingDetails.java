package com.coderbd.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "receivingDetails")
public class ReceivingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String receiverName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date receivingDate;



//    @ManyToOne
//    @JoinColumn(name = "sendingbranch_id")
//    private Branch sendingBranch;




    @ManyToOne
    @JoinColumn(name = "destinationbranch_id")
    private Branch receivingBranch;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

   // @OneToMany
    @ManyToMany
    @JoinTable(
            name = "recivings_packing",
            joinColumns = @JoinColumn(name = "sending_details_id"),
            inverseJoinColumns = @JoinColumn(name = "packing_id"))
    private Set<Packing> packings;

    public ReceivingDetails() {
    }

    public ReceivingDetails(String receiverName, Date receivingDate, Branch receivingBranch, Employee employee, Set<Packing> packings) {
        this.receiverName = receiverName;
        this.receivingDate = receivingDate;
        this.receivingBranch = receivingBranch;
        this.employee = employee;
        this.packings = packings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    public Branch getReceivingBranch() {
        return receivingBranch;
    }

    public void setReceivingBranch(Branch receivingBranch) {
        this.receivingBranch = receivingBranch;
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
        ReceivingDetails that = (ReceivingDetails) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getReceiverName(), that.getReceiverName()) &&
                Objects.equals(getReceivingDate(), that.getReceivingDate()) &&
                Objects.equals(getReceivingBranch(), that.getReceivingBranch()) &&
                Objects.equals(getEmployee(), that.getEmployee()) &&
                Objects.equals(getPackings(), that.getPackings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReceiverName(), getReceivingDate(), getReceivingBranch(), getEmployee(), getPackings());
    }

    @Override
    public String toString() {
        return "ReceivingDetails{" +
                "id=" + id +
                ", receiverName='" + receiverName + '\'' +
                ", receivingDate=" + receivingDate +
                ", receivingBranch=" + receivingBranch +
                ", employee=" + employee +
                ", packings=" + packings +
                '}';
    }
}
