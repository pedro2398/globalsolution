package com.globalsolution.model.dto;

import com.globalsolution.model.Hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {
    private Long id;
    private String nome;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private String email;

    public HospitalDto(Hospital hospital) {
        id = hospital.getId();
        nome = hospital.getNome();
        rua = hospital.getRua();
        numero = hospital.getNumero();
        complemento = hospital.getComplemento();
        bairro = hospital.getBairro();
        cidade = hospital.getCidade();
        estado = hospital.getEstado();
        telefone1 = hospital.getTelefone1();
        telefone2 = hospital.getTelefone2();
        telefone3 = hospital.getTelefone3();
        email = hospital.getEmail();
    }
}
