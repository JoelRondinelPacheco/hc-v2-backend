-- ROLES
INSERT INTO role (name) VALUES ('CLIENT');
INSERT INTO role (name) VALUES ('EMPLOYEE');
INSERT INTO role (name) VALUES ('ADMINISTRATOR');
INSERT INTO role (name) VALUES ('ASSISTANT_OWNER');
INSERT INTO role (name) VALUES ('OWNER');

-- PAYMENT METHOD
INSERT INTO payment_method (type, interest)
VALUES ('EFECTIVO', 00.00);
INSERT INTO payment_method (type, interest)
VALUES ('DEBITO', 3.00);
INSERT INTO payment_method (type, interest)
VALUES ('CREDITO', 9.00);
INSERT INTO payment_method (type, interest)
VALUES ('MONEDERO_VIRTUAL', 00.00);
INSERT INTO payment_method (type, interest)
VALUES ('TRANSEFERENCIA', 2.45);

-- CATEGORIES
INSERT INTO category (name, description) VALUES ('HOTEL', 'Habitaciones de hotel por noche');
INSERT INTO category (name, description) VALUES ('TRANSPORTE', 'Alquiler de autos y otros medios');
INSERT INTO category (name, description) VALUES ('PASAJES', 'Pasajes de avion, tren, etc');
INSERT INTO category (name, description) VALUES ('EXCURSIONES', 'Reserva de excursiones');
INSERT INTO category (name, description) VALUES ('EVENTOS', 'Entradas a eventos');

-- SERVICES
INSERT INTO service (created_at, updated_at, name, description, price, category_id)
VALUES ('2024-03-04 12:34:56.000000', '2024-03-04 12:34:56.000000', 'Una habitacion', 'Hotel una habitacion', 100.00, 1);
INSERT INTO service (created_at, updated_at, name, description, price, category_id)
VALUES ('2024-03-03 12:34:56.000000', '2024-03-03 12:34:56.000000', 'Dos habitaciones', 'Hotel de dos habitaciones', 150.00, 1);
INSERT INTO service (created_at, updated_at, name, description, price, category_id)
VALUES ('2024-03-04 12:34:56.000000', '2024-03-04 12:34:56.000000', 'Automovil', 'Alquiler de automovil', 30.00, 2);
INSERT INTO service (created_at, updated_at, name, description, price, category_id)
VALUES ('2024-03-04 12:34:56.000000', '2024-03-04 12:34:56.000000', 'Motocicleta', 'Alquiler de motocicleta', 20.00, 2);
INSERT INTO service (created_at, updated_at, name, description, price, category_id)
VALUES ('2024-03-04 12:34:56.000000', '2024-03-04 12:34:56.000000', 'Bicicleta', 'Alquiler de bicicleta', 5.00, 2);

-- PERSON
INSERT INTO person (address, birthday, dni, email, name, lastname, nationality, phone_number, role_id)
VALUES ('direccion', '1994-10-25 12:34:56.000000', 123, 'person1@email.com', 'personA', 'rp', 'ARG', 123, 1);
INSERT INTO person (address, birthday, dni, email, name, lastname, nationality, phone_number, role_id)
VALUES ('direccion', '1994-10-25 12:34:56.000000', 123, 'person2@email.com', 'personB', 'rp', 'ARG', 123, 2);

-- CLIENT
INSERT INTO client (person_id) VALUES (1);

-- EMPLOYEES
INSERT INTO user_table (person_id, salary, password)
VALUES (2, 100.00, 'password');
