package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.LoanCollection;
import com.example.ngoProjects.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/loanCollect/")
public class LoanCollectionController {

  @Autowired
  private LoanCollectionRepo loanCollectionRepo;


    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private LoanRepo loanRepo;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private CollectionTypeRepo collectionTypeRepo;



    @GetMapping(value = "add")
    public String addLoanCollectionView(Model model) {
        model.addAttribute("loanCollection", new LoanCollection());

        model.addAttribute("employeeList", this.employeeRepo.findAll());
        model.addAttribute("accountList", this.accountRepo.findAll());
        model.addAttribute("loanList", this.loanRepo.findAll());
        model.addAttribute("branchList", this.branchRepo.findAll());
        model.addAttribute("collectionTypeList", this.collectionTypeRepo.findAll());

        return "loanCollect/add";
    }


  @PostMapping(value = "add")
  public String addLoanCollection(@Valid LoanCollection loanCollection, BindingResult result, Model model){
      if(result.hasErrors()){
          return "loanCollect/add";
      }else {
          if (loanCollection != null){
              LoanCollection loanCollection1 = this.loanCollectionRepo.findByEmployee(loanCollection.getEmployee());
              if (loanCollection1 != null){
                  model.addAttribute("existMsg", "LoanCollectionName is already exist");
              }else {
                  this.loanCollectionRepo.save(loanCollection);
                  model.addAttribute("loanCollection", new LoanCollection());
                  model.addAttribute("successMsg", "Data insert is Success");
              }
          }
      }
      return "loanCollect/add";
  }


    @GetMapping(value = "/list")
    public String LoanCollectionList(Model model) {
        model.addAttribute("list", this.loanCollectionRepo.findAll());
        return "loanCollect/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editLoanCollectionView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("loanCollection", this.loanCollectionRepo.getOne(id));
        return "loanCollect/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editLoanCollection(@Valid LoanCollection loanCollection, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "loanCollect/edit";
        } else {
            if (loanCollection != null) {
                LoanCollection loanCollection1 = this.loanCollectionRepo.findByEmployee(loanCollection.getEmployee());
                if (loanCollection1 != null) {
                    model.addAttribute("existMsg", "LoanCollectionName is already exist");
                    return "loanCollect/edit";
                } else {
                    this.loanCollectionRepo.save(loanCollection);
                    model.addAttribute("loanCollection", new LoanCollection());
                    model.addAttribute("successMsg", "Data Update is Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delLoanCollection(@PathVariable("id") Long id) {
        this.loanCollectionRepo.deleteById(id);
        return "redirect:/list";

    }


}