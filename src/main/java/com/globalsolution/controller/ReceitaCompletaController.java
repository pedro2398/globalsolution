package com.globalsolution.controller;

import com.globalsolution.model.ReceitaCompleta;
import com.globalsolution.service.ReceitaCompletaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("receita_completa")
public class ReceitaCompletaController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ReceitaCompletaService service;

    @GetMapping
    public List<ReceitaCompleta> getReceitaCompleta(@PageableDefault(size = 3, sort = "id") Pageable pageable) {
        log.info("Mostrando todas as Receita Completas");
        return service.getReceitaCompleta(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReceitaCompleta> geReceitaCompletaByID(@PathVariable Long id) {
        log.info("Mostrando Receita Completa com id: " + id);
        return ResponseEntity.ok(service.getReceitaCompletaById(id));
    }

    @PostMapping
    public ResponseEntity<ReceitaCompleta> postReceitaCompleta(@RequestBody @Valid ReceitaCompleta newEntity) {
        log.info("Cadastrando Receita Completa");
        ReceitaCompleta entity =  service.postReceitaCompleta(newEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReceitaCompleta> putReceitaCompleta(@PathVariable Long id, @RequestBody @Valid ReceitaCompleta entity) {
        log.info("Alterando Receita Completa com id: " + id);
        ReceitaCompleta newEntity = service.putReceitaCompleta(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteReceitaCompleta(@PathVariable Long id) {
        log.info("Deletando Receita Completa com id: " + id);
        service.deleteReceitaCompleta(id);
        return ResponseEntity.noContent().build();
    }
}
