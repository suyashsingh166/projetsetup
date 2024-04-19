package com.ats.ATS.model;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "applicant")
@lombok.Data
public class ApplicantData {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int id;
	
	@Column(name = "applicantName")
	private String name;
	
	@Column(name = "mobileNumber")
	private String mobNo;
	
	@Column(name = "DOB")
	private String dob;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "experience")
	private String experience;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "noticePeriod")
	private Integer noticePeriod;
	
	@Column(name = "resumename")
	private String resumename;

	@Transient
	private MultipartFile resume;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	

	public String getResumename() {
		return resumename;
	}

	public void setResumename(String resumename) {
		this.resumename = resumename;
	}

	public MultipartFile getResume() {
		return resume;
	}

	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}


	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Integer getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(Integer noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	
	

	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	

	@Override
	public String toString() {
		return "ApplicantData [id=" + id + ", name=" + name + ", mobNo=" + mobNo + ", dob=" + dob + ", gender=" + gender
				+ ", emailId=" + emailId + ", experience=" + experience + ", department=" + department
				+ ", noticePeriod=" + noticePeriod + ", resumename=" + resumename + ", resume=" + resume + "]";
	}

	public ApplicantData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicantData(int id, String name, String mobNo, String dob, String gender, String emailId,
			String experience, String department, Integer noticePeriod, String resumename, MultipartFile resume) {
		super();
		this.id = id;
		this.name = name;
		this.mobNo = mobNo;
		this.dob = dob;
		this.gender = gender;
		this.emailId = emailId;
		this.experience = experience;
		this.department = department;
		this.noticePeriod = noticePeriod;
		this.resumename = resumename;
		this.resume = resume;
	}


 


}
