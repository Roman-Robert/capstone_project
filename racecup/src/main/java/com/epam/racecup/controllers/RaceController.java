package com.epam.racecup.controllers;

import com.epam.racecup.models.Race;
import com.epam.racecup.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RaceController {

    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/schedule")
    public String getAllRacesForSchedule(Model model) {
        model.addAttribute("schedule", raceService.getAllRaces());
        return "schedule";
    }

    @GetMapping("/new_race")
    public String createRaceForm(Race race) {
        return "new_race";
    }

    @PostMapping("/new_race")
    public String createRace(Race race) {
        raceService.saveRace(race);
        return "redirect:/schedule";
    }
}
