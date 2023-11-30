package com.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalsolution.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{
    
}
