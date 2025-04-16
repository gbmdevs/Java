CREATE TABLE STOCK_DATA_HIST(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    stock_id VARCHAR(36) NOT NULL,
    stock_date DATE NOT NULL,
    stock_open NUMERIC(10,2) DEFAULT 0,
    stock_close NUMERIC(10,2) DEFAULT 0,
    stock_high NUMERIC(10,2) DEFAULT 0,
    stock_low NUMERIC(10,2) DEFAULT 0,
    CONSTRAINT fk_stock_id FOREIGN KEY(stock_id) REFERENCES stock(id),
    CONSTRAINT stock_date_unique UNIQUE (stock_id, stock_date)
);


