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
    private final ObjectMapper objectMapper;

    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity enderecoCriado = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
        return enderecoDTO;
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO listByEndereco(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = findById(idEndereco);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
        return enderecoDTO;
    }

    public List<EnderecoDTO> listByPessoa(Integer idPessoa) {
        return enderecoRepository.searchByPessoa(idPessoa)
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoEntity findById(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity entity = enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return entity;
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity entity = findById(idEndereco);
        enderecoRepository.delete(entity);
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        findById(idEndereco);
        EnderecoEntity entity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        entity.setIdEndereco(idEndereco);
        EnderecoEntity update = enderecoRepository.save(entity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(update, EnderecoDTO.class);
        return enderecoDTO;
    }
}
