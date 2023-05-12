package com.epam.racecup.controller;

import com.epam.racecup.model.Race;
import com.epam.racecup.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/race")
public class RaceController {

    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/all")
    public String getAllRacesForSchedule(Model model) {
        model.addAttribute("race", raceService.getAllRaces());
        return "race/all";
    }

    @GetMapping("/new")
    public String createRaceForm(@ModelAttribute("race") Race race) {
        return "race/new";
    }

    @PostMapping("/new")
    public String createRace(@ModelAttribute("race") Race race) {
        raceService.saveRace(race);
        //Продумать редирект на "success create race" page
        return "race/success_create_race";
    }

    @GetMapping("/delete/{id}")
    public String deleteRace(@PathVariable("id") int id) {
        raceService.deleteRaceById(id);
        //Продумать редирект на "success delete race" page
        //Продумать подтверждение удаления
        return "race/success_delete_race";
    }

    @GetMapping("/edit/{id}")
    public String editRace(@PathVariable("id") int id,
                           Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        return "race/edit";
    }

    @PostMapping("/edit/{id}")
    public String editRace(Race race) {
        raceService.saveRace(race);
        //Продумать редирект на "success edit race" page
        return "race/success_edit_race";
    }
    @GetMapping("/about/{id}")
    public String aboutRace(@PathVariable("id") int id,
                            Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        return "race/about";
    }
}
