package entity;

import javax.persistence.*;


@Entity
@Table(name = "employee_wisedeposite")
public class EmployeeWiseDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "loan_branch", nullable = false)
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "employee_name", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "nominee_name", nullable = false)
    private Nominee nominee;

    @ManyToOne
    @JoinColumn(name = "Deposit_Amount", nullable = false)
    private Deposit deposit;

}