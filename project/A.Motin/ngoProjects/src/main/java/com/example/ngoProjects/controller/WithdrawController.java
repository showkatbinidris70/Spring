package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.Withdraw;
import com.example.ngoProjects.repo.AccountRepo;
import com.example.ngoProjects.repo.EmployeeRepo;
import com.example.ngoProjects.repo.WithdrawRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/withdraw/")
public class WithdrawController {

  @Autowired
  private WithdrawRepo withdrawRepo;


    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private EmployeeRepo employeeRepo;



    @GetMapping(value = "add")
    public String addWithdrawView(Model model) {
        model.addAttribute("withdraw", new Withdraw());

        model.addAttribute("accountList", this.accountRepo.findAll());
        model.addAttribute("employeeList", this.employeeRepo.findAll());

        return "withdraw/add";
    }


  @PostMapping(value = "add")
  public String addWithdraw(@Valid Withdraw withdraw, BindingResult result, Model model){
      if(result.hasErrors()){
          return "withdraw/add";
      }else {
          if (withdraw != null){
              Withdraw withdraw1 = this.withdrawRepo.findByAccount(withdraw.getAccount());
              if (withdraw1 != null){
                  model.addAttribute("existMsg", "WithdrawName is already exist");
              }else {
                  this.withdrawRepo.save(withdraw);
                  model.addAttribute("withdraw", new Withdraw());
                  model.addAttribute("successMsg", "Data insert is Success");
              }
          }
      }
      return "withdraw/add";
  }


    @GetMapping(value = "/list")
    public String WithdrawList(Model model) {
        model.addAttribute("list", this.withdrawRepo.findAll());
        return "withdraw/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editWithdrawView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("withdraw", this.withdrawRepo.getOne(id));
        return "withdraw/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editWithdraw(@Valid Withdraw withdraw, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "withdraw/edit";
        } else {
            if (withdraw != null) {
                Withdraw withdraw1 = this.withdrawRepo.findByAccount(withdraw.getAccount());
                if (withdraw1 != null) {
                    model.addAttribute("existMsg", "WithdrawName is already exist");
                    return "withdraw/edit";
                } else {
                    this.withdrawRepo.save(withdraw);
                    model.addAttribute("withdraw", new Withdraw());
                    model.addAttribute("successMsg", "Data Update is Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delWithdraw(@PathVariable("id") Long id) {
        this.withdrawRepo.deleteById(id);
        return "redirect:/list";

    }


}