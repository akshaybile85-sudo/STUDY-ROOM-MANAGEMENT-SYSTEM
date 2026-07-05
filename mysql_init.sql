ALTER USER 'root'@'localhost' IDENTIFIED BY 'password';
CREATE USER IF NOT EXISTS 'postgres'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'postgres'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
