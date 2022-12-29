CREATE TABLE perfil(
    id bigint NOT NULL,
    nome VARCHAR(20) NOT NULL,
    descricao VARCHAR(20) NOT NULL,    
    CONSTRAINT perfil_pkey PRIMARY KEY (id)
);

INSERT INTO perfil values(1,'Administrador','administrador');