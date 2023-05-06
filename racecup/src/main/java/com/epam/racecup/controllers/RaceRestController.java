package com.epam.racecup.controllers;

import com.epam.racecup.models.Race;
import com.epam.racecup.services.RaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class RaceRestController {

    private final RaceService raceService;

    public RaceRestController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping
    public List<Race> getAllRaces() {
        return raceService.getAllRaces();
    }
}
