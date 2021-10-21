SELECT *
FROM PESSOA P
RIGHT OUTER JOIN CONTATO C ON (P.ID_PESSOA = C.ID_PESSOA);

SELECT *
FROM PESSOA P
RIGHT OUTER JOIN PESSOA_X_PESSOA_ENDERECO PPE ON (P.ID_PESSOA = PPE.ID_PESSOA)
RIGHT OUTER JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PPE.ID_ENDERECO);

SELECT *
FROM PESSOA P
RIGHT OUTER JOIN CONTATO C ON (C.ID_PESSOA = P.ID_PESSOA)
RIGHT OUTER JOIN PESSOA_X_PESSOA_ENDERECO PPE ON (PPE.ID_PESSOA = P.ID_PESSOA)
RIGHT OUTER JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PPE.ID_ENDERECO);

SELECT *
FROM PESSOA P
FULL OUTER JOIN CONTATO C ON (P.ID_PESSOA = C.ID_PESSOA);

SELECT *
FROM PESSOA P
FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO PPE ON (P.ID_PESSOA = PPE.ID_PESSOA)
FULL OUTER JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PPE.ID_ENDERECO);

SELECT *
FROM PESSOA P
FULL OUTER JOIN CONTATO C ON (C.ID_PESSOA = P.ID_PESSOA)
FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO PPE ON (PPE.ID_PESSOA = P.ID_PESSOA)
FULL OUTER JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PPE.ID_ENDERECO);

SELECT * FROM PESSOA P
  WHERE EXISTS (
  	SELECT *
  	 FROM PESSOA_X_PESSOA_ENDERECO PPE
  	 WHERE P.ID_PESSOA = PPE.ID_PESSOA  	 
  );
  
 SELECT P.ID_PESSOA, P.NOME FROM PESSOA P
 UNION
 SELECT EP.ID_ENDERECO, EP.LOGRADOURO FROM ENDERECO_PESSOA EP;