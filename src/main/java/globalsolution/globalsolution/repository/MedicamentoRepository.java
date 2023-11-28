package globalsolution.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import globalsolution.globalsolution.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{
    
}
