package com.epam.racecup.controller;

import com.epam.racecup.model.User;
import com.epam.racecup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {

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
        int pageSize = size.orElse(10);

        Page<User> allUserPaged = userService.getAllUsers(PageRequest.of(currentPage - 1, pageSize));
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

