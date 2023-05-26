package com.epam.racecup.controller;

import com.epam.racecup.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @GetMapping("")
    public String emptyRequest() {
        return "redirect:/mainpage";
    }

    @GetMapping("/mainpage")
    public String mainPage() {
        return "mainpage";
    }

    @GetMapping("/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            long userId = userDetails.getUser().getId();

            return "redirect:/user/" + userId + "/account";
        }
        return "/user/sign_in";
    }
}