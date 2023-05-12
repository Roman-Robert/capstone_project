package com.epam.racecup.controller;

import com.epam.racecup.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/result")
public class ResultController {

    private final RaceService raceService;
//    private final ResultService resultService;

    @Autowired
    public ResultController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("")
    public String result(Model model) {
        model.addAttribute("races", raceService.getAllRaces());
        return "result/result";
    }

    @GetMapping("/{id}")
    public String getResultByRaceId(@PathVariable("id") long id, Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        return "result/id";
    }

}
