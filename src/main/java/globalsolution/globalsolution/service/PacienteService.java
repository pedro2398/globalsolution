package globalsolution.globalsolution.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import globalsolution.globalsolution.model.dto.PacienteDto;
import globalsolution.globalsolution.model.pessoa.Paciente;
import globalsolution.globalsolution.repository.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository repository;

    public PacienteDto getPacienteById(Long id) {
        Paciente entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Não foi possivel realizar a requisição!");
        });

        return new PacienteDto(entity);
    }

    public List<PacienteDto> getPaciente() {
        List<Paciente> entities = repository.findAll();
        List<PacienteDto> dtos = new ArrayList<PacienteDto>();
        for(Paciente entity: entities) {
            PacienteDto dto = new PacienteDto(entity);
            dtos.add(dto);
        }

        return dtos;
    }

    public PacienteDto deletePaciente(Long id) {
        PacienteDto entity = getPacienteById(id);
        repository.deleteById(entity.getId());
        return entity;
    }

    public PacienteDto postPaciente(Paciente paciente) {
        repository.save(paciente);
        return new PacienteDto(paciente);
    }

    public PacienteDto putPaciente(Long id, Paciente paciente) {
        getPacienteById(id);
        paciente.setId(id);
        repository.save(paciente);

        return new PacienteDto(paciente);
    }
}