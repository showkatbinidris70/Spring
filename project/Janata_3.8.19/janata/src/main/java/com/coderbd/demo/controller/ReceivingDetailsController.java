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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

//
//    @GetMapping(value = "/edit/{id}")
//    public String editUserView(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", this.userRepo.getOne(id));
//        return "user/edit";
//
//    }
//
//    @PostMapping(value = "/edit/{id}")
//    public String editUser(@Valid User user, BindingResult result, @PathVariable("id") Long id, Model model) {
//        if (result.hasErrors()) {
//            return "user/edit";
//        } else {
//            if (user != null) {
//                User user1 = this.userRepo.findByUsername(user.getUsername());
//                if (user1 != null) {
//                    model.addAttribute("existMsg", "UserName is already exist");
//                    return "user/edit";
//                } else {
//                    this.userRepo.save(user);
//                    model.addAttribute("user", new User());
//                    model.addAttribute("successMsg", "Alread Success");
//                }
//            }
//        }
//        return "redirect:/list";
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String delUser(@PathVariable("id") Long id) {
//        this.userRepo.deleteById(id);
//        return "redirect:/list";
//
//    }


}
