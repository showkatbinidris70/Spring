package com.coderbd.janataexpress.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "rolename", unique = true)
    @NotEmpty(message = "rolename")
    private String roleName;


}