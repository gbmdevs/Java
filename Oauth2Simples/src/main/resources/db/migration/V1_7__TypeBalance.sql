CREATE TABLE type_balance(
   id VARCHAR(36) NOT NULL PRIMARY KEY,
   name VARCHAR(20) NOT NULL,   
   situation VARCHAR(1) default 'N',
   type_company VARCHAR(10) default NULL
);

INSERT INTO type_balance VALUES('e192b12d-e9ca-447a-97f5-c98bd2c09c45','Banco ITI Itau','S','BANK');
INSERT INTO type_balance VALUES('d4aaf6bb-5996-42c3-ade2-d2908131f480','Banco Inter','S','BANK');
INSERT INTO type_balance VALUES('1b41e479-b407-4f3c-a69a-de788ef2de90','Rico Corretora','S','BROKER');
INSERT INTO type_balance VALUES('43df77f6-8be6-42f0-82a2-ade5ad9109ee','XP S.A Corretora','N','BROKER');