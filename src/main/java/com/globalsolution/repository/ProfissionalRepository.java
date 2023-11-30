package com.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalsolution.model.pessoa.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    
}
