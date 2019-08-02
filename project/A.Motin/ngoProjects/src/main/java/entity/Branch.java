package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @Column(name = "branch_code", nullable = false)
    private String branchCode;

    @Column(name = "branch_address", nullable = false)
    private String branchAddress;

    // branch manager
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ngo_id")
    private Ngo ngo;


}