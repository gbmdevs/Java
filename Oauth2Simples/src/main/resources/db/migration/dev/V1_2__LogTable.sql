CREATE TABLE log_details (
    id Integer NOT NULL PRIMARY KEY,
    create_date_time TIMESTAMP NOT NULL,
    action varchar(20),
    value1 varchar(50) DEFAULT NULL
);