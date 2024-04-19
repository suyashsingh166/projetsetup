package com.ats.ATS.Service;

import org.springframework.stereotype.Service;

import com.ats.ATS.model.ApplicantData;

@Service
public interface ApplicantService {
	
	public void saveapplicant(ApplicantData data);


}
