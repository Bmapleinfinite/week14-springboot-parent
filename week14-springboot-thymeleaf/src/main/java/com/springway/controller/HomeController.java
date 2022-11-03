package com.springway.controller;

import com.springway.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/toTest")
    public String toTest(Model model){
        model.addAttribute("user", new User(1,"miku", "123456"));
        return "test";
    }
}
