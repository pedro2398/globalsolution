package com.globalsolution.model;

import java.sql.Timestamp;

import com.globalsolution.model.pessoa.Paciente;

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
@Table(name = "TB_EVENTO")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EVENTO")
    @Column(name = "ID_EVENTO")
    private Long id;

    @NotBlank
    @Column(name = "TIME_EVENTO")
    private Timestamp eventoTime;

    @NotBlank
    @Column(name = "VALOR_EVENTO")
    private String valor;

    @NotBlank
    @Column(name = "TIPO_EVENTO")
    private String tipo;

    @NotBlank
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
        name = "ID_PACIENTE",
        referencedColumnName = "ID_PESSOA",
        foreignKey = @ForeignKey(name = "FK_EVENTO_PACIENTE") 
    )
    private Paciente paciente;
}
