package globalsolution.globalsolution.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Convenio {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private Hospital hospital;
}
