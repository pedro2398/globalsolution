package globalsolution.globalsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import globalsolution.globalsolution.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{
    
}
