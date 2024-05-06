package com.example.jobforyou.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String companyName;
    private String jobDescription;
    private String requirements;
    private String workOptions;
	public Employer(Long id, String name, String email, String phone, String companyName, String jobDescription,
			String requirements, String workOptions) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.companyName = companyName;
		this.jobDescription = jobDescription;
		this.requirements = requirements;
		this.workOptions = workOptions;
	}
	public Employer() {
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getWorkOptions() {
		return workOptions;
	}
	public void setWorkOptions(String workOptions) {
		this.workOptions = workOptions;
	}
	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", companyName="
				+ companyName + ", jobDescription=" + jobDescription + ", requirements=" + requirements
				+ ", workOptions=" + workOptions + "]";
	}

    // Getters and setters
}
