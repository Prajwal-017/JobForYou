package com.example.jobforyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobforyou.Entity.JobListing;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {
    // Add custom query methods if needed
}
