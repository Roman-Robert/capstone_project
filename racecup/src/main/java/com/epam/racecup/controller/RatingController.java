package com.epam.racecup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rating")
public class RatingController {

    @GetMapping("")
    public String rating() {
        return "/rating/rating";
    }

}
