package globalsolution.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import globalsolution.globalsolution.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{
    
}
