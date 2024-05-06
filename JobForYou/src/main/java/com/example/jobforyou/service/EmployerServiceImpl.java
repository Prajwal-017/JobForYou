package com.example.jobforyou.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobforyou.Entity.Employer;
import com.example.jobforyou.repository.EmployerRepository;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    @Override
    public Optional<Employer> getEmployerById(Long id) {
        return employerRepository.findById(id);
    }

    @Override
    public Employer createEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public Employer updateEmployer(Long id, Employer employerDetails) {
        Employer existingEmployer = employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found"));
        existingEmployer.setName(employerDetails.getName());
        existingEmployer.setEmail(employerDetails.getEmail());
        existingEmployer.setPhone(employerDetails.getPhone());
        existingEmployer.setCompanyName(employerDetails.getCompanyName());
        existingEmployer.setJobDescription(employerDetails.getJobDescription());
        existingEmployer.setRequirements(employerDetails.getRequirements());
        existingEmployer.setWorkOptions(employerDetails.getWorkOptions());
        return employerRepository.save(existingEmployer);
    }

    @Override
    public void deleteEmployer(Long id) {
        employerRepository.deleteById(id);
    }
}
