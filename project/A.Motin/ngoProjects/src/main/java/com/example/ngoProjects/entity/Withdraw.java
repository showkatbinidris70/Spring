package com.example.ngoProjects.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "withdraw_deposit")
public class Withdraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "withdraw_date", nullable = false)
    private Date withdrawDate = new Date();


    //RelationShip
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

}
