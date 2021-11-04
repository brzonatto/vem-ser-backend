package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.service.DadosPessoaisService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@Validated
@RequiredArgsConstructor
@Slf4j
public class DadosPessoaisController {
    private final DadosPessoaisService dadosPessoaisService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra lista de dados pessoais"),
            @ApiResponse(code = 400, message = "Você não tem permissão para usar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Mostra todos os dados pessoais cadastrados no sistema")
    @GetMapping()
    public List<DadosPessoaisDTO> listDadosPessoais() {
        return dadosPessoaisService.list();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra dados pessoais"),
            @ApiResponse(code = 400, message = "CPF não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Mostra dados pessoais da pessoa com o cpf especificado por parâmetro")
    @GetMapping("/{cpf}")
    public DadosPessoaisDTO listDadosPessoaisByCPF(@PathVariable("cpf") String cpf) {
        return dadosPessoaisService.listByCPF(cpf);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cria dados pessoais"),
            @ApiResponse(code = 400, message = "CPF não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Cria dados pessoais")
    @PostMapping()
    public DadosPessoaisDTO create(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisService.create(dadosPessoaisDTO);
    }
}
