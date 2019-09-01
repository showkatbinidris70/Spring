package com.example.ngoProjects.controller;

import com.example.ngoProjects.repo.UserRepo;
import com.example.ngoProjects.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private UserRepo userRepo;

    @ResponseBody
    @GetMapping(value = "/test")
    public User restApi(){
        return userRepo.findByUsername("admin");
    }
}
