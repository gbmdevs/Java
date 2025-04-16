CREATE TABLE STOCK_USER_OPER(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    usuario_id VARCHAR(36) NOT NULL,
    stock_id VARCHAR(36) NOT NULL,
    oper_buy_qt INTEGER NOT NULL,
    oper_sell_qt INTEGER DEFAULT 0,
    oper_buy_price NUMERIC(10,2) DEFAULT 0,
    oper_sell_price NUMERIC(10,2) DEFAULT 0,
    oper_buy_date DATE NOT NULL,
    oper_sell_date DATE DEFAULT NULL,
    oper_buy_total NUMERIC(10,2) DEFAULT 0,
    oper_sell_total NUMERIC(10,2) DEFAULT 0,
    oper_situation CHAR(1) DEFAULT 'A',
    CONSTRAINT fk_usuario_oper_id FOREIGN KEY(usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_stock_oper_id FOREIGN KEY(stock_id) REFERENCES stock(id)
);


