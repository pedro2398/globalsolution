package com.globalsolution.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_MEDICAMENTO")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MEDICAMENTO")
    @Column(name = "ID_MEDICAMENTO")
    private Long id;

    @NotBlank
    @Column(name = "NM_MEDICAMENTO")
    private String nome;

    @NotBlank
    @Column(name = "VIA_ADM_MEDICAMENTO")
    private Integer viaAdministracao;
}
