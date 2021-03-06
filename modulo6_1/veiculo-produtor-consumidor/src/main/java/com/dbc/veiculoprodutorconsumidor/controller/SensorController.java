package com.dbc.veiculoprodutorconsumidor.controller;

import com.dbc.veiculoprodutorconsumidor.dto.MediaTodosDTO;
import com.dbc.veiculoprodutorconsumidor.dto.TotalDTO;
import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensor")
@RequiredArgsConstructor
public class SensorController {
    private final ConsumerService consumerService;

    @GetMapping
    public List<VeiculoDTO> list() {
        return consumerService.list();
    }

    @GetMapping("/media-velocidade")
    public MediaTodosDTO mediaVelocidadeTodos() {
        return consumerService.mediaVelocidadeTodos();
    }

    @GetMapping("/media-rotacao")
    public MediaTodosDTO mediaRotacaoTodos() {
        return consumerService.mediaRotacaoTodos();
    }

    @GetMapping("/total")
    public TotalDTO count() {
        return consumerService.count();
    }
}
