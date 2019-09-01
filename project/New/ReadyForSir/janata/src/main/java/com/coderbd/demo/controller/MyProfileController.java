package com.coderbd.demo.controller;


import com.coderbd.demo.entity.MyProfile;
import com.coderbd.demo.ropo.MyProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/myprofile/")
public class MyProfileController {

    @Autowired
    private MyProfileRepo myProfileRepo;

    @GetMapping(value = "add")
    public String addMyProfileView(Model model) {
        model.addAttribute("myprofile", new MyProfile());
        return "myProfile/add";
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
        return "myProfile/add";
    }



    @GetMapping(value = "/list")
    public String myProfileList(Model model) {
        model.addAttribute("list", this.myProfileRepo.findAll());
        return "myProfile/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editMyProfileView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("myprofile", this.myProfileRepo.getOne(id));
        return "myProfile/edit";

    }
//
//    @PostMapping(value = "/edit/{id}")
//    public String editRole(@Valid Role role, BindingResult result, @PathVariable("id") Long id, Model model) {
//        if (result.hasErrors()) {
//            return "role/edit";
//        } else {
//            if (role != null) {
//                Role role1 = this.repo.findByRoleName(role.getRoleName());
//                if (role1 != null) {
//                    model.addAttribute("existMsg", "RoleName is already exist");
//                    return "role/edit";
//                } else {
//                    this.repo.save(role);
//                    model.addAttribute("role", new Role());
//                    model.addAttribute("successMsg", "Alread Success");
//                }
//            }
//        }
//        return "redirect:/list";
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String delRole(@PathVariable("id") Long id) {
//        this.repo.deleteById(id);
//        return "redirect:/list";
//
//    }
}
