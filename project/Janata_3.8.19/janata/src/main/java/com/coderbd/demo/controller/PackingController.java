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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

