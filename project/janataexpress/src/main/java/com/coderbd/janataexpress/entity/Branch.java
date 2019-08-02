package com.coderbd.janataexpress.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Please enter your name")
    private String name;

    @Column(name = "managerName", unique = false)
    @NotEmpty(message = "Please enter Manager name")
    private String managerName;

    @Column(name = "code", unique = false)
    private String code;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "contactNo", nullable = false, unique = true)
    private String contactNo;

    @NotNull(message = "Enter An Email Address")
    @Email
    @Column(name = "email", unique = true)
    private String email;


}
