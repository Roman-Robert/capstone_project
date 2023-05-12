package com.epam.racecup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ResultController {

    @GetMapping("/result")
    public String result() {
        return "result/result";
    }

}
