package globalsolution.globalsolution.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    private Long id;
    private String nome;
    private String cnpj;
    private String cep;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private String email;
    private String senha;
}
