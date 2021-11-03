package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {
    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty("Tipo do contato - (0 - RESIDENCIAL, 1 - COMERCIAL)")
    private Integer tipo;

    @Size(max = 250, min = 1, message = "deve conter no máximo 250 caracteres")
    @NotEmpty
    @NotBlank
    @ApiModelProperty("Exemplo: Rua, Av, Beco + nome")
    private String logradouro;

    @NotNull
    @ApiModelProperty("Número da residencia")
    private Integer numero;

    @ApiModelProperty("Complemento da residencia")
    private String complemento;

    @Size(max = 8, min = 1, message = "deve conter no máximo 8 caracteres")
    @NotEmpty
    @NotBlank
    @ApiModelProperty("CEP, somente números")
    private String cep;

    @Size(max = 250, min = 1, message = "deve conter no máximo 250 caracteres")
    @NotEmpty
    @NotBlank
    @ApiModelProperty("Cidade")
    private String cidade;

    @NotEmpty
    @NotBlank
    @ApiModelProperty("Estado")
    private String estado;

    @NotEmpty
    @NotBlank
    @ApiModelProperty("País")
    private String pais;
}
