package com.dawntechbd.simpleThymeleafTemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "list")
    public String getList(Model model){

        List<User> list = this.userRepository.findAll();
        model.addAttribute("list",list);
        return "users/list";
    }


    @GetMapping(value = "/add")
    public String add(Model model){
        model.addAttribute("user",new User());
        return "users/add";
    }

    @GetMapping(value = "/add")
    public String addView(Model model){
        model.addAttribute("user",new User());
        return "users/add";
    }

    @GetMapping(value = "/add")
    public String add(Model model,@Valid User user ){
        if (user == null){
            this.userRepository.save(user);
            model.addAttribute("successMsg","User Saved Successfully")
        }

        return "users/add";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id){
        return "users/edit";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id){
        return "redicrect:/user/list";
    }

}
