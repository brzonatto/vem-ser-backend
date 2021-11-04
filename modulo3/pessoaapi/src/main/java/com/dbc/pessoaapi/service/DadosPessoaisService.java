package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DadosPessoaisService {
    private final DadosPessoaisClient dadosPessoaisClient;

    public List<DadosPessoaisDTO> list() {
        return dadosPessoaisClient.get();
    }

    public DadosPessoaisDTO listByCPF(String cpf) {
        return dadosPessoaisClient.getByCpf(cpf);
    }

    public DadosPessoaisDTO create(DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }
}
