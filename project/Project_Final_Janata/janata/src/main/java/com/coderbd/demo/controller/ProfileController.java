package com.coderbd.demo.controller;


import com.coderbd.demo.entity.User;
import com.coderbd.demo.ropo.RoleRepo;
import com.coderbd.demo.ropo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/profile")
    public String profileView(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user1 = this.userRepo.findByUsername(auth.getName());
        model.addAttribute("user", this.userRepo.findByUsername(auth.getName()));

        return "profile";
    }
}
