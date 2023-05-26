package com.epam.racecup.controller;

import com.epam.racecup.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("")
    public String getRatingPage() {
        return "/rating/rating";
    }

    @GetMapping("/personal")
    public String getPersonalRating(Model model) {
        model.addAttribute("ratings", ratingService.getPersonalRating());
        return "/rating/personal";
    }

    @GetMapping("/team")
    public String getTeamRating(Model model) {
        model.addAttribute("ratings", ratingService.getTeamRating());
        return "/rating/team";
    }
}