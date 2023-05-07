package com.epam.racecup.controllers;

import com.epam.racecup.models.Race;
import com.epam.racecup.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String createRaceForm(@ModelAttribute("race") Race race) {
        return "new_race";
    }

    @PostMapping("/new_race")
    public String createRace(@ModelAttribute("race") Race race) {
        raceService.saveRace(race);
        //Продумать редирект на "success create race" page
        return "redirect:/schedule";
    }

    @GetMapping("/race/delete/{id}")
    public String deleteRace(@PathVariable("id") int id) {
        raceService.deleteRaceById(id);
        //Продумать редирект на "success delete race" page
        //Продумать подтверждение удаления
        return "redirect:/schedule";
    }

    @GetMapping("/race/edit/{id}")
    public String editRace(@PathVariable("id") int id,
                           Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        return "edit_race";
    }


    @PostMapping("/race/edit/{id}")
    public String editRace(Race race) {
        raceService.saveRace(race);
        //Продумать редирект на "success edit race" page
        return "redirect:/schedule";
    }
    @GetMapping("/race/about/{id}")
    public String aboutRace(@PathVariable("id") int id,
                            Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        return "about_race";

    }



}
