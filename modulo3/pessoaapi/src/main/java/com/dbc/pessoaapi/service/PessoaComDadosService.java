package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.PessoaComDadosDTO;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaComDadosService {
    private final DadosPessoaisClient dadosPessoaisClient;
    private final PessoaRepository pessoaRepository;

    public List<PessoaComDadosDTO> list() {

    }
}
