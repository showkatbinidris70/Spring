package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.AccountType;
import com.example.ngoProjects.repo.AccountTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/accType/")
public class AccountTypeController {

    @Autowired
    private AccountTypeRepo repo;

    @GetMapping(value = "add")
    public String addAccountTypeView(Model model) {
        model.addAttribute("accountType", new AccountType());
        return "accType/add";

    }

    @PostMapping(value = "add")
    public String addAccountType(@Valid AccountType accountType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "accType/add";
        } else {
            if (accountType != null) {
                AccountType accountType1 = this.repo.findByTypeName(accountType.getTypeName());
                if (accountType1 != null) {
                    model.addAttribute("existMsg", "AccountTypeName is already exist");
                } else {
                    this.repo.save(accountType);
                    model.addAttribute("accountType", new AccountType());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "accType/add";
    }

    @GetMapping(value = "/list")
    public String AccountTypeList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "accType/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editAccountTypeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("accountType", this.repo.getOne(id));
        return "accType/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editAccountType(@Valid AccountType accountType, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "accType/edit";
        } else {
            if (accountType != null) {
                AccountType accountType1 = this.repo.findByTypeName(accountType.getTypeName());
                if (accountType1 != null) {
                    model.addAttribute("existMsg", "AccountTypeName is already exist");
                    return "accType/edit";
                } else {
                    this.repo.save(accountType);
                    model.addAttribute("accountType", new AccountType());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delAccountType(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/list";

    }
}
