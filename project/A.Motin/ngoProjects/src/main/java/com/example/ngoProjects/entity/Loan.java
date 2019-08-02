package com.example.ngoProjects.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_code", nullable = false)
    private Long loanCodeNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "loan_date", nullable = false)
    private Date loanDate = new Date();

    @Column(name = "loan_amount", nullable = false)
    private double loanAmount;

    @Column(name = "no_loan_kisti", nullable = false)
    private int noOfKisti;

    @Column(name = "loan_payable_kisti", nullable = false)
    private String loanPayableKisti;


    //RelationShip
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;
}
