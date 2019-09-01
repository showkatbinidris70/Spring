package com.coderbd.demo.controller;

import com.coderbd.demo.entity.Company;
import com.coderbd.demo.entity.Customer;
import com.coderbd.demo.ropo.CompanyRepo;
import com.coderbd.demo.ropo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/customer/")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CompanyRepo companyRepo;


    @GetMapping(value = "add")
    public String addCustomerView(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("companyList", this.companyRepo.findAll());
        return "customer/add";
    }


    @PostMapping(value = "add")
    public String addCustomer(@Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customer/add";
        } else {
            if (customer != null) {
                //  Branch branch1 = this.branchRepo.findByBranchName(branch.getBranchName());
                //  User user1 = this.userRepo.findByUsername(user.getUsername());
                Customer customer1 = this.customerRepo.findByCustomerName(customer.getCustomerName());
                if (customer1 != null) {
                    model.addAttribute("existMsg", "Customer Name is already exist");
                } else {
                    this.customerRepo.save(customer);
                    model.addAttribute("customer", new Customer());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "customer/add";
    }

//    @GetMapping(value = "/documentlist")
//    public String documentlList(Model model) {
//        model.addAttribute("list", this.parcelRepo.findAllByProductType("document"));
//        return "parcel/documentlist";
//    }

    @GetMapping(value = "/list")
    public String customerList(Model model) {
        model.addAttribute("list", this.customerRepo.findAll());
        return "customer/list";
    }

    @GetMapping(value = "/districtlist")
    public String cusDistrictList(Model model) {
        model.addAttribute("list", this.customerRepo.findAllByDistrict("Rangpur"));
        return "customer/districtlist";
    }


    @GetMapping(value = "/edit/{id}")
    public String editCustomerView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", this.customerRepo.getOne(id));
        return "customer/edit";

    }


    @PostMapping(value = "/edit/{id}")
    public String editCustomer(@Valid Customer customer, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "customer/edit";
        } else {
            if (customer != null) {
                Customer customer1 = this.customerRepo.getOne(id);
                customer1.setCustomerName(customer.getCustomerName());
                this.customerRepo.save(customer1);
                model.addAttribute("customer", new Company());
                model.addAttribute("successMsg", "Update Successfully");

            }
        }
        return "redirect:/customer/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delCustomer(@PathVariable("id") Long id) {
        this.customerRepo.deleteById(id);
        return "redirect:/customer/list";

    }
}
