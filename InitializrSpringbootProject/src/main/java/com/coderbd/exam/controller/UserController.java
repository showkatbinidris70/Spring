
package com.coderbd.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping(value = "/user-save")
    public String saveUser(){
    return "user";
    }
    
}
