package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loansummary")
public class LoanSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_branch", unique = true, nullable = false)
    private String loanBranch;

    @Temporal(TemporalType.TIMESTAMP)
    private Date loanDate = new Date();

    @Column(name = "loan_amount", nullable = false)
    private double loanAmount;

    @Column(name = "number_of_T_loan_amount", nullable = false)
    private double numberOfLoanAmount;

    @Column(name = "number_of_cllected_amount", nullable = false)
    private double numberOfCollectedAmount;

    @Column(name = "number_of_due_amount", nullable = false)
    private double numberOfDueAmount;

    @Column(name = "number_of_collected_kisti", nullable = false)
    private double numberOfCollectedKisti;

    @Column(name = "number_of_due_Kisti", nullable = false)
    private double numberOfDueKisti;


    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


}
