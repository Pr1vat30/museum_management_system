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
    admin_password VARCHAR(255) NOT NULL 
);

CREATE TABLE Staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    staff_cf VARCHAR(16) NOT NULL UNIQUE, 
    staff_name VARCHAR(50) NOT NULL,          
    staff_surname VARCHAR(50) NOT NULL,       
    staff_email VARCHAR(100) NOT NULL UNIQUE,
	staff_password VARCHAR(255) NOT NULL,   
    staff_salary DECIMAL(10, 2) NOT NULL,
    type_contract ENUM('Full-time', 'Part-time', 'Stage') NOT NULL
);

CREATE TABLE Message (
	message_id INT AUTO_INCREMENT PRIMARY KEY,
    message_title VARCHAR(50) NOT NULL, 
    message_object VARCHAR(50) NOT NULL,
    message_content VARCHAR(50) NOT NULL,       
    send_date DATE NOT NULL
);

CREATE TABLE Arts (
  art_id INT AUTO_INCREMENT PRIMARY KEY,
  art_name VARCHAR(50) NOT NULL, 
  art_desc VARCHAR(50) NOT NULL, 
  art_artist VARCHAR(50) NOT NULL, 
  art_length VARCHAR(50) NOT NULL, 
  art_height VARCHAR(50) NOT NULL,
  art_image VARCHAR(100) NOT NULL
);

CREATE TABLE Events (
  event_id INT AUTO_INCREMENT PRIMARY KEY,
  start_date datetime NOT NULL,
  end_date datetime NOT NULL,
  n_seats int NOT NULL,
  n_seats_available int DEFAULT '0',
  event_desc varchar(1000) NOT NULL,
  event_name varchar(20) NOT NULL
);

CREATE TABLE Tickets (
  ticket_id INT AUTO_INCREMENT PRIMARY KEY,
  ticket_type VARCHAR(50) NOT NULL, 
  ticket_price DECIMAL(10, 2) NOT NULL,
  event_id INT NOT NULL,
  FOREIGN KEY (event_id) REFERENCES Events (event_id) ON DELETE CASCADE
);	



