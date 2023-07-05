CREATE TABLE stocks(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    ticket VARCHAR(10) NOT NULL UNIQUE,
    region VARCHAR(02) NOT NULL,
    name VARCHAR(50) NOT NULL,
    isActive VARCHAR(1) DEFAULT 'N'
);

INSERT INTO stocks values('64f0f5fe-f7f1-40c1-a977-b697c7abff2a','BBAS3','SA','Banco do Brasil S.A','S');
INSERT INTO stocks values('8ea3e3c5-b419-469d-a9b3-5e46abdc97dc','ITSA4','SA','Itausa','S');
INSERT INTO stocks values('a4533fe5-70dc-45f6-99d0-87e663b743f8','USIM5','SA','Usiminas','S');