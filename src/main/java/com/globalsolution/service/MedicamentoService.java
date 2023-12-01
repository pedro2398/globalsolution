package com.globalsolution.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.globalsolution.model.Medicamento;
import com.globalsolution.repository.MedicamentoRepository;

@Service
public class MedicamentoService {
    @Autowired
    MedicamentoRepository repository;

    public Medicamento getMedicamentoById(Long id) {
        Medicamento entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Não foi possivel realizar a requisição!");
        });

        return entity;
    }

    public List<Medicamento> getMedicamento(Pageable pageable) {
        List<Medicamento> entities = repository.findAll(pageable).getContent();
        return entities;
    }

    public Medicamento deleteMedicamento(Long id) {
        Medicamento entity = getMedicamentoById(id);
        repository.deleteById(entity.getId());
        return entity;
    }

    public Medicamento postMedicamento(Medicamento medicamento) {
        repository.save(medicamento);
        return medicamento;
    }

    public Medicamento putMedicamento(Long id, Medicamento medicamento) {
        getMedicamentoById(id);
        medicamento.setId(id);
        repository.save(medicamento);

        return medicamento;
    }
}