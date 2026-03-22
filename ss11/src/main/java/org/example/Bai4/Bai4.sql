create database service_db;
use service_db;
CREATE TABLE Patients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100)
);
INSERT INTO Patients (full_name) VALUES
('Nguyen Van A'),
('Tran Thi B');