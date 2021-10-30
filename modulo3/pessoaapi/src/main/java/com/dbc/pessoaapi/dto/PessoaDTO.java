package com.dbc.pessoaapi.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    private Integer idPessoa;

    @NotEmpty
    @NotBlank
    private String nome;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "deve conter 11 números")
    @NotEmpty
    @NotBlank
    private String cpf;
}
