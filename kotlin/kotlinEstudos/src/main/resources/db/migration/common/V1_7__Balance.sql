CREATE TABLE BALANCE(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    usuario_id VARCHAR(36) NOT NULL,
    type NUMERIC NOT NULL,
    value_consume NUMERIC(10,2) DEFAULT 0,
    date_consume TIMESTAMP DEFAULT NULL,
    description VARCHAR(50) NOT NULL,
    CONSTRAINT fk_usuario_balance_id FOREIGN KEY(usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_type_balance_id FOREIGN KEY(type) REFERENCES type_balance(type)
);


