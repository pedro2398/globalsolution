package globalsolution.globalsolution.model.pessoa;

import globalsolution.globalsolution.model.Convenio;
import lombok.Getter;
import lombok.Setter;

public class Paciente extends Pessoa {
    @Getter
    @Setter
    private String cpf;

    @Getter
    @Setter
    private String carteirinha;

    @Getter
    @Setter
    private String telefone;

    @Getter
    @Setter
    private String rua;

    @Getter
    @Setter
    private String complemento;

    @Getter
    @Setter
    private String numeroResidencial;

    @Getter
    @Setter
    private String bairro;

    @Getter
    @Setter
    private String cidade;

    @Getter
    @Setter
    private String estado; 
    
    @Getter
    @Setter
    private String cep; 

    @Getter
    @Setter
    private Convenio convenio;    
    

    public Paciente() {
        super();
    }

    public Paciente(Long id, String nome, String email, String senha, String celular, String cpf, String carteirinha, String telefone,  String rua, String complemento, String numeroResidencial, String bairro, String cidade, String estado,  String cep, Convenio convenio) {
        super(id, nome, email, senha, celular);
        this.bairro = bairro;
        this.telefone = telefone;
        this.cpf = cpf;
        this.complemento = complemento;
        this.estado = estado;
        this.cep = cep;
        this.numeroResidencial = numeroResidencial;
        this.cidade = cidade;
        this.carteirinha = carteirinha;
        this.rua = rua;
        this.convenio = convenio;
    }

}
