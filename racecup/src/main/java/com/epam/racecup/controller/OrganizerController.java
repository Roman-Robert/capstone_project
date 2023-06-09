package com.epam.racecup.controller;

import com.epam.racecup.model.dto.OrganizerDTO;
import com.epam.racecup.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizer")
public class OrganizerController {

    private final OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @GetMapping("{id}/new")
    public String createOrganizerForm(@PathVariable("id") Long id,
                                      Model model) {
        model.addAttribute("organizer", OrganizerDTO.builder().id(id).build());
        return "organizer/new";
    }

    @PostMapping("{id}/new")
    public String createOrganizer(@PathVariable("id") Long id,
                                  @ModelAttribute("organizer") @Validated OrganizerDTO organizer,
                                  BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors("mobilePhone")) {
            return "organizer/new";
        }
        organizerService.saveOrganizer(organizer);
        return "organizer/success_user_to_organizer";
    }

    @GetMapping("/all")
    public String getAllOrganizers(Model model) {
        model.addAttribute("organizers", organizerService.getAllOrganizers());
        return "organizer/all";
    }
}