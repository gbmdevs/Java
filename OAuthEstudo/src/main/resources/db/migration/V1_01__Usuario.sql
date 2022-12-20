CREATE TABLE hibernate_sequences(
	sequence_name varchar(255) NOT NULL,
	sequence_next_hi_value bigint NOT NULL
);

CREATE TABLE permissao(
    id bigint NOT NULL,
    dataatualizacao timestamp,
    datacriacao timestamp,
    descricao varchar(255)
);

CREATE TABLE perfil(
    id bigint NOT NULL
);

CREATE TABLE usuario (
    id bigint NOT NULL,
    login VARCHAR(20) NOT NULL,
    senha VARCHAR(20) NOT NULL
);


CREATE TABLE segurancaapi (
     id bigint NOT NULL
);