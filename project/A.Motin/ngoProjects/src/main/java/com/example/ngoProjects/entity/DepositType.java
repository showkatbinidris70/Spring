package com.example.ngoProjects.entity;


import javax.persistence.*;

@Entity
@Table(name = "diposit_type")
public class DepositType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", nullable = false, unique = true)
    private String type;

//   ( microCredit= weekly, quarterly, monthly),
//   ( FixedTime = Six monthly, Yearly, Five year, Ten year)

}
