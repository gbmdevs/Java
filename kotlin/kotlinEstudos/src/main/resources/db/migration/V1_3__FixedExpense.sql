CREATE TABLE FIXED_EXPENSE(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    type_fixed_id VARCHAR(36) NOT NULL,
    due_date DATE DEFAULT NULL,
    CONSTRAINT fk_TYPE_FIXED_EXPENSE_id FOREIGN KEY(type_fixed_id) REFERENCES TYPE_FIXED_EXPENSE(id),
    CONSTRAINT fk_fixed_expense_unique UNIQUE (id, type_fixed_id, due_date)
);