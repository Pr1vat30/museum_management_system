drop database if exists DbMuseum;
create database if not exists DbMuseum;
use DbMuseum;

# CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
# GRANT ALL PRIVILEGES ON DbMuseum.* TO 'user'@'localhost';

CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL, 
    user_password VARCHAR(255) NOT NULL,     
    user_email VARCHAR(100) NOT NULL UNIQUE, 
    user_phone VARCHAR(100) NOT NULL 
);

CREATE TABLE Admin (
	admin_id INT AUTO_INCREMENT PRIMARY KEY,
    
    admin_cf VARCHAR(16) NOT NULL UNIQUE, 
    admin_name VARCHAR(50) NOT NULL,
    admin_surname VARCHAR(50) NOT NULL,       
    admin_email VARCHAR(100) NOT NULL UNIQUE, 
    admin_password VARCHAR(255) NOT NULL,    
    admin_phone VARCHAR(15),

    admin_salary DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    
    staff_name VARCHAR(50) NOT NULL,          
    staff_surname VARCHAR(50) NOT NULL,       
    staff_email VARCHAR(100) NOT NULL UNIQUE,
	staff_password VARCHAR(255) NOT NULL,   
	staff_phone VARCHAR(15),              
    staff_salary DECIMAL(10, 2) NOT NULL,
    
    type_contract ENUM('Full-time', 'Part-time', 'Stagista') NOT NULL,
    staff_role ENUM('Guida', 'Custode', 'Tecnico', 'Receptionist') NOT NULL,
    hiring_date DATE,                
    weekly_hours INT,     
    supervisor_cf CHAR(16),  
    FOREIGN KEY (supervisor_cf) REFERENCES Admin(admin_cf)
);

select * from User