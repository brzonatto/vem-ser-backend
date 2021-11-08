package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.EnderecoService;
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
@RequestMapping("/endereco")
@Validated
@Slf4j
@RequiredArgsConstructor
public class EnderecoController {
    private final EnderecoService enderecoService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço criado"),
            @ApiResponse(code = 400, message = "Dados inconsistentes"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Cria um novo endereço pelo ID da pessoa especificado por parâmetro")
    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        log.info("criando endereço");
        EnderecoDTO enderecoDTO = enderecoService.create(idPessoa, enderecoCreateDTO);
        log.info("endereço criado");
        return enderecoDTO;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra lista de endereços cadastrados"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Mostra todos os endereços cadastrados no sistema")
    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra o endereço"),
            @ApiResponse(code = 400, message = "Endereço não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Mostra o endereço com o ID especificado por parâmetro")
    @GetMapping("/{idEndereco}")
    public EnderecoDTO listByEndereco(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return enderecoService.listByEndereco(idEndereco);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra os endereços"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Mostra os endereços com o ID da pessoa especificado por parâmetro")
    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listByPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByPessoa(idPessoa);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Remove o endereço"),
            @ApiResponse(code = 400, message = "Endereço não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Remove o endereço com o ID especificado por parâmetro")
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        log.info("deletando endereço");
        enderecoService.delete(idEndereco);
        log.info("endereço deletado");
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualiza o endereço"),
            @ApiResponse(code = 400, message = "Endereço não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Atualiza o endereço com o ID especificado por parâmetro")
    @PutMapping("/{idEndereco}")
    public EnderecoDTO update(@PathVariable("idEndereco") Integer idEndereco, @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        log.info("atualizando endereço");
        EnderecoDTO enderecoDTO = enderecoService.update(idEndereco, enderecoCreateDTO);
        log.info("endereço atualizado");
        return enderecoDTO;
    }
}
