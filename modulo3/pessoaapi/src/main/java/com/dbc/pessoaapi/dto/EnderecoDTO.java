package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoEndereco;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private Integer idEndereco;
    private Integer idPessoa;

    @NotNull
    @Min(0)
    @Max(1)
    private Integer tipo;

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
