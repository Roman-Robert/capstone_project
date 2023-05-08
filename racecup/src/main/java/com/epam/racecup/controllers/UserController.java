package com.epam.racecup.controllers;

import com.epam.racecup.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

/*    @GetMapping()
    public String createUserForm() {
        return "user/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user/all";
        }
*/

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "user/all";
    }

   /* @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id,
                              Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/account";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id,
                              Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(User user) {
        userService.saveUser(user);
        return "redirect:/account";
    }

    @GetMapping("delete")
    public String deleteUser(@PathVariable("id") int id) {
        //Продумать редирект на "success delete user" page
        //менять только статус юзера is_active, а не удалять
        userService.deleteUserById(id);
        return "redirect:/user/all";
}*/


}

