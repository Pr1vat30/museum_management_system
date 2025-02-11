drop database if exists DbMuseum;
create database if not exists DbMuseum;
use DbMuseum;

# CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
# GRANT ALL PRIVILEGES ON DbMuseum.* TO 'user'@'localhost';
# GRANT SUPER ON *.* TO 'user'@'localhost';

CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL, 
    user_password VARCHAR(255) NOT NULL,     
    user_email VARCHAR(100) NOT NULL UNIQUE,
    user_phone VARCHAR(100) NOT NULL
);
DELIMITER //
CREATE TRIGGER validate_user_name
    BEFORE INSERT ON User
    FOR EACH ROW
BEGIN
    -- Verifica formato e lunghezza
    IF LENGTH(NEW.user_name) < 3 OR NEW.user_name NOT REGEXP '^[a-zA-Z]+(?: [a-zA-Z]+)?$' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Il nome utente deve essere maggiore di 3 caratteri e contenere solo lettere';
    END IF;
END;
//
DELIMITER ;
DELIMITER //
CREATE TRIGGER validate_email
    BEFORE INSERT ON User
    FOR EACH ROW
BEGIN
    IF NEW.user_email NOT REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Formato email non valido';
    END IF;
END;
//
DELIMITER ;
DELIMITER //

CREATE TRIGGER validate_password
    BEFORE INSERT ON User
    FOR EACH ROW
BEGIN
    -- Verifica che la stringa sia lunga almeno 6 caratteri
    IF NEW.user_password NOT REGEXP '.{6,}' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'La stringa deve contenere almeno 6 caratteri';
    END IF;

    -- Verifica che ci sia almeno un numero
    IF NEW.user_password NOT REGEXP '[0-9]' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'La stringa deve contenere almeno un numero';
    END IF;

    -- Verifica che ci sia almeno un carattere speciale
    IF NEW.user_password NOT REGEXP '[[:punct:]]' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'La stringa deve contenere almeno un carattere speciale';
    END IF;
END;
//
DELIMITER ;
DELIMITER //
CREATE TRIGGER validate_user_phone
    BEFORE INSERT ON User
    FOR EACH ROW
BEGIN
    IF NEW.user_phone NOT REGEXP '^([+]?[0-9]{1,4}[-. ]?)?([(]?[0-9]{1,3}[)]?[-. ]?)?([0-9]{1,4}[-. ]?){1,3}[0-9]{1,9}$' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Formato numero di telefono non valido';
    END IF;
END;
//
DELIMITER ;

CREATE TABLE Payment_method (
  payment_id int not null auto_increment,
  user_id int not null,
  is_default boolean default true,
  card_number VARCHAR(50) not null,
  card_expiry_date VARCHAR(50) not null,
  card_secret_code int not null,
  primary key (payment_id),
  foreign key (user_id) references user(user_id)
);
DELIMITER //
CREATE TRIGGER validate_card_number
    BEFORE INSERT ON Payment_method
    FOR EACH ROW
BEGIN
    IF LENGTH(NEW.card_number) != 16 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Formato numero carta non valido';
    END IF;
END;
//
DELIMITER ;
DELIMITER //
CREATE TRIGGER validate_card_expiry_date
    BEFORE INSERT ON Payment_method
    FOR EACH ROW
BEGIN
    IF NEW.card_expiry_date NOT REGEXP '^[0-9]{2}/[0-9]{2}$' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Formato data scadenza carta non valido';
    END IF;
END;
//
DELIMITER ;
DELIMITER //
CREATE TRIGGER validate_card_secret_code
    BEFORE INSERT ON Payment_method
    FOR EACH ROW
BEGIN
    IF NEW.card_secret_code NOT REGEXP '^[0-9]{3}$' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Formato secret code non valido';
    END IF;
END;
//
DELIMITER ;

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
  art_desc VARCHAR(200) NOT NULL,
  art_artist VARCHAR(50) NOT NULL, 
  art_length VARCHAR(50) NOT NULL, 
  art_height VARCHAR(50) NOT NULL,
  art_image VARCHAR(100) NOT NULL
);

CREATE TABLE Events (
  event_id INT AUTO_INCREMENT PRIMARY KEY,
  start_date DATETIME NOT NULL,
  end_date DATETIME NOT NULL,
  n_seats INT NOT NULL,
  n_seats_available INT DEFAULT 0 CHECK (n_seats_available >= 0),
  event_desc VARCHAR(1000) NOT NULL,
  event_name VARCHAR(20) NOT NULL
);

CREATE TABLE Tickets (
  ticket_id INT AUTO_INCREMENT PRIMARY KEY,
  ticket_type VARCHAR(50) NOT NULL, 
  ticket_price DECIMAL(10, 2) NOT NULL,
  event_id INT NOT NULL,
  FOREIGN KEY (event_id) REFERENCES Events (event_id) ON DELETE CASCADE
);

CREATE TABLE Purchases (
    purchase_id INT AUTO_INCREMENT PRIMARY KEY,
    purchase_date DATETIME NOT NULL,
    ticket_id INT NOT NULL,
    event_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (ticket_id) REFERENCES Tickets (ticket_id) ON DELETE CASCADE,
    FOREIGN KEY (event_id) REFERENCES Events (event_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES User (user_id) ON DELETE CASCADE
);



CREATE VIEW TicketEventView AS
SELECT 
  Tickets.ticket_id,
  Tickets.ticket_type,
  Tickets.ticket_price,
  Events.event_id,
  Events.event_name,
  Events.start_date,
  Events.end_date,
  Events.n_seats,
  Events.n_seats_available,
  Events.event_desc
FROM 
  Tickets
INNER JOIN 
  Events ON Tickets.event_id = Events.event_id;



CREATE VIEW TicketEventPurchaseView AS
SELECT 
  Tickets.ticket_id,
  Tickets.ticket_type,
  Tickets.ticket_price,
  Events.event_id,
  Events.event_name,
  Events.start_date,
  Events.end_date,
  Events.n_seats,
  Events.n_seats_available,
  Events.event_desc,
  Purchases.purchase_id,
  Purchases.purchase_date,
  Purchases.user_id
FROM 
  Tickets
INNER JOIN 
  Events ON Tickets.event_id = Events.event_id
INNER JOIN
  Purchases ON Purchases.ticket_id = Tickets.ticket_id AND Purchases.event_id = Events.event_id;



DELIMITER //

CREATE TRIGGER DecreaseSeatsAvailable
AFTER INSERT ON Purchases
FOR EACH ROW
BEGIN
  UPDATE Events 
  SET n_seats_available = n_seats_available - 1
  WHERE event_id = NEW.event_id;
END //

DELIMITER ;


