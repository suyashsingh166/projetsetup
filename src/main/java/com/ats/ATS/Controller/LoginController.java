package com.ats.ATS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ats.ATS.Response.*;
import com.ats.ATS.Service.ApplicantService;
import com.ats.ATS.Service.DepartmentService;
import com.ats.ATS.Service.UserService;
import com.ats.ATS.model.ApplicantData;
import com.ats.ATS.model.Department;
import com.ats.ATS.model.User;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/career")
public class LoginController {
	
	 Logger logger = LoggerFactory.getLogger(LoginController.class);
	 
	   @Value("${applicant.documents.location}")
		String visitorDoc;
	 
	    @Autowired
	    ApplicantService applicantservice;
	    
	    @Autowired
	    DepartmentService departmentService;
		
		
	    @PostMapping("/careers")
	    public ServiceResponse<?> career(@ModelAttribute ApplicantData applicantdata){
	    	try {
	    		
	    		MultipartFile resume= applicantdata.getResume();
	    		String resumename=resume.getOriginalFilename();
	    		
	    		applicantdata.setResumename(resumename);
	    		System.out.println("resumename"+resumename);
	    		
	    		 String filePath = visitorDoc; 
	    		 System.out.println("file"+filePath);
	    		 HashMap<String,InputStream> uploadFileMap = new HashMap<String,InputStream>();
	    			       
	    			        File directoryPath = new File(filePath); 
	    			        if (!directoryPath.exists()) {
	    			        directoryPath.mkdir();
	    			        }
	    			        File resumefile=new File(directoryPath,resumename);
	    			       
	    			        try {
	    					
	    					resume.transferTo(resumefile);
	    			        }
	    			        catch(Exception e) {
	    			        	System.out.println(e.getLocalizedMessage());
	    			        }
	    		applicantservice.saveapplicant(applicantdata);
	    	 
	    	return new ServiceResponse<>(new GeneralMessage<>("new Applicant Registered", 201), HttpStatus.ACCEPTED);
	    }catch(Exception e) {
	    	return new ServiceResponse<>(new GeneralMessage<>("Something went wrong",500),
					HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    }
	    @GetMapping("/department")
	    public ServiceResponse<?> department(){
	    	List<Department> departments = departmentService.find();
	    	System.out.println("list"+departments.toString());
	    	return new ServiceResponse<>(new GeneralMessage<>("OK",departments, 200), HttpStatus.OK);
	    }
	    }
	    	


