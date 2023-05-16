package com.epam.racecup.controller;

import com.epam.racecup.model.User;
import com.epam.racecup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
//    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
//        this.userValidator = userValidator;
    }

    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "user/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user/new";
        }
        userService.saveUser(user);
        return "user/success_create_user";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/all";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id,
                              Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/id";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id,
                           @ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        //Saving old password, isActive, role
        User oldUser = userService.getUserById(id);
        user.setPassword(oldUser.getPassword());
        user.setIsActive(oldUser.getIsActive());
        user.setRole(oldUser.getRole());

        userService.saveUser(user);
        return "user/success_edit_user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        //Changing User status 1->0
        User user = userService.getUserById(id);
        user.setIsActive(0);
        userService.saveUser(user);
        return "user/success_delete_user";
    }

    @GetMapping("/{id}/account")
    public String userAccount(@PathVariable("id") long id,
                              Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/account";
    }

    @GetMapping("/sign_in")
    public String signIn() {
        return "user/sign_in";
    }

}

