package com.epam.racecup.controllers;

import com.epam.racecup.services.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;


    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public String getAllRacesForSchedule(Model model) {
        model.addAttribute("schedule", scheduleService.getAllRaces());
        return "schedule";
    }
}
