package com.example.ngoProjects.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account_type")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  /*
  1.Savings Acount
  2.MicroCredit Acoount
  3.FixedTime Account
  4.CoOperative Account
  */
    @Column(name = "type_name", nullable = false, unique = true)
    private String typeName;



    //Constructor

    public AccountType() {
    }

    public AccountType(String typeName) {
        this.typeName = typeName;
    }




    //Getter and Setter method

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }



    //Equals and HashCode method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTypeName(), that.getTypeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypeName());
    }



    //toString

    @Override
    public String toString() {
        return "AccountType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}