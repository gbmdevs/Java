CREATE TABLE stocks_user_operations(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    stocks_id VARCHAR(36) NOT NULL,
    date_operate_buy DATE DEFAULT NULL,
    date_Operate_Sell DATE DEFAULT NULL,
    stock_value_buy decimal DEFAULT 0,
    stock_value_sell decimal DEFAULT 0,
    qtd_stocks_buy Integer DEFAULT 0,
    QtdStocksSell Integer DEFAULT 0,
    valueBuy decimal DEFAULT 0,
    valueSell decimal DEFAULT 0,
    situationOperation VARCHAR(1) DEFAULT NULL,
    CONSTRAINT fk_stocks FOREIGN KEY(stocks_id) REFERENCES stocks(id)
);


INSERT INTO stocks_user_operations values('f7e2055f-fa79-4c2f-b173-bff576dd03ed',select id from stocks where ticket = 'VALE3','2023-05-26',NULL,66.50,NULL,6,NULL,399,NULL,'A');
INSERT INTO stocks_user_operations values('d3c0173f-40c8-4302-ae22-7513e8caad58',select id from stocks where ticket = 'TAEE4','2023-07-20',NULL,12.03,NULL,25,NULL,300.75,NULL,'A');