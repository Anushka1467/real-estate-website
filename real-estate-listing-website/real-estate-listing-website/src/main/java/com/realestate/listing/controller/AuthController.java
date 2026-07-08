package com.realestate.listing.controller;

import com.realestate.listing.model.User;
import com.realestate.listing.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Home Page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Signup Page
    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    // Register User
    @PostMapping("/signup")
    public String registerUser(@ModelAttribute("user") User user,
                               Model model) {

        if (userService.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "Email already exists!");
            return "signup";
        }

        userService.registerUser(user);

        return "redirect:/login";
    }
}