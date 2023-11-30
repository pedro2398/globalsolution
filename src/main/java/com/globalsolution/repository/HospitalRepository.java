package com.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalsolution.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{
    
}
