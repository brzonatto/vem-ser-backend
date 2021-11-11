package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaContatoDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.dto.PessoaEnderecoDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.PessoaService;
import freemarker.template.TemplateException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@RequiredArgsConstructor
@Slf4j
public class PessoaController {
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa criada"),
            @ApiResponse(code = 400, message = "Dados inconsistentes"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Cria uma nova pessoa no sistema")
    @PostMapping
    public PessoaDTO create(@RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        log.info("criando pessoa");
        PessoaDTO pessoaCriada = pessoaService.create(pessoaCreateDTO);
        log.info("pessoa criada");
        return pessoaCriada;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mostra a lista de pessoas cadastradas"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar esse recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Mostra todas as pessoas cadastradas no sistema")
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa encontrada"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Mostra todas as pessoas cadastradas no sistema que contenham o nome especificado por parâmetro")
    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") @NotBlank @NotEmpty String nome) {
        return pessoaService.listByName(nome);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa atualizada"),
            @ApiResponse(code = 400, message = "Dados inconsistentes ou pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Atualiza a pessoa pelo id especificado por parâmetro")
    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        log.info("atualizando pessoa");
        PessoaDTO pessoaDTO = pessoaService.update(id, pessoaCreateDTO);
        log.info("pessoa atualizada");
        return pessoaDTO;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa deletada"),
            @ApiResponse(code = 400, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema")
    })
    @ApiOperation("Remove a pessoa pelo id especificado por parâmetro")
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        log.info("Deletando pessoa");
        pessoaService.delete(id);
        log.info("pessoa deletada");
    }

    @GetMapping("/find-by-nome")
    public List<PessoaEntity> findByNomeContainingIgnoreCase(@RequestParam("nome") String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/find-by-cpf")
    public PessoaEntity findByCpf(@RequestParam("cpf") String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    @GetMapping("/find-by-data")
    public List<PessoaEntity> findByData(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return pessoaRepository.findByDataNascimentoBetween(start, end);
    }

    @GetMapping("/list-with-contato")
    public List<PessoaContatoDTO> listWithContato(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) {
        return pessoaService.listWithContato(idPessoa);
    }

    @GetMapping("/list-with-endereco")
    public List<PessoaEnderecoDTO> listWithEndereco(@RequestParam(value = "idPessoa", required = false) Integer idPessoa) {
        return pessoaService.listWithEndereco(idPessoa);
    }

    @GetMapping("/search-by-data")
    public List<PessoaEntity> searchByData(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return pessoaRepository.searchByData(start, end);
    }

    @GetMapping("/search-contain-endereco")
    public List<PessoaEntity> searchContainEndereco() {
        return pessoaRepository.searchContainEndereco();
    }


    @GetMapping("/search-by-without-endereco")
    public List<PessoaEntity> searchByWithoutEndereco() {
        return pessoaRepository.searchByWithoutEndereco();
    }
}
