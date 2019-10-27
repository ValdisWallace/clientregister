DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (login, password, balance) VALUES
  ('user321', 'pass123', 200.05),
  ('admin', 'admin', 999.89);
