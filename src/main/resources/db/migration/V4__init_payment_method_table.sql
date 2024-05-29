CREATE TABLE IF NOT EXISTS payment_method (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(100) UNIQUE NOT NULL,
    interest DECIMAL(10, 2) NOT NULL,
);