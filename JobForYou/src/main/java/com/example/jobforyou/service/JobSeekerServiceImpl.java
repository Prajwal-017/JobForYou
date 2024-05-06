package com.example.jobforyou.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobforyou.Entity.JobListing;
import com.example.jobforyou.Entity.JobSeeker;
import com.example.jobforyou.repository.JobListingRepository;
import com.example.jobforyou.repository.JobSeekerRepository;
@Service
public class JobSeekerServiceImpl implements JobSeekerService {
	
	@Autowired
	private JobListingRepository jobListingRepository;
	
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Override
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

    @Override
    public Optional<JobSeeker> getJobSeekerById(Long id) {
        return jobSeekerRepository.findById(id);
    }

    @Override
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }

    @Override
    public JobSeeker updateJobSeeker(Long id, JobSeeker jobSeekerDetails) {
        JobSeeker existingJobSeeker = jobSeekerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Seeker not found"));
        existingJobSeeker.setName(jobSeekerDetails.getName());
        existingJobSeeker.setEmail(jobSeekerDetails.getEmail());
        existingJobSeeker.setPhone(jobSeekerDetails.getPhone());
        existingJobSeeker.setSkills(jobSeekerDetails.getSkills());
        existingJobSeeker.setExperience(jobSeekerDetails.getExperience());
        existingJobSeeker.setEducation(jobSeekerDetails.getEducation());
        existingJobSeeker.setPreferences(jobSeekerDetails.getPreferences());
        return jobSeekerRepository.save(existingJobSeeker);
    }

    @Override
    public void deleteJobSeeker(Long id) {
        jobSeekerRepository.deleteById(id);
    }

	@Override
	public void applyForJob(Long jobListingId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean applyForJob(Long jobSeekerId, Long jobListingId) {
	    // Retrieve the job seeker by ID
	    Optional<JobSeeker> jobSeekerOptional = jobSeekerRepository.findById(jobSeekerId);
	    
	    // Retrieve the job listing by ID
	    Optional<JobListing> jobListingOptional = jobListingRepository.findById(jobListingId);
	    
	    // Check if both the job seeker and job listing exist
	    if (jobSeekerOptional.isPresent() && jobListingOptional.isPresent()) {
	        JobSeeker jobSeeker = jobSeekerOptional.get();
	        JobListing jobListing = jobListingOptional.get();
	        
	        // Add the job listing ID to the job seeker's list of applied jobs
	        jobSeeker.addAppliedJob(jobListingId); // Implement this method in JobSeeker class
	        
	        // Save the updated job seeker
	        jobSeekerRepository.save(jobSeeker);
	        
	        // Return true to indicate successful application
	        return true;
	    }
	    
	    // If either the job seeker or job listing was not found, return false
	    return false;
	}

}
