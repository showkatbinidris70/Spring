package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.EmployeeType;
import com.example.ngoProjects.repo.EmployeeTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/empType/")
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeRepo employeeTypeRepo;

    @GetMapping(value = "add")
    public String addEmployeeTypeView(Model model) {
        model.addAttribute("employeeType", new EmployeeType());
        return "empType/add";

    }

    @PostMapping(value = "add")
    public String addEmployeeType(@Valid EmployeeType employeeType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "empType/add";
        } else {
            if (employeeType != null) {
                EmployeeType employeeType1 = this.employeeTypeRepo.findByTypeName(employeeType.getTypeName());
                if (employeeType1 != null) {
                    model.addAttribute("existMsg", "EmployeeTypeName is already exist");
                } else {
                    this.employeeTypeRepo.save(employeeType);
                    model.addAttribute("employeeType", new EmployeeType());
                    model.addAttribute("successMsg", "Data insert is Success");
                }
            }
        }
        return "empType/add";
    }

    @GetMapping(value = "/list")
    public String employeeTypeList(Model model) {
        model.addAttribute("list", this.employeeTypeRepo.findAll());
        return "empType/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editEmployeeTypeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employeeType", this.employeeTypeRepo.getOne(id));
        return "empType/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editEmployeeType(@Valid EmployeeType employeeType, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "empType/edit";
        } else {
            if (employeeType != null) {
                EmployeeType employeeType1 = this.employeeTypeRepo.findByTypeName(employeeType.getTypeName());
                if (employeeType1 != null) {
                    model.addAttribute("existMsg", "EmployeeTypeName is already exist");
                    return "empType/edit";
                } else {
                    this.employeeTypeRepo.save(employeeType);
                    model.addAttribute("employeeType", new EmployeeType());
                    model.addAttribute("successMsg", "Data Update is Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delEmployeeType(@PathVariable("id") Long id) {
        this.employeeTypeRepo.deleteById(id);
        return "redirect:/list";

    }
}
