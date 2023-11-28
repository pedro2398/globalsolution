package globalsolution.globalsolution.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import globalsolution.globalsolution.model.dto.ProfissionalDto;
import globalsolution.globalsolution.model.pessoa.Profissional;
import globalsolution.globalsolution.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
    @Autowired
    ProfissionalRepository repository;

    public ProfissionalDto getProfissionalById(Long id) {
        Profissional entity = repository.findById(id).orElseThrow( () -> {
            return new RuntimeException("Não foi possivel realizar a requisição!");
        });

        return new ProfissionalDto(entity);
    }

    public List<ProfissionalDto> getProfissional() {
        List<Profissional> entities = repository.findAll();
        List<ProfissionalDto> dtos = new ArrayList<ProfissionalDto>();
        for(Profissional entity: entities) {
            ProfissionalDto dto = new ProfissionalDto(entity);
            dtos.add(dto);
        }

        return dtos;
    }

    public ProfissionalDto deleteProfissional(Long id) {
        ProfissionalDto entity = getProfissionalById(id);
        repository.deleteById(entity.getId());
        return entity;
    }

    public ProfissionalDto postProfissional(Profissional profissional) {
        repository.save(profissional);
        return new ProfissionalDto(profissional);
    }

    public ProfissionalDto putProfissional(Long id, Profissional profissional) {
        getProfissionalById(id);
        profissional.setId(id);
        repository.save(profissional);

        return new ProfissionalDto(profissional);
    }
}