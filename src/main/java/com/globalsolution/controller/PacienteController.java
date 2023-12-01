package com.globalsolution.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.globalsolution.model.dto.PacienteDto;
import com.globalsolution.model.pessoa.Paciente;
import com.globalsolution.service.PacienteService;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    PacienteService service;

    @GetMapping
    public List<PacienteDto> getPaciente(@PageableDefault(size = 3, sort = "id") Pageable pageable) {
        log.info("Mostrando todas os Pacientes ");
        return service.getPaciente(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<PacienteDto> getPcienteByID(@PathVariable Long id) {
        log.info("Mostrando Paciente com id: " + id);
        return ResponseEntity.ok(service.getPacienteById(id));
    }

    @PostMapping
    public ResponseEntity<PacienteDto> postPaciente(@RequestBody @Valid Paciente paciente) {
        log.info("Cadastrando Paciente");
        PacienteDto entity =  service.postPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("{id}")
    public ResponseEntity<PacienteDto> putPaciente(@PathVariable Long id, @RequestBody @Valid Paciente paciente) {
        log.info("Alterando Paciente com id: " + id);
        PacienteDto newEntity = service.putPaciente(id, paciente);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletePaciente(@PathVariable Long id) {
        log.info("Deletando Paciente com id: " + id);
        service.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

}