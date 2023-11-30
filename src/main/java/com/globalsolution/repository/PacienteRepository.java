package com.globalsolution.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.globalsolution.model.pessoa.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllPage(Pageable pageable);
}
