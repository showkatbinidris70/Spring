package com.example.ngoProjects.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "acc_hold_name", nullable = false)
    private String accountHolderName;

    @Column(name = "account_namber", nullable = false)
    private Long accountNumber;

    @Column(name = "acc_code_number", nullable = false)
    private String accountCodeNumber;

    @Column(name = "pri_Dep_amount", nullable = false)
    private double primaryDepositAmount;

    @Column(name = "total_withdraw", nullable = false)
    private double totalWithdraw;

    @Column(name = "balance_amount", nullable = false)
    private double balanceAmount;

    @Column(name = "acc_hold_age", nullable = false)
    private int accountHolderAge;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String mobile;

    @Column(nullable = false)
    private String address;

    @Column(name = "nid_number", nullable = false, unique = true)
    private String nidNumber;

    @Column(nullable = false)
    private String profession;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "acc_open_date", nullable = false)
    private Date accountOpeningDate = new Date();


    //RelationShip
    @ManyToOne
    @JoinColumn(name = "account_type_id", nullable = false)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "account_nominee",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "nominee_id")
    )
    private Set<Nominee> nominees;


}
