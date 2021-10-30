package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {
    private Integer idContato;
    private Integer idPessoa;

    @NotNull
    private TipoContato tipoContato;

    @Size(max = 13, min = 1, message = "deve ter no máximo 13 números")
    @NotEmpty
    @NotBlank
    private String numero;

    @NotEmpty
    @NotBlank
    private String descricao;
}
