-- Persons
INSERT INTO person (name, lastname, email, address, dni, birthday)
VALUES ('Juan', 'Client', 'juan@client.com', 'Address', 123456789, '1994-01-01');
INSERT INTO person (name, lastname, email, address, dni, birthday)
VALUES ('Joel', 'Employee', 'joel@employee.com', 'Address', 123456789, '1994-01-01');
INSERT INTO person (name, lastname, email, address, dni, birthday)
VALUES ('Joel', 'Admin', 'joel@admin.com', 'Address', 123456789, '1994-01-01');
INSERT INTO person (name, lastname, email, address, dni, birthday)
VALUES ('Joel', 'Owner', 'joel@owner.com', 'Address', 123456789, '1994-01-01');

-- Credentials
INSERT INTO user_credential (user_email, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, role_id)
VALUES ('juan@client.com', '$2a$10$W8y2Dlmq5GnvrL3GuF1wguIPKbQBMeycTpVxwHRaPEH3xbsO5vJfu', 1, 1, 1, 1, 1);
INSERT INTO user_credential (user_email, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, role_id)
VALUES ('joel@employee.com', '$2a$10$W8y2Dlmq5GnvrL3GuF1wguIPKbQBMeycTpVxwHRaPEH3xbsO5vJfu', 1, 1, 1, 1, 2);
INSERT INTO user_credential (user_email, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, role_id)
VALUES ('joel@admin.com', '$2a$10$W8y2Dlmq5GnvrL3GuF1wguIPKbQBMeycTpVxwHRaPEH3xbsO5vJfu', 1, 1, 1, 1, 3);
INSERT INTO user_credential (user_email, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, role_id)
VALUES ('joel@owner.com', '$2a$10$W8y2Dlmq5GnvrL3GuF1wguIPKbQBMeycTpVxwHRaPEH3xbsO5vJfu', 1, 1, 1, 1, 5);

-- Clients
INSERT INTO client (person_id) VALUES
(1);

-- Employees
INSERT INTO employee (person_id, salary) VALUES
(2, 100000.00);
INSERT INTO employee (person_id, salary) VALUES
(3, 100000.00);
INSERT INTO employee (person_id, salary) VALUES
(4, 100000.00);