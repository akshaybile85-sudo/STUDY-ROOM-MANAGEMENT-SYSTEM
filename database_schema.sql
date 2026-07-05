CREATE DATABASE IF NOT EXISTS student;
USE student;

CREATE TABLE IF NOT EXISTS registeredstudent (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    mobile_no VARCHAR(20),
    email VARCHAR(255),
    parentmob VARCHAR(20),
    college VARCHAR(255),
    edu VARCHAR(255),
    slot VARCHAR(50)
);
