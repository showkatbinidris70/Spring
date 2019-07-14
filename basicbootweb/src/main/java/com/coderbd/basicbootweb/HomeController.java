package com.coderbd.basicbootweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private StudentRepository repository;


    @GetMapping(value = "/")
    public String home(Model model) {
        // this.repository.save(new Student(UUID.randomUUID().toString()));
        model.addAttribute("student", new Student());
        return "home";
    }

    // for saving
    @PostMapping(value = "/")
    public String saveStudent(Model model, @Valid Student student) {
        this.repository.save(student);
        //  model.addAttribute("success", " save Success!!!");
        return "redirect:/students";
    }

    @GetMapping(value = "/students")
    public String studentList(Model model) {
        List<Student> studentList = this.repository.findAll();
        model.addAttribute("slist", studentList);
        return "list";
    }

    @GetMapping(value = "/students2")
    public ModelAndView displayStudnts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList", this.repository.findAll());
        modelAndView.setViewName("list2");
        return modelAndView;
    }

    @GetMapping(value = "/students/{id}")
    public String getStudnetBYId(Model model, @PathVariable("id") Long id) {
        Student s = this.repository.getOne(id);
        model.addAttribute("stu", s);
        return "student";
    }

    @GetMapping(value = "/student")
    public String displaytStudnetBYId(Model model, @RequestParam(name = "studentId", required = false, defaultValue = "1") Long id) {
        Student s = this.repository.getOne(id);
        model.addAttribute("stu", s);
        return "student2";
    }


    @GetMapping(value = "/about.bd")
    public String aboutDisplay(Model model) {
        return "about";
    }

    @GetMapping(value = "/contact.php")
    public String contactDisplay(Model model) {
        return "contact";
    }
}
