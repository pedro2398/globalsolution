package com.globalsolution.controller;

import com.globalsolution.model.ReceitaParcial;
import com.globalsolution.service.ReceitaParcialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("receita_parcial")
public class ReceitaParcialController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ReceitaParcialService service;

    @GetMapping
    public List<ReceitaParcial> getReceitaParcial() {
        log.info("Mostrando todas as Receitas Parciais");
        return service.getReceitaParcial();
    }

    @GetMapping("{id}")
    public ResponseEntity<ReceitaParcial> geReceitaParcialByID(@PathVariable Long id) {
        log.info("Mostrando Receita Parcial com id: " + id);
        return ResponseEntity.ok(service.getReceitaParcialById(id));
    }

    @PostMapping
    public ResponseEntity<ReceitaParcial> postReceitaParcial(@RequestBody ReceitaParcial newEntity) {
        log.info("Cadastrando Receita Parcial");
        ReceitaParcial entity =  service.postReceitaParcial(newEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReceitaParcial> putReceitaParcical(@PathVariable Long id, @RequestBody ReceitaParcial entity) {
        log.info("Alterando Receita Parcial com id: " + id);
        ReceitaParcial newEntity = service.putReceitaParcial(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteReceitaParcial(@PathVariable Long id) {
        log.info("Deletando Receita Parcial com id: " + id);
        service.deleteReceitaParcial(id);
        return ResponseEntity.noContent().build();
    }
}
