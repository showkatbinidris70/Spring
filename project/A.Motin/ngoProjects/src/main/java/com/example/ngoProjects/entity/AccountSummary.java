package com.example.ngoProjects.entity;


import javax.persistence.*;

@Entity
@Table(name = "account_summary")
public class AccountSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // deposit Summary
    @Column(name = "t_depo_amount", nullable = false)
    private double totalDepositAmount;

    @Column(name = "p_In_depo_amount", nullable = false)
    private double profitInDepositAmount;

    @Column(name = "t_dep_amount_wprofit", nullable = false)
    private double totalDepositAmountWithProfit;

    @Column(name = "wid_depo_amount", nullable = false)
    private double widthrewDepositAmount;

    @Column(name = "avail_depo_amount", nullable = false)
    private double availableDepositAmount;


    //loan Summary
    @Column(name = "n_loan_taken", nullable = false)
    private int noOfLoanTaken;

    @Column(name = "n_loan_paid", nullable = false)
    private int noOfLoanPaid;

    @Column(name = "n_loan_due", nullable = false)
    private int noOfLoanDue;

    @Column(name = "t_loan_amount", nullable = false)
    private double totalLoanAmount;

    @Column(name = "t_loan_paid_amount", nullable = false)
    private double totalLoanPaidAmount;

    @Column(name = "t_loan_due_amount", nullable = false)
    private double totalLoanDueAmount;


    //current loan
    @Column(name = "c_loan_amount", nullable = false)
    private double currentLoanAmount;

    @Column(name = "c_loan_paid_amount", nullable = false)
    private double currentLoanPaidAmount;

    @Column(name = "c_loan_due_amount", nullable = false)
    private double currentLoanDueAmount;


    // RelationShip
    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;


}
