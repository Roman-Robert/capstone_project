package com.epam.racecup.controller;

import com.epam.racecup.model.dto.AthleteDTO;
import com.epam.racecup.service.AthleteService;
import com.epam.racecup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/athlete")
public class AthleteController {

    private final AthleteService athleteService;

    @Autowired
    public AthleteController(AthleteService athleteService, UserService userService) {
        this.athleteService = athleteService;
    }

    @GetMapping("{id}/new")
    public String createAthleteForm(@PathVariable("id") Long id,
                                    Model model) {
        model.addAttribute("athlete", AthleteDTO.builder().id(id).build());
        return "athlete/new";
    }

    @PostMapping("{id}/new")
    public String createAthlete(@PathVariable("id") Long id,
                                @ModelAttribute("athlete") AthleteDTO athlete) {
        athleteService.saveAthlete(athlete);
        return "athlete/success_user_to_athlete";
    }

    @GetMapping("/all")
    public String getAllAthletes(Model model,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<AthleteDTO> allAthletesPaged = athleteService.getAllAthletes(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("athletes", allAthletesPaged);

        int totalPages = allAthletesPaged.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "athlete/all";
    }

}
