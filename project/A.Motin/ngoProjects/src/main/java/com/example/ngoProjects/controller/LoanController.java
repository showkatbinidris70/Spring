package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.Loan;
import com.example.ngoProjects.repo.AccountRepo;
import com.example.ngoProjects.repo.BranchRepo;
import com.example.ngoProjects.repo.EmployeeRepo;
import com.example.ngoProjects.repo.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/loan/")
public class LoanController {

  @Autowired
  private LoanRepo loanRepo;



    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BranchRepo branchRepo;



    @GetMapping(value = "add")
    public String addLoanView(Model model) {
        model.addAttribute("loan", new Loan());

        model.addAttribute("employeeList", this.employeeRepo.findAll());
        model.addAttribute("accountList", this.accountRepo.findAll());
        model.addAttribute("branchList", this.branchRepo.findAll());
        return "loan/add";
    }


  @PostMapping(value = "add")
  public String addLoan(@Valid Loan loan, BindingResult result, Model model){
      if(result.hasErrors()){
          return "loan/add";
      }else {
          if (loan != null){
              Loan loan1 = this.loanRepo.findByLoanCodeNumber(loan.getLoanCodeNumber());
              if (loan1 != null){
                  model.addAttribute("existMsg", "LoanCodeNumber is already exist");
              }else {
                  this.loanRepo.save(loan);
                  model.addAttribute("loan", new Loan());
                  model.addAttribute("successMsg", "Already Success");
              }
          }
      }
      return "loan/add";
  }


    @GetMapping(value = "/list")
    public String LoanList(Model model) {
        model.addAttribute("list", this.loanRepo.findAll());
        return "loan/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editLoanView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("loan", this.loanRepo.getOne(id));
        return "loan/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editLoan(@Valid Loan loan, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "loan/edit";
        } else {
            if (loan != null) {
                Loan loan1 = this.loanRepo.findByLoanCodeNumber(loan.getLoanCodeNumber());
                if (loan1 != null) {
                    model.addAttribute("existMsg", "LoanCodeNumber is already exist");
                    return "loan/edit";
                } else {
                    this.loanRepo.save(loan);
                    model.addAttribute("loan", new Loan());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delLoan(@PathVariable("id") Long id) {
        this.loanRepo.deleteById(id);
        return "redirect:/list";

    }


}