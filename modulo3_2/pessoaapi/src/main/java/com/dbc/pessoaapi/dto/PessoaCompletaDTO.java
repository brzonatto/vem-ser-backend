package com.dbc.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCompletaDTO {
    @NotNull
    private PessoaDTO pessoa;

    private List<ContatoDTO> contatos;
    private List<EnderecoDTO> enderecos;
}
