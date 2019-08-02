package com.coderbd.demo.entity;

import javax.persistence.*;

@Entity
public class ShippingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String recieverName;
    private String flatNo;
    private String roadNo;
    private String city;
    private String state;
    private String country;
    private String mobileNo;


}
