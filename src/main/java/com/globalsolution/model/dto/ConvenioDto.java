package com.globalsolution.model.dto;

import com.globalsolution.model.Convenio;
import com.globalsolution.model.Hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConvenioDto {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Hospital hospital;

    public ConvenioDto(Convenio convenio) {
        id = convenio.getId();
        nome = convenio.getNome();
        telefone = convenio.getTelefone();
        email = convenio.getEmail();
        hospital = convenio.getHospital();
    }
}
