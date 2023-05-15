package com.epam.racecup.controller;

import com.epam.racecup.model.Organizer;
import com.epam.racecup.model.Role;
import com.epam.racecup.model.User;
import com.epam.racecup.service.OrganizerService;
import com.epam.racecup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/organizer")
public class OrganizerController {

    private final UserService userService;
    private final OrganizerService organizerService;

    @Autowired
    public OrganizerController(UserService userService,
                               OrganizerService organizerService) {
        this.userService = userService;
        this.organizerService = organizerService;
    }

    @GetMapping("{id}/new")
    public String createOrganizerForm(@PathVariable("id") Long id,
                                      Model model) {
        Organizer organizer = new Organizer();
        organizer.setId(id);
        model.addAttribute("organizer", organizer);
        return "organizer/new";
    }

    @PostMapping("{id}/new")
    public String createOrganizer(@PathVariable("id") Long id,
                                  @ModelAttribute("organizer") Organizer organizer) {
        organizer.setId(id);
        organizerService.saveOrganizer(organizer);

        //change status user->organizer
        User updatedUser = userService.getUserById(id);
        updatedUser.setRole(Role.ORGANIZER.getRole());
        userService.saveUser(updatedUser);
        return "organizer/success_user_to_organizer";
    }

    @GetMapping("/all")
    public String getAllOrganizers(Model model) {
        model.addAttribute("organizers", organizerService.getAllOrganizers());
        return "organizer/all";
    }
}
