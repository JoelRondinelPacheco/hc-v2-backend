CREATE TABLE IF NOT EXISTS client (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    person_id BIGINT UNSIGNED,
    FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS employee (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    person_id BIGINT UNSIGNED,
    salary DECIMAL(10, 2) UNSIGNED NOT NULL,
    CONSTRAINT fk_person
        FOREIGN KEY (person_id)
        REFERENCES person(id)
        ON DELETE SET NULL
);