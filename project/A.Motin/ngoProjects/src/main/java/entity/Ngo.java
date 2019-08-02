package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ngo")
public class Ngo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ngo_name", unique = true, nullable = false)
    private String name;

    @Column(name = "ngo_owner", unique = true, nullable = false)
    private String owner;

    @Column(name = "ngo_mobile", unique = true, nullable = false)
    private String mobile;

    @Column(name = "ngo_email", unique = true, nullable = false)
    private String email;

    @Column(name = "address", unique = true, nullable = false)
    private String address;

    @Column(name = "ngo_service", unique = true)
    private String ngoService;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ngoRegiDate = new Date();

}