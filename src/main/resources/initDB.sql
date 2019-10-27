DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    login VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    balance DECIMAL NOT NULL
);
CREATE UNIQUE INDEX users_unique_login_idx ON users (login);