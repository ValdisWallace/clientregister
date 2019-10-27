DELETE FROM clients;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO clients (login, password, balance) VALUES
  ('user123', 'pass123', 200.05),
  ('admin', 'admin', 999.89);
