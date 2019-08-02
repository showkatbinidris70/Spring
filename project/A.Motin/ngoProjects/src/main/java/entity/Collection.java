package entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanCodeNumber;

    private String dipositCodeNumber;

    private String employeeName;

    private int ngoOfTotalKisti;

    private double ngoOfTotalAmount;

    private int ngoOfCollectedKisti;

    private double ngoOfColectedAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionDate = new Date();


    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;


    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = false)
    private Deposit deposit;


    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = false)
    private Branch branch;

}
