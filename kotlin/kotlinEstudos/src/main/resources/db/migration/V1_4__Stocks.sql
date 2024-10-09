CREATE TABLE STOCK(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    stock_ticket VARCHAR(12) NOT NULL,
    stock_desc VARCHAR(36) DEFAULT NULL,
    stock_loc VARCHAR(10) NOT NULL,
    is_active BOOLEAN DEFAULT true
);


