package globalsolution.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import globalsolution.globalsolution.model.pessoa.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    
}
