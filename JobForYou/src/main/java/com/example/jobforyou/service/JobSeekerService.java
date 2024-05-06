package com.example.jobforyou.service;

import java.util.List;
import java.util.Optional;

import com.example.jobforyou.Entity.JobSeeker;

public interface JobSeekerService {
    List<JobSeeker> getAllJobSeekers();

    Optional<JobSeeker> getJobSeekerById(Long id);

    JobSeeker createJobSeeker(JobSeeker jobSeeker);

    JobSeeker updateJobSeeker(Long id, JobSeeker jobSeekerDetails);

    void deleteJobSeeker(Long id);

	void applyForJob(Long jobListingId);

	boolean applyForJob(Long jobSeekerId, Long jobListingId);
}
