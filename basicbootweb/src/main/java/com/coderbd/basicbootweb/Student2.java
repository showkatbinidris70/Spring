package com.coderbd.basicbootweb;

import javax.persistence.*;

@Entity
@Table(name = "stu")
public class Student2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Student2(String name) {
        this.name = name;
    }

    public Student2() {
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
