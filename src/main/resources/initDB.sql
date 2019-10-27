DROP TABLE IF EXISTS clients;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE clients
(
    id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    login VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    balance DECIMAL NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON clients (login);