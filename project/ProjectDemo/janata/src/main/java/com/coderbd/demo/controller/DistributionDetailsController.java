package com.coderbd.demo.controller;

import com.coderbd.demo.entity.DistributionDetails;
import com.coderbd.demo.ropo.DistributionDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/distributionDetails/")
public class DistributionDetailsController {
    @Autowired
    private DistributionDetailsRepo distributionDetailsRepo;


    @GetMapping(value = "add")
    public String addDistributionDetailsView(Model model) {
        model.addAttribute("distributionDetails", new DistributionDetails());
        return "distributionDetails/add";
    }


    @PostMapping(value = "add")
    public String addDistributionDetails(@Valid DistributionDetails distributionDetails, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "distributionDetails/add";
        } else {
            if (distributionDetails != null) {
                DistributionDetails distributionDetails1 = this.distributionDetailsRepo.findByParcelName(distributionDetails.getParcelName());
                if (distributionDetails1 != null) {
                    model.addAttribute("existMsg", "DistributionDetails is already exist");
                } else {
                    this.distributionDetailsRepo.save(distributionDetails);
                    model.addAttribute("distributionDetails", new DistributionDetails());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "distributionDetails/add";
    }


    @GetMapping(value = "/list")
    public String distributionDetailsList(Model model) {
        model.addAttribute("list", this.distributionDetailsRepo.findAll());
        return "distributionDetails/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editDistritutionDetailsView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("distributionDetails", this.distributionDetailsRepo.getOne(id));
        return "distributionDetails/edit";

    }


    @PostMapping(value = "/edit/{id}")
    public String editDistributionDetails(@Valid DistributionDetails distributionDetails, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "distributionDetails/edit";
        } else {
            if (distributionDetails != null) {
                DistributionDetails distributionDetails1 = this.distributionDetailsRepo.getOne(id);
                distributionDetails1.setParcelName(distributionDetails.getParcelName());
                this.distributionDetailsRepo.save(distributionDetails1);
                model.addAttribute("distributionDetails", new DistributionDetails());
                model.addAttribute("successMsg", "Update Successfully");

            }
        }
        return "redirect:/distributionDetails/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delDistributionDetails(@PathVariable("id") Long id) {
        this.distributionDetailsRepo.deleteById(id);
        return "redirect:/distributionDetails/list";

    }
}
