package globalsolution.globalsolution.model.dto;

import globalsolution.globalsolution.model.Cargo;
import globalsolution.globalsolution.model.pessoa.Profissional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalDto {
    private Long id;
    private String nome;
    private String email;
    private String celular;
    private Cargo cargo;
    private String refistroProfissional;

    public ProfissionalDto(Profissional profissional) {
        id = profissional.getId();
        nome = profissional.getNome();
        email = profissional.getEmail();
        celular = profissional.getCelular();
        cargo = profissional.getCargo();
        refistroProfissional = profissional.getRefistroProfissional();
    }
}
