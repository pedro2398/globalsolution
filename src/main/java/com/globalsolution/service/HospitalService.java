package com.globalsolution.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalsolution.model.Hospital;
import com.globalsolution.model.dto.HospitalDto;
import com.globalsolution.repository.HospitalRepository;

@Service
public class HospitalService {
    @Autowired
    HospitalRepository repository;

    public HospitalDto getHospitallById(Long id) {
        Hospital entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Não foi possivel realizar a requisição!");
        });

        return new HospitalDto(entity);
    }

    public List<HospitalDto> getHospital() {
        List<Hospital> entities = repository.findAll();
        List<HospitalDto> dtos = new ArrayList<HospitalDto>();
        for(Hospital entity: entities) {
            HospitalDto dto = new HospitalDto(entity);
            dtos.add(dto);
        }

        return dtos;
    }

    public HospitalDto deleteHospital(Long id) {
        HospitalDto entity = getHospitallById(id);
        repository.deleteById(entity.getId());
        return entity;
    }

    public HospitalDto postHospital(Hospital hospital) {
        repository.save(hospital);
        return new HospitalDto(hospital);
    }

    public HospitalDto putHospital(Long id, Hospital hospital) {
        getHospitallById(id);
        hospital.setId(id);
        repository.save(hospital);

        return new HospitalDto(hospital);
    }
}