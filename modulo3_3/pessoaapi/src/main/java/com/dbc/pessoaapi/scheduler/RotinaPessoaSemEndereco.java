package com.dbc.pessoaapi.scheduler;

import com.dbc.pessoaapi.service.PessoaService;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class RotinaPessoaSemEndereco {
    private final PessoaService pessoaService;

    @Scheduled(cron = "0 0 8,20 * * *")
    public void pessoasSemEdereco() throws InterruptedException, MessagingException, TemplateException, IOException {
        pessoaService.sendPessoasSemEndereco();
    }

    @Scheduled(cron = "0 0 0 23 12 ?")
    public void meuPrimeiroScheduler() throws InterruptedException, MessagingException, TemplateException, IOException {
        pessoaService.sendPessoasSemEndereco();
    }
}
