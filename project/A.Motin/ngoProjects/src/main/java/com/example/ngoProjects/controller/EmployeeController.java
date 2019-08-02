package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.Employee;
import com.example.ngoProjects.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;


    @Autowired
    private EmployeeTypeRepo employeeTypeRepo;

    @Autowired
    private NgoRepo ngoRepo;

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private UserRepo userRepo;


    @GetMapping(value = "add")
    public String addEmployeeView(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeList", this.employeeRepo.findAll());

        model.addAttribute("employeeTypeList", this.employeeTypeRepo.findAll());
        model.addAttribute("ngoList", this.ngoRepo.findAll());
        model.addAttribute("branchList", this.branchRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        return "branch/add";
    }


    @PostMapping(value = "add")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "employee/add";
        } else {
            if (employee != null) {
                Employee employee1 = this.employeeRepo.findByEmployeeName(employee.getEmployeeName());
                if (employee1 != null) {
                    model.addAttribute("existMsg", "EmployeeName is already exist");
                } else {
                    this.employeeRepo.save(employee);
                    model.addAttribute("employee", new Employee());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "employee/add";
    }


    @GetMapping(value = "/list")
    public String EmployeeList(Model model) {
        model.addAttribute("list", this.employeeRepo.findAll());
        return "employee/list";
    }


    @GetMapping(value = "/edit/{id}")
    public String editEmployeeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", this.employeeRepo.getOne(id));
        return "employee/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editEmployee(@Valid Employee employee, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "employee/edit";
        } else {
            if (employee != null) {
                Employee employee1 = this.employeeRepo.findByEmployeeName(employee.getEmployeeName());
                if (employee1 != null) {
                    model.addAttribute("existMsg", "EmployeeName is already exist");
                    return "employee/edit";
                } else {
                    this.employeeRepo.save(employee);
                    model.addAttribute("employee", new Employee());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delEmployee(@PathVariable("id") Long id) {
        this.employeeRepo.deleteById(id);
        return "redirect:/list";

    }


}