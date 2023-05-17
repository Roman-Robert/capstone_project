package com.epam.racecup.controller;

import com.epam.racecup.model.Race;
import com.epam.racecup.model.RaceResult;
import com.epam.racecup.service.AthleteService;
import com.epam.racecup.service.RaceService;
import com.epam.racecup.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/result")
public class ResultController {

    private final RaceService raceService;
    private final ResultService resultService;
    private final AthleteService athleteService;

    @Autowired
    public ResultController(RaceService raceService, ResultService resultService, AthleteService athleteService) {
        this.raceService = raceService;
        this.resultService = resultService;
        this.athleteService = athleteService;
    }

    @GetMapping("")
    public String result(Model model) {
        Date today = Date.valueOf(LocalDate.now());
        model.addAttribute("races", raceService.findByDateBefore(today));
        return "result/result";
    }


    //implement the output of the full name, the calculation of the age group, assignment of places
    @GetMapping("/{id}")
    public String getResultByRaceId(@PathVariable("id") long id, Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        model.addAttribute("results", resultService.getRaceResultsByRaceId(id));
        return "result/race_id";
    }

    //page for enter race result by id
    @GetMapping("/{id}/set_result")
    public String setRaceResultsForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        model.addAttribute("results", resultService.getRaceResultsByRaceId(id));
        return "/result/set_result";
    }

    //Post mapping method doesn't work!!
    @PostMapping("/{id}/set_result")
    public String setRaceResults(@PathVariable("id") Long id,
                                 @ModelAttribute("race") Race race,
                                 @ModelAttribute("results") RaceResult raceResult) {
        resultService.saveResult(raceResult);
        return "redirect:/result/"+race.getId();
    }
}
