Create database pharmacy_db;
use pharmacy_db;
CREATE TABLE pharmacy (
    id INT AUTO_INCREMENT PRIMARY KEY,
    medicine_name VARCHAR(50),
    stock INT
);
INSERT INTO pharmacy(medicine_name, stock) VALUES
('Panadol', 3),
('Aspirin', 5),
('Paracetamol', 10);