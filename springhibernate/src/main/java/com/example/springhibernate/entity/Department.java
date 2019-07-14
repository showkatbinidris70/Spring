package com.example.springhibernate.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dep_name", nullable = false, unique = true)
    @Size(min = 3, max = 20)
    private String name;

    public Department() {
    }

    @Size
    public Department(@Size(min = 3, max = 20) String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
