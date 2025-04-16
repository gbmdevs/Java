CREATE TABLE Usuario (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    email VARCHAR(25) UNIQUE,
    password VARCHAR(60),
    token VARCHAR(140),
    username VARCHAR(60)
);
