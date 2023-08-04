CREATE TABLE stocks_data(
    id VARCHAR(36) NOT NULL,
    stocks_id VARCHAR(36) NOT NULL,
    date_close DATE NOT NULL,
    CONSTRAINT fk_stocks_data FOREIGN KEY(stocks_id) REFERENCES stocks(id),
    PRIMARY KEY(stocks_id,date_close)
);
