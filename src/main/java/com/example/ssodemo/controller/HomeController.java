package com.example.ssodemo.controller;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/secured")
    public String secured(Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("name", principal.getFullName());
        model.addAttribute("email", principal.getEmail());
        return "secured";
    }
}
