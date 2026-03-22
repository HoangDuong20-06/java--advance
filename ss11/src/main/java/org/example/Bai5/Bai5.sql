SET SQL_SAFE_UPDATES = 0;
DROP DATABASE doctors_db;
create database doctors_db;
use doctors_db;
CREATE TABLE doctors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialty VARCHAR(100)
);
INSERT INTO doctors (name,specialty) VALUES
('Hoang Duong','Phau thuat'),
('Huy Hoang','Nhi'),
('Huong Lan','Dieu duong');

SET SQL_SAFE_UPDATES = 1;