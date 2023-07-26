CREATE TABLE stocks_type(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    type VARCHAR(10) NOT NULL,
    description VARCHAR(50)
);

INSERT INTO stocks_type values('e2f78b05-6345-4d00-a3f7-7aa04faeb1d2','STOCK','Ação da bolsa de valores');
INSERT INTO stocks_type values('943740d8-4ece-44cb-bd4b-1e7ab94831e6','FII','Fundos Imobiliarios');
INSERT INTO stocks_type values('24db537f-f973-429f-ae84-0cb2d589f928','BDRS','Papeis Estrangeiros listados no Brasil');
