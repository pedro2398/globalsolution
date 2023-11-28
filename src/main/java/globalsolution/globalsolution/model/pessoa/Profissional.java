package globalsolution.globalsolution.model.pessoa;

import globalsolution.globalsolution.model.Cargo;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Profissional extends Pessoa {
    @Getter
    @Setter
    private String refistroProfissional;

    @Getter
    @Setter
    private Cargo cargo; 

    public Profissional() {
        super();
    }

     public Profissional(Long id, String nome, String email, String senha, String celular, String refistroProfissional, Cargo cargo) {
        super(id, nome, email, senha, celular);
        this.cargo =  cargo;
        this.refistroProfissional = refistroProfissional;
    }
}
