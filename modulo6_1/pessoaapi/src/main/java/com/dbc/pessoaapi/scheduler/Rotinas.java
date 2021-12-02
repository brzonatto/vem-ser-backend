package com.dbc.pessoaapi.scheduler;

import com.dbc.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class Rotinas {
    private final PessoaService pessoaService;

    @Scheduled(cron = "0 0 8,20 * * *")
    public void pessoasSemEdereco() throws IOException {
        pessoaService.sendPessoasSemEndereco();
    }

    @Scheduled(cron = "0 0 8 * * *")
    public void aniversariante() throws IOException {
        pessoaService.sendAniversariante();
    }

    @Scheduled(cron = "0 0 0 23 12 *")
    public void promo() throws IOException {
        pessoaService.sendPromo();
    }
}
