package com.ats.ATS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.ApplicantData;

@Repository
public interface ApplicantRepo extends JpaRepository<ApplicantData, Integer>{

}
