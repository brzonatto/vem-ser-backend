package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        pessoaRepository.listById(idPessoa);
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        ContatoEntity contatoCriado = contatoRepository.create(idPessoa, contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);
        return contatoDTO;
    }

    public List<ContatoDTO> list() {
        return contatoRepository.list().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer idEndereco, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        ContatoEntity entity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        ContatoEntity update = contatoRepository.update(idEndereco, entity);
        ContatoDTO contatoDTO = objectMapper.convertValue(update, ContatoDTO.class);
        return contatoDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        contatoRepository.delete(id);
    }

    public List<ContatoDTO> listByPessoa(Integer idPessoa) {
        return contatoRepository.listByPessoa(idPessoa).stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }
}
