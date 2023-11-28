package globalsolution.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import globalsolution.globalsolution.model.pessoa.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
}
