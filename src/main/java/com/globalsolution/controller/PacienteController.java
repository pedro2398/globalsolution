package com.globalsolution.controller;

import java.util.List;

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
    public List<PacienteDto> getPaciente() {
        return service.getPaciente();
    }

    @GetMapping("{id}")
    public ResponseEntity<PacienteDto> getPcienteByID(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPacienteById(id));
    }

    @PostMapping
    public ResponseEntity<PacienteDto> postPaciente(@RequestBody Paciente paciente) {
        PacienteDto entity =  service.postPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("{id}")
    public ResponseEntity<PacienteDto> putPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        PacienteDto newPaciente = service.putPaciente(id, paciente);
        return ResponseEntity.ok(newPaciente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletePaciente(@PathVariable Long id) {
        service.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

}