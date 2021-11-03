package com.dbc.pessoaapi.entity;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEntity {
    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
}