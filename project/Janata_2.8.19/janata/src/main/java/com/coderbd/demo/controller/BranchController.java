package com.coderbd.demo.controller;

import com.coderbd.demo.entity.Branch;
import com.coderbd.demo.ropo.BranchRepo;
import com.coderbd.demo.ropo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BranchController {
    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private CompanyRepo companyRepo;


//    @GetMapping(value = "add")
//    public String addUserView(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("roleList", this.roleRepo.findAll());
//        return "user/add";
//    }

//    @GetMapping(value = "add")
//    public String addBranchView(Model model){
//        model.addAttribute("branch", new Branch());
//        model.addAttribute("branchList", this)
//    }



}
