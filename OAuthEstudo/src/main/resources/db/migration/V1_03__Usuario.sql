CREATE TABLE hibernate_sequences(
	sequence_name varchar(255) NOT NULL,
	sequence_next_hi_value bigint NOT NULL
);



CREATE TABLE perfil_permissoes(
   perfil_id bigint NOT NULL,   
   permissoes_id bigint NOT NULL,
   CONSTRAINT perfilpermissao_perm_fkey FOREIGN KEY (permissoes_id) REFERENCES permissao (id),
   CONSTRAINT perfilpermissao_perfil_fkey FOREIGN KEY (perfil_id) REFERENCES perfil (id)
);

CREATE TABLE usuario (
    id bigint NOT NULL,
    login VARCHAR(20) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    senha VARCHAR(20) NOT NULL,        
    perfil_id  bigint NOT NULL,
    CONSTRAINT usuario_perfil_fkey FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);

INSERT INTO usuario values(1,'teste','Guilherme Gois Braga de Medeiros','teste',1);


CREATE TABLE segurancaapi (
     id bigint NOT NULL
);