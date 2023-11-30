package com.globalsolution.model.pessoa;

import com.globalsolution.model.Cargo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PROFISSIONAL", uniqueConstraints = {
    @UniqueConstraint(name = "UK_REGISTRO_PROFISSIONAL", columnNames = "REGISTRO_PROFISSIONAL")
})
@DiscriminatorValue("PROFISSIONAL")
public class Profissional extends Pessoa {
    @Getter
    @Setter
    @Column(name = "REGISTRO_PROFISSIONAL")
    private String refistroProfissional;

    @Getter
    @Setter
    @Column(name = "CARGO_PROFISSIONAL")
    private Cargo cargo; 

    public Profissional() {
        super("PROFISSIONAL");
    }

     public Profissional(Long id, String nome, String email, String senha, String celular, String refistroProfissional, Cargo cargo) {
        super(id, nome, email, senha, celular, "PROFISSIONAL");
        this.cargo =  cargo;
        this.refistroProfissional = refistroProfissional;
    }
}
