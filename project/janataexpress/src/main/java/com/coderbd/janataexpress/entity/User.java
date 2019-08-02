package com.coderbd.janataexpress.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true)
    @NotEmpty(message = "Please enter username")
    private String userName;

    @Column(name = "username", unique = true)
    @NotEmpty(message = "Please enter password")
    private String password;


}

