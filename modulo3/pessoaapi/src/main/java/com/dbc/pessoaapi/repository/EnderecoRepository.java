package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EnderecoRepository {
    private static List<EnderecoEntity> listaEnderecoEntity = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoEntity create(Integer idPessoa, EnderecoEntity enderecoEntity) throws RegraDeNegocioException{
        enderecoEntity.setIdEndereco(COUNTER.incrementAndGet());
        enderecoEntity.setIdPessoa(idPessoa);
        listaEnderecoEntity.add(enderecoEntity);
        return enderecoEntity;
    }

    public List<EnderecoEntity> list() {
        return listaEnderecoEntity;
    }

    public EnderecoEntity listByEndereco(Integer idEndereco) throws RegraDeNegocioException {
        return listaEnderecoEntity.stream()
                .filter(enderecoEntity -> enderecoEntity.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
    }

    public List<EnderecoEntity> listByPessoa(Integer idPessoa) {
        return listaEnderecoEntity.stream()
                .filter(enderecoEntity -> enderecoEntity.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntityRecuperado = listaEnderecoEntity.stream()
                .filter(enderecoEntity -> enderecoEntity.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("endereço não encontrado"));
        listaEnderecoEntity.remove(enderecoEntityRecuperado);
    }

    public EnderecoEntity update(Integer idEndereco, EnderecoEntity enderecoEntityAtualizado) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntityRecuperado = listaEnderecoEntity.stream()
                .filter(enderecoEntity -> enderecoEntity.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("endereço não encontrado"));
        enderecoEntityRecuperado.setTipo(enderecoEntityAtualizado.getTipo());
        enderecoEntityRecuperado.setLogradouro(enderecoEntityAtualizado.getLogradouro());
        enderecoEntityRecuperado.setNumero(enderecoEntityAtualizado.getNumero());
        enderecoEntityRecuperado.setComplemento(enderecoEntityAtualizado.getComplemento());
        enderecoEntityRecuperado.setCep(enderecoEntityAtualizado.getCep());
        enderecoEntityRecuperado.setCidade(enderecoEntityAtualizado.getCidade());
        enderecoEntityRecuperado.setEstado(enderecoEntityAtualizado.getEstado());
        enderecoEntityRecuperado.setPais(enderecoEntityAtualizado.getPais());
        return enderecoEntityRecuperado;
    }
}
