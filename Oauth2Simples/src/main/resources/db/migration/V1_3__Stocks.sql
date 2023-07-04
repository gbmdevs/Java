CREATE TABLE stocks(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    ticket VARCHAR(10) NOT NULL,
    name VARCHAR(50) NOT NULL,
    isActive VARCHAR(1) DEFAULT 'N'
);

INSERT INTO stocks values('95879c62-06d9-11ee-be56-0242ac120002','BBAS3','Banco do Brasil S.A','S');