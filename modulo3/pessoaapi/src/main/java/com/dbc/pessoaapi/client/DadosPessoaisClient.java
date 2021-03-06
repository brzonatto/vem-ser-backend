package com.dbc.pessoaapi.client;

import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value="dados-pessoais", url="https://my-application-teste.herokuapp.com")
@Headers("Content-Type: application/json")
public interface DadosPessoaisClient {
    @RequestLine("GET /dados-pessoais")
    List<DadosPessoaisDTO> get();

    @RequestLine("GET /dados-pessoais/{cpf}")
    DadosPessoaisDTO getByCpf(@Param("cpf") String cpf);

    @RequestLine("POST /dados-pessoais")
    DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO);

    @RequestLine("PUT /dados-pessoais/{cpf}")
    DadosPessoaisDTO put(@Param("cpf") String cpf, DadosPessoaisDTO dadosPessoaisDTO);

    @RequestLine("DELETE /dados-pessoais/{cpf}")
    void delete(@Param("cpf") String cpf);
}
