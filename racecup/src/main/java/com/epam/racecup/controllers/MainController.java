package com.epam.racecup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
    //заменить на Filter?
    @GetMapping("/mainpage")
    public String goToMainPage() {
        return "mainpage";
    }
}


