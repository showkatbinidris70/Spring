package com.example.ngoProjects.controller;

import com.example.ngoProjects.entity.Ngo;
import com.example.ngoProjects.repo.NgoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/ngo/")
public class NgoController {

    @Autowired
    private NgoRepo ngoRepo;

    @GetMapping(value = "add")
    public String addNgoView(Model model) {
        model.addAttribute("ngo", new Ngo());
        model.addAttribute("ngoList", this.ngoRepo.findAll());
        return "ngo/add";
    }


    @PostMapping(value = "add")
    public String addNgo(@Valid Ngo ngo, BindingResult result, Model model){
        if(result.hasErrors()){
            return "ngo/add";
        }else {
            if (ngo != null){
                Ngo ngo1 = this.ngoRepo.findByName(ngo.getName());
                if (ngo1 != null){
                    model.addAttribute("existMsg", "NgoName is already exist");
                }else {
                    this.ngoRepo.save(ngo);
                    model.addAttribute("ngo", new Ngo());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "ngo/add";
    }


    @GetMapping(value = "/list")
    public String ngoList(Model model) {
        model.addAttribute("list", this.ngoRepo.findAll());
        return "ngo/list";
    }



    @GetMapping(value = "/edit/{id}")
    public String editNgoView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ngo", this.ngoRepo.getOne(id));
        return "ngo/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editNgo(@Valid Ngo ngo, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "ngo/edit";
        } else {
            if (ngo != null) {
                Ngo ngo1 = this.ngoRepo.findByName(ngo.getName());
                if (ngo1 != null) {
                    model.addAttribute("existMsg", "NgoName is already exist");
                    return "ngo/edit";
                } else {
                    this.ngoRepo.save(ngo);
                    model.addAttribute("ngo", new Ngo());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delNgo(@PathVariable("id") Long id) {
        this.ngoRepo.deleteById(id);
        return "redirect:/list";

    }




}
