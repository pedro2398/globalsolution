package com.globalsolution.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<PacienteDto> getPaciente( @PageableDefault(size = 3, sort = "id") Pageable pageRequest) {
        return service.getPaciente(pageRequest);
    }

    @PostMapping
    public ResponseEntity<PacienteDto> postPaciente(@RequestBody Paciente paciente) {
        PacienteDto entity =  service.postPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
}