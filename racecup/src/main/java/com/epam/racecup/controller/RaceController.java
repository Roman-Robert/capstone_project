package com.epam.racecup.controller;

import com.epam.racecup.model.Race;
import com.epam.racecup.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String createRace(@ModelAttribute("race") @Valid Race race,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "race/new";
        }
        raceService.saveRace(race);
        return "race/success_create_race";
    }

    @GetMapping("/delete/{id}")
    public String deleteRace(@PathVariable("id") long id) {
        ////Changing Race "is_actual" status 1->0
        Race race = raceService.getRaceById(id);
        race.setIsActual(0);
        raceService.saveRace(race);
        return "race/success_delete_race";
    }

    @GetMapping("/edit/{id}")
    public String editRace(@PathVariable("id") long id, Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        return "race/edit";
    }

    @PostMapping("/edit/{id}")
    public String editRace(@PathVariable("id") Long id,
                           @ModelAttribute("race") @Valid Race race,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        //Saving old "organizer_id", "is_actual"
        Race oldRace = raceService.getRaceById(id);
        race.setOrganizerId(oldRace.getOrganizerId());
        race.setIsActual(oldRace.getIsActual());
        raceService.saveRace(race);
        return "race/success_edit_race";
    }

    @GetMapping("/about/{id}")
    public String aboutRace(@PathVariable("id") long id, Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        return "race/about";
    }

}
