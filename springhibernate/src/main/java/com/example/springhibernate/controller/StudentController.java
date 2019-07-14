package com.example.springhibernate.controller;

import com.example.springhibernate.entity.Department;
import com.example.springhibernate.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private DepartmentRepo repo;

    @Autowired
    private DepartmentRepo

    @GetMapping(value = "/student")

    public String displayIndex(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("list", this.repo.findAll());
        model.addAttribute("deplist", this.departmentRepo.findAll());
        return "index";
    }

    @PostMapping(value = "/")
    public String save(Model model, @Valid Department dep, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something Wrong");
        } else {
            this.repo.save(dep);
            model.addAttribute("successMsg", "Date save Successfuly");
            model.addAttribute("list", this.repo.findAll());
        }
        return "index";
    }
}
