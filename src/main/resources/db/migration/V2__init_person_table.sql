CREATE TABLE IF NOT EXISTS person (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    address VARCHAR(100),
    dni INT UNSIGNED,
    birthday DATE NOT NULL,
    phone_number INT UNSIGNED,
    role_id BIGINT UNSIGNED,
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE SET NULL,
    CONSTRAINT positive_values
        CHECK ( dni > 0 AND phone_number > 0)
);