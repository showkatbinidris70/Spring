package com.example.ngoProjects.controller;

import com.example.ngoProjects.repo.DepositRepo;
import com.example.ngoProjects.repo.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    private DepositRepo depositRepo;

    @Autowired
    private LoanRepo loanRepo;



    double totalAmount = 0.0;
    double totaldisloanAmount = 0.0;

    @GetMapping(value = "totaldepositamount")
    public String getTotalDeposit(Model model){
         totalAmount = 0.0;
        this.depositRepo.findAll().forEach((dep)->{
            totalAmount += dep.getAmount();
        });
        model.addAttribute("list",this.depositRepo.findAll());
        model.addAttribute("totalAmount",totalAmount);
        return "reports/totaldeposit";
    }

    @GetMapping(value = "distributedloan")
    public String getTotalLoanAmount(Model model){
        totaldisloanAmount = 0.0;
        this.loanRepo.findAll().forEach((loan)->{
            totaldisloanAmount += loan.getLoanAmount();
        });
        model.addAttribute("list",this.loanRepo.findAll());
        model.addAttribute("totaldisloanAmount",totaldisloanAmount);
        return "reports/loanamount";
    }
}
