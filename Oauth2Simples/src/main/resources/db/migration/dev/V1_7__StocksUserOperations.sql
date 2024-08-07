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
    sit_operation VARCHAR(1) DEFAULT NULL,
    CONSTRAINT fk_stocks FOREIGN KEY(stocks_id) REFERENCES stocks(id),
    CONSTRAINT fk_type_balance FOREIGN KEY(type_balance_id) REFERENCES type_balance(id)
);


--INSERT INTO stocks_user_operations values('f7e2055f-fa79-4c2f-b173-bff576dd03ed',select id from stocks where ticket = 'VALE3','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-05-26',NULL,66.50,NULL,6,NULL,399,NULL,'A');
--INSERT INTO stocks_user_operations values('d3c0173f-40c8-4302-ae22-7513e8caad58',select id from stocks where ticket = 'TAEE4','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-07-20',NULL,12.03,NULL,25,NULL,300.75,NULL,'A');
--INSERT INTO stocks_user_operations values('dc946d1c-6f50-432c-b508-a1ee2c752bb8',select id from stocks where ticket = 'MXRF11','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-09-05',NULL,NULL,NULL,201,NULL,NULL,NULL,'I');
--INSERT INTO stocks_user_operations values('98af887f-e8e7-4e68-800c-97d0987eb36a',select id from stocks where ticket = 'HASH11','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-09-13',NULL,NULL,NULL,77,NULL,NULL,NULL,'I');
--INSERT INTO stocks_user_operations values('e8eb546b-12e7-4d5a-80bd-42e9ef91c633',select id from stocks where ticket = 'BBSE3','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-09-13',NULL,NULL,NULL,16,NULL,NULL,NULL,'R');
--INSERT INTO stocks_user_operations values('38065e60-af24-4298-b6e0-4b9fc94c77a2',select id from stocks where ticket = 'VIVT3','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-09-24',NULL,NULL,NULL,7,NULL,NULL,NULL,'R');
--INSERT INTO stocks_user_operations values('ab2ca7d4-8fc2-4f2c-9fa7-b04bb0429b5e',select id from stocks where ticket = 'BBAS3','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-09-24',NULL,NULL,NULL,12,NULL,NULL,NULL,'R');
--INSERT INTO stocks_user_operations values('b6c046d5-ade2-44ac-8a38-6d18801871a5',select id from stocks where ticket = 'CMIG3','1b41e479-b407-4f3c-a69a-de788ef2de90','2023-10-20',NULL,16.10,NULL,22,NULL,354.20,NULL,'A');
INSERT INTO stocks_user_operations values('2a550729-e337-43cc-9c3f-5dfcd2382a4f',select id from stocks where ticket = 'VALE3','1b41e479-b407-4f3c-a69a-de788ef2de90','2024-08-05',NULL,57.10,NULL,11,NULL,628.10,NULL,'A');
INSERT INTO stocks_user_operations values('0753652e-0f71-4263-8aff-e37b940e6f28',select id from stocks where ticket = 'HASH11','1b41e479-b407-4f3c-a69a-de788ef2de90','2024-08-05',NULL,45.50,NULL,10,NULL,455,NULL,'A');