CREATE TABLE perfil(
    id VARCHAR(36) NOT NULL,
    nome VARCHAR(20) NOT NULL,
    descricao VARCHAR(20) NOT NULL,    
    CONSTRAINT perfil_pkey PRIMARY KEY (id)
);

INSERT INTO perfil values('806e3829-8942-4488-8cbf-686f19bed22f','Administrador','administrador');