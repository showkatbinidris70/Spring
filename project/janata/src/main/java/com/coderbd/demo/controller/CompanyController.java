package com.coderbd.demo.controller;

import com.coderbd.demo.ropo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepo companyRepo;



}
