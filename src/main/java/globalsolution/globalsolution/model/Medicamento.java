package globalsolution.globalsolution.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicamento {
    private Long id;
    private String nome;
    private Integer viaAdministracao;
}
