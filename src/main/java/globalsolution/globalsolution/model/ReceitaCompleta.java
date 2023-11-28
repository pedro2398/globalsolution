package globalsolution.globalsolution.model;

import globalsolution.globalsolution.model.pessoa.Paciente;
import globalsolution.globalsolution.model.pessoa.Profissional;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaCompleta {
    private Long id;
    private ReceitaParcial receitaParcial;  
    private Profissional profissional;
    private Paciente paciente;
}
