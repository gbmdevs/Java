CREATE TABLE segurancaapi (
     id VARCHAR(36) NOT NULL,     
     usuario_id VARCHAR(36) NOT NULL,     
     CONSTRAINT segurancaapi_usuario_fkey FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);