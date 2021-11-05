package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaComDadosDTO;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.PessoaComDadosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pessoa/dados")
@Validated
@RequiredArgsConstructor
@Slf4j
public class PessoaComDadosController {
    private final PessoaComDadosService pessoaComDadosService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa criada"),
            @ApiResponse(code = 400, message = "Dados inconsistentes"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Cria uma nova pessoa com dados no sistema")
    @PostMapping
    public PessoaComDadosDTO create(@RequestBody @Valid PessoaComDadosDTO pessoaComDadosDTO) {
        log.info("criando pessoa com dados");
        PessoaComDadosDTO pessoaCriada = pessoaComDadosService.create(pessoaComDadosDTO);
        log.info("pessoa com dados criada");
        return pessoaCriada;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra pessoa com dados"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Mostra pessoa com dados pelo CPF especificado por parâmetro")
    @GetMapping("/{cpf}")
    public PessoaComDadosDTO listByCPF(@PathVariable("cpf") String cpf) throws RegraDeNegocioException {
        return pessoaComDadosService.getByCPF(cpf);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa deletada"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Deleta pessoa com dados pelo CPF especificado por parâmetro")
    @DeleteMapping("{cpf}")
    public void delete(@PathVariable String cpf) throws RegraDeNegocioException {
        pessoaComDadosService.delete(cpf);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa Atualizada"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Atualiza pessoa com dados pelo CPF especificado por parâmetro")
    @PutMapping("/{cpf}")
    public PessoaComDadosDTO update(@PathVariable String cpf,
                                    @RequestBody @Valid PessoaComDadosDTO pessoaComDadosDTO) throws RegraDeNegocioException {
        return pessoaComDadosService.update(cpf, pessoaComDadosDTO);
    }
}
