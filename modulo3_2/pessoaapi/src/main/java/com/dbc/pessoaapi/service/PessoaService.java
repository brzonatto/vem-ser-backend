package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final ObjectMapper objectMapper;
    private final PessoaRepository pessoaRepository;
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO)
            throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
//        String message = "<br><br>Estamos felizes em ter você em nosso sistema :)" +
//                "<br>Seu cadastro foi realizado com sucesso, seu " +
//                "identificador é " + pessoaDTO.getIdPessoa() + ".";
//        emailService.sendEmailPessoa(pessoaDTO, message , "Bem-Vindo!");
        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = findById(id);
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        return dto;
    }

    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("pessoa não encontrada"));
        return entity;
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaCreateDTO)
            throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        findById(id);
        PessoaEntity entity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        entity.setIdPessoa(id);
        PessoaEntity update = pessoaRepository.save(entity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(update, PessoaDTO.class);
//        emailService.sendEmailPessoa(pessoaDTO, "Seus dados foram atualizados no nosso sistema.", "Dados atualizados!");
        return pessoaDTO;
    }

    public void delete(Integer id)
            throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        PessoaEntity pessoaEntity = findById(id);
        pessoaRepository.delete(pessoaEntity);
//        emailService.sendEmailPessoa(pessoaDTO, "<br><br>Você perdeu o acesso ao nosso sistema.<br>", "Acesso perdido!");
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll()
                .stream()
                .filter(pessoa -> pessoa.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList()).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaContatoDTO> listWithContato(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findAll()
                    .stream()
                    .filter(pessoaEntity -> pessoaEntity.getIdPessoa().equals(idPessoa))
                    .map(pessoa -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                        PessoaContatoDTO pessoaContatoDTO = new PessoaContatoDTO();
                        pessoaContatoDTO.setPessoa(pessoaDTO);
                        pessoaContatoDTO.setContatos(
                                pessoa.getContatos()
                                        .stream()
                                        .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                        .collect(Collectors.toList())
                        );
                        return pessoaContatoDTO;
                    })
                    .collect(Collectors.toList());
        }
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> {
                    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                    PessoaContatoDTO pessoaContatoDTO = new PessoaContatoDTO();
                    pessoaContatoDTO.setPessoa(pessoaDTO);
                    pessoaContatoDTO.setContatos(
                            pessoa.getContatos()
                                    .stream()
                                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                    .collect(Collectors.toList())
                    );
                    return pessoaContatoDTO;
                })
                .collect(Collectors.toList());
    }

    public List<PessoaEnderecoDTO> listWithEndereco(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findAll()
                    .stream()
                    .filter(pessoaEntity -> pessoaEntity.getIdPessoa().equals(idPessoa))
                    .map(pessoa -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                        PessoaEnderecoDTO pessoaEnderecoDTO = new PessoaEnderecoDTO();
                        pessoaEnderecoDTO.setPessoa(pessoaDTO);
                        pessoaEnderecoDTO.setEnderecos(
                                pessoa.getEnderecos()
                                        .stream()
                                        .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                        .collect(Collectors.toList())
                        );
                        return pessoaEnderecoDTO;
                    })
                    .collect(Collectors.toList());
        }
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> {
                    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                    PessoaEnderecoDTO pessoaEnderecoDTO = new PessoaEnderecoDTO();
                    pessoaEnderecoDTO.setPessoa(pessoaDTO);
                    pessoaEnderecoDTO.setEnderecos(
                            pessoa.getEnderecos()
                                    .stream()
                                    .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                    .collect(Collectors.toList())
                    );
                    return pessoaEnderecoDTO;
                })
                .collect(Collectors.toList());
    }

    public List<PessoaCompletaDTO> listCompleta(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findAll()
                    .stream()
                    .filter(pessoaEntity -> pessoaEntity.getIdPessoa().equals(idPessoa))
                    .map(pessoa -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                        PessoaCompletaDTO pessoaCompletaDTO = new PessoaCompletaDTO();
                        pessoaCompletaDTO.setPessoa(pessoaDTO);
                        pessoaCompletaDTO.setEnderecos(
                                pessoa.getEnderecos()
                                        .stream()
                                        .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                        .collect(Collectors.toList())
                        );
                        pessoaCompletaDTO.setContatos(
                                pessoa.getContatos()
                                        .stream()
                                        .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                        .collect(Collectors.toList())
                        );
                        return pessoaCompletaDTO;
                    })
                    .collect(Collectors.toList());
        }
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> {
                    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                    PessoaCompletaDTO pessoaCompletaDTO = new PessoaCompletaDTO();
                    pessoaCompletaDTO.setPessoa(pessoaDTO);
                    pessoaCompletaDTO.setEnderecos(
                            pessoa.getEnderecos()
                                    .stream()
                                    .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                    .collect(Collectors.toList())
                    );
                    pessoaCompletaDTO.setContatos(
                            pessoa.getContatos()
                                    .stream()
                                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                    .collect(Collectors.toList())
                    );
                    return pessoaCompletaDTO;
                })
                .collect(Collectors.toList());
    }

}
