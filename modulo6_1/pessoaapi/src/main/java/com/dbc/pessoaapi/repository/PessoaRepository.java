package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);

    PessoaEntity findByCpf(String cpf);

    List<PessoaEntity> findByDataNascimentoBetween(LocalDate start, LocalDate end);

    @Query("SELECT P " +
            "FROM PESSOA P " +
            "WHERE P.dataNascimento BETWEEN :start AND :end")
    List<PessoaEntity> searchByData(LocalDate start, LocalDate end);

    @Query("SELECT DISTINCT P " +
            "FROM PESSOA P " +
            "INNER JOIN P.enderecos E")
    List<PessoaEntity> searchContainEndereco();

    @Query(value = "SELECT * " +
            "FROM PESSOA P " +
            "WHERE NOT EXISTS " +
            "(SELECT * " +
            "FROM PESSOA_X_PESSOA_ENDERECO PPE " +
            "WHERE P.ID_PESSOA = PPE.ID_PESSOA)", nativeQuery = true)
    List<PessoaEntity> searchByWithoutEndereco();

    @Query(value = "SELECT * " +
            "FROM PESSOA P " +
            "WHERE TO_CHAR(P.DATA_NASCIMENTO, 'DD/MM')  =  :data", nativeQuery = true)
    List<PessoaEntity> searchAniversatiante(String data);
}