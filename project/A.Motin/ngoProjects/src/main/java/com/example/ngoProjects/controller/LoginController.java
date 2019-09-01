package com.example.ngoProjects.controller;


import com.example.ngoProjects.entity.User;
import com.example.ngoProjects.repo.RoleRepo;
import com.example.ngoProjects.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){
        return "redirect:/";
    }
    return "login";

    }

    @GetMapping(value = "/access-denied")
    public String accessDenied(){
        return "access-denied";
    }


    @GetMapping(value = "/signup")
    public String viewSignUp(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
}
