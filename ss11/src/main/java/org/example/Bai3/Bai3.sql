create database bed_db;
use bed_db;
CREATE TABLE Beds (
    bed_id INT PRIMARY KEY,
    bed_status VARCHAR(50)
);
INSERT INTO Beds VALUES
(1, 'Available'),
(2, 'Unavailable');