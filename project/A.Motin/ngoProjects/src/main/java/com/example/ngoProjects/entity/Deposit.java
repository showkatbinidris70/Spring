package com.example.ngoProjects.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deposit_branch", unique = true, nullable = false)
    private String depositBranch;

    @Column(nullable = false)
    private Long loanCodeNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date depositDate = new Date();

    @Column(name = "deposit_amount", nullable = false)
    private double amount;


    //RelationShip
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "deposit_type_id", nullable = false)
    private DepositType depositType;
}
