package com.dbc.pessoaapi.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PessoaCompletaDTO {
    @NotNull
    private PessoaDTO pessoa;

    private List<ContatoDTO> contatos;
    private List<EnderecoDTO> enderecos;
}
