package com.coderbd.demotampate.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Packing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String packingId;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendDate;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "compnany_id")
    private Company company;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "packing_parcel",
            joinColumns = @JoinColumn(name = "packing_id"),
            inverseJoinColumns = @JoinColumn(name = "parcel_id"))
    private Set<Parcel> parcels;
}
