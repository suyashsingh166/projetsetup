package com.ats.ATS.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ATS.model.Department;

@Service
public interface DepartmentService {
	
public List<Department> find();

}
