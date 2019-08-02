package com.coderbd.demotampate.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class RecivingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recivingDate;

    @ManyToOne
    @JoinColumn(name = "sendingbranch_id")
    private Branch sendingBranch;

    @ManyToOne
    @JoinColumn(name = "destinationbranch_id")
    private Branch recivingBranch;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany
    @JoinTable(
            name = "recivings_packing",
            joinColumns = @JoinColumn(name = "sending_details_id"),
            inverseJoinColumns = @JoinColumn(name = "packing_id"))
    private Set<Packing> packings;

}
