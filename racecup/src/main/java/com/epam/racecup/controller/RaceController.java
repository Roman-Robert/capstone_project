package com.epam.racecup.controller;

import com.epam.racecup.model.dto.RaceDTO;
import com.epam.racecup.security.UserDetailsImpl;
import com.epam.racecup.service.RaceService;
import com.epam.racecup.util.RaceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/race")
public class RaceController {

    private final RaceService raceService;
    private final RaceValidator raceValidator;

    @Autowired
    public RaceController(RaceService raceService, RaceValidator raceValidator) {
        this.raceService = raceService;
        this.raceValidator = raceValidator;
    }

    @GetMapping("/all")
    public String getAllRaces(Model model,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<RaceDTO> allRacesPaged = raceService.getAllRaces(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("races", allRacesPaged);

        int totalPages = allRacesPaged.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "race/all";
    }

    @GetMapping("/schedule")
    public String getAllRacesForSchedule(Model model,
                                         @RequestParam("page") Optional<Integer> page,
                                         @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Date today = Date.valueOf(LocalDate.now());
        Page<RaceDTO> allRacesPaged = raceService.findByDateAfter(today, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("races", allRacesPaged);

        int totalPages = allRacesPaged.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "race/schedule";
    }

    @GetMapping("/new")
    public String createRaceForm(@ModelAttribute("race") RaceDTO race) {
        return "race/new";
    }

    @PostMapping("/new")
    public String createRace(@ModelAttribute("race") @Valid RaceDTO race,
                             BindingResult bindingResult) {
        raceValidator.validate(race, bindingResult);

        if (bindingResult.hasErrors()) {
            return "race/new";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        long organizerId = userDetails.getUser().getId();

        race.setOrganizerId(organizerId);

        raceService.saveRace(race);
        return "race/success_create_race";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRace(@PathVariable("id") long id) {
        ////Changing Race "is_actual" status 1->0
        RaceDTO race = raceService.getRaceById(id);
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
    public String editRace(@PathVariable("id") Long raceId,
                           @ModelAttribute("race") @Valid RaceDTO race,
                           BindingResult bindingResult) {
        raceValidator.validate(race, bindingResult);

        if (bindingResult.hasErrors()) {
            return "race/edit";
        }
        raceService.updateRace(race, raceId);
        return "race/success_edit_race";
    }

    @GetMapping("/about/{id}")
    public String aboutRace(@PathVariable("id") long id, Model model) {
        model.addAttribute("race", raceService.getRaceById(id));
        return "race/about";
    }
}
