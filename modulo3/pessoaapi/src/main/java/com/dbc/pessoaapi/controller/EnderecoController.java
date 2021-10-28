package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid Endereco endereco) throws RegraDeNegocioException {
        return enderecoService.create(idPessoa, endereco);
    }

    @GetMapping
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public Endereco listByEndereco(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return enderecoService.listByEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByPessoa(idPessoa);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.delete(idEndereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco") Integer idEndereco, @RequestBody @Valid Endereco enderecoAtualizado) throws RegraDeNegocioException {
        return enderecoService.update(idEndereco, enderecoAtualizado);
    }
}
