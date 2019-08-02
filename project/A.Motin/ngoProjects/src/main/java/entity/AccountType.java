package entity;

import javax.persistence.*;

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
    private String type;

}