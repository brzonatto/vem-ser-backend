package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {
    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty("Tipo do contato - (0 - RESIDENCIAL, 1 - COMERCIAL)")
    private Integer tipoContato;

    @Size(max = 13, min = 1, message = "deve ter no máximo 13 números")
    @NotEmpty
    @NotBlank
    @ApiModelProperty("Número do telefone, somente números")
    private String numero;

    @NotEmpty
    @NotBlank
    @ApiModelProperty("Descrição do contato")
    private String descricao;
}
