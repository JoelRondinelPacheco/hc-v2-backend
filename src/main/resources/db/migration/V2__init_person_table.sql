CREATE TABLE IF NOT EXISTS person (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    address VARCHAR(100),
    dni INT UNSIGNED,
    birthday DATE NOT NULL,
    phone_number INT UNSIGNED,
    CONSTRAINT positive_values
        CHECK ( dni > 0 AND phone_number > 0)
);

CREATE TABLE IF NOT EXISTS user_credential (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    account_non_expired BOOLEAN,
    account_non_locked BOOLEAN,
    credentials_non_expired BOOLEAN,
    enabled BOOLEAN,
    email_token VARCHAR(2000),
    role_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY (user_email)
        REFERENCES person(email)
        ON DELETE CASCADE,
    CONSTRAINT fk_user_role
        FOREIGN KEY (role_id)
        REFERENCES role(id)
        ON DELETE CASCADE
);