package globalsolution.globalsolution.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    private Long id;
    private String titulo;
    private String descricao;
}
