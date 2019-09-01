package com.coderbd.demo.controller;

import com.coderbd.demo.entity.User;
import com.coderbd.demo.ropo.RoleRepo;
import com.coderbd.demo.ropo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;




    @GetMapping(value = "add")
    public String addUserView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "user/add";
    }

    @PostMapping(value = "add")
    public String addUser(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("roleList", this.roleRepo.findAll());
            return "user/add";
        }else {
            if (user != null){
                User user1 = this.userRepo.findByUsername(user.getUsername());
                if (user1 != null){
                    model.addAttribute("existMsg", "UserName is already exist");
                }else {
                    user.setStatus(true);

                    user.setConformationToken(UUID.randomUUID().toString());
                    this.userRepo.save(user);
                    model.addAttribute("user", new User());
                    model.addAttribute("roleList", this.roleRepo.findAll());
                    model.addAttribute("successMsg", "Congratulation Data Insert Success");
                }
            }
        }
        return "user/add";
    }

//    @PostMapping(value = "add")
//    public String addUser(@Valid User user, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "user/add";
//        } else {
//            if (user != null) {
//                User user1 = this.userRepo.findByUsername(user.getUsername());
//                if (user1 != null) {
//                    model.addAttribute("existMsg", "UserName is already exist");
//                } else {
//                    this.userRepo.save(user);
//                    model.addAttribute("user", new User());
//                    model.addAttribute("successMsg", "Already Success");
//                }
//            }
//        }
//        return "user/add";
//    }

    @GetMapping(value = "/list")
    public String userList(Model model) {
        model.addAttribute("list", this.userRepo.findAll());
        return "user/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editUserView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userRepo.getOne(id));
        return "user/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editUser(@Valid User user, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "user/edit";
        } else {
            if (user != null) {
                User user1 = this.userRepo.findByUsername(user.getUsername());
                if (user1 != null) {
                    model.addAttribute("existMsg", "UserName is already exist");
                    return "user/edit";
                } else {
                    this.userRepo.save(user);
                    model.addAttribute("user", new User());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "redirect:/list";
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delUser(@PathVariable("id") Long id) {
        this.userRepo.deleteById(id);
        return "redirect:/list";

    }

}
