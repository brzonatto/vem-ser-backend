package com.dbc.pessoaapi.entity.pk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProfessorPK implements Serializable {
    @Column(name = "id_professor")
    private Integer idProfessor;

    @Column(name = "id_universidade")
    private Integer idUniversidade;
}
