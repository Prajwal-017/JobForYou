package com.example.jobforyou.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String skills;
    private String experience;
    private String education;
    private String preferences;
    
    // New field to track applied jobs
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Long> appliedJobs = new ArrayList<>();
    
    public JobSeeker(Long id, String name, String email, String phone, String skills, String experience,
                    String education, String preferences) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
        this.experience = experience;
        this.education = education;
        this.preferences = preferences;
    }
    
    public JobSeeker() {
        super();
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getSkills() {
        return skills;
    }
    
    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    public String getExperience() {
        return experience;
    }
    
    public void setExperience(String experience) {
        this.experience = experience;
    }
    
    public String getEducation() {
        return education;
    }
    
    public void setEducation(String education) {
        this.education = education;
    }
    
    public String getPreferences() {
        return preferences;
    }
    
    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
    
    @Override
    public String toString() {
        return "JobSeeker [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", skills=" + skills
                + ", experience=" + experience + ", education=" + education + ", preferences=" + preferences + "]";
    }
    
    // Method to add a job listing ID to the list of applied jobs
    public void addAppliedJob(Long jobListingId) {
        if (!appliedJobs.contains(jobListingId)) {
            appliedJobs.add(jobListingId);
        }
    }
    
    // Getter for appliedJobs
    public List<Long> getAppliedJobs() {
        return appliedJobs;
    }
}
