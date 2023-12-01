package com.globalsolution.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.globalsolution.model.ReceitaParcial;
import com.globalsolution.repository.ReceitaParcialRepository;

@Service
public class ReceitaParcialService {
    @Autowired
    ReceitaParcialRepository repository;

    public ReceitaParcial getReceitaParcialById(Long id) {
        ReceitaParcial entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Não foi possivel realizar a requisição!");
        });

        return entity;
    }

    public List<ReceitaParcial> getReceitaParcial(Pageable pageable) {
        List<ReceitaParcial> entities = repository.findAll(pageable).getContent();
        return entities;
    }

    public ReceitaParcial deleteReceitaParcial(Long id) {
        ReceitaParcial entity = getReceitaParcialById(id);
        repository.deleteById(entity.getId());
        return entity;
    }

    public ReceitaParcial postReceitaParcial(ReceitaParcial receitaParcial) {
        repository.save(receitaParcial);
        return receitaParcial;
    }

    public ReceitaParcial putReceitaParcial(Long id, ReceitaParcial receitaParcial) {
        getReceitaParcialById(id);
        receitaParcial.setId(id);
        repository.save(receitaParcial);

        return receitaParcial;
    }
}