package com.globalsolution.controller;

import com.globalsolution.model.dto.ProfissionalDto;
import com.globalsolution.model.pessoa.Profissional;
import com.globalsolution.service.ProfissionalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("profissional")
public class ProfissionalController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProfissionalService service;

    @GetMapping
    public List<ProfissionalDto> getProfissional() {
        log.info("Mostrando todas os Profissionais");
        return service.getProfissional();
    }

    @GetMapping("{id}")
    public ResponseEntity<ProfissionalDto> getProfissionalByID(@PathVariable Long id) {
        log.info("Mostrando Profissional com id: " + id);
        return ResponseEntity.ok(service.getProfissionalById(id));
    }

    @PostMapping
    public ResponseEntity<ProfissionalDto> postProfissional(@RequestBody Profissional profissional) {
        log.info("Cadastrando Profissional");
        ProfissionalDto entity =  service.postProfissional(profissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProfissionalDto> putProfissional(@PathVariable Long id, @RequestBody Profissional profissional) {
        log.info("Alterando Profissional com id: " + id);
        ProfissionalDto newEntity = service.putProfissional(id, profissional);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteProfissional(@PathVariable Long id) {
        log.info("Deletando Profissional com id: " + id);
        service.deleteProfissional(id);
        return ResponseEntity.noContent().build();
    }
}
