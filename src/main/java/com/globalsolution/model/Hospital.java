package com.globalsolution.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_HOSPITAL", uniqueConstraints = {
    @UniqueConstraint(name = "UK_CNPJ_HOSPITAL", columnNames = "CNPJ_HOSPITAL"),
    @UniqueConstraint(name = "UK_EMAIL_HOSPITAL", columnNames = "EMAIL_HOSPITAL")
})
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_HOSPITAL")
    @Column(name = "ID_HOSPITAL")
    private Long id;

    @Column(name = "NM_HOSPITAL")
    private String nome;

    @Column(name = "CNPJ_HOSPITAL")
    private String cnpj;

    @Column(name = "CEP_HOSPITAL")
    private String cep;

    @Column(name = "RUA_HOSPITAL")
    private String rua;

    @Column(name = "NUMERO_HOSPITAL")
    private String numero;

    @Column(name = "COMPLEMENTO_HOSPITAL")
    private String complemento;

    @Column(name = "BAIRRO_HOSPITAL")
    private String bairro;

    @Column(name = "CIDADE_HOSPITAL")
    private String cidade;

    @Column(name = "UF_HOSPITAL")
    private String estado;

    @Column(name = "TEL_1_HOSPITAL")
    private String telefone1;

    @Column(name = "TEL_2_HOSPITAL")
    private String telefone2;
    
    @Column(name = "TEL_3_HOSPITAL")
    private String telefone3;
    
    @Column(name = "EMAIL_HOSPITAL")
    private String email;

    @Column(name = "SENHA_HOSPITAL")
    private String senha;
}
