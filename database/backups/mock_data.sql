-- Inserisci dati nella tabella User
INSERT INTO User (user_name, user_password, user_email, user_phone) VALUES
('Alice', 'password1', 'alice@example.com', '1234567890'),
('Bob', 'password2', 'bob@example.com', '2345678901'),
('Charlie', 'password3', 'charlie@example.com', '3456789012'),
('David', 'password4', 'david@example.com', '4567890123'),
('Eve', 'password5', 'eve@example.com', '5678901234'),
('Frank', 'password6', 'frank@example.com', '6789012345'),
('Grace', 'password7', 'grace@example.com', '7890123456'),
('Hank', 'password8', 'hank@example.com', '8901234567'),
('Ivy', 'password9', 'ivy@example.com', '9012345678'),
('Jack', 'password10', 'jack@example.com', '0123456789');

-- Popola la tabella Payment_method
INSERT INTO Payment_method (user_id, is_default, card_number, card_expiry_date, card_secret_code) VALUES
(1, true, '4111111111111111', '12/26', 123),
(2, true, '4222222222222222', '11/25', 456),
(3, true, '4333333333333333', '10/24', 789),
(4, true, '4444444444444444', '09/27', 321),
(5, true, '4555555555555555', '08/26', 654),
(6, true, '4666666666666666', '07/25', 987),
(7, true, '4777777777777777', '06/28', 111),
(8, true, '4888888888888888', '05/29', 222),
(9, true, '4999999999999999', '04/30', 333),
(10, true, '4000000000000000', '03/27', 444);

-- Inserisci dati nella tabella Admin
INSERT INTO Admin (admin_cf, admin_name, admin_surname, admin_email, admin_password) VALUES
('CFADMIN001', 'Laura', 'Rossi', 'laura.rossi.admin@example.com', 'adminpass1'),
('CFADMIN002', 'Marco', 'Bianchi', 'marco.bianchi.admin@example.com', 'adminpass2'),
('CFADMIN003', 'Sophia', 'Verdi', 'sophia.verdi.admin@example.com', 'adminpass3'),
('CFADMIN004', 'Luca', 'Neri', 'luca.neri.admin@example.com', 'adminpass4'),
('CFADMIN005', 'Anna', 'Gialli', 'anna.gialli.admin@example.com', 'adminpass5'),
('CFADMIN006', 'Giorgio', 'Blu', 'giorgio.blu.admin@example.com', 'adminpass6'),
('CFADMIN007', 'Chiara', 'Viola', 'chiara.viola.admin@example.com', 'adminpass7'),
('CFADMIN008', 'Enrico', 'Grigi', 'enrico.grigi.admin@example.com', 'adminpass8'),
('CFADMIN009', 'Paola', 'Rosa', 'paola.rosa.admin@example.com', 'adminpass9'),
('CFADMIN010', 'Giovanni', 'Marroni', 'giovanni.marroni.admin@example.com', 'adminpass10');

-- Inserisci dati nella tabella Staff (senza staff_role)
INSERT INTO Staff (staff_cf, staff_name, staff_surname, staff_email, staff_password, staff_salary, type_contract) VALUES
('CFSTAFF001', 'Tom', 'Smith', 'tom.smith.staff@example.com', 'staffpass1', 2000.50, 'Full-time'),
('CFSTAFF002', 'Jerry', 'Brown', 'jerry.brown.staff@example.com', 'staffpass2', 1800.00, 'Part-time'),
('CFSTAFF003', 'Lucy', 'Johnson', 'lucy.johnson.staff@example.com', 'staffpass3', 2200.75, 'Full-time'),
('CFSTAFF004', 'Mia', 'Davis', 'mia.davis.staff@example.com', 'staffpass4', 1900.00, 'Part-time'),
('CFSTAFF005', 'John', 'Miller', 'john.miller.staff@example.com', 'staffpass5', 2100.00, 'Full-time'),
('CFSTAFF006', 'Daisy', 'Wilson', 'daisy.wilson.staff@example.com', 'staffpass6', 1700.25, 'Stage'),
('CFSTAFF007', 'Liam', 'Moore', 'liam.moore.staff@example.com', 'staffpass7', 2500.00, 'Full-time'),
('CFSTAFF008', 'Sophia', 'Taylor', 'sophia.taylor.staff@example.com', 'staffpass8', 1800.75, 'Part-time'),
('CFSTAFF009', 'Olivia', 'Anderson', 'olivia.anderson.staff@example.com', 'staffpass9', 2300.00, 'Full-time'),
('CFSTAFF010', 'Emma', 'Thomas', 'emma.thomas.staff@example.com', 'staffpass10', 2400.50, 'Full-time');

-- Inserisci dati nella tabella Message
INSERT INTO Message (message_title, message_object, message_content, send_date) VALUES
('Welcome', 'Greetings', 'Welcome to our platform', '2024-01-01'),
('Update', 'Notice', 'System will be down for maintenance', '2024-01-02'),
('Reminder', 'Event', 'Don’t forget to attend the meeting', '2024-01-03'),
('Alert', 'Warning', 'Unusual activity detected', '2024-01-04'),
('Survey', 'Feedback', 'Please complete our survey', '2024-01-05'),
('Offer', 'Promotion', 'Special discount for this week', '2024-01-06'),
('Notice', 'Policy', 'Updated terms and conditions', '2024-01-07'),
('News', 'Announcement', 'New feature released', '2024-01-08'),
('Thank You', 'Appreciation', 'Thank you for your support', '2024-01-09'),
('Event', 'Invitation', 'Join us for the upcoming webinar', '2024-01-10');

-- Inserisci dati nella tabella Arts
INSERT INTO Arts (art_name, art_desc, art_artist, art_length, art_height, art_image) VALUES
('Starry Night', 'Impressionismo', 'Vincent van Gogh', '73.7 cm', '92.1 cm', 'https://example.com/starry_night.jpg'),
('Mona Lisa', 'Rinascimento', 'Leonardo da Vinci', '77 cm', '53 cm', 'https://example.com/mona_lisa.jpg'),
('The Persistence of Memory', 'Surrealismo', 'Salvador Dalí', '24 cm', '33 cm', 'https://example.com/persistence_of_memory.jpg'),
('The Scream', 'Espressionismo', 'Edvard Munch', '91 cm', '73.5 cm', 'https://example.com/the_scream.jpg'),
('Girl with a Pearl Earring', 'Rinascimento olandese', 'Johannes Vermeer', '44.5 cm', '39 cm', 'https://example.com/girl_with_pearl_earring.jpg'),
('Guernica', 'Cubismo', 'Pablo Picasso', '349 cm', '776 cm', 'https://example.com/guernica.jpg'),
('The Kiss', 'Simbolismo', 'Gustav Klimt', '180 cm', '180 cm', 'https://example.com/the_kiss.jpg'),
('American Gothic', 'Regionalismo', 'Grant Wood', '78 cm', '65.3 cm', 'https://example.com/american_gothic.jpg'),
('Nighthawks', 'Realismo americano', 'Edward Hopper', '84.1 cm', '152.4 cm', 'https://example.com/nighthawks.jpg'),
('The Birth of Venus', 'Rinascimento', 'Sandro Botticelli', '172.5 cm', '278.9 cm', 'https://example.com/birth_of_venus.jpg'),
('Las Meninas', 'Barocco', 'Diego Velázquez', '318 cm', '276 cm', 'https://example.com/las_meninas.jpg');

-- Inserimento di 15 entry nella tabella Events
INSERT INTO Events (start_date, end_date, n_seats, n_seats_available, event_desc, event_name) VALUES 
  ('2025-01-01', '2025-01-15', 100, 50, 'Mostra di arte moderna', 'Arte Moderna 1'),
  ('2025-01-05', '2025-01-20', 120, 60, 'Esposizione di fotografie', 'Fotografia 2'),
  ('2025-01-10', '2025-01-25', 150, 70, 'Collezione di dipinti rinascimentali', 'Rinascimento 3'),
  ('2025-02-01', '2025-02-10', 80, 40, 'Sculture contemporanee', 'Scultura 4'),
  ('2025-02-15', '2025-03-01', 200, 120, 'Arte astratta e sperimentale', 'Astratto 5'),
  ('2025-03-05', '2025-03-20', 90, 45, 'Mostra di street art', 'Street Art 6'),
  ('2025-03-25', '2025-04-05', 110, 55, 'Esposizione storica', 'Storico 7'),
  ('2025-04-10', '2025-04-20', 130, 65, 'Fotografie naturalistiche', 'Natura 8'),
  ('2025-04-25', '2025-05-10', 180, 90, 'Esposizione di design', 'Design 9'),
  ('2025-05-15', '2025-05-30', 170, 85, 'Arte concettuale', 'Concettuale 10'),
  ('2025-06-01', '2025-06-15', 100, 50, 'Collezione di arte giapponese', 'Giapponese 11'),
  ('2025-06-20', '2025-07-05', 120, 60, 'Mostra di arte antica', 'Antico 12'),
  ('2025-07-10', '2025-07-25', 150, 75, 'Esposizione di arte futurista', 'Futurismo 13'),
  ('2025-08-01', '2025-08-15', 80, 40, 'Mostra di calligrafia', 'Calligrafia 14'),
  ('2025-08-20', '2025-09-01', 200, 100, 'Esposizione d\'arte digitale', 'Digitale 15');

-- Inserimento di 15 entry nella tabella Tickets
INSERT INTO Tickets (ticket_type, ticket_price, event_id) VALUES 
  ('Adult', 15.00, 1),
  ('Child', 10.00, 2),
  ('Student', 12.50, 3),
  ('Senior', 13.00, 4),
  ('Group', 50.00, 5),
  ('Adult', 16.00, 6),
  ('Child', 8.50, 7),
  ('Student', 11.50, 8),
  ('Senior', 14.00, 9),
  ('Group', 45.00, 10),
  ('Adult', 18.00, 11),
  ('Child', 9.00, 12),
  ('Student', 13.50, 13),
  ('Senior', 12.00, 14),
  ('Group', 55.00, 15);

INSERT INTO Purchases (purchase_date, ticket_id, event_id, user_id) VALUES 
('2025-01-15', 1, 1, 1),
('2025-01-18', 2, 1, 2),
('2025-01-20', 3, 2, 3),
('2025-01-22', 4, 3, 4),
('2025-01-23', 5, 3, 5),
('2025-01-24', 6, 4, 6),
('2025-01-25', 7, 5, 7),
('2025-01-26', 8, 6, 8),
('2025-01-28', 9, 7, 9),
('2025-01-30', 10, 8, 10);
