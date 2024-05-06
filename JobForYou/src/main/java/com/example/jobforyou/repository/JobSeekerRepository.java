package com.example.jobforyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobforyou.Entity.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
    // Add custom query methods if needed
}
