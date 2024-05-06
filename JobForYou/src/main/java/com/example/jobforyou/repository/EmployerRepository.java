package com.example.jobforyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobforyou.Entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    // Add custom query methods if needed
}
