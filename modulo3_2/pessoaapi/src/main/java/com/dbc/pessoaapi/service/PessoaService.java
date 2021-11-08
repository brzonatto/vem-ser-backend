package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final ObjectMapper objectMapper;
    private final PessoaRepository pessoaRepository;
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        String message = "<br><br>Estamos felizes em ter você em nosso sistema :)" +
                "<br>Seu cadastro foi realizado com sucesso, seu " +
                "identificador é " + pessoaDTO.getIdPessoa() + ".";
//        emailService.sendEmailPessoa(pessoaDTO, message , "Bem-Vindo!");
        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        PessoaEntity entity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity update = pessoaRepository.update(id, entity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(update, PessoaDTO.class);
//        emailService.sendEmailPessoa(pessoaDTO, "Seus dados foram atualizados no nosso sistema.", "Dados atualizados!");
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException, MessagingException, TemplateException, IOException {
        PessoaEntity pessoaEntity = pessoaRepository.listById(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        pessoaRepository.delete(id);
//        emailService.sendEmailPessoa(pessoaDTO, "<br><br>Você perdeu o acesso ao nosso sistema.<br>", "Acesso perdido!");
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }


}
