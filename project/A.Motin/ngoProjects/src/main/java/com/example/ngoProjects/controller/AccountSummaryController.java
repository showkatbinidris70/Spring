package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.AccountSummary;
import com.example.ngoProjects.repo.AccountRepo;
import com.example.ngoProjects.repo.AccountSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/accSummary/")
public class AccountSummaryController {

  @Autowired
  private AccountSummaryRepo accountSummaryRepo;



    @Autowired
    private AccountRepo accountRepo;




    @GetMapping(value = "add")
    public String addAccountSummaryView(Model model) {
        model.addAttribute("accountSummary", new AccountSummary());

        model.addAttribute("accountList", this.accountRepo.findAll());

        return "accSummary/add";
    }


  @PostMapping(value = "add")
  public String addAccountSummary(@Valid AccountSummary accountSummary, BindingResult result, Model model){
      if(result.hasErrors()){
          return "accSummary/add";
      }else {
          if (accountSummary != null){
              AccountSummary accountSummary1 = this.accountSummaryRepo.findByAccount(accountSummary.getAccount());
              if (accountSummary1 != null){
                  model.addAttribute("existMsg", "AccountSummaryName is already exist");
              }else {
                  this.accountSummaryRepo.save(accountSummary);
                  model.addAttribute("accountSummary", new AccountSummary());
                  model.addAttribute("successMsg", "Data insert is Success");
              }
          }
      }
      return "accSummary/add";
  }


    @GetMapping(value = "/list")
    public String AccountSummaryList(Model model) {
        model.addAttribute("list", this.accountSummaryRepo.findAll());
        return "accSummary/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editAccountSummaryView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("accountSummary", this.accountSummaryRepo.getOne(id));
        return "accSummary/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAccountSummary(@Valid AccountSummary accountSummary, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "accSummary/edit";
        } else {
            if (accountSummary != null) {
                AccountSummary accountSummary1 = this.accountSummaryRepo.findByAccount(accountSummary.getAccount());
                if (accountSummary1 != null) {
                    model.addAttribute("existMsg", "AccountSummaryName is already exist");
                    return "accSummary/edit";
                } else {
                    this.accountSummaryRepo.save(accountSummary);
                    model.addAttribute("accountSummary", new AccountSummary());
                    model.addAttribute("successMsg", "Data Update is Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delAccountSummary(@PathVariable("id") Long id) {
        this.accountSummaryRepo.deleteById(id);
        return "redirect:/list";

    }


}