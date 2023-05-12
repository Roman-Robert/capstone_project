package com.epam.racecup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @GetMapping("")
    public String emptyRequest() {
        return "redirect:/mainpage";
    }

    @GetMapping("/mainpage")
    public String mainPage() {
        return "mainpage";
    }

    @GetMapping("/login")
    public String login() {
        return "/user/sign_in";
    }

}
