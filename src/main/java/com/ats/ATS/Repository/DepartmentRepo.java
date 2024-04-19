package com.ats.ATS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.ApplicantData;
import com.ats.ATS.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
