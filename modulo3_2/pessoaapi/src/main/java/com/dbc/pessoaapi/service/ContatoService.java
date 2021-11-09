package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        pessoaService.findById(idPessoa);
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        contatoEntity.setIdPessoa(idPessoa);
        ContatoEntity contatoCriado = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);
        return contatoDTO;
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoEntity findById(Integer idContato) throws RegraDeNegocioException {
        ContatoEntity entity = contatoRepository.findById(idContato)
                .orElseThrow(() -> new RegraDeNegocioException("contato não encontrado"));
        return entity;
    }

    public ContatoDTO update(Integer idContato, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        ContatoEntity contatoEntity = findById(idContato);
        ContatoEntity entity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        entity.setIdPessoa(contatoEntity.getIdPessoa());
        entity.setIdContato(idContato);
        ContatoEntity update = contatoRepository.save(entity);
        ContatoDTO contatoDTO = objectMapper.convertValue(update, ContatoDTO.class);
        return contatoDTO;
    }

    public void delete(Integer idContato) throws RegraDeNegocioException {
        ContatoEntity entity = findById(idContato);
        contatoRepository.delete(entity);
    }

    public List<ContatoDTO> listByPessoa(Integer idPessoa) {
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList()).stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}
