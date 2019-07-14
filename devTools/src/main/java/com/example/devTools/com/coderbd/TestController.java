package com.example.devTools.com.coderbd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/")
    public String index() {
        return "Hello Spring Rest Api";
    }

    @GetMapping(value = "/test")
    public String indexTest() {
        return "Hello Spring Rest Api";
    }

}
