CREATE TABLE stocks_user_operations(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    stocks_id VARCHAR(36) NOT NULL,
    type_balance_id VARCHAR(36) NOT NULL,
    date_operate_buy DATE DEFAULT NULL,
    date_Operate_Sell DATE DEFAULT NULL,
    stock_value_buy decimal DEFAULT 0,
    stock_value_sell decimal DEFAULT 0,
    qtd_stocks_buy Integer DEFAULT 0,
    QtdStocksSell Integer DEFAULT 0,
    valueBuy decimal DEFAULT 0,
    valueSell decimal DEFAULT 0,
    situationOperation VARCHAR(1) DEFAULT NULL,
    CONSTRAINT fk_stocks FOREIGN KEY(stocks_id) REFERENCES stocks(id),
    CONSTRAINT fk_type_balance FOREIGN KEY(type_balance_id) REFERENCES type_balance(id)
);


INSERT INTO stocks_user_operations values('f7e2055f-fa79-4c2f-b173-bff576dd03ed',select id from stocks where ticket = 'VALE3','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-05-26',NULL,66.50,NULL,6,NULL,399,NULL,'A');
INSERT INTO stocks_user_operations values('d3c0173f-40c8-4302-ae22-7513e8caad58',select id from stocks where ticket = 'TAEE4','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-07-20',NULL,12.03,NULL,25,NULL,300.75,NULL,'A');
INSERT INTO stocks_user_operations values('dc946d1c-6f50-432c-b508-a1ee2c752bb8',select id from stocks where ticket = 'MXRF11','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-09-05',NULL,NULL,NULL,201,NULL,NULL,NULL,'I');
INSERT INTO stocks_user_operations values('98af887f-e8e7-4e68-800c-97d0987eb36a',select id from stocks where ticket = 'HASH11','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-09-13',NULL,NULL,NULL,77,NULL,NULL,NULL,'I');
INSERT INTO stocks_user_operations values('e8eb546b-12e7-4d5a-80bd-42e9ef91c633',select id from stocks where ticket = 'BBSE3','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-09-13',NULL,NULL,NULL,16,NULL,NULL,NULL,'R');