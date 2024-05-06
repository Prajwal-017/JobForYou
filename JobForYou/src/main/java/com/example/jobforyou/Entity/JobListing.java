package com.example.jobforyou.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String skillsRequired;
    private String location;
    private String jobType;
    private String employerName;
	public JobListing(Long id, String title, String description, String skillsRequired, String location, String jobType,
			String employerName) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.skillsRequired = skillsRequired;
		this.location = location;
		this.jobType = jobType;
		this.employerName = employerName;
	}
	public JobListing() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	@Override
	public String toString() {
		return "JobListing [id=" + id + ", title=" + title + ", description=" + description + ", skillsRequired="
				+ skillsRequired + ", location=" + location + ", jobType=" + jobType + ", employerName=" + employerName
				+ "]";
	}

    // Getters and setters
}
