/*
    HOMERWORK DOIS DE ORACLE
*/

-- Selecionar todos os países ordenados pro nome decrescente
SELECT * FROM VEM_SER.PAIS p 
ORDER BY p.NOME DESC;

-- Selecionar logradouro e cep dos endereços. Porém, somente os logradouros que comecem com a letra 'a' (maiúsculo ou minúsculo);
SELECT e.LOGRADOURO , e.CEP  FROM VEM_SER.ENDERECO e 
WHERE UPPER(e.LOGRADOURO ) LIKE  'A%';

-- Selecionar todos os endereços que tenham cep com final ‘0’;
SELECT * FROM VEM_SER.ENDERECO e 
WHERE e.CEP LIKE '%0';

-- Selecionar todos os endereços que tenham números entre 1 e 100;
SELECT * FROM VEM_SER.ENDERECO e 
WHERE e.NUMERO BETWEEN 0 AND 100;

-- Selecionar todos os endereços que comecem por “RUA” e ordenar pelo cep de forma decrescente ;
SELECT * FROM VEM_SER.ENDERECO e 
WHERE UPPER(e.LOGRADOURO) LIKE 'RUA%'
ORDER BY e.CEP DESC ;

-- Selecionar a quantidade de endereços cadastrados na tabela;
SELECT COUNT(*) AS Qtd_Enderecos FROM VEM_SER.ENDERECO e ;

-- Selecionar a quantidade de endereços cadastrados agrupados pelo id da cidade;
SELECT e.ID_CIDADE  AS ID_CIDADE, COUNT(*) AS Qtd_Enderecos FROM VEM_SER.ENDERECO e GROUP BY e.ID_CIDADE  ;


/*
    Clarear: uma cidade pode ter o mesmo id_cidade com estado diferente ou id_cidade iguais com
    estados diferentes. 
*/