package com.dbc.pessoaapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    private Integer idPessoa;

    @NotEmpty
    @NotBlank
    @ApiModelProperty("Nome da pessoa")
    private String nome;

    @Past
    @NotNull
    @ApiModelProperty("Data de nascimento da pessoa, formato AAAA-MM-DD")
    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "deve conter 11 números")
    @NotEmpty
    @NotBlank
    @ApiModelProperty("CPF da pessoa, sómente números")
    private String cpf;

    @Email
    @NotEmpty
    @NotBlank
    @ApiModelProperty("E-mail da pessoa")
    private String email;

    @JsonIgnore
    private List<ContatoDTO> contatos;
}
