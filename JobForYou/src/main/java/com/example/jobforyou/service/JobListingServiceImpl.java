package com.example.jobforyou.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobforyou.Entity.JobListing;
import com.example.jobforyou.repository.JobListingRepository;

@Service
public class JobListingServiceImpl implements JobListingService {
    @Autowired
    private JobListingRepository jobListingRepository;

    @Override
    public List<JobListing> getAllJobListings() {
        return jobListingRepository.findAll();
    }

    @Override
    public Optional<JobListing> getJobListingById(Long id) {
        return jobListingRepository.findById(id);
    }

    @Override
    public JobListing createJobListing(JobListing jobListing) {
        return jobListingRepository.save(jobListing);
    }

    @Override
    public JobListing updateJobListing(Long id, JobListing jobListingDetails) {
        JobListing existingJobListing = jobListingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Listing not found"));
        existingJobListing.setTitle(jobListingDetails.getTitle());
        existingJobListing.setDescription(jobListingDetails.getDescription());
        existingJobListing.setSkillsRequired(jobListingDetails.getSkillsRequired());
        existingJobListing.setLocation(jobListingDetails.getLocation());
        existingJobListing.setJobType(jobListingDetails.getJobType());
        existingJobListing.setEmployerName(jobListingDetails.getEmployerName());
        return jobListingRepository.save(existingJobListing);
    }

    @Override
    public void deleteJobListing(Long id) {
        jobListingRepository.deleteById(id);
    }
}
