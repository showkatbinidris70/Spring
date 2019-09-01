package com.coderbd.demo.controller;


import com.coderbd.demo.entity.MyProfile;
import com.coderbd.demo.ropo.CompanyRepo;
import com.coderbd.demo.ropo.MyProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/myprofile/")
public class MyProfileController {

    @Autowired
    private MyProfileRepo myProfileRepo;

    @GetMapping(value = "add")
    public String addMyProfileView(Model model) {
        model.addAttribute("myprofile", new MyProfile());
        return "myprofile/add";
    }


    @PostMapping(value = "add")
    public String addMyProfile(@Valid MyProfile myProfile, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "myProfile/add";
        } else {
            if (myProfile != null) {
                MyProfile myProfile1 = this.myProfileRepo.findByUsername(myProfile.getUsername());
                if (myProfile1 != null) {
                    model.addAttribute("existMsg", "MyProfile Name is already exist");
                } else {
                    this.myProfileRepo.save(myProfile);
                    model.addAttribute("myprofile", new MyProfile());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "myprofile/add";
    }


//    @GetMapping(value = "/list")
//    public String myProfileList(Model model) {
//        model.addAttribute("list", this.myProfileRepo.findAll());
//        return "myprofile/list";
//    }
//
//
//    @GetMapping(value = "/edit/{id}")
//    public String editMyFprofileView(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("myprofile", this.myProfileRepo.getOne(id));
//        return "myprofile/edit";
//
//    }
//
//    @PostMapping(value = "/edit/{id}")
//    public String editMyProfile(@Valid MyProfile myProfile, BindingResult result, @PathVariable("id") Long id, Model model) {
//        if (result.hasErrors()) {
//            return "myprofile/edit";
//        } else {
//            if (myProfile != null) {
//                MyProfile myProfile1 = this.myProfileRepo.findByUsername(myProfile.getUsername());
//                if (myProfile1 != null) {
//                    model.addAttribute("existMsg", "MyProfile Name is already exist");
//                    return "myprofile/edit";
//                } else {
//                    this.myProfileRepo.save(myProfile);
//                    model.addAttribute("myprofile", new MyProfile());
//                    model.addAttribute("successMsg", "Alread Success");
//                }
//            }
//        }
//        return "redirect:/list";
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String delMyProfile(@PathVariable("id") Long id) {
//        this.myProfileRepo.deleteById(id);
//        return "redirect:/list";
//
//    }



}
