package com.globalsolution.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.globalsolution.model.ReceitaCompleta;
import com.globalsolution.repository.ReceitaCompletaRepository;

@Service
public class ReceitaCompletaService {
    @Autowired
    ReceitaCompletaRepository repository;

    public ReceitaCompleta getReceitaCompletaById(Long id) {
        ReceitaCompleta entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Não foi possivel realizar a requisição!");
        });

        return entity;
    }

    public List<ReceitaCompleta> getReceitaCompleta(Pageable pageable) {
        List<ReceitaCompleta> entities = repository.findAll(pageable).getContent();
        return entities;
    }

    public ReceitaCompleta deleteReceitaCompleta(Long id) {
        ReceitaCompleta entity = getReceitaCompletaById(id);
        repository.deleteById(entity.getId());
        return entity;
    }

    public ReceitaCompleta postReceitaCompleta(ReceitaCompleta receitaCompleta) {
        repository.save(receitaCompleta);
        return receitaCompleta;
    }

    public ReceitaCompleta putReceitaCompleta(Long id, ReceitaCompleta receitaCompleta) {
        getReceitaCompletaById(id);
        receitaCompleta.setId(id);
        repository.save(receitaCompleta);

        return receitaCompleta;
    }
}