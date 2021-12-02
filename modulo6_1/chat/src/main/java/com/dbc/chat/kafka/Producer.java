package com.dbc.chat.kafka;

import com.dbc.chat.dto.MensagemCreateDTO;
import com.dbc.chat.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic.geral-chat}")
    private String chatGeral;

    private void send(MensagemDTO mensagemDTO, String topico) throws JsonProcessingException {
        String payload = objectMapper.writeValueAsString(mensagemDTO);
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();
        ListenableFuture<SendResult<String, String>> send = stringKafkaTemplate.send(message);
        send.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Erro ao enviar mensagem!");
            }
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("{} [{}] para {}: {}",
                        mensagemDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        mensagemDTO.getUsuario(),
                        StringUtils.capitalize(topico.replaceAll("chat-", "")),
                        mensagemDTO.getMensagem());
            }
        });
    }

    public void sendToChatGeral(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        mensagemDTO.setUsuario("Brunno");
        send(mensagemDTO, chatGeral);
    }

    public void sendTo(MensagemCreateDTO mensagemCreateDTO, String topico) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        mensagemDTO.setUsuario("Brunno");
        send(mensagemDTO, "chat-" + topico);
    }
}
