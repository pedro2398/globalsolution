package com.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalsolution.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
