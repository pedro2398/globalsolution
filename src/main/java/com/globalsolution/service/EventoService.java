package com.globalsolution.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalsolution.model.Evento;
import com.globalsolution.repository.EventoRepository;

@Service
public class EventoService {
    @Autowired
    EventoRepository repository;

    public Evento getEventoById(Long id) {
        Evento entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Não foi possivel realizar a requisição!");
        });

        return entity;
    }

    public List<Evento> getEvento() {
        List<Evento> entities = repository.findAll();
        return entities;
    }

    public Evento deleteEvento(Long id) {
        Evento entity = getEventoById(id);
        repository.deleteById(entity.getId());
        return entity;
    }

    public Evento postEvento(Evento evento) {
        repository.save(evento);
        return evento;
    }

    public Evento putEvento(Long id, Evento evento) {
        getEventoById(id);
        evento.setId(id);
        repository.save(evento);

        return evento;
    }
}