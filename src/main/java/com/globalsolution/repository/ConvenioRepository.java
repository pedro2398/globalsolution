package com.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalsolution.model.Convenio;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ConvenioRepository extends JpaRepository<Convenio, Long> {
    
}
