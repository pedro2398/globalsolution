package com.globalsolution.controller;

import com.globalsolution.model.Evento;
import com.globalsolution.service.EventoService;
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
@RequestMapping("evento")
public class EventoController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    EventoService service;

    @GetMapping
    public List<Evento> getEvento( @PageableDefault(size = 3, sort = "id") Pageable pageRequest) {
        log.info("Mostrando todas os Eventos");
        List<Evento> entities = service.getEvento(pageRequest).getContent();
        return  entities;
    }

    @GetMapping("{id}")
    public ResponseEntity<Evento> geEventoByID(@PathVariable Long id) {
        log.info("Mostrando Evento com id: " + id);
        return ResponseEntity.ok(service.getEventoById(id));
    }

    @PostMapping
    public ResponseEntity<Evento> postEvento(@RequestBody @Valid Evento evento) {
        log.info("Cadastrando Evento");
        Evento entity =  service.postEvento(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("{id}")
    public ResponseEntity<Evento> putEvento(@PathVariable Long id, @RequestBody @Valid Evento evento) {
        log.info("Alterando Evento com id: " + id);
        Evento newEntity = service.putEvento(id, evento);
        return ResponseEntity.ok(newEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteEvento(@PathVariable Long id) {
        log.info("Deletando Evento com id: " + id);
        service.deleteEvento(id);
        return ResponseEntity.noContent().build();
    }
}
