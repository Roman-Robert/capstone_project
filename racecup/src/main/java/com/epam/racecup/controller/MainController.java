package com.epam.racecup.controller;

import com.epam.racecup.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String login() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            Long userId = (userDetails.getUser().getId());

            if (userId != null) {
                return "redirect:/user/" + userId + "/account";
            }
        } catch (Exception e) {
        }

        return "/user/sign_in";
    }
}
