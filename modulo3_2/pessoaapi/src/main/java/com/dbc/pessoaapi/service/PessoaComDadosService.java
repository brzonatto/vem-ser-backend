package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaComDadosDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaComDadosService {
    private final DadosPessoaisClient dadosPessoaisClient;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public PessoaComDadosDTO create(PessoaComDadosDTO pessoaComDadosDTO) {
        PessoaEntity entity = objectMapper.convertValue(pessoaComDadosDTO, PessoaEntity.class);
        entity.setNome(pessoaComDadosDTO.getDadosPessoaisDTO().getNome());
        entity.setCpf(pessoaComDadosDTO.getDadosPessoaisDTO().getCpf());
        PessoaEntity entityCriada = pessoaRepository.create(entity);
        PessoaComDadosDTO pessoaComDadosDTO1 = objectMapper.convertValue(entityCriada, PessoaComDadosDTO.class);
        DadosPessoaisDTO dadosPessoaisDTO = dadosPessoaisClient.post(pessoaComDadosDTO.getDadosPessoaisDTO());
        pessoaComDadosDTO1.setDadosPessoaisDTO(dadosPessoaisDTO);
        return pessoaComDadosDTO1;
    }

    public PessoaComDadosDTO getByCPF(String cpf) throws RegraDeNegocioException {
        PessoaEntity entity = pessoaRepository.getByCPF(cpf);
        DadosPessoaisDTO dadosPessoaisDTO = dadosPessoaisClient.getByCpf(entity.getCpf());
        PessoaComDadosDTO pessoaComDadosDTO = objectMapper.convertValue(entity, PessoaComDadosDTO.class);
        pessoaComDadosDTO.setDadosPessoaisDTO(dadosPessoaisDTO);
        return pessoaComDadosDTO;
    }

    public void delete(String cpf) throws RegraDeNegocioException {
        PessoaEntity entity = pessoaRepository.getByCPF(cpf);
        dadosPessoaisClient.delete(cpf);
        pessoaRepository.delete(entity.getIdPessoa());
    }

    public PessoaComDadosDTO update(String cpf, PessoaComDadosDTO pessoaComDadosDTO) throws RegraDeNegocioException {
        dadosPessoaisClient.put(cpf, pessoaComDadosDTO.getDadosPessoaisDTO());
        PessoaEntity entity = pessoaRepository.getByCPF(cpf);
        entity.setNome(pessoaComDadosDTO.getDadosPessoaisDTO().getNome());
        entity.setCpf(cpf);
        PessoaEntity update = pessoaRepository.update(entity.getIdPessoa(), entity);
        PessoaComDadosDTO pessoaAtualizada = objectMapper.convertValue(update, PessoaComDadosDTO.class);
        pessoaAtualizada.setDadosPessoaisDTO(pessoaComDadosDTO.getDadosPessoaisDTO());
        dadosPessoaisClient.put(cpf, pessoaAtualizada.getDadosPessoaisDTO());
        return pessoaAtualizada;
    }
}
