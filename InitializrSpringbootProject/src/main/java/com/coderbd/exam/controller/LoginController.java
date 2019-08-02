
package com.coderbd.exam.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public String Login(){
        return "public/login";
    }
    
    @GetMapping(value = "/access-denied" )
    public String accessDenied(){
    return "access-denied";
    }
    
}
