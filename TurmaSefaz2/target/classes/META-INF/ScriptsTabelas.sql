-- Scripts para criação do projeto --

CREATE TABLE usuarioEmail (
	email VARCHAR(100) NOT NULL,
	nome VARCHAR(100) NOT NULL,
  senha VARCHAR(100) NOT NULL,
 	PRIMARY KEY (email) 
);

CREATE TABLE veiculo (
	marca VARCHAR(100) NOT NULL,
	modelo VARCHAR(100) NOT NULL,
  ano VARCHAR(100) NOT NULL,
  id_peca VARCHAR(100) NOT NULL,
  PRIMARY KEY (marca) 
);

CREATE TABLE peca (
 id INT NOT NULL,	
tipo VARCHAR(100) NOT NULL,
  tamanho NUMBER NOT NULL,
  desgaste   VARCHAR(100) NOT NULL,
	PRIMARY KEY (id) 
);

ALTER TABLE veiculo
ADD FOREIGN KEY (id_peca) 
REFERENCES peca(id);

//falta alterar a parte de baixo

CREATE SEQUENCE S_JOGO 
	MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 ;

	
insert into PLATAFORMA (nome, descricao) values ('PS4', 'Playstation 4'); 
insert into PLATAFORMA (nome, descricao) values ('XBOX', 'XBOX'); 
insert into PLATAFORMA (nome, descricao) values ('XBOX ONE', 'XBOX ONE'); 
insert into PLATAFORMA (nome, descricao) values ('PC', 'Computador PC'); 	