package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa) throws Exception {
        return pessoaRepository.create(pessoa);
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws RegraDeNegocioException {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
         pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
