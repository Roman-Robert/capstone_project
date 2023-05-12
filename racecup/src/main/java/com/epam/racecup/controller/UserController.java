package com.epam.racecup.controller;

import com.epam.racecup.model.User;
import com.epam.racecup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "user/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/all";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id,
                              Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/id";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") int id,
                           Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(User user) {
        userService.saveUser(user);
//        return "redirect:/account";
        return "redirect:/user/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        //Продумать редирект на "success delete user" page
        //менять только статус юзера is_active, а не удалять
        userService.deleteUserById(id);
        return "redirect:/user/all";
    }

}

