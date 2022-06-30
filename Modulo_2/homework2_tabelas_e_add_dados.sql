/*
    Clebson Mendonça Machado da Silva
    Observações: preferi não criar os sequenc para mapear os id.
    Então para cada id eu adicionei manualmente (ficou melhor de visualizar o que eu estava fazendo)
*/

/* ######### CRIANDO AS TABELAS ######### */

-- Criar tabela país

CREATE TABLE PAIS (
                ID_PAIS NUMBER NOT NULL,
                NOME VARCHAR2(50) NOT NULL,
                PRIMARY KEY (ID_PAIS)
);

-- Criar tabela estado
CREATE TABLE ESTADO (
                ID_ESTADO NUMBER(38) NOT NULL,
                NOME VARCHAR2(50) NOT NULL,
                ID_PAIS NUMBER NOT NULL,
                PRIMARY KEY (ID_ESTADO),
                CONSTRAINT FK_PAIS FOREIGN KEY(ID_PAIS) REFERENCES PAIS (ID_PAIS)
);

-- Criar tabela cidade
CREATE TABLE CIDADE (
                ID_CIDADE NUMBER(38) NOT NULL,
                ID_ESTADO NUMBER(38) NOT NULL,
                NOME VARCHAR2(50) NOT NULL,
                PRIMARY KEY (ID_CIDADE, ID_ESTADO),
                CONSTRAINT FK_ESTADO FOREIGN KEY(ID_ESTADO) REFERENCES ESTADO(ID_ESTADO)
);

-- Criar tabela bairro
CREATE TABLE BAIRRO (
                ID_BAIRRO NUMBER(38) NOT NULL,
                ID_CIDADE NUMBER(38) NOT NULL,
                ID_ESTADO NUMBER(38) NOT NULL,
                NOME VARCHAR2(50) NOT NULL,
                PRIMARY KEY (ID_BAIRRO, ID_CIDADE),
                CONSTRAINT FK_BAIRRO_CIDADE FOREIGN KEY (ID_CIDADE, ID_ESTADO) REFERENCES CIDADE (ID_CIDADE, ID_ESTADO)
);

-- Criar tabela endereço
CREATE TABLE Endereco (
                ID_ENDERECO NUMBER(38) NOT NULL,
                ID_BAIRRO NUMBER(38) NOT NULL,
                ID_CIDADE NUMBER(38) NOT NULL,
                LOGRADOURO VARCHAR2(255) NOT NULL,
                NUMERO VARCHAR2(38) NOT NULL,
                COMPLEMENTO VARCHAR2(100),
                CEP CHAR(9),
                PRIMARY KEY (ID_ENDERECO),
                CONSTRAINT FK_ENDERECO_BAIRRO FOREIGN KEY (ID_BAIRRO, ID_CIDADE) REFERENCES BAIRRO (ID_BAIRRO, ID_CIDADE)        
);

/* ######### POPULANDO O BANCO ######### */


-- Add paises
INSERT INTO VEM_SER.PAIS(id_pais, nome)VALUES(10001, 'Brasil');
INSERT INTO VEM_SER.PAIS(id_pais, nome)VALUES(10002, 'China');

-- add estados no país Brasil
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES(22, 10001, 'Maranhão');
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES(23, 10001, 'Tocantins');

-- add estados no país China
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES(32, 10002, 'Macau');
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES(33, 10002, 'Hainan');

-- obs: como é chave dupla, então as cidades podem ter a mesma chave id_cidade, 
-- desde que a chave de estado seja diferente. São Luis e Tebete possuem as
-- mesmas id_cidade, mas estados diferentes
-- Acaba criando uma certa confusão mental, mas é bom para praticar

-- add cidades nos estados do BRASIL 
INSERT INTO VEM_SER.CIDADE (id_cidade, ID_ESTADO, nome) VALUES(2111201, 22, 'São Luis');
INSERT INTO VEM_SER.CIDADE (id_cidade, ID_ESTADO, nome) VALUES(2111202, 22, 'Bacabal');
INSERT INTO VEM_SER.CIDADE (id_cidade, ID_ESTADO, nome) VALUES(2111203, 23, 'Palmas');
INSERT INTO VEM_SER.CIDADE (id_cidade, ID_ESTADO, nome) VALUES(2111204, 23, 'Araguaia');

-- add cidades nos estados da CHINA
INSERT INTO VEM_SER.CIDADE (id_cidade, ID_ESTADO, nome) VALUES(2111201, 32, 'Tebete');
INSERT INTO VEM_SER.CIDADE (id_cidade, ID_ESTADO, nome) VALUES(2111202, 32, 'Xangai');
INSERT INTO VEM_SER.CIDADE (id_cidade, ID_ESTADO, nome) VALUES(2111203, 33, 'Pequim');
INSERT INTO VEM_SER.CIDADE (id_cidade, ID_ESTADO, nome) VALUES(2111204, 33, 'Wuhan');

-- add 2 bairros nos estados BRASILEIROS 
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(1, 2111201, 22, 'Cohama');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(2, 2111201, 22, 'Renascença');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(3, 2111202, 22, 'Centro');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(4, 2111202, 22, 'Alama');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(5, 2111203, 23, 'Blue');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(6, 2111203, 23, 'Anil');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(7, 2111204, 23, 'Turu');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(8, 2111204, 23, 'Alemanha');

-- add 2 bairros nos estados CHINESES 
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(9, 2111201, 32, 'Modelo');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(10, 2111201, 32, 'Morada Feliz');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(11, 2111202, 32, 'Morro do Sesi');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(12, 2111202, 32, 'Vila Oásis');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(13, 2111203, 33, 'Lago belo');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(14, 2111203, 33, 'Tabajara');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(15, 2111204, 33, 'Santa Rosa');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES(16, 2111204, 33, 'Planeta');

-- adicionar 2 endereços em cada bairro
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(1, 1, 2111201, 'Rua ', 22, '', '6541300' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(2, 1, 2111201, 'Rua 2', 55, '', '6541400' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(3, 2, 2111201, 'Rua 5', 77, '', '6511300' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(4, 2, 2111201, 'Rua 3', 55, '', '6541411' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(5, 3, 2111202, 'Universitário', 721, '', '79070-210' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(6, 3, 2111202, 'Rio Maina', 379, '', '88817-450' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(7, 4, 2111202, 'Cidade Industrial', 806, '', '81350-120' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(8, 4, 2111202, 'Santa Maria da Codipe', 343, '', '64013-605' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(9, 5, 2111203, 'Ilha da Figueira', 158, '', '89258-220' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(10, 5, 2111203, 'Rio Maina', 379, '', '88817-450' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(11, 6, 2111203, 'Rua Desembargador Enock ', 395, '', '49082-160' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(12, 6, 2111203, 'Plano Diretor Norte', 768, '', '77001-676' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(13, 7, 2111204, 'Pedra 90', 561, '', '78099-275' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(14, 7, 2111204, 'Vila Eulália', 379, '', '56331-230' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(15, 8, 2111204, 'Senador Teotônio Vilela', 529, '', '57311-556' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(16, 8, 2111204, 'Imbiribeira', 708, '', '51180-390' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(17, 9, 2111201, 'Valentina de Figueiredo', 561974, '', '58064-245' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(18, 9, 2111201, 'Plano Diretor Sul', 259, '', '77015-263' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(19, 10, 2111201, 'Ikaray', 103, '', '78130-396' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(20, 10, 2111201, 'Lagoinha', 142, '', '76829-814' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(21, 11, 2111202, 'Rua Carolina', 760, '', '65911-393' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(22, 11, 2111202, 'Rua Salgueiro', 139, '', '69911-325' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(23, 12, 2111202, 'Quadra 709 Sul Avenida LO 19', 309, '', '77017-130' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(24, 12, 2111202, 'Beco André Jobim', 806, '', '69067-043' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(25, 13, 2111203, 'Rua Cloves Marques de Carvalho', 407, '', '59625-235' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(26, 13, 2111203, 'Rua João Cipreste Filho', 676, '', '29102-584' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(27, 14, 2111203, 'Travessa Maria Tereza', 625, '', '69905-211' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(28, 14, 2111203, 'Rua Hitler Lucena', 806, '', '69313-560' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(29, 15, 2111204, 'Rua Raphael de Oliveira Alves', 385, '', '50790-320' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(30, 15, 2111204, 'Rua OP-XXXI', 463, '', '69316-318' );

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(31, 16, 2111204, 'Jardim Marco Zero', 414, '', '68903-372' );
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, NUMERO, complemento, cep)
values(32, 16, 2111204, 'Quadra Quadra 301 Conjunto 10', 466, '', '72620-210' );