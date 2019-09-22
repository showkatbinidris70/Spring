package com.coderbd.demo.controller;


import com.coderbd.demo.entity.Parcel;
import com.coderbd.demo.ropo.BranchRepo;
import com.coderbd.demo.ropo.CompanyRepo;
import com.coderbd.demo.ropo.ParcelRepo;
import com.coderbd.demo.ropo.ShippingDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/parcel/")
public class ParcelController {
    @Autowired
    private ParcelRepo parcelRepo;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private ShippingDetailsRepo shippingDetailsRepo;

    @GetMapping(value = "add")
    public String addParcelView(Model model) {
        model.addAttribute("parcel", new Parcel());
        model.addAttribute("branchList", this.branchRepo.findAll());
        model.addAttribute("companyList", this.companyRepo.findAll());
        model.addAttribute("shippingDetailsList", this.shippingDetailsRepo.findAll());
        return "parcel/add";
    }


    @PostMapping(value = "add")
    public String addParcel(@Valid Parcel parcel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "parcel/add";
        } else {
            if (parcel != null) {
                Parcel parcel1 = this.parcelRepo.findByParcelName(parcel.getParcelName());
                if (parcel1 != null) {
                    model.addAttribute("existMsg", "Parcel Name is already exist");
                } else {
                    this.parcelRepo.save(parcel);
                    model.addAttribute("parcel", new Parcel());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "parcel/add";
    }


    @GetMapping(value = "/list")
    public String ParcelList(Model model) {
        model.addAttribute("list", this.parcelRepo.findAll());
        return "parcel/list";
    }


    @GetMapping(value = "/parcellist")
    public String parcelList(Model model) {
        model.addAttribute("list", this.parcelRepo.findAllByProductType("parcel"));
        return "parcel/parcellist";
    }

    @GetMapping(value = "/documentlist")
    public String documentlist(Model model) {
        model.addAttribute("list", this.parcelRepo.findAllByProductType("document"));
        return "parcel/documentlist";
    }

    @GetMapping(value = "/cashlist")
    public String cashlist(Model model) {
        model.addAttribute("list", this.parcelRepo.findAllByDeliveryType("cash"));
        return "parcel/cashlist";
    }

    @GetMapping(value = "/craditlist")
    public String craditlist(Model model) {
        model.addAttribute("list", this.parcelRepo.findAllByDeliveryType("cradit"));
        return "parcel/craditlist";
    }

    @GetMapping(value = "/proreceive")
    public String proreceive(Model model) {
        model.addAttribute("list", this.parcelRepo.findAllByReceivedToAndProductType("China", "parcel"));
        return "parcel/proreceive";
    }


//
//
//    @GetMapping(value = "/bdpercellist")
//    public String bdparcelList(Model model) {
//        model.addAttribute("list", this.parcelRepo.findAllByProductTypeAndSendCountry("parcel","Bangladesh"));
//        return "parcel/bdparcellist";
//    }
//
//    @GetMapping(value = "/dubaipercellist")
//    public String dubaiparcelList(Model model) {
//        model.addAttribute("list", this.parcelRepo.findAllByProductTypeAndReceivedTo("parcel","Dubi"));
//        return "parcel/dubaiparcellist";
//    }
//
//    @GetMapping(value = "/deliverydatelist")
//    public String deliveryDateList(Model model) {
//        model.addAttribute("list", this.parcelRepo.findAllByProductType("2019-09-04"));
//        return "parcel/documentlist";
//    }

    @GetMapping(value = "/edit/{id}")
    public String editParcelView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("parcel", this.parcelRepo.getOne(id));
        return "parcel/edit";

    }


    @PostMapping(value = "/edit/{id}")
    public String editParcel(@Valid Parcel parcel, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "parcel/edit";
        } else {
            if (parcel != null) {
                Parcel parcel1 = this.parcelRepo.getOne(id);
                parcel1.setParcelName(parcel.getParcelName());
                this.parcelRepo.save(parcel1);
                model.addAttribute("parcel", new Parcel());
                model.addAttribute("successMsg", "Update Successfully");

            }
        }
        return "redirect:/parcel/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delParcel(@PathVariable("id") Long id) {
        this.parcelRepo.deleteById(id);
        return "redirect:/parcel/list";

    }
}
