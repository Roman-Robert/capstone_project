package com.epam.racecup.controllers;

import com.epam.racecup.models.Race;
import com.epam.racecup.services.ScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleRestController {

    private final ScheduleService scheduleService;

    public ScheduleRestController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Race> getAllRaces() {
        return scheduleService.getAllRaces();
    }
}
