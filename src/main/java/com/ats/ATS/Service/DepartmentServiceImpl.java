package com.ats.ATS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.DepartmentRepo;
import com.ats.ATS.model.Department;
@Service
public class DepartmentServiceImpl implements  DepartmentService{
	
	@Autowired
	DepartmentRepo departmentrepo;

	@Override
	public List<Department> find() {
		return departmentrepo.findAll();
	}

}
