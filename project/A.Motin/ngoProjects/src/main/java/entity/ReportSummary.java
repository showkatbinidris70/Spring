package entity;

import javax.persistence.*;

@Entity
@Table(name = "report_summary")
public class ReportSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double depositIncome;

    private double loanIncome;

    private double totalIncome;

    private double buyOfSalary;

    private double buyOfOfficeManagement;

    private double totalCost;

    private double totalLost;

    private double totalProfit;


}
