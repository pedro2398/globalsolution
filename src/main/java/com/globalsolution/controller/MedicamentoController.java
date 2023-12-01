package com.globalsolution.controller;

import com.globalsolution.model.Medicamento;
import com.globalsolution.service.MedicamentoService;
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
@RequestMapping("medicamento")
public class MedicamentoController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MedicamentoService service;

    @GetMapping
    public List<Medicamento> getMedicamento(@PageableDefault(size = 3, sort = "id")Pageable pageRequest) {
        log.info("Mostrando todas os Medicamentos");
        return service.getMedicamento(pageRequest);
    }

    @GetMapping("{id}")
    public ResponseEntity<Medicamento> getMedicamentoByID(@PathVariable Long id) {
        log.info("Mostrando Medicamento com id: " + id);
        return ResponseEntity.ok(service.getMedicamentoById(id));
    }

    @PostMapping
    public ResponseEntity<Medicamento> postMedicamento(@RequestBody @Valid Medicamento newEntity) {
        log.info("Cadastrando Medicamento");
        Medicamento entity =  service.postMedicamento(newEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("{id}")
    public ResponseEntity<Medicamento> putMedicamento(@PathVariable Long id, @RequestBody @Valid Medicamento entity) {
        log.info("Alterando Medicamento com id: " + id);
        Medicamento newEntity = service.putMedicamento(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteMedicamento(@PathVariable Long id) {
        log.info("Deletando Medicamento com id: " + id);
        service.deleteMedicamento(id);
        return ResponseEntity.noContent().build();
    }
}
