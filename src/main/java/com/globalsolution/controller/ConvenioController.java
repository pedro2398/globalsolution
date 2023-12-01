package com.globalsolution.controller;

import com.globalsolution.model.Convenio;
import com.globalsolution.model.dto.ConvenioDto;
import com.globalsolution.service.ConvenioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("convenio")
public class ConvenioController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ConvenioService service;

    @GetMapping
    public List<ConvenioDto> getConvenio() {
        log.info("Mostrando todas os Convenios ");
        return service.getConvenio();
    }

    @GetMapping("{id}")
    public ResponseEntity<ConvenioDto> getConvenioByID(@PathVariable Long id) {
        log.info("Mostrando Convenio com id: " + id);
        return ResponseEntity.ok(service.getConvenioById(id));
    }

    @PostMapping
    public ResponseEntity<ConvenioDto> postConvenio(@RequestBody Convenio convenio) {
        log.info("Cadastrando Convenio");
        ConvenioDto entity =  service.postConvenio(convenio);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("{id}")
    public ResponseEntity<ConvenioDto> putConvenio(@PathVariable Long id, @RequestBody Convenio convenio) {
        log.info("Alterando Convenio com id: " + id);
        ConvenioDto newEntity = service.putConvenio(id, convenio);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteConvenio(@PathVariable Long id) {
        log.info("Deletando Convenio com id: " + id);
        service.deleteConvenio(id);
        return ResponseEntity.noContent().build();
    }
}
