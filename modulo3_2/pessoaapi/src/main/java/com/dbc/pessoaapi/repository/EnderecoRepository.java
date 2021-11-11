package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    @Query("SELECT e " +
            "FROM ENDERECO_PESSOA e " +
            "WHERE e.pais = :pais ")
    List<EnderecoEntity> searchByPais(String pais);

    @Query("SELECT E " +
            "FROM ENDERECO_PESSOA E " +
            "JOIN E.pessoas P " +
            "WHERE P.idPessoa = :idPessoa")
    List<EnderecoEntity> searchByPessoa(Integer idPessoa);

    @Query(value = "SELECT * " +
            "FROM ENDERECO_PESSOA E " +
            "WHERE UPPER(E.PAIS) LIKE :cidadeOrPais OR UPPER(E.CIDADE) LIKE :cidadeOrPais", nativeQuery = true)
    List<EnderecoEntity> searchByCidadeOrPais(String cidadeOrPais);

    @Query(value = "SELECT * " +
            "FROM ENDERECO_PESSOA E " +
            "WHERE E.COMPLEMENTO IS NULL", nativeQuery = true)
    List<EnderecoEntity> searchByWithoutComplemento();
}
