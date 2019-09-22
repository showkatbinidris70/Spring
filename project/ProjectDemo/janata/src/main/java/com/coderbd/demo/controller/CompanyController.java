package com.coderbd.demo.controller;

import com.coderbd.demo.entity.Company;
import com.coderbd.demo.ropo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/company/")
public class CompanyController {
    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping(value = "add")
    public String addCompanyView(Model model) {
        model.addAttribute("company", new Company());
        return "company/add";

    }

    @PostMapping(value = "add")
    public String addCompany(@Valid Company company, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "company/add";
        } else {
            if (company != null) {
                Company company1 = this.companyRepo.findByCompanyName(company.getCompanyName());
                if (company1 != null) {
                    model.addAttribute("existMsg", "CompanyName is already exist");
                } else {
                    this.companyRepo.save(company);
                    model.addAttribute("company", new Company());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "company/add";
    }

    @GetMapping(value = "/list")
    public String companyList(Model model) {
        model.addAttribute("list", this.companyRepo.findAll());
        return "company/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editCompanyView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("company", this.companyRepo.getOne(id));
        return "company/edit";
    }


    @PostMapping(value = "/edit/{id}")
    public String editCompany(@Valid Company company, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "company/edit";
        } else {
            if (company != null) {
                Company company1 = this.companyRepo.getOne(id);
                company1.setCompanyName(company.getCompanyName());
                this.companyRepo.save(company1);
                model.addAttribute("company", new Company());
                model.addAttribute("successMsg", "Update Successfully");

            }
        }
        return "redirect:/company/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delCompany(@PathVariable("id") Long id) {
        this.companyRepo.deleteById(id);
        return "redirect:/company/list";

    }

}
