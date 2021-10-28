package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid Contato contato) throws RegraDeNegocioException {
        Contato contatoCriado = contatoService.create(idPessoa, contato);
        return new ResponseEntity<>(contatoCriado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByPessoa(idPessoa);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer idContato, @RequestBody Contato contatoAtualizar) throws RegraDeNegocioException {
        return contatoService.update(idContato, contatoAtualizar);
    }
}
