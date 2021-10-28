package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Endereco create(Integer idPessoa, Endereco endereco) throws RegraDeNegocioException {
        pessoaRepository.listById(idPessoa);
        return enderecoRepository.create(idPessoa, endereco);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco listByEndereco(Integer idEndereco) throws Exception {
        return enderecoRepository.listByEndereco(idEndereco);
    }

    public List<Endereco> listByPessoa(Integer idPessoa) {
        return enderecoRepository.listByPessoa(idPessoa);
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        enderecoRepository.delete(idEndereco);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtualizado) throws RegraDeNegocioException {
        return enderecoRepository.update(idEndereco, enderecoAtualizado);
    }
}
