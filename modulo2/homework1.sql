CREATE TABLE VEM_SER.ESTUDANTE (
    id_pessoa NUMBER NOT NULL,
    nome VARCHAR2(200) NOT NULL,
    data_nascimento DATE NOT NULL,
    nr_matricula NUMBER(10) UNIQUE NOT NULL,    
    ativo CHAR(1) NOT NULL,
    PRIMARY KEY(id_pessoa)
);

CREATE SEQUENCE VEM_SER.seq_estudante
	START WITH 1
	INCREMENT BY 1
	NOCACHE
	NOCYCLE;

INSERT INTO VEM_SER.ESTUDANTE e 
(e.ID_PESSOA, e.NOME, e.DATA_NASCIMENTO, e.NR_MATRICULA, e.ATIVO)
VALUES 
(VEM_SER.seq_estudante.nextval, 'Brunno Zonatto', TO_DATE('30-06-1992', 'dd-mm-yyyy'), 3129881343, 's');

INSERT INTO VEM_SER.ESTUDANTE e 
(e.ID_PESSOA, e.NOME, e.DATA_NASCIMENTO, e.NR_MATRICULA, e.ATIVO)
VALUES 
(VEM_SER.seq_estudante.nextval, 'Caroline Marinho', TO_DATE('11-11-1995', 'dd-mm-yyyy'), 3199851473, 's');

INSERT INTO VEM_SER.ESTUDANTE e 
(e.ID_PESSOA, e.NOME, e.DATA_NASCIMENTO, e.NR_MATRICULA, e.ATIVO)
VALUES 
(VEM_SER.seq_estudante.nextval, 'Renata Zonatto', TO_DATE('13-10-1983', 'dd-mm-yyyy'), 4135151167, 's');

INSERT INTO VEM_SER.ESTUDANTE e 
(e.ID_PESSOA, e.NOME, e.DATA_NASCIMENTO, e.NR_MATRICULA, e.ATIVO)
VALUES 
(VEM_SER.seq_estudante.nextval, 'Zenira Zonatto', TO_DATE('20-09-1961', 'dd-mm-yyyy'), 1994477233, 's');

INSERT INTO VEM_SER.ESTUDANTE e 
(e.ID_PESSOA, e.NOME, e.DATA_NASCIMENTO, e.NR_MATRICULA, e.ATIVO)
VALUES 
(VEM_SER.seq_estudante.nextval, 'Maicon Gerardi', TO_DATE('22-06-1942', 'dd-mm-yyyy'), 2126970496, 'n');

INSERT INTO VEM_SER.ESTUDANTE e 
(e.ID_PESSOA, e.NOME, e.DATA_NASCIMENTO, e.NR_MATRICULA, e.ATIVO)
VALUES 
(VEM_SER.seq_estudante.nextval, 'Jo�o Assis', TO_DATE('30-06-1972', 'dd-mm-yyyy'), 1985593230, 's');

INSERT INTO VEM_SER.ESTUDANTE e 
(VEM_SER.e.ID_PESSOA, e.NOME, e.DATA_NASCIMENTO, e.NR_MATRICULA, e.ATIVO)
VALUES 
(VEM_SER.seq_estudante.nextval, 'Rafael Rosa', TO_DATE('29-06-1985', 'dd-mm-yyyy'), 5525892539, 'n');

INSERT INTO VEM_SER.ESTUDANTE e 
(e.ID_PESSOA, e.NOME, e.DATA_NASCIMENTO, e.NR_MATRICULA, e.ATIVO)
VALUES 
(VEM_SER.seq_estudante.nextval, 'Lucas Cardoso', TO_DATE('25-12-1999', 'dd-mm-yyyy'), 5599450094, 's');

INSERT INTO VEM_SER.ESTUDANTE e 
(e.ID_PESSOA, e.NOME, e.DATA_NASCIMENTO, e.NR_MATRICULA, e.ATIVO)
VALUES 
(VEM_SER.seq_estudante.nextval, 'Jair Donato', TO_DATE('20-10-2000', 'dd-mm-yyyy'), 9529614735, 'n');

INSERT INTO VEM_SER.ESTUDANTE e 
(e.ID_PESSOA, e.NOME, e.DATA_NASCIMENTO, e.NR_MATRICULA, e.ATIVO)
VALUES 
(VEM_SER.seq_estudante.nextval, 'Pericles da Silva', TO_DATE('10-06-1992', 'dd-mm-yyyy'), 9598308594, 's');

SELECT * FROM VEM_SER.ESTUDANTE;