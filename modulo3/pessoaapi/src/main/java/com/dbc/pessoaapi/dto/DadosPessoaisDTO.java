package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.Sexo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoaisDTO {
    @NotEmpty
    @NotBlank
    @ApiModelProperty("Nome da pessoa")
    private String nome;

    @Size(max = 11, min = 11, message = "deve conter 11 números")
    @NotEmpty
    @NotBlank
    @ApiModelProperty("CPF da pessoa, sómente números")
    private String cpf;

    @Size(max = 11, min = 11, message = "deve conter 11 números")
    @NotEmpty
    @NotBlank
    @ApiModelProperty("RG da pessoa, sómente números")
    private String rg;

    @Size(max = 11, min = 11, message = "deve conter 11 números")
    @NotEmpty
    @NotBlank
    @ApiModelProperty("CNH da pessoa, sómente números")
    private String cnh;

    @NotEmpty
    @NotBlank
    @ApiModelProperty("Nome completo da mãe da pessoa")
    private String nomeMae;

    @NotEmpty
    @NotBlank
    @ApiModelProperty("Nome completo do pai da pessoa")
    private String nomePai;

    @Size(max = 11, min = 11, message = "deve conter 11 números")
    @NotEmpty
    @NotBlank
    @ApiModelProperty("CNH da pessoa, sómente números")
    private String tituloEleitor;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty("Sexo - (0 - MASCULINO, 1 - FEMININO)")
    private Sexo sexo;
}
