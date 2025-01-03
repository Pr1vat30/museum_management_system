-- Populating User Table
INSERT INTO User (user_name, user_password, user_email, user_phone) VALUES
('user1', 'password1', 'user1@example.com', '1234567890'),
('user2', 'password2', 'user2@example.com', '1234567891'),
('user3', 'password3', 'user3@example.com', '1234567892'),
('user4', 'password4', 'user4@example.com', '1234567893'),
('user5', 'password5', 'user5@example.com', '1234567894'),
('user6', 'password6', 'user6@example.com', '1234567895'),
('user7', 'password7', 'user7@example.com', '1234567896'),
('user8', 'password8', 'user8@example.com', '1234567897'),
('user9', 'password9', 'user9@example.com', '1234567898'),
('user10', 'password10', 'user10@example.com', '1234567899'),
('user11', 'password11', 'user11@example.com', '1234567890'),
('user12', 'password12', 'user12@example.com', '1234567891'),
('user13', 'password13', 'user13@example.com', '1234567892'),
('user14', 'password14', 'user14@example.com', '1234567893'),
('user15', 'password15', 'user15@example.com', '1234567894'),
('user16', 'password16', 'user16@example.com', '1234567895'),
('user17', 'password17', 'user17@example.com', '1234567896'),
('user18', 'password18', 'user18@example.com', '1234567897'),
('user19', 'password19', 'user19@example.com', '1234567898'),
('user20', 'password20', 'user20@example.com', '1234567899');

-- Populating Admin Table
INSERT INTO Admin (admin_cf, admin_name, admin_surname, admin_email, admin_password, admin_phone, admin_salary) VALUES
('CF12345678901', 'Mario', 'Rossi', 'admin1@example.com', 'password1', '0987654321', 4500.50),
('CF12345678902', 'Luca', 'Bianchi', 'admin2@example.com', 'password2', '0987654322', 4000.00),
('CF12345678903', 'Giulia', 'Verdi', 'admin3@example.com', 'password3', '0987654323', 4700.20),
('CF12345678904', 'Anna', 'Gialli', 'admin4@example.com', 'password4', '0987654324', 4200.75),
('CF12345678905', 'Marco', 'Neri', 'admin5@example.com', 'password5', '0987654325', 4300.00),
('CF12345678906', 'Elena', 'Bianchi', 'admin6@example.com', 'password6', '0987654326', 4600.25),
('CF12345678907', 'Francesco', 'Rossi', 'admin7@example.com', 'password7', '0987654327', 4000.90),
('CF12345678908', 'Sara', 'Marroni', 'admin8@example.com', 'password8', '0987654328', 4500.30),
('CF12345678909', 'Lorenzo', 'Blu', 'admin9@example.com', 'password9', '0987654329', 4200.00),
('CF12345678910', 'Marta', 'Rosa', 'admin10@example.com', 'password10', '0987654330', 4800.80),
('CF12345678911', 'Fabio', 'Azzurri', 'admin11@example.com', 'password11', '0987654331', 4700.10),
('CF12345678912', 'Clara', 'Arancioni', 'admin12@example.com', 'password12', '0987654332', 4100.50),
('CF12345678913', 'Simone', 'Verdi', 'admin13@example.com', 'password13', '0987654333', 4900.00),
('CF12345678914', 'Valeria', 'Rossi', 'admin14@example.com', 'password14', '0987654334', 4300.25),
('CF12345678915', 'Paolo', 'Viola', 'admin15@example.com', 'password15', '0987654335', 4600.70),
('CF12345678916', 'Chiara', 'Rossi', 'admin16@example.com', 'password16', '0987654336', 4400.90),
('CF12345678917', 'Alessandro', 'Gialli', 'admin17@example.com', 'password17', '0987654337', 4200.00),
('CF12345678918', 'Beatrice', 'Bianchi', 'admin18@example.com', 'password18', '0987654338', 4500.30),
('CF12345678919', 'Stefano', 'Rossi', 'admin19@example.com', 'password19', '0987654339', 4100.00),
('CF12345678920', 'Giorgia', 'Neri', 'admin20@example.com', 'password20', '0987654340', 4700.50);

INSERT INTO Staff (staff_name, staff_surname, staff_email, staff_password, staff_phone, staff_salary, type_contract, staff_role, hiring_date, weekly_hours, supervisor_cf) VALUES
('Andrea', 'Grigi', 'staff1@example.com', 'password1', '1234567801', 3000.50, 'Full-time', 'Guida', '2020-05-12', 40, 'CF12345678901'),
('Laura', 'Blu', 'staff2@example.com', 'password2', '1234567802', 2900.00, 'Part-time', 'Receptionist', '2021-07-15', 25, 'CF12345678902'),
('Emanuele', 'Verdi', 'staff3@example.com', 'password3', '1234567803', 3200.20, 'Full-time', 'Custode', '2019-02-11', 40, 'CF12345678903'),
('Federica', 'Rossi', 'staff4@example.com', 'password4', '1234567804', 3100.00, 'Part-time', 'Tecnico', '2022-03-18', 30, 'CF12345678904'),
('Matteo', 'Bianchi', 'staff5@example.com', 'password5', '1234567805', 2800.75, 'Stagista', 'Tecnico', '2023-06-01', 20, 'CF12345678905'),
('Chiara', 'Gialli', 'staff6@example.com', 'password6', '1234567806', 3500.60, 'Full-time', 'Receptionist', '2018-09-25', 40, 'CF12345678906'),
('Davide', 'Neri', 'staff7@example.com', 'password7', '1234567807', 3300.40, 'Full-time', 'Guida', '2021-01-05', 40, 'CF12345678907'),
('Sara', 'Viola', 'staff8@example.com', 'password8', '1234567808', 2700.00, 'Part-time', 'Custode', '2020-12-10', 20, 'CF12345678908'),
('Simone', 'Azzurri', 'staff9@example.com', 'password9', '1234567809', 3200.00, 'Full-time', 'Tecnico', '2019-07-22', 35, 'CF12345678909'),
('Valentina', 'Marroni', 'staff10@example.com', 'password10', '1234567810', 3100.25, 'Part-time', 'Receptionist', '2020-10-01', 30, 'CF12345678910'),
('Alessandro', 'Rossi', 'staff11@example.com', 'password11', '1234567811', 3400.50, 'Full-time', 'Guida', '2022-05-16', 40, 'CF12345678911'),
('Martina', 'Blu', 'staff12@example.com', 'password12', '1234567812', 2800.80, 'Stagista', 'Guida', '2023-04-12', 15, 'CF12345678912'),
('Francesca', 'Verdi', 'staff13@example.com', 'password13', '1234567813', 3500.30, 'Full-time', 'Custode', '2018-08-30', 40, 'CF12345678913'),
('Luca', 'Arancioni', 'staff14@example.com', 'password14', '1234567814', 2900.10, 'Part-time', 'Tecnico', '2021-11-23', 25, 'CF12345678914'),
('Sofia', 'Gialli', 'staff15@example.com', 'password15', '1234567815', 3300.70, 'Full-time', 'Receptionist', '2019-06-15', 40, 'CF12345678915'),
('Giorgio', 'Neri', 'staff16@example.com', 'password16', '1234567816', 2800.90, 'Part-time', 'Custode', '2022-07-20', 30, 'CF12345678916'),
('Beatrice', 'Viola', 'staff17@example.com', 'password17', '1234567817', 2700.50, 'Stagista', 'Guida', '2023-02-01', 20, 'CF12345678917'),
('Riccardo', 'Bianchi', 'staff18@example.com', 'password18', '1234567818', 3600.00, 'Full-time', 'Guida', '2020-03-10', 40, 'CF12345678918'),
('Elisa', 'Rosa', 'staff19@example.com', 'password19', '1234567819', 2900.40, 'Part-time', 'Tecnico', '2021-09-01', 25, 'CF12345678919'),
('Tommaso', 'Marroni', 'staff20@example.com', 'password20', '1234567820', 3100.20, 'Full-time', 'Receptionist', '2018-05-22', 40, 'CF12345678920');


INSERT INTO Message (message_title, message_object, message_content, send_date) VALUES 
('Welcome Message', 'Introduction', 'Hello, welcome to our service!', '2025-01-01'),
('Reminder', 'Task Reminder', 'Don\'t forget to complete your tasks!', '2025-01-02'),
('Event Update', 'Meeting', 'The meeting is scheduled at 10 AM tomorrow.', '2025-01-03'),
('Thank You', 'Gratitude', 'Thank you for being a valued customer.', '2025-01-04'),
('System Alert', 'Maintenance', 'System maintenance is scheduled for tonight.', '2025-01-05');

select * from Message

