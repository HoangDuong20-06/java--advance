create database appointments_db;
use appointments_db;
CREATE TABLE appointments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    patient_name VARCHAR(255) NOT NULL,
    appointment_date DATE NOT NULL,
    doctor_name VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL
);
INSERT INTO appointments (patient_name, appointment_date, doctor_name, status)
VALUES 
('Nguyen Van A', '2026-03-25', 'Dr. Minh', 'Pending'),
('Tran Thi B', '2026-03-26', 'Dr. Hoa', 'Completed'),
('Le Van C', '2026-03-27', 'Dr. Minh', 'Cancelled');
