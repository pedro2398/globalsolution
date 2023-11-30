package com.globalsolution.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
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
@Table(name = "TB_CONVENIO", uniqueConstraints = {
    @UniqueConstraint(name = "UK_EMAIL_CONVENIO", columnNames = "EMAIL_CONVENIO")
})
public class Convenio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CONVENIO")
    private Long id;
  
    @Column(name = "NM_CONVENIO")
    private String nome;

    @Column(name = "TEL_CONVENIO")
    private String telefone;

    @Column(name = "EMAIL_CONVENIO")
    private String email;

    @Column(name = "SENHA_CONVENIO")
    private String senha;

    /*@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
        name = "ID_HOSPITAL",
        referencedColumnName = "ID_HOSPITAL",
        foreignKey = @ForeignKey(name = "FK_CONVENIO_HOSPITAL")
    )
    private Hospital hospital;*/
}