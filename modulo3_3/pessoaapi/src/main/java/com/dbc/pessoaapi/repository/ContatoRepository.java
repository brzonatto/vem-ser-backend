package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {
    @Query("SELECT C " +
            "FROM CONTATO C " +
            "WHERE C.tipoContato = :tipo")
    List<ContatoEntity> searchByTipo(TipoContato tipo);

    @Query(value = "SELECT * " +
            "FROM CONTATO C " +
            "JOIN PESSOA P ON (C.ID_PESSOA = P.ID_PESSOA) " +
            "WHERE C.ID_PESSOA = :idPessoa", nativeQuery = true)
    List<ContatoEntity> searchByPessoa(Integer idPessoa);
}