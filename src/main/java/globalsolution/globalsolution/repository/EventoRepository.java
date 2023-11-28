package globalsolution.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import globalsolution.globalsolution.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
