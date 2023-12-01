package com.globalsolution.model;

import com.globalsolution.model.pessoa.Paciente;
import com.globalsolution.model.pessoa.Profissional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_RECEITA_COMPLETA")
public class ReceitaCompleta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RECEITA_COMPLETA")
    @Column(name = "ID_RECEITA_COMPLETA")
    private Long id;

    @NotBlank
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
        name = "ID_RECEITA_PARCIAL",
        referencedColumnName = "ID_RECEITA_PARCIAL",
        foreignKey = @ForeignKey(name = "FK_RECEITA_COMPLETA_RECEITA_PARCAL")
    )
    private ReceitaParcial receitaParcial;

    @NotBlank
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
        name = "ID_PROFISSIONAL",
        referencedColumnName = "ID_PESSOA",
        foreignKey = @ForeignKey(name = "FK_RECEITA_COMPLETA_PROFISSIONAL")
    )
    private Profissional profissional;

    @NotBlank
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
        name = "ID_PACIENTE",
        referencedColumnName = "ID_PESSOA",
        foreignKey = @ForeignKey(name = "FK_RECEITA_COMPLETA_PACIENTE")
    )
    private Paciente paciente;
}
