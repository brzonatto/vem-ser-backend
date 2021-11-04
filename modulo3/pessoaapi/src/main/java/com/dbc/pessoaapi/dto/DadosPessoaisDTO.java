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
    @ApiModelProperty("Nome da pessoa")
    private String nome;
    @ApiModelProperty("CPF da pessoa, sómente números")
    private String cpf;
    @ApiModelProperty("RG da pessoa, sómente números")
    private String rg;
    @ApiModelProperty("CNH da pessoa, sómente números")
    private String cnh;
    @ApiModelProperty("Nome completo da mãe da pessoa")
    private String nomeMae;
    @ApiModelProperty("Nome completo do pai da pessoa")
    private String nomePai;
    @ApiModelProperty("CNH da pessoa, sómente números")
    private String tituloEleitor;
    @ApiModelProperty("Sexo - (M, F)")
    private Sexo sexo;
}
