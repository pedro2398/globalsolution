package globalsolution.globalsolution.model.dto;

import globalsolution.globalsolution.model.pessoa.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {
    private Long id;
    private String nome;
    private String email;
    private String celular;
    private String carteirinha;
    private String telefone;
    private String rua;
    private String complemento;
    private String numeroResidencial;
    private String bairro;
    private String cidade;
    private String estado;
    
    public PacienteDto(Paciente paciente){
        id = paciente.getId();
        nome = paciente.getNome();
        email = paciente.getEmail();
        celular = paciente.getCelular();
        carteirinha = paciente.getCarteirinha();
        telefone = paciente.getTelefone();
        rua = paciente.getRua();
        complemento = paciente.getComplemento();
        numeroResidencial = paciente.getNumeroResidencial();
        bairro = paciente.getBairro();
        cidade = paciente.getCidade();
        estado = paciente.getEstado();
    }
}
