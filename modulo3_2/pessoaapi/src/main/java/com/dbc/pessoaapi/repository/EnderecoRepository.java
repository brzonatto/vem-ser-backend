package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            "WHERE UPPER(E.PAIS) LIKE UPPER(:pais) OR UPPER(E.CIDADE) LIKE UPPER(:cidade)", nativeQuery = true)
    List<EnderecoEntity> searchByCidadeOrPais(String cidade, String pais);

    @Query(value = "SELECT * " +
            "FROM ENDERECO_PESSOA E " +
            "WHERE E.COMPLEMENTO IS NULL", nativeQuery = true)
    List<EnderecoEntity> searchByWithoutComplemento();

    @Query(value = "select e from ENDERECO_PESSOA e where upper(e.pais) like upper(?1)")
    Page<EnderecoEntity> findByPais(String pais, Pageable pageable);
}
