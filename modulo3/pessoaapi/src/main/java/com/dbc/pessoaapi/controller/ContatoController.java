package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.ContatoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
@RequiredArgsConstructor
@Slf4j
public class ContatoController {
    private final ContatoService contatoService;

    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        log.info("criando contato");
        ContatoDTO contatoCriado = contatoService.create(idPessoa, contatoCreateDTO);
        log.info("contato criado");
        return contatoCriado;
    }

    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        log.info("deletando contato");
        contatoService.delete(id);
        log.info("contato deletado");
    }

    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByPessoa(idPessoa);
    }

    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") Integer idContato, @RequestBody ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        log.info("atualizando contato");
        ContatoDTO contatoDTO = contatoService.update(idContato, contatoCreateDTO);
        log.info("contato atualizado");
        return contatoDTO;
    }
}
