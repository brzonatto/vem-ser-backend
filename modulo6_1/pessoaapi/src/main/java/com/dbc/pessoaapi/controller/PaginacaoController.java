package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;

    @GetMapping("/contato-by-descriacao-page")
    public Page<ContatoEntity> contatoByDescricaoPage(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina, // pagina que eu quero
                quantidadeDeRegistrosPorPagina, //quantidade de registros por pagina
                Sort.by("descricao") //ordenação (opcional)
        );
        Page<ContatoEntity> paginaDoBanco = contatoRepository.findAll(pageable);
        return paginaDoBanco;
    }

    @GetMapping("/endereco-by-cep-page")
    public Page<EnderecoEntity> EnderecoByCepPage(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina, // pagina que eu quero
                quantidadeDeRegistrosPorPagina, //quantidade de registros por pagina
                Sort.by("cep") //ordenação (opcional)
        );
        Page<EnderecoEntity> paginaDoBanco = enderecoRepository.findAll(pageable);
        return paginaDoBanco;
    }

    @GetMapping("/list-by-pais")
    public Page<EnderecoEntity> findByPais(
            @RequestParam String pais,
            @RequestParam Integer pagina,
            @RequestParam(defaultValue = "2", required = false) Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina);
        Page<EnderecoEntity> paginaDoBanco = enderecoRepository.findByPais("%"+pais+"%", pageable);
        return paginaDoBanco;
    }

}
