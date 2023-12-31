package com.globalsolution.model.pessoa;

import com.globalsolution.model.Convenio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PACIENTE", uniqueConstraints = {
    @UniqueConstraint(name = "UK_CPF_PACIENTE", columnNames = "CPF_PACIENTE" ),
    @UniqueConstraint(name = "UK_CARTEIRINHA_PACIENTE", columnNames = "CARTEIRINHA_PACIENTE")
})
@DiscriminatorValue("PACIENTE")
public class Paciente extends Pessoa {
    @Getter
    @Setter
    @NotBlank
    @Column(name = "CPF_PACIENTE")
    private String cpf;
    
    @Getter
    @Setter
    @NotBlank
    @Column(name = "CARTEIRINHA_PACIENTE")
    private String carteirinha;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "TEL_PACIENTE")
    private String telefone;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "RUA_PACIENTE")
    private String rua;

    @Getter
    @Setter
    @Column(name = "COMPLEMENTO_PACIENTE")
    private String complemento;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "NUMERO_RESIDENCIAL_PACIENTE")
    private String numeroResidencial;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "BAIRRO_PACIENTE")
    private String bairro;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "CIDADE_PACIENTE")
    private String cidade;

    @Getter
    @Setter
    @NotBlank
    @Column(name = "UF_PACIENTE")
    private String estado; 
    
    @Getter
    @Setter
    @NotBlank
    @Column(name = "CEP_PACIENTE")
    private String cep; 

    @Getter
    @Setter
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
            name = "ID_CONVENIO",
            referencedColumnName = "ID_CONVENIO",
            foreignKey = @ForeignKey(name = "FK_PACIENTE_CONVENIO")
    )
    private Convenio convenio;    

    public Paciente() {
        super("PACIENTE");
    }

    public Paciente(Long id, String nome, String email, String senha, String celular, String cpf, String carteirinha, String telefone,  String rua, String complemento, String numeroResidencial, String bairro, String cidade, String estado,  String cep, Convenio convenio) {
        super(id, nome, email, senha, celular, "PACIENTE");
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
