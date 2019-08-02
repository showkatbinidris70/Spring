package com.coderbd.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexView() {
        return "index";
    }

}
