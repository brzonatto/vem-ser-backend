package com.dbc.pessoaapi.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoEntity {
    private Integer idContato;
    private Integer idPessoa;
    private TipoContato tipoContato;
    private String numero;
    private String descricao;
}
