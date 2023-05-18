package com.epam.racecup.controller;

import com.epam.racecup.model.entity.RaceEntity;
import com.epam.racecup.model.entity.RaceResultEntity;
import com.epam.racecup.service.AthleteService;
import com.epam.racecup.service.RaceService;
import com.epam.racecup.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/result")
public class ResultController {

    private final RaceService raceService;
    private final ResultService resultService;
    private final AthleteService athleteService;

    @Autowired
    public ResultController(RaceService raceService,
                            ResultService resultService,
                            AthleteService athleteService) {
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


    //implement the output of the calculation of the
    // age group, assignment of places
    @GetMapping("/{id}")
    public String getResultByRaceId(@PathVariable("id") long id,
                                    Model model,
                                    @RequestParam("page") Optional<Integer> page,
                                    @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<RaceResultEntity> resultsPaged = resultService
                .getRaceResultsByRaceId(id, PageRequest.of(currentPage - 1,
                        pageSize, Sort.by(Sort.Direction.ASC, "transitTime")));

        for (RaceResultEntity result:resultsPaged) {
            //group calculation
        }

        int totalPages = resultsPaged.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("results", resultsPaged);
        model.addAttribute("race", raceService.getRaceById(id));
        return "result/race_id";
    }

    @GetMapping("/{id}/set_result")
    public String setRaceResultsForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        model.addAttribute("results", resultService.getRaceResultsByRaceId(id));
        return "/result/set_result";
    }

    //Post mapping method doesn't work!!
    @PostMapping("/{id}/set_result")
    public String setRaceResults(@PathVariable("id") Long id,
                                 @ModelAttribute("race") RaceEntity race,
                                 @ModelAttribute("results") RaceResultEntity raceResult) {
        resultService.saveResult(raceResult);
        return "redirect:/result/" + race.getId();
    }
}
