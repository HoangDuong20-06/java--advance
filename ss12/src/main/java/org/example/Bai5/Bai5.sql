drop database RHMS;
create database RHMS;
use RHMS;
create table Patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    department VARCHAR(100),
    disease VARCHAR(255),
    admission_date DATE
);
INSERT INTO Patients (name, age, department, disease, admission_date) VALUES
('Nguyen Van A', 25, 'ICU', 'Sot cao', '2026-03-20'),
('Tran Thi B', 30, 'Noi khoa', 'Viem phoi', '2026-03-18'),
('Le Van C', 40, 'Ngoai khoa', 'Gay chan', '2026-03-15'),
('Pham Thi D', 22, 'ICU', 'Suy ho hap', '2026-03-21');
DELIMITER $$
CREATE PROCEDURE CALCULATE_DISCHARGE_FEE(
    IN p_id INT,
    OUT total_fee DOUBLE
)
BEGIN
    DECLARE days INT;
    SELECT DATEDIFF(CURDATE(), admission_date)
    INTO days
    FROM Patients
    WHERE id = p_id;
    SET total_fee = days * 100;
END $$
DELIMITER ;