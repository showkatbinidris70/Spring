package com.coderbd.demo.controller;


import com.coderbd.demo.entity.Branch;
import com.coderbd.demo.ropo.BranchRepo;
import com.coderbd.demo.ropo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/branch/")
public class BranchController {

    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping(value = "add")
    public String addBranchView(Model model) {
        model.addAttribute("branch", new Branch());
        model.addAttribute("companyList", this.companyRepo.findAll());
        return "branch/add";
    }


    @PostMapping(value = "add")
    public String addBranch(@Valid Branch branch, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "branch/add";
        } else {
            if (branch != null) {
              //  Branch branch1 = this.branchRepo.findByBranchName(branch.getBranchName());
                //  User user1 = this.userRepo.findByUsername(user.getUsername());
                Branch branch1 = this.branchRepo.findByBranchName(branch.getBranchName());
                if (branch1 != null) {
                    model.addAttribute("existMsg", "Branch Name is already exist");
                } else {
                    this.branchRepo.save(branch);
                    model.addAttribute("branch", new Branch());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "branch/add";
    }


    @GetMapping(value = "/list")
    public String branchList(Model model) {
        model.addAttribute("list", this.branchRepo.findAll());
        return "branch/list";
    }


    @GetMapping(value = "/edit/{id}")
    public String editBranchView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("branch", this.branchRepo.getOne(id));
        return "branch/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editBranch(@Valid Branch branch, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "branch/edit";
        } else {
            if (branch != null) {
                Branch branch1 = this.branchRepo.findByBranchName(branch.getBranchName());
                if (branch1 != null) {
                    model.addAttribute("existMsg", "Branch Name is already exist");
                    return "branch/edit";
                } else {
                    this.branchRepo.save(branch);
                    model.addAttribute("branch", new Branch());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delBranch(@PathVariable("id") Long id) {
        this.branchRepo.deleteById(id);
        return "redirect:/list";

    }


}
