package com.coderbd.demo.controller;

import com.coderbd.demo.entity.Packing;
import com.coderbd.demo.ropo.BranchRepo;
import com.coderbd.demo.ropo.CompanyRepo;
import com.coderbd.demo.ropo.PackingRepo;
import com.coderbd.demo.ropo.ParcelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/packing/")
public class PackingController {
    @Autowired
    private PackingRepo packingRepo;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private ParcelRepo parcelRepo;

    @GetMapping(value = "add")
    public String addPackingView(Model model) {
        model.addAttribute("packing", new Packing());
        model.addAttribute("branchList", this.branchRepo.findAll());
        model.addAttribute("companyList", this.companyRepo.findAll());
        model.addAttribute("parcelList", this.parcelRepo.findAll());
        return "packing/add";
    }


    @PostMapping(value = "add")
    public String addPacking(@Valid Packing packing, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "packing/add";
        } else {
            if (packing != null) {
                Packing packing1 = this.packingRepo.findByPackingCode(packing.getPackingCode());
                if (packing1 != null) {
                    model.addAttribute("existMsg", "PackingCode is already exist");
                } else {
                    this.packingRepo.save(packing);
                    model.addAttribute("packing", new Packing());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "packing/add";
    }


    @GetMapping(value = "/list")
    public String packingList(Model model) {
        model.addAttribute("list", this.packingRepo.findAll());
        return "packing/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editPackingView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("packing", this.packingRepo.getOne(id));
        return "packing/edit";

    }


    @PostMapping(value = "/edit/{id}")
    public String editPacking(@Valid Packing packing, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "packing/edit";
        } else {
            if (packing != null) {
                Packing packing1 = this.packingRepo.getOne(id);
                packing1.setPackingCode(packing.getPackingCode());
                this.packingRepo.save(packing1);
                model.addAttribute("packing", new Packing());
                model.addAttribute("successMsg", "Update Successfully");

            }
        }
        return "redirect:/packing/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delPacking(@PathVariable("id") Long id) {
        this.packingRepo.deleteById(id);
        return "redirect:/packing/list";

    }
}

