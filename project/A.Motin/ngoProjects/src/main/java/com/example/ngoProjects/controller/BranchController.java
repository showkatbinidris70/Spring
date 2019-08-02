package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.Branch;
import com.example.ngoProjects.repo.BranchRepo;
import com.example.ngoProjects.repo.EmployeeRepo;
import com.example.ngoProjects.repo.NgoRepo;
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
    private EmployeeRepo employeeRepo;

    @Autowired
    private NgoRepo ngoRepo;


    @GetMapping(value = "add")
    public String addBranchView(Model model) {
        model.addAttribute("branch", new Branch());
        model.addAttribute("employeeList", this.employeeRepo.findAll());
        model.addAttribute("ngoList", this.ngoRepo.findAll());
        return "branch/add";
    }


    @PostMapping(value = "add")
    public String addBranch(@Valid Branch branch, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "branch/add";
        } else {
            if (branch != null) {
                Branch branch1 = this.branchRepo.findByBranchName(branch.getBranchName());
                if (branch1 != null) {
                    model.addAttribute("existMsg", "BranchName is already exist");
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
    public String BranchList(Model model) {
        model.addAttribute("list", this.branchRepo.findAll());
        return "branch/list";
    }


    @GetMapping(value = "/edit/{id}")
    public String editBranchView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("branch", this.branchRepo.getOne(id));
        return "user/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editBranch(@Valid Branch branch, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "branch/edit";
        } else {
            if (branch != null) {
                Branch branch1 = this.branchRepo.findByBranchName(branch.getBranchName());
                if (branch1 != null) {
                    model.addAttribute("existMsg", "BranchName is already exist");
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