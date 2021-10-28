package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Contato create(Integer idPessoa, Contato contato) throws RegraDeNegocioException {
        pessoaRepository.listById(idPessoa);
        return contatoRepository.create(idPessoa, contato);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer idEndereco, Contato contatoAtualizar) throws RegraDeNegocioException {
        return contatoRepository.update(idEndereco, contatoAtualizar);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        contatoRepository.delete(id);
    }

    public List<Contato> listByPessoa(Integer idPessoa) {
        return contatoRepository.listByPessoa(idPessoa);
    }
}
