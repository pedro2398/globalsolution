package globalsolution.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import globalsolution.globalsolution.model.Convenio;

public interface ConvenioRepository extends JpaRepository<Convenio, Long> {
    
}
