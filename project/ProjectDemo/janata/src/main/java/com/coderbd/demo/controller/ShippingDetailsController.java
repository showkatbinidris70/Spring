package com.coderbd.demo.controller;


import com.coderbd.demo.entity.ShippingDetails;
import com.coderbd.demo.ropo.ShippingDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/shippingDetails/")
public class ShippingDetailsController {

    @Autowired
    private ShippingDetailsRepo shippingDetailsRepo;

    @GetMapping(value = "add")
    public String addShippingDetailsView(Model model) {
        model.addAttribute("shippingDetails", new ShippingDetails());
        return "shippingDetails/add";

    }

    @PostMapping(value = "add")
    public String addShippingDetails(@Valid ShippingDetails shippingDetails, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "shippingDetails1/add";
        } else {
            if (shippingDetails != null) {
                ShippingDetails shippingDetails1 = this.shippingDetailsRepo.findByRecieverName(shippingDetails.getRecieverName());
                if (shippingDetails1 != null) {
                    model.addAttribute("existMsg", "shippingDetails is already exist");
                } else {
                    this.shippingDetailsRepo.save(shippingDetails);
                    model.addAttribute("shippingDetails", new ShippingDetails());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "shippingDetails/add";
    }


    @GetMapping(value = "/list")
    public String ShippingDetails(Model model) {
        model.addAttribute("list", this.shippingDetailsRepo.findAll());
        return "shippingDetails/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editShippingDetailsView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("shippingDetails", this.shippingDetailsRepo.getOne(id));
        return "shippingDetails/edit";

    }


    @PostMapping(value = "/edit/{id}")
    public String editShippingDetails(@Valid ShippingDetails shippingDetails, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "shippingDetails/edit";
        } else {
            if (shippingDetails != null) {
                ShippingDetails shippingDetails1 = this.shippingDetailsRepo.getOne(id);
                shippingDetails1.setRecieverName(shippingDetails.getRecieverName());
                this.shippingDetailsRepo.save(shippingDetails1);
                model.addAttribute("shippingDetails", new ShippingDetails());
                model.addAttribute("successMsg", "Update Successfully");

            }
        }
        return "redirect:/shippingDetails/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delShippingDetails(@PathVariable("id") Long id) {
        this.shippingDetailsRepo.deleteById(id);
        return "redirect:/shippingDetails/list";

    }
}
