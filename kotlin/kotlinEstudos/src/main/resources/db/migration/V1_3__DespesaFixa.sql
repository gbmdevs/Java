CREATE TABLE DESP_FIXA(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    usuario_id VARCHAR(36) NOT NULL,
    tip_desp_fixa_id VARCHAR(36) NOT NULL,
    CONSTRAINT fk_usu_desp_fix_id FOREIGN KEY(usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_tip_desp_fixa_id FOREIGN KEY(tip_desp_fixa_id) REFERENCES tip_desp_fixa(id)
);
