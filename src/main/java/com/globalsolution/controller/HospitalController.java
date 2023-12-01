package com.globalsolution.controller;

import com.globalsolution.model.Evento;
import com.globalsolution.model.Hospital;
import com.globalsolution.model.dto.HospitalDto;
import com.globalsolution.service.EventoService;
import com.globalsolution.service.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hospital")
public class HospitalController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    HospitalService service;

    @GetMapping
    public List<HospitalDto> getHospital() {
        log.info("Mostrando todas os Hospitais");
        return service.getHospital();
    }

    @GetMapping("{id}")
    public ResponseEntity<HospitalDto> getHospitalByID(@PathVariable Long id) {
        log.info("Mostrando Hospital com id: " + id);
        return ResponseEntity.ok(service.getHospitallById(id));
    }

    @PostMapping
    public ResponseEntity<HospitalDto> postHospital(@RequestBody Hospital newEntity) {
        log.info("Cadastrando Hospital");
        HospitalDto entity =  service.postHospital(newEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("{id}")
    public ResponseEntity<HospitalDto> putHospital(@PathVariable Long id, @RequestBody Hospital entity) {
        log.info("Alterando Hospital com id: " + id);
        HospitalDto newEntity = service.putHospital(id, entity);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteHospital(@PathVariable Long id) {
        log.info("Deletando Hospital com id: " + id);
        service.deleteHospital(id);
        return ResponseEntity.noContent().build();
    }
}
