package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        pessoaRepository.listById(idPessoa);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity enderecoCriado = enderecoRepository.create(idPessoa, enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
        return enderecoDTO;
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO listByEndereco(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = enderecoRepository.listByEndereco(idEndereco);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
        return enderecoDTO;
    }

    public List<EnderecoDTO> listByPessoa(Integer idPessoa) {
        return enderecoRepository.listByPessoa(idPessoa).stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        enderecoRepository.delete(idEndereco);
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        EnderecoEntity entity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity update = enderecoRepository.update(idEndereco, entity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(update, EnderecoDTO.class);
        return enderecoDTO;
    }
}
