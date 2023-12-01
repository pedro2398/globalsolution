package com.globalsolution.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.globalsolution.model.Convenio;
import com.globalsolution.model.dto.ConvenioDto;
import com.globalsolution.repository.ConvenioRepository;

@Service
public class ConvenioService {
    @Autowired
    ConvenioRepository repository;

    public ConvenioDto getConvenioById(Long id) {
        Convenio entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Não foi possivel realizar a requisição!");
        });

        return new ConvenioDto(entity);
    }

    public List<ConvenioDto> getConvenio(Pageable pageable) {
        Page<Convenio> entities = repository.findAll(pageable);
        List<ConvenioDto> dtos = new ArrayList<ConvenioDto>();
        for(Convenio entity: entities.getContent()) {
            ConvenioDto dto = new ConvenioDto(entity);
            dtos.add(dto);
        }

        return dtos;
    }

    public ConvenioDto deleteConvenio(Long id) {
        ConvenioDto entity = getConvenioById(id);
        repository.deleteById(entity.getId());
        return entity;
    }

    public ConvenioDto postConvenio(Convenio convenio) {
        repository.save(convenio);
        return new ConvenioDto(convenio);
    }

    public ConvenioDto putConvenio(Long id, Convenio convenio) {
        getConvenioById(id);
        convenio.setId(id);
        repository.save(convenio);

        return new ConvenioDto(convenio);
    }
}