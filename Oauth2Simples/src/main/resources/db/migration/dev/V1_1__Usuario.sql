CREATE TABLE Usuario (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    username VARCHAR(60),
    email VARCHAR(25),
    password VARCHAR(25),
    token VARCHAR(140)
);

insert into usuario values('6630f0bf-055e-45e7-90a0-055f032ceea9','Emaloka','guih.smi2@gmail.com',NULL,NULL);