INSERT INTO customer(id, name, email) VALUES (1, 'John Doe', 'john.doe@example.com');
INSERT INTO customer(id, name, email) VALUES (2, 'Jane Smith', 'jane.smith@example.com');

ALTER SEQUENCE customer_id_seq RESTART WITH 3;
