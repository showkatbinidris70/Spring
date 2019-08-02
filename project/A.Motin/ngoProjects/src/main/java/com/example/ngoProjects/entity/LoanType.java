package com.example.ngoProjects.entity;


import javax.persistence.*;

@Entity
@Table(name = "loan_type")
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //   ( microCredit= weekly, quarterly, monthly),
    //   ( FixedTime = Six monthly, Yearly, Five year, Ten year)

    @Column(name = "type_name", nullable = false, unique = true)
    private String type;

}
