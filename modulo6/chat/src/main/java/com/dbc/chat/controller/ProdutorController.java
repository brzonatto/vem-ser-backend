package com.dbc.chat.controller;

import com.dbc.chat.dto.MensagemDTO;
import com.dbc.chat.kafka.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final Producer producer;

    @PostMapping("/send-to-chat-geral")
    public void sendToChatGeral(@RequestBody MensagemDTO mensagemDTO) throws JsonProcessingException {
        producer.sendToChatGeral(mensagemDTO);
    }

    @PostMapping("/send-to")
    public void sendTo(@RequestBody MensagemDTO mensagemDTO, @RequestParam String chatPrivado) throws JsonProcessingException {
        producer.sendTo(mensagemDTO, chatPrivado);
    }
}
