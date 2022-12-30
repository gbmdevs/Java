CREATE TABLE hibernate_sequences(
	sequence_name varchar(255) NOT NULL,
	sequence_next_hi_value bigint NOT NULL
);



CREATE TABLE perfil_permissoes(
   perfil_id VARCHAR(36) NOT NULL,   
   permissoes_id VARCHAR(36) NOT NULL,
   CONSTRAINT perfilpermissao_perm_fkey FOREIGN KEY (permissoes_id) REFERENCES permissao (id),
   CONSTRAINT perfilpermissao_perfil_fkey FOREIGN KEY (perfil_id) REFERENCES perfil (id)
);

CREATE TABLE usuario (
    id VARCHAR(36) NOT NULL,
    login VARCHAR(20) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    senha VARCHAR(40) NOT NULL,        
    perfil_id  VARCHAR(36) NOT NULL,
    CONSTRAINT usuario_perfil_fkey FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);

INSERT INTO usuario values('d6dbec62-8782-11ed-a1eb-0242ac120002','teste','Guilherme Gois Braga de Medeiros','698dc19d489c4e4db73e28a713eab07b','806e3829-8942-4488-8cbf-686f19bed22f');


CREATE TABLE segurancaapi (
     id bigint NOT NULL
);