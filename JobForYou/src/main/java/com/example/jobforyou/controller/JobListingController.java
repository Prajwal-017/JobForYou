package com.example.jobforyou.controller;

import com.example.jobforyou.Entity.JobListing;
import com.example.jobforyou.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/job-listings")
public class JobListingController {

    @Autowired
    private JobListingService jobListingService;

    // Serve the HTML view of job listings
    @GetMapping
    public String jobListings(Model model) {
        // Retrieve all job listings and add to the model
        List<JobListing> jobListings = jobListingService.getAllJobListings();
        model.addAttribute("jobListings", jobListings);
        return "jobListings"; // Return the name of the Thymeleaf view (jobListings.html)
    }

    // Serve API data of all job listings
    @GetMapping("/api")
    public List<JobListing> getAllJobListings() {
        return jobListingService.getAllJobListings();
    }

    // Serve API data of a specific job listing by ID
    @GetMapping("/api/{id}")
    public ResponseEntity<JobListing> getJobListingById(@PathVariable Long id) {
        return jobListingService.getJobListingById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Create a new job listing
    @PostMapping("/api")
    public JobListing createJobListing(@RequestBody JobListing jobListing) {
        return jobListingService.createJobListing(jobListing);
    }

    // Update an existing job listing by ID
    @PutMapping("/api/{id}")
    public ResponseEntity<JobListing> updateJobListing(@PathVariable Long id, @RequestBody JobListing jobListingDetails) {
        JobListing updatedJobListing = jobListingService.updateJobListing(id, jobListingDetails);
        return ResponseEntity.ok(updatedJobListing);
    }

    // Delete a job listing by ID
    @DeleteMapping("/api/{id}")
    public ResponseEntity<Void> deleteJobListing(@PathVariable Long id) {
        jobListingService.deleteJobListing(id);
        return ResponseEntity.noContent().build();
    }
}
