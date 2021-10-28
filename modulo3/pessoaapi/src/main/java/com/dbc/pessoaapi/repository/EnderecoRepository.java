package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEndereco = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public Endereco create(Integer idPessoa, Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        listaEndereco.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEndereco;
    }

    public Endereco listByEndereco(Integer idEndereco) throws Exception {
        return listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado!"));
    }

    public List<Endereco> listByPessoa(Integer idPessoa) {
        return listaEndereco.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("endereço não encontrado"));
        listaEndereco.remove(enderecoRecuperado);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtualizado) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("endereço não encontrado"));
        enderecoRecuperado.setTipo(enderecoAtualizado.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizado.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizado.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizado.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizado.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizado.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizado.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizado.getPais());
        return enderecoRecuperado;
    }
}
