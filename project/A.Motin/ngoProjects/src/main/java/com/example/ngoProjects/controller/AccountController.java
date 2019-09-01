package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.Account;
import com.example.ngoProjects.repo.AccountRepo;
import com.example.ngoProjects.repo.AccountTypeRepo;
import com.example.ngoProjects.repo.BranchRepo;
import com.example.ngoProjects.repo.NomineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/account/")
public class AccountController {

  @Autowired
  private AccountRepo accountRepo;



    @Autowired
    private AccountTypeRepo accountTypeRepo;

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private NomineeRepo nomineeRepo;



    @GetMapping(value = "add")
    public String addAccountView(Model model) {
        model.addAttribute("account", new Account());
       model.addAttribute("accountList", this.accountRepo.findAll());

        model.addAttribute("accountTypeList", this.accountTypeRepo.findAll());
        model.addAttribute("branchList", this.branchRepo.findAll());
        model.addAttribute("nomineeList", this.nomineeRepo.findAll());
        return "account/add";
    }


  @PostMapping(value = "add")
  public String addAccount(@Valid Account account, BindingResult result, Model model){
      if(result.hasErrors()){
          return "account/add";
      }else {
          if (account != null){
              Account account1 = this.accountRepo.findByAccountHolderName(account.getAccountHolderName());
              if (account1 != null){
                  model.addAttribute("existMsg", "AccountName is already exist");
              }else {
                  this.accountRepo.save(account);
                  model.addAttribute("account", new Account());
                  model.addAttribute("successMsg", "Already Success");
              }
          }
      }
      return "account/add";
  }


    @GetMapping(value = "/list")
    public String AccountList(Model model) {
        model.addAttribute("list", this.accountRepo.findAll());
        return "account/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editAccountView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("account", this.accountRepo.getOne(id));
        return "account/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAccount(@Valid Account account, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "account/edit";
        } else {
            if (account != null) {
                Account account1 = this.accountRepo.findByAccountHolderName(account.getAccountHolderName());
                if (account1 != null) {
                    model.addAttribute("existMsg", "AccountName is already exist");
                    return "account/edit";
                } else {
                    this.accountRepo.save(account);
                    model.addAttribute("account", new Account());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delAccount(@PathVariable("id") Long id) {
        this.accountRepo.deleteById(id);
        return "redirect:/list";

    }


}