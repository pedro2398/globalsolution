package com.globalsolution.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_RECEITA_PARCIAL")
public class ReceitaParcial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RECEITA_PARCIAL")
    @Column(name = "ID_RECEITA_PARCIAL")
    private Long id;

    @NotNull
    @Column(name = "QTD_RECEITA_PARCIAL")
    private Integer quantidade;

    @NotNull
    @Column(name = "HORARIO_RECEITA_PARCIAL")
    private Timestamp horario;

    @NotNull
    @Column(name = "FREQUENCIA_RECEITA_PARCIAL")
    private Integer frequencia;

    @NotNull
    @Column(name = "DT_INICIO_RECEITA_PARCIAL")
    private LocalDate dataInicio;

    @NotNull
    @Column(name = "DT_FIM_RECEITA_PARCIAL")
    private LocalDate dataFim;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
        name = "ID_MEDICAMENTO",
        referencedColumnName = "ID_MEDICAMENTO",
        foreignKey = @ForeignKey(name = "FK_RECEITA_PARCIAL_MEDICAMENTO")
    )
    private Medicamento medicamento;
}
