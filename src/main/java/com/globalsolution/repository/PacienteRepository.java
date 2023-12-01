package com.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalsolution.model.pessoa.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
