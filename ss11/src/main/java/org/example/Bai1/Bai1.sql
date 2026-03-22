create database hospital_db;
use hospital_db;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50)
);
INSERT INTO users(name, email) VALUES
('An', 'an@gmail.com'),
('Binh', 'binh@gmail.com'),
('Cuong', 'cuong@gmail.com');