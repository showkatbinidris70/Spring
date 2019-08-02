package com.example.ngoProjects.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "collection")
public class LoanCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ngo_total_amount", nullable = false)
    private double ngoOfTotalAmount;

    @Column(name = "collect_kisti_no", nullable = false)
    private int collectedKistiNo;

    @Column(name = "ngo_collect_amount", nullable = false)
    private double ngoOfCollectedAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionDate = new Date();


    //RelationShip
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;


    @ManyToOne
    @JoinColumn(name = "coll_type_id", nullable = false)
    private CollectionType collectionType;


}
