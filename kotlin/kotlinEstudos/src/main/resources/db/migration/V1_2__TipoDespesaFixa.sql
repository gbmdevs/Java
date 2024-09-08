CREATE TABLE TIP_DESP_FIXA(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    usuario_id VARCHAR(36) NOT NULL,
    tipo INTEGER NOT NULL,
    tipo_desc VARCHAR(36) DEFAULT NULL,
    CONSTRAINT fk_usuario_id FOREIGN KEY(usuario_id) REFERENCES usuario(id),
    CONSTRAINT usuario_tipo_unique UNIQUE (usuario_id, tipo)
);
