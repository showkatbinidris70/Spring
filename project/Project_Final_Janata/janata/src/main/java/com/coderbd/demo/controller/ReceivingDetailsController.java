package com.coderbd.demo.controller;

import com.coderbd.demo.entity.ReceivingDetails;
import com.coderbd.demo.entity.SendingDetails;
import com.coderbd.demo.ropo.BranchRepo;
import com.coderbd.demo.ropo.EmployeeRepo;
import com.coderbd.demo.ropo.PackingRepo;
import com.coderbd.demo.ropo.ReceiveingDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/receivingDetails/")
public class ReceivingDetailsController {
    @Autowired
    private ReceiveingDetailsRepo receiveingDetailsRepo;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PackingRepo packingRepo;

    @GetMapping(value = "add")
    public String addReceivingDetailsView(Model model) {
        model.addAttribute("receivingDetails", new ReceivingDetails());
        model.addAttribute("branchList", this.branchRepo.findAll());
        model.addAttribute("employeeList", this.employeeRepo.findAll());
        model.addAttribute("packingList", this.packingRepo.findAll());
        return "receivingDetails/add";
    }


    @PostMapping(value = "add")
    public String addReceivingDetails(@Valid ReceivingDetails receivingDetails, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "receivingDetails/add";
        } else {
            if (receivingDetails != null) {
                ReceivingDetails receivingDetails1 = this.receiveingDetailsRepo.findByReceiverName(receivingDetails.getReceiverName());
                if (receivingDetails1 != null) {
                    model.addAttribute("existMsg", "Receiver Name is already exist");
                } else {
                    this.receiveingDetailsRepo.save(receivingDetails);
                    model.addAttribute("receivingDetails", new ReceivingDetails());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "sendingDetails/add";
    }


    @GetMapping(value = "/list")
    public String receivingDetailsList(Model model) {
        model.addAttribute("list", this.receiveingDetailsRepo.findAll());
        return "receivingDetails/list";
    }


    @GetMapping(value = "/edit/{id}")
    public String editReceivingDetailsView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("receivingDetails", this.receiveingDetailsRepo.getOne(id));
        return "receivingDetails/edit";

    }


    @PostMapping(value = "/edit/{id}")
    public String editReceivingDetails(@Valid ReceivingDetails receivingDetails, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "receivingDetails/edit";
        } else {
            if (receivingDetails != null) {
                ReceivingDetails receivingDetails1 = this.receiveingDetailsRepo.getOne(id);
                receivingDetails1.setReceiverName(receivingDetails.getReceiverName());
                this.receiveingDetailsRepo.save(receivingDetails1);
                model.addAttribute("receivingDetails", new ReceivingDetails());
                model.addAttribute("successMsg", "Update Successfully");

            }
        }
        return "redirect:/receivingDetails/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delReceivingDetails(@PathVariable("id") Long id) {
        this.receiveingDetailsRepo.deleteById(id);
        return "redirect:/receivingDetails/list";

    }
}
