package com.globalsolution.controller;

import com.globalsolution.model.Cargo;
import com.globalsolution.service.CargoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cargo")
public class CargoController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    CargoService service;

    @GetMapping
    public List<Cargo> getCargo() {
        log.info("Mostrando todas os Cargos ");
        return service.getCargo();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cargo> getCargoByID(@PathVariable Long id) {
        log.info("Mostrando Cargo com id: " + id);
        return ResponseEntity.ok(service.getCargoById(id));
    }

    @PostMapping
    public ResponseEntity<Cargo> postCargo(@RequestBody Cargo cargo) {
        log.info("Cadastrando Cargo");
        Cargo entity =  service.postCargo(cargo);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cargo> putCargo(@PathVariable Long id, @RequestBody Cargo cargo) {
        log.info("Alterando Cargo com id: " + id);
        Cargo newEntity = service.putCargo(id, cargo);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteCargo(@PathVariable Long id) {
        log.info("Deletando Cargo com id: " + id);
        service.deleteCargo(id);
        return ResponseEntity.noContent().build();
    }
}
