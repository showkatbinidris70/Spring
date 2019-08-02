package entity;


import javax.persistence.*;

@Entity
@Table(name = "employee_type")
public class EmployeeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", nullable = false, unique = true)
    private String type;
}
