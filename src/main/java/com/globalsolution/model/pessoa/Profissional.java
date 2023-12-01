package com.globalsolution.model.pessoa;

import com.globalsolution.model.Cargo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private String registroProfissional;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
            name = "ID_CARGO",
            referencedColumnName = "ID_CARGO",
            foreignKey = @ForeignKey(name = "FK_PROFISSIONAL_CARGO")
    )
    private Cargo cargo;

    public Profissional() {
        super("PROFISSIONAL");
    }

     public Profissional(Long id, String nome, String email, String senha, String celular, String registroProfissional, Cargo cargo) {
        super(id, nome, email, senha, celular, "PROFISSIONAL");
        this.cargo =  cargo;
        this.registroProfissional = registroProfissional;
    }
}
