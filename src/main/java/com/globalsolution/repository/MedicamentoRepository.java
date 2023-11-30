package com.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalsolution.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{
    
}
