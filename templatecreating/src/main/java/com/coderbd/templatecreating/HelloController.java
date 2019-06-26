package com.coderbd.templatecreating;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping(value = "/")
    public String DisplayIndex(){
        return "index";
    }
    @GetMapping(value = "/header")
    public String DisplayHeader(){
        return "header";
    }
    @GetMapping(value = "/footer")
    public String DisplayFooter(){
        return "footer";
    }
}
