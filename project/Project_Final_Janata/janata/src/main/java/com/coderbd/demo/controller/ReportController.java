package com.coderbd.demo.controller;

import com.coderbd.demo.ropo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/report")
public class ReportController {
    //Total Customer

    @Autowired
    private CustomerRepo customerRepo;
    int totalCustomer = 0;

    @GetMapping(value = "totalCustomer")
    public String getTotalCustomer(Model model) {
        totalCustomer = 0;
        model.addAttribute("list", customerRepo.findAll());
        model.addAttribute("totalCustomer", this.customerRepo.findAll().size());

        return "report/totalCustomer";
    }

    @Autowired
    private UserRepo userRepo;
    int totalUser = 0;

    @GetMapping(value = "totalUser")
    public String getTotalUser(Model model) {
        totalUser = 0;
        model.addAttribute("list", userRepo.findAll());
        model.addAttribute("totalUser", this.userRepo.findAll().size());

        return "report/totalUser";
    }


    //Branch
    @Autowired
    private BranchRepo branchRepo;
    int totalBranch = 0;

    @GetMapping(value = "totalBranch")
    public String getTotalBranch(Model model) {
        totalBranch = 0;
        model.addAttribute("list", branchRepo.findAll());
        model.addAttribute("totalBranch", this.branchRepo.findAll().size());

        return "report/totalBranch";
    }

    //Employee
    @Autowired
    private EmployeeRepo employeeRepo;
    int totalEmployee = 0;

    @GetMapping(value = "totalEmployee")
    public String getTotalEmployee(Model model) {
        totalEmployee = 0;
        model.addAttribute("list", employeeRepo.findAll());
        model.addAttribute("totalEmployee", this.employeeRepo.findAll().size());

        return "report/totalEmployee";
    }

    //Total Sender
    @Autowired
    private SendingDetailsRepo sendingDetailsRepo;
    int totalSender = 0;

    @GetMapping(value = "totalSender")
    public String getTotalSender(Model model) {
        totalSender = 0;
        model.addAttribute("list", sendingDetailsRepo.findAll());
        model.addAttribute("totalSender", this.sendingDetailsRepo.findAll().size());

        return "report/totalSender";
    }

    //Total Reveiver
    @Autowired
    private ReceiveingDetailsRepo receiveingDetailsRepo;
    int totalReceiver = 0;

    @GetMapping(value = "totalReceiver")
    public String getTotalReceiver(Model model) {
        totalReceiver = 0;
        model.addAttribute("list", receiveingDetailsRepo.findAll());
        model.addAttribute("totalReceiver", this.receiveingDetailsRepo.findAll().size());

        return "report/totalReceiver";
    }

    //Total Shipping
    @Autowired
    private ShippingDetailsRepo shippingDetailsRepo;
    int totalShipping = 0;

    @GetMapping(value = "totalShipping")
    public String getTotalShipping(Model model) {
        totalShipping = 0;
        model.addAttribute("list", shippingDetailsRepo.findAll());
        model.addAttribute("totalShipping", this.shippingDetailsRepo.findAll().size());

        return "report/totalShipping";
    }


}
