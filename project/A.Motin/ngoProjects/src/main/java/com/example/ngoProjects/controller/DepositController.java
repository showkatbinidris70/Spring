package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.Deposit;
import com.example.ngoProjects.repo.AccountRepo;
import com.example.ngoProjects.repo.DepositRepo;
import com.example.ngoProjects.repo.DepositTypeRepo;
import com.example.ngoProjects.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/deposit/")
public class DepositController {

  @Autowired
  private DepositRepo depositRepo;



    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private DepositTypeRepo depositTypeRepo;



    @GetMapping(value = "add")
    public String addDepositView(Model model) {
        model.addAttribute("deposit", new Deposit());

        model.addAttribute("employeeList", this.employeeRepo.findAll());
        model.addAttribute("accountList", this.accountRepo.findAll());
        model.addAttribute("depositTypeList", this.depositTypeRepo.findAll());
        return "deposit/add";
    }


  @PostMapping(value = "add")
  public String addDeposit(@Valid Deposit deposit, BindingResult result, Model model){
      if(result.hasErrors()){
          return "deposit/add";
      }else {
          if (deposit != null){
              Deposit deposit1 = this.depositRepo.findByDepositBranch(deposit.getDepositBranch());
              if (deposit1 != null){
                  model.addAttribute("existMsg", "DepositName is already exist");
              }else {
                  this.depositRepo.save(deposit);
                  model.addAttribute("deposit", new Deposit());
                  model.addAttribute("successMsg", "Already Success");
              }
          }
      }
      return "deposit/add";
  }


    @GetMapping(value = "/list")
    public String DepositList(Model model) {
        model.addAttribute("list", this.depositRepo.findAll());
        return "deposit/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editDepositView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("deposit", this.depositRepo.getOne(id));
        return "deposit/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editDeposit(@Valid Deposit deposit, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "deposit/edit";
        } else {
            if (deposit != null) {
                Deposit deposit1 = this.depositRepo.findByDepositBranch(deposit.getDepositBranch());
                if (deposit1 != null) {
                    model.addAttribute("existMsg", "DepositBranchName is already exist");
                    return "deposit/edit";
                } else {
                    this.depositRepo.save(deposit);
                    model.addAttribute("deposit", new Deposit());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delDeposit(@PathVariable("id") Long id) {
        this.depositRepo.deleteById(id);
        return "redirect:/list";

    }


}