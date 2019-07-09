package com.example.securitySpringOne;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/home")
    public String displayHome(){
        return "home";
    }
    @GetMapping(value = "/hello")
    public String displayHello(){
        return "hello";
    }
    @GetMapping(value = "/")
    public String displayIndex(){
        return "index";
    }
    @GetMapping(value = "/login")
    public String displaylogin(){
        return "login";
    }
}
