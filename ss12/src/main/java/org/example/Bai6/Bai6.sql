drop database Hospital_db;
create database Hospital_db;
use Hospital_db;
create table  medicines (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    price DECIMAL(10,2),
    stock INT
);
create table prescriptions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    medicine_id INT,
    quantity_sold INT,
    sale_date DATE,
    FOREIGN KEY (medicine_id) REFERENCES medicines(id)
);
INSERT INTO medicines(name, price, stock) VALUES
('Paracetamol', 5000, 100),
('Aspirin', 7000, 50),
('Vitamin C', 3000, 200);

INSERT INTO prescriptions(medicine_id, quantity_sold, sale_date) VALUES
(1, 2, '2026-03-23'),
(2, 1, '2026-03-23'),
(3, 5, '2026-03-22');
DELIMITER $$
CREATE PROCEDURE CalculatePrescriptionTotal(
    IN p_id INT,
    OUT p_total DECIMAL(18,2)
)
BEGIN
    SELECT m.price * p.quantity_sold
    INTO p_total
    FROM prescriptions p
    JOIN medicines m ON p.medicine_id = m.id
    WHERE p.id = p_id;
END$$
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE GetDailyRevenue(
    IN p_date DATE,
    OUT p_revenue DECIMAL(18,2)
)
BEGIN
    SELECT SUM(m.price * p.quantity_sold)
    INTO p_revenue
    FROM prescriptions p
    JOIN medicines m ON p.medicine_id = m.id
    WHERE p.sale_date = p_date;
END$$
DELIMITER ;