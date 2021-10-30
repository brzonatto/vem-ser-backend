package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEntity {
    private Integer idEndereco;
    private Integer idPessoa;

    @NotNull
    private TipoEndereco tipo;

    @Size(max = 250, min = 1, message = "deve conter no máximo 250 caracteres")
    @NotEmpty
    @NotBlank
    private String logradouro;

    @NotNull
    private Integer numero;

    private String complemento;

    @Size(max = 8, min = 1, message = "deve conter no máximo 8 caracteres")
    @NotEmpty
    @NotBlank
    private String cep;

    @Size(max = 250, min = 1, message = "deve conter no máximo 250 caracteres")
    @NotEmpty
    @NotBlank
    private String cidade;

    @NotEmpty
    @NotBlank
    private String estado;

    @NotEmpty
    @NotBlank
    private String pais;
}
