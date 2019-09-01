package com.coderbd.demo.reportContorller;

import com.coderbd.demo.ropo.CompanyRepo;
import com.coderbd.demo.ropo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/district/")
public class District {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CompanyRepo companyRepo;


    @GetMapping(value = "/districtlist")
    public String cusDistrictList(Model model) {
        model.addAttribute("list", this.customerRepo.findAllByDistrict("Rangpur"));
        return "reprot/districtlist";
    }


    
}
