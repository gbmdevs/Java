CREATE TABLE stocks(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    stocks_type_id VARCHAR(36) NOT NULL,
    ticket VARCHAR(10) NOT NULL UNIQUE,
    region VARCHAR(02) NOT NULL,
    name VARCHAR(50) NOT NULL,
    isActive VARCHAR(1) DEFAULT 'N',
    CONSTRAINT fk_stocks_types FOREIGN KEY(stocks_type_id) REFERENCES stocks_type(id)
);

INSERT INTO stocks values('64f0f5fe-f7f1-40c1-a977-b697c7abff2a','e2f78b05-6345-4d00-a3f7-7aa04faeb1d2','BBAS3','SA','Banco do Brasil S.A','S');
INSERT INTO stocks values('8ea3e3c5-b419-469d-a9b3-5e46abdc97dc','e2f78b05-6345-4d00-a3f7-7aa04faeb1d2','ITSA4','SA','Itausa S.A','S');
INSERT INTO stocks values('a4533fe5-70dc-45f6-99d0-87e663b743f8','e2f78b05-6345-4d00-a3f7-7aa04faeb1d2','USIM5','SA','Usiminas','S');
INSERT INTO stocks values('fd520d1b-23dc-427d-8632-b23f11fa47f5','e2f78b05-6345-4d00-a3f7-7aa04faeb1d2','TAEE4','SA','Taesa','S');
INSERT INTO stocks values('80581280-5815-41fb-8c8d-03ddee00ee51','e2f78b05-6345-4d00-a3f7-7aa04faeb1d2','VALE3','SA','Vale SA','S'); 
INSERT INTO stocks values('f8c0e808-42aa-4bc4-8b42-e5941139cf1c','943740d8-4ece-44cb-bd4b-1e7ab94831e6','MXRF11','SA','Fundo imobiliario MXFR11','S'); 
INSERT INTO stocks values('d017b5e6-2d65-4503-8f98-51073a21ec36','3f4a334b-103f-4289-99de-91fb3e818ed6','HASH11','SA','Hash Index','S'); 
INSERT INTO stocks values('25d554be-f700-437b-8711-bd71fb4b0d2a','e2f78b05-6345-4d00-a3f7-7aa04faeb1d2','BBSE3','SA','BB Seguridade','S');