CREATE TABLE type_balance(
   id VARCHAR(36) NOT NULL PRIMARY KEY,
   name VARCHAR(20) NOT NULL,   
   situation VARCHAR(1) default 'N'
);

INSERT INTO type_balance VALUES('e192b12d-e9ca-447a-97f5-c98bd2c09c45','Banco ITI Itau','S');
INSERT INTO type_balance VALUES('d4aaf6bb-5996-42c3-ade2-d2908131f480','Banco Inter','N');