package com.dawntechbd.classDemoTemplate.controller;

import com.dawntechbd.classDemoTemplate.entity.Role;
import com.dawntechbd.classDemoTemplate.entity.User;
import com.dawntechbd.classDemoTemplate.repo.RoleRepo;
import com.dawntechbd.classDemoTemplate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;
    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(value = "/user/create",method = RequestMethod.GET)
    public ModelAndView getUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("userPage");
        return modelAndView;
    }

    @RequestMapping(value = "/user/create",method = RequestMethod.POST)
    public String saveRole(@Valid User user, BindingResult bindingResult){
        user.setPassword(encoder.encode(user.getPassword()));
        this.repo.save(user);
        return "userPage";
    }
}
