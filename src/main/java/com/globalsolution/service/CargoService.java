package com.globalsolution.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.globalsolution.model.Cargo;
import com.globalsolution.repository.CargoRepository;

@Service
public class CargoService {
    @Autowired
    CargoRepository repository;

    public Cargo getCargoById(Long id) {
        Cargo entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Não foi possivel realizar a requisição!");
        });
        return entity;
    }

    public Page<Cargo> getCargo(Pageable pageable) {
        Page<Cargo> entities = repository.findAll(pageable);
        return entities;
    }

    public Cargo deleteCargo(Long id) {
        Cargo entity = getCargoById(id);
        repository.deleteById(entity.getId());
        return entity;
    }

    public Cargo postCargo(Cargo cargo) {
        repository.save(cargo);
        return cargo;
    }

    public Cargo putCargo(Long id, Cargo cargo) {
        getCargoById(id);
        cargo.setId(id);
        repository.save(cargo);

        return cargo;
    }
}