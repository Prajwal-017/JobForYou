package com.example.jobforyou.controller;

import com.example.jobforyou.Entity.Employer;
import com.example.jobforyou.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    // Serve the HTML view
    @GetMapping
    public String employers(Model model) {
        // Retrieve a list of employers from the service and add it to the model
        List<Employer> employers = employerService.getAllEmployers();
        model.addAttribute("employers", employers);
        
        // Return the name of the HTML view (employers.html)
        return "employers";
    }

    // Method to serve the form (eprofile.html)
    @GetMapping("/profile")
    public String showEmployerProfileForm() {
        return "eprofile"; // Return the name of the HTML file for creating an employer profile
    }

    // Method to handle form submissions from eprofile.html
    @PostMapping
    public Employer createEmployer(@ModelAttribute Employer employer) {
        // Call service method to create a new employer
        return employerService.createEmployer(employer);
    }
}
