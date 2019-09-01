package com.coderbd.demo.controller;

import com.coderbd.demo.entity.Employee;
import com.coderbd.demo.ropo.BranchRepo;
import com.coderbd.demo.ropo.CompanyRepo;
import com.coderbd.demo.ropo.EmployeeRepo;
import com.coderbd.demo.ropo.UserRepo;
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
    private BranchRepo branchRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "add")
    public String addEmployeeView(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("branchList", this.branchRepo.findAll());
        model.addAttribute("companyList", this.companyRepo.findAll());
        model.addAttribute("userList", this.userRepo.findAll());
        return "employee/add";
    }
    @PostMapping(value = "add")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "employee/add";
        } else {
            if (employee != null) {
                Employee employee1 = this.employeeRepo.findByFirstName(employee.getFirstName());
                if (employee1 != null) {
                    model.addAttribute("existMsg", "Employee Name is already exist");
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
                Employee employee1 = this.employeeRepo.getOne(id);
                employee1.setFirstName(employee.getFirstName());
                this.employeeRepo.save(employee1);
                model.addAttribute("employee", new Employee());
                model.addAttribute("successMsg", "Update Successfully");
            }
        }
        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delEmployee(@PathVariable("id") Long id) {
        this.employeeRepo.deleteById(id);
        return "redirect:/employee/list";

    }

}
