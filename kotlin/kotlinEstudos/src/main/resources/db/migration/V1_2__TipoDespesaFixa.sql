CREATE TABLE TYPE_FIXED_EXPENSE(
    id VARCHAR(36) NOT NULL,
    usuario_id VARCHAR(36) NOT NULL,
    type_desc VARCHAR(36) DEFAULT NULL,
    is_fixed BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id),
    CONSTRAINT fk_usuario_id FOREIGN KEY(usuario_id) REFERENCES usuario(id),
    CONSTRAINT usuario_tipo_unique UNIQUE (usuario_id, id)
);
