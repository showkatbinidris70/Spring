package entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emplyee_name", nullable = false)
    private String employeeName;

    @Column(name = "emplyee_code", unique = true, nullable = false)
    private String emplyeeCode;

    @Column(name = "emplyee_gender", nullable = false)
    private String emplyeeGender;

    @Column(name = "emplyee_age", nullable = false)
    private int emplyeeAge;

    @Column(name = "emplyee_salary", nullable = false)
    private String emplyeeSalary;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regiDate = new Date();

    @Column(name = "emplyee_mobile", nullable = false)
    private String emplyeeMobile;

    @Column(name = "emplyee_address", nullable = false)
    private String emplyeeddress;

    @Column(name = "emplyee_nid", unique = true, nullable = false)
    private String emplyeeNid;


    @ManyToOne
    @JoinColumn(name = "ngo_id", nullable = false)
    private Ngo ngo;


    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "emp_type_id", nullable = false)
    private EmployeeType employeeType;
    }
