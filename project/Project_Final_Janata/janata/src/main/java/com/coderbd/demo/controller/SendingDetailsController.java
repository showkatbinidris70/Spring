package com.coderbd.demo.controller;

import com.coderbd.demo.entity.SendingDetails;
import com.coderbd.demo.ropo.BranchRepo;
import com.coderbd.demo.ropo.EmployeeRepo;
import com.coderbd.demo.ropo.PackingRepo;
import com.coderbd.demo.ropo.SendingDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/sendingDetails/")
public class SendingDetailsController {
    @Autowired
    private SendingDetailsRepo sendingDetailsRepo;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PackingRepo packingRepo;

    @GetMapping(value = "add")
    public String addSendingDetailsView(Model model) {
        model.addAttribute("sendingDetails", new SendingDetails());
        model.addAttribute("branchList", this.branchRepo.findAll());
        model.addAttribute("employeeList", this.employeeRepo.findAll());
        model.addAttribute("packingList", this.packingRepo.findAll());
        return "sendingDetails/add";
    }


    @PostMapping(value = "add")
    public String addSendingDetails(@Valid SendingDetails sendingDetails, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "sendingDetails/add";
        } else {
            if (sendingDetails != null) {
                SendingDetails sendingDetails1 = this.sendingDetailsRepo.findBySenderName(sendingDetails.getSenderName());
                if (sendingDetails1 != null) {
                    model.addAttribute("existMsg", "Sender Code is already exist");
                } else {
                    this.sendingDetailsRepo.save(sendingDetails);
                    model.addAttribute("sendingDetails", new SendingDetails());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "sendingDetails/add";
    }


    @GetMapping(value = "/list")
    public String sendingDetailsList(Model model) {
        model.addAttribute("list", this.sendingDetailsRepo.findAll());
        return "sendingDetails/list";
    }


    @GetMapping(value = "/edit/{id}")
    public String editSendingDetailsView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("sendingDetails", this.sendingDetailsRepo.getOne(id));
        return "sendingDetails/edit";

    }


    @PostMapping(value = "/edit/{id}")
    public String editSendingDetails(@Valid SendingDetails sendingDetails, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "sendingDetails/edit";
        } else {
            if (sendingDetails != null) {
                SendingDetails sendingDetails1 = this.sendingDetailsRepo.getOne(id);
                sendingDetails1.setSenderName(sendingDetails.getSenderName());
                this.sendingDetailsRepo.save(sendingDetails1);
                model.addAttribute("sendingDetails", new SendingDetails());
                model.addAttribute("successMsg", "Update Successfully");

            }
        }
        return "redirect:/sendingDetails/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delSendingDetails(@PathVariable("id") Long id) {
        this.sendingDetailsRepo.deleteById(id);
        return "redirect:/sendingDetails/list";

    }
}
