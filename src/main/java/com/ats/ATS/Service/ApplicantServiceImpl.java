package com.ats.ATS.Service;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

import org.aspectj.weaver.bcel.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ats.ATS.Repository.ApplicantRepo;
import com.ats.ATS.Response.ServiceResponse;
import com.ats.ATS.model.ApplicantData;

@Service
public class ApplicantServiceImpl implements ApplicantService{
	

	@Autowired
	ApplicantRepo applicantrepo;

	@Override
	public void saveapplicant(ApplicantData data) {
    
		applicantrepo.save(data);
		
	}
	
	

}
