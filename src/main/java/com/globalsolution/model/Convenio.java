package com.globalsolution.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CONVENIO")
public class Convenio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONVENIO")
    @Column(name = "ID_CONVENIO")
    private Long id;

    @NotBlank
    @Column(name = "NM_CONVENIO")
    private String nome;

    @NotBlank
    @Column(name = "TEL_CONVENIO")
    private String telefone;

    @NotBlank
    @Column(name = "EMAIL_CONVENIO")
    private String email;

    @NotBlank
    @Column(name = "SENHA_CONVENIO")
    private String senha;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
        name = "ID_HOSPITAL",
        referencedColumnName = "ID_HOSPITAL",
        foreignKey = @ForeignKey(name = "FK_CONVENIO_HOSPITAL")
    )
    private Hospital hospital;
}