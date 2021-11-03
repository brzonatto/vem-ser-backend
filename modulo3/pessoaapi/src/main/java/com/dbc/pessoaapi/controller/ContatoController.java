package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.ContatoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contato criado"),
            @ApiResponse(code = 400, message = "Dados inconsistentes ou pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Cria um novo contato para a pessoa com o ID especificado por parâmetro")
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        log.info("criando contato");
        ContatoDTO contatoCriado = contatoService.create(idPessoa, contatoCreateDTO);
        log.info("contato criado");
        return contatoCriado;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra lista de contatos"),
            @ApiResponse(code = 400, message = "Você não tem permissão para usar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Mostra todos os contatos cadastrados no sistema")
    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contato Removido"),
            @ApiResponse(code = 400, message = "Contato não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Remove um contato pelo ID de contato especificado por parâmetro")
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        log.info("deletando contato");
        contatoService.delete(id);
        log.info("contato deletado");
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra lista de contatos"),
            @ApiResponse(code = 400, message = "pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Mostra todos os contatos da pessoa com o ID especificado por parâmetro")
    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByPessoa(idPessoa);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contato criado"),
            @ApiResponse(code = 400, message = "Dados inconsistentes ou pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Atualiza o contato com o ID especificado por parâmetro")
    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") Integer idContato, @RequestBody ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        log.info("atualizando contato");
        ContatoDTO contatoDTO = contatoService.update(idContato, contatoCreateDTO);
        log.info("contato atualizado");
        return contatoDTO;
    }
}
