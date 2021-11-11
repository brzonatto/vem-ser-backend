package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {
    private Integer idContato;

    @JsonIgnore
    private Integer idPessoa;

//    @NotNull
//    @Min(0)
//    @Max(1)
    @ApiModelProperty("Tipo do contato - (1 - RESIDENCIAL, 2 - COMERCIAL)")
    private TipoContato tipoContato;

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
