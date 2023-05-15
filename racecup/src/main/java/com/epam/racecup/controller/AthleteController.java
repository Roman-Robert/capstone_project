package com.epam.racecup.controller;

import com.epam.racecup.model.Athlete;
import com.epam.racecup.model.Role;
import com.epam.racecup.model.User;
import com.epam.racecup.service.AthleteService;
import com.epam.racecup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/athlete")
public class AthleteController {

    private final AthleteService athleteService;
    private final UserService userService;

    @Autowired
    public AthleteController(AthleteService athleteService, UserService userService) {
        this.athleteService = athleteService;
        this.userService = userService;
    }

    @GetMapping("{id}/new")
    public String createAthleteForm(@PathVariable("id") Long id,
                                    Model model) {
        Athlete athlete = new Athlete();
        athlete.setId(id);
        model.addAttribute("athlete", athlete);
        return "athlete/new";
    }

    @PostMapping("{id}/new")
    public String createAthlete(@PathVariable("id") Long id,
                                @ModelAttribute("athlete") Athlete athlete) {
        athlete.setId(id);
        athleteService.saveAthlete(athlete);

        //change status user->athlete
        User updatedUser = userService.getUserById(id);
        updatedUser.setRole(Role.ATHLETE.getRole());
        userService.saveUser(updatedUser);
        return "athlete/success_user_to_athlete";
    }

    @GetMapping("/all")
    public String getAllAthletes(Model model) {
        model.addAttribute("athletes", athleteService.getAllAthletes());
        return "athlete/all";
    }

}
