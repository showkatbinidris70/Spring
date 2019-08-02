package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "firstName", unique = true)
    private String firstName;

    @Column(name = "lastName", unique = true)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regiDate = new Date();

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "mobile", unique = true)
    private String mobile;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Role role;

    @ManyToOne
    @JoinColumn(name = "ngo_id")
    private Ngo ngo;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}


