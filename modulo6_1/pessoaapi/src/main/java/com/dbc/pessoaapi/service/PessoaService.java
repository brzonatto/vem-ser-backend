package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.kafka.Producer;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final ObjectMapper objectMapper;
    private final PessoaRepository pessoaRepository;
    private final EmailService emailService;
    private final Producer producer;

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
        if (idPessoa == null) {
            return pessoaRepository.findAll()
                    .stream()
                    .map(pessoa -> {
                        return setPessoaContatoDTO(pessoa);
                    })
                    .collect(Collectors.toList());
        }
        return pessoaRepository.findById(idPessoa)
                .stream()
                .map(pessoa -> {
                    return setPessoaContatoDTO(pessoa);
                })
                .collect(Collectors.toList());
    }

    public List<PessoaEnderecoDTO> listWithEndereco(Integer idPessoa) {
        if (idPessoa == null) {
            return pessoaRepository.findAll()
                    .stream()
                    .map(pessoa -> {
                        return setPessoaEnderecoDTO(pessoa);
                    })
                    .collect(Collectors.toList());
        }
        return pessoaRepository.findById(idPessoa)
                .stream()
                .map(pessoa -> {
                    return setPessoaEnderecoDTO(pessoa);
                })
                .collect(Collectors.toList());
    }

    public List<PessoaCompletaDTO> listCompleta(Integer idPessoa) {
        if (idPessoa == null) {
            return pessoaRepository.findAll()
                    .stream()
                    .map(pessoa -> {
                        return setPessoaCompletaDTO(pessoa);
                    })
                    .collect(Collectors.toList());
        }
        return pessoaRepository.findById(idPessoa)
                .stream()
                .map(pessoa -> {
                    return setPessoaCompletaDTO(pessoa);
                })
                .collect(Collectors.toList());
    }

    public PessoaContatoDTO setPessoaContatoDTO(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        PessoaContatoDTO pessoaContatoDTO = new PessoaContatoDTO();
        pessoaContatoDTO.setPessoa(pessoaDTO);
        pessoaContatoDTO.setContatos(
                pessoaEntity.getContatos()
                        .stream()
                        .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                        .collect(Collectors.toList())
        );
        return pessoaContatoDTO;
    }

    public PessoaEnderecoDTO setPessoaEnderecoDTO(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        PessoaEnderecoDTO pessoaEnderecoDTO = new PessoaEnderecoDTO();
        pessoaEnderecoDTO.setPessoa(pessoaDTO);
        pessoaEnderecoDTO.setEnderecos(
                pessoaEntity.getEnderecos()
                        .stream()
                        .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                        .collect(Collectors.toList())
        );
        return pessoaEnderecoDTO;
    }

    public PessoaCompletaDTO setPessoaCompletaDTO(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        PessoaCompletaDTO pessoaCompletaDTO = new PessoaCompletaDTO();
        pessoaCompletaDTO.setPessoa(pessoaDTO);
        pessoaCompletaDTO.setEnderecos(
                pessoaEntity.getEnderecos()
                        .stream()
                        .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                        .collect(Collectors.toList())
        );
        pessoaCompletaDTO.setContatos(
                pessoaEntity.getContatos()
                        .stream()
                        .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                        .collect(Collectors.toList())
        );
        return pessoaCompletaDTO;
    }


    public void sendPessoasSemEndereco() throws JsonProcessingException {
        List<PessoaEntity> pessoasSemEndereco = pessoaRepository.searchByWithoutEndereco();
        String message = "Estamos muito felizes que você está em nosso sistema." +
                "<br>Para que possamos enviá-lo um brinde exclusivo, por gentileza," +
                "<br>adicione ou atualize o seu endereço no seu cadastro.";
        for (PessoaEntity key : pessoasSemEndereco) {
            producer.sendToSendBox(new KafkaDTO(key.getNome(), key.getEmail(), "Atualize seu cadastro!", message));
        }
    }

    public void sendAniversariante() throws JsonProcessingException {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM"));
        List<PessoaEntity> aniversariantes = pessoaRepository.searchAniversatiante(date);
        for (PessoaEntity key : aniversariantes) {
            String message = "Essa data de " + date + " também é especial" +
                    "<br>para nós do Vem Ser. Estamos comemorando junto com você. \\o/" +
                    "<br><br>Desejamos um feliz aniversário, que sejam " + (LocalDate.now().getYear() - key.getDataNascimento().getYear()) + " anos de muitos." +
                    "<br>Sucesso, alegria, felicidade e muitas realizações.";
            producer.sendToSendBox(new KafkaDTO(key.getNome(), key.getEmail(), "Parabéns!", message));
        }
    }

    public void sendPromo() throws JsonProcessingException {
        List<PessoaEntity> pessoas = pessoaRepository.findAll();
        for (PessoaEntity key : pessoas) {
            String message = "Selecionamos algumas das nossas super promoções de natal na nossa plataforma" +
                    "<br>especialmente para você:" +
                    "<br>- Na compra de 1 CD do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico." +
                    "<br>- Na locação de um filme em VHS, a outra locação é grátis." +
                    "<br>- Fita de Super Nintendo com 50% de desconto.";
            producer.sendToSendBox(new KafkaDTO(key.getNome(), key.getEmail(), "Parabéns!", message));
        }
    }
}
