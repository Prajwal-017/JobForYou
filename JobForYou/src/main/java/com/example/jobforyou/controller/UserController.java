package com.example.jobforyou.controller;

import com.example.jobforyou.Entity.User;
import com.example.jobforyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Serve the registration form
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration";
    }

    // Handle user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        // Call service method to register the user
        userService.registerUser(user);

        // Redirect to the appropriate page based on the user's role
        if ("jobseeker".equals(user.getRole())) {
            return "redirect:/job-seekers";
        } else if ("employer".equals(user.getRole())) {
            return "redirect:/employers";
        } else {
            return "redirect:/";
        }
    }

    // Serve the login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Handle user login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        // Verify the user's credentials
        User user = userService.verifyCredentials(email, password);
        if (user != null) {
            // Redirect to the appropriate page based on the user's role
            if ("jobseeker".equals(user.getRole())) {
                return "redirect:/job-seekers";
            } else if ("employer".equals(user.getRole())) {
                return "redirect:/employers";
            }
        }
        // If login fails, return to login page with error
        model.addAttribute("loginError", "Invalid email or password.");
        return "login";
    }

    // Serve the forgot password form
    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password";
    }

    // Handle forgot password form submission
    @PostMapping("/forgot-password")
    public String changePassword(@RequestParam String email, @RequestParam String newPassword, Model model) {
        // Call service method to change the user's password
        boolean passwordChanged = userService.changePassword(email, newPassword);

        if (passwordChanged) {
            model.addAttribute("message", "Password changed successfully.");
            return "login"; // Redirect back to the login page
        } else {
            model.addAttribute("error", "Failed to change password. Email not found.");
            return "forgot-password"; // Return to the password reset page with an error message
        }
    }
}
