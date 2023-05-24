package com.epam.racecup.controller;

import com.epam.racecup.model.Role;
import com.epam.racecup.model.dto.UserDTO;
import com.epam.racecup.service.AthleteService;
import com.epam.racecup.service.OrganizerService;
import com.epam.racecup.service.UserService;
import com.epam.racecup.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AthleteService athleteService;
    private final OrganizerService organizerService;
    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService,
                          AthleteService athleteService,
                          OrganizerService organizerService,
                          UserValidator userValidator) {
        this.userService = userService;
        this.athleteService = athleteService;
        this.organizerService = organizerService;
        this.userValidator = userValidator;
    }

    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("user") UserDTO user) {
        return "user/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") @Valid UserDTO user,
                             BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/new";
        }

        userService.saveUser(user);
        return "user/success_create_user";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        Page<UserDTO> allUserPaged = userService.getAllUsers(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("users", allUserPaged);

        int totalPages = allUserPaged.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "user/all";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id,
                              Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/id";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") long id,
                               Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id,
                           @ModelAttribute("user") @Validated UserDTO user,
                           BindingResult bindingResult) {

        //TODO: add fields to change athlete and organizer fields
        if (bindingResult.hasFieldErrors("password") ||
                bindingResult.hasFieldErrors("firstName")||
                bindingResult.hasFieldErrors("lastName")) {
            return "user/edit";
        }
        userService.updateUser(user);
        return "user/success_edit_user";
    }

    //TODO: check mapping
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(userService.getUserById(id));
        return "user/success_delete_user";
    }

    @GetMapping("/{id}/account")
    public String userAccount(@PathVariable("id") long id,
                              Model model) {
        UserDTO user = userService.getUserById(id);
        model.addAttribute("user", user);
        //additional info fields for the account
        if (user.getRole().equals(Role.ROLE_ATHLETE.getRole())) {
            model.addAttribute("athlete", athleteService.getAthleteById(id));
        } else if (user.getRole().equals(Role.ROLE_ORGANIZER.getRole())) {
            model.addAttribute("organizer", organizerService.getOrganizerById(id));
        }
        return "user/account";
    }

    @GetMapping("/set_role/{id}")
    public String setRoleForm(@PathVariable("id") long id,
                              Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/set_role";
    }

    @PostMapping("/set_role/{id}")
    public String setRole(@PathVariable("id") long id,
                          @ModelAttribute("user") UserDTO user) {
        userService.updateUserRole(user);
        return "user/success_edit_user";
    }

    @GetMapping("/sign_in")
    public String signIn() {
        return "user/sign_in";
    }

}

