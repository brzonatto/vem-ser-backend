package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.service.ContatoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}
