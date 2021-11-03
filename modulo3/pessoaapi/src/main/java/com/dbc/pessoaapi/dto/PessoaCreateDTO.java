package com.dbc.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {
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

    @Email
    @NotEmpty
    @NotBlank
    private String email;
}
