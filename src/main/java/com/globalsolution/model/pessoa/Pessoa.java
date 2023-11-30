package com.globalsolution.model.pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PESSOA", uniqueConstraints = {
    @UniqueConstraint(name="UK_EMAIL_PESSOA", columnNames = "EMAIL_PESSOA")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA")
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "NM_PESSOA")
    private String nome;

    @Column(name = "EMAIL_PESSOA")
    private String email;

    @Column(name = "SENHA_PESSOA")
    private String senha;

    @Column(name = "CEL_PESSOA")
    private String celular; 
    
    @Column(name = "TP_PESSOA")
    private String tipo;

    public Pessoa(String tipo) {
        this.tipo = tipo;
    }
}
