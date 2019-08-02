package com.example.ngoProjects.controller;

import com.example.ngoProjects.entity.Nominee;
import com.example.ngoProjects.repo.NomineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/nominee/")
public class NomineeController {

    @Autowired
    private NomineeRepo repo;

    @GetMapping(value = "add")
    public String addNomineeView(Model model) {
        model.addAttribute("nominee", new Nominee());

        return "nominee/add";
    }


    @PostMapping(value = "add")
    public String addNominee(@Valid Nominee nominee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "nominee/add";
        } else {
            if (nominee != null) {
                Nominee nominee1 = this.repo.findByNomineeName(nominee.getNomineeName());
                if (nominee1 != null) {
                    model.addAttribute("existMsg", "NomineeName is already exist");
                } else {
                    this.repo.save(nominee);
                    model.addAttribute("nominee", new Nominee());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "nominee/add";
    }


    @GetMapping(value = "/list")
    public String nomineeList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "nominee/list";
    }


    @GetMapping(value = "/edit/{id}")
    public String editNomineeView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("nominee", this.repo.getOne(id));
        return "ngo/edit";

    }

    @PostMapping(value = "/edit/{id}")
    public String editNominee(@Valid Nominee nominee, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            return "nominee/edit";
        } else {
            if (nominee != null) {
                Nominee nominee1 = this.repo.findByNomineeName(nominee.getNomineeName());
                if (nominee1 != null) {
                    model.addAttribute("existMsg", "NomineeName is already exist");
                    return "nominee/edit";
                } else {
                    this.repo.save(nominee);
                    model.addAttribute("nominee", new Nominee());
                    model.addAttribute("successMsg", "Already Success");
                }
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delNominee(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/list";

    }


}
