package com.example.jobforyou.service;

import java.util.List;
import java.util.Optional;

import com.example.jobforyou.Entity.Employer;

public interface EmployerService {
    List<Employer> getAllEmployers();

    Optional<Employer> getEmployerById(Long id);

    Employer createEmployer(Employer employer);

    Employer updateEmployer(Long id, Employer employerDetails);

    void deleteEmployer(Long id);
}
