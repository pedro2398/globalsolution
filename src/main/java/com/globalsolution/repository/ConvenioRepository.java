package com.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalsolution.model.Convenio;

public interface ConvenioRepository extends JpaRepository<Convenio, Long> {
    
}
