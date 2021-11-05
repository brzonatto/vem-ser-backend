package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaComDadosDTO {
    private Integer idPessoa;

    @Past
    @NotNull
    @ApiModelProperty("Data de nascimento da pessoa, formato AAAA-MM-DD")
    private LocalDate dataNascimento;

    @Email
    @NotEmpty
    @NotBlank
    @ApiModelProperty("E-mail da pessoa")
    private String email;

    private DadosPessoaisDTO dadosPessoaisDTO;
}
