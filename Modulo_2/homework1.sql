/*Comandos da aula*/

/*
 Criar uma tabela ESTUDANTE com os campos:
	id: numérico e chave primária
	nome: texto até 200 caracteres não nulo
	data_nascimento: Data não nulo
	nr_matricula: numérico de 10 não nulo, único (UK)
	ativo: caracter (‘S’ = ativo, ‘N’ = não ativo) 
*/

-- Criando tabela Estudante

CREATE TABLE VEM_SER.ESTUDANTE(
	id NUMBER NOT NULL,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) UNIQUE NOT NULL,
	ativo CHAR(1),
	PRIMARY KEY(id)
);

-- Criar uma sequence para essa tabela (seq_estudante)

CREATE SEQUENCE seq_estudante 
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

-- INCREMENT PARA MATRICULA (SÓ PARA APRENDIZADO)

CREATE SEQUENCE seq_matricula
START WITH 10000
INCREMENT BY 1
NOCACHE NOCYCLE;


-- Inserir 10 registros para essa tabela;

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
	VALUES(seq_estudante.nextval, 'Gabrielly', TO_DATE('07/02/1993', 'dd-mm-yyyy'), seq_matricula.nextval, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
	VALUES(seq_estudante.nextval, 'Cauê Leandro', TO_DATE('14/03/1997', 'dd-mm-yyyy'), seq_matricula.nextval, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
	VALUES(seq_estudante.nextval, 'Heloisa', TO_DATE('27/02/1996', 'dd-mm-yyyy'), seq_matricula.nextval, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
	VALUES(seq_estudante.nextval, 'Manoel ', TO_DATE('18/01/1993', 'dd-mm-yyyy'), seq_matricula.nextval, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
	VALUES(seq_estudante.nextval, 'Leandro Ryan', TO_DATE('11/01/1999', 'dd-mm-yyyy'), seq_matricula.nextval, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
	VALUES(seq_estudante.nextval, 'Esther Marcela', TO_DATE('07/05/1996', 'dd-mm-yyyy'), seq_matricula.nextval, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
	VALUES(seq_estudante.nextval, 'Davi Noah', TO_DATE('16/02/1998', 'dd-mm-yyyy'), seq_matricula.nextval, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
	VALUES(seq_estudante.nextval, 'Raquel Alice', TO_DATE('22/04/1997', 'dd-mm-yyyy'), seq_matricula.nextval, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
	VALUES(seq_estudante.nextval, 'Tânia Andreia', TO_DATE('18/03/1954', 'dd-mm-yyyy'), seq_matricula.nextval, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
	VALUES(seq_estudante.nextval, 'Jennifer Larissa', TO_DATE('23/03/1956', 'dd-mm-yyyy'), seq_matricula.nextval, 'N');

-- Selecionar os registros

SELECT * FROM VEM_SER.ESTUDANTE; 

-- Selecionar os registros (com parâmetros - testes)

SELECT e.ID, e.NOME , e.NR_MATRICULA  FROM VEM_SER.ESTUDANTE e;



