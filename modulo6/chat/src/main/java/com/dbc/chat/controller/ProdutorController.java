package com.dbc.chat.controller;

import com.dbc.chat.dto.MensagemCreateDTO;
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
    public void sendToChatGeral(@RequestBody MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        producer.sendToChatGeral(mensagemCreateDTO);
    }

    @PostMapping("/send-to")
    public void sendTo(@RequestBody MensagemCreateDTO mensagemCreateDTO, @RequestParam String chatPrivado) throws JsonProcessingException {
        producer.sendTo(mensagemCreateDTO, chatPrivado);
    }
}
