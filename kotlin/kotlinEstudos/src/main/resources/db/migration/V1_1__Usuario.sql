CREATE TABLE Usuario (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    username VARCHAR(60),
    email VARCHAR(25),
    password VARCHAR(60),
    token VARCHAR(140)
);
