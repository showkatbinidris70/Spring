
package com.coderbd.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
    @GetMapping(value = "/role")
    public String roleSave(){
    return "role";
    }
    
}
