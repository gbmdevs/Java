CREATE TABLE TYPE_FIXED_EXPENSE(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    usuario_id VARCHAR(36) NOT NULL,
    tipo SERIAL,
    tipo_desc VARCHAR(36) DEFAULT NULL,
    is_fixed BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_usuario_id FOREIGN KEY(usuario_id) REFERENCES usuario(id),
    CONSTRAINT usuario_tipo_unique UNIQUE (usuario_id, tipo)
);
