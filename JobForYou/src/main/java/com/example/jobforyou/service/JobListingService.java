package com.example.jobforyou.service;

import java.util.List;
import java.util.Optional;

import com.example.jobforyou.Entity.JobListing;

public interface JobListingService {
    List<JobListing> getAllJobListings();

    Optional<JobListing> getJobListingById(Long id);

    JobListing createJobListing(JobListing jobListing);

    JobListing updateJobListing(Long id, JobListing jobListingDetails);

    void deleteJobListing(Long id);
}
