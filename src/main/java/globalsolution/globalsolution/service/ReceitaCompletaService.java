package globalsolution.globalsolution.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import globalsolution.globalsolution.model.ReceitaCompleta;
import globalsolution.globalsolution.repository.ReceitaCompletaRepository;

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

    public List<ReceitaCompleta> getReceitaCompleta() {
        List<ReceitaCompleta> entities = repository.findAll();
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