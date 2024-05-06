package com.example.jobforyou.controller;

import com.example.jobforyou.Entity.JobListing;
import com.example.jobforyou.Entity.JobSeeker;
import com.example.jobforyou.service.JobListingService;
import com.example.jobforyou.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/job-seekers")
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @Autowired
    private JobListingService jobListingService;

    // Serve the HTML view for job seekers
    @GetMapping
    public String jobSeekers(Model model) {
        // Retrieve a list of job seekers and add them to the model
        List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers();
        model.addAttribute("jobSeekers", jobSeekers);

        // Retrieve a list of job listings and add them to the model
        List<JobListing> jobListings = jobListingService.getAllJobListings();
        model.addAttribute("jobListings", jobListings);

        // Return the name of the HTML view (jobSeekers.html)
        return "jobSeekers";
    }

    // Serve the HTML view for creating a job seeker profile
    @GetMapping("/profile")
    public String showCreateJobSeekerProfileForm() {
        return "createJobSeekerProfile"; // Returns the name of the HTML view (createJobSeekerProfile.html)
    }

    // Handle job seeker profile creation
    @PostMapping
    public String createJobSeeker(@ModelAttribute JobSeeker jobSeeker, Model model) {
        try {
            jobSeekerService.createJobSeeker(jobSeeker);
            model.addAttribute("successMessage", "Job seeker profile created successfully.");
            return "redirect:/job-seekers"; // Redirect to job seekers view
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to create job seeker profile.");
            return "createJobSeekerProfile"; // Return to profile creation view
        }
    }

    // Handle job applications
    @PostMapping("/apply")
    public String applyForJob(@RequestParam Long jobListingId, @RequestParam Long jobSeekerId, Model model) {
        boolean applicationSuccess = jobSeekerService.applyForJob(jobSeekerId, jobListingId);
        
        if (applicationSuccess) {
            model.addAttribute("successMessage", "Successfully applied for the job.");
        } else {
            model.addAttribute("errorMessage", "Failed to apply for the job.");
        }

        return "redirect:/job-seekers"; // Redirect back to the job seekers page
    }
}
