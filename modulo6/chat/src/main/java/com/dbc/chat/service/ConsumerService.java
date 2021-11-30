package com.dbc.chat.service;

import com.dbc.chat.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic.geral-chat}",
            groupId = "${kafka.group-geral-chat}",
            containerFactory = "listenerContainerFactoryEarliest",
            clientIdPrefix = "geral"
    )
    public void consumeChatGeral(@Payload String mensagem) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("{}/{}/{} {}:{}:{} - [{}] (geral): {}",
                mensagemDTO.getDataCriacao().getDayOfMonth(),
                mensagemDTO.getDataCriacao().getMonthValue(),
                mensagemDTO.getDataCriacao().getYear(),
                mensagemDTO.getDataCriacao().minusHours(3).getHour(),
                mensagemDTO.getDataCriacao().getMinute(),
                mensagemDTO.getDataCriacao().getSecond(),
                mensagemDTO.getUsuario(),
                mensagemDTO.getMensagem());
    }

    @KafkaListener(
            topics = "${kafka.topic.meu-chat}",
            groupId = "${kafka.group-meu-chat}",
            containerFactory = "listenerContainerFactoryEarliest",
            clientIdPrefix = "private"
    )
    public void consumeMeuChat(@Payload String mensagem) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("{}/{}/{} {}:{}:{} - [{}] (privado): {}",
                mensagemDTO.getDataCriacao().getDayOfMonth(),
                mensagemDTO.getDataCriacao().getMonthValue(),
                mensagemDTO.getDataCriacao().getYear(),
                mensagemDTO.getDataCriacao().getHour(),
                mensagemDTO.getDataCriacao().getMinute(),
                mensagemDTO.getDataCriacao().getSecond(),
                mensagemDTO.getUsuario(),
                mensagemDTO.getMensagem());
    }
}
