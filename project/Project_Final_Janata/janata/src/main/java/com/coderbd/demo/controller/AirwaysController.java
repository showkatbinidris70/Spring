package com.coderbd.demo.controller;

import com.coderbd.demo.entity.Airways;
import com.coderbd.demo.ropo.AirwaysRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/airways/")
public class AirwaysController {
    @Autowired
    private AirwaysRepo airwaysRepo;

    @GetMapping(value = "add")
    public String addAirwaysView(Model model) {
        model.addAttribute("airways", new Airways());
        return "airways/add";

    }

    @PostMapping(value = "add")
    public String addAirways(@Valid Airways airways, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "airways/add";
        } else {
            if (airways != null) {
                Airways airways1 = this.airwaysRepo.findByAirwaysName(airways.getAirwaysName());
                if (airways1 != null) {
                    model.addAttribute("existMsg", "AirwaysName is already exist");
                } else {
                    this.airwaysRepo.save(airways);
                    model.addAttribute("airways", new Airways());
                    model.addAttribute("successMsg", "Alread Success");
                }
            }
        }
        return "airways/add";
    }

    @GetMapping(value = "/list")
    public String airwaysList(Model model) {
        model.addAttribute("list", this.airwaysRepo.findAll());
        return "airways/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String editAirwaysView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("airways", this.airwaysRepo.getOne(id));
        return "airways/edit";

    }


    @PostMapping(value = "/edit/{id}")
    public String editAirways(@Valid Airways airways, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "airways/edit";
        } else {
            if (airways != null) {
                Airways airways1 = this.airwaysRepo.getOne(id);
                airways1.setAirwaysName(airways.getAirwaysName());
                this.airwaysRepo.save(airways1);
                model.addAttribute("airways", new Airways());
                model.addAttribute("successMsg", "Update Successfully");

            }
        }
        return "redirect:/airways/list";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delAirways(@PathVariable("id") Long id) {
        this.airwaysRepo.deleteById(id);
        return "redirect:/airways/list";

    }

}
