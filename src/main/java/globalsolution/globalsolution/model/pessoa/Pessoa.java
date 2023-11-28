package globalsolution.globalsolution.model.pessoa;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String celular;    
}
