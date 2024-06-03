CREATE TABLE IF NOT EXISTS sale (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    type ENUM('SINGLE_SALE', 'PACKAGE'),
    total DECIMAL(10, 2) UNSIGNED NOT NULL,
    discount DECIMAL(10, 2),
    interest DECIMAL(10, 2),
    payment_method_id BIGINT UNSIGNED,
    employee_id BIGINT UNSIGNED,
    client_id BIGINT UNSIGNED,
    CONSTRAINT fk_payment_method
        FOREIGN KEY (payment_method_id)
        REFERENCES payment_method(id)
        ON DELETE SET NULL,
    CONSTRAINT fk_employee
        FOREIGN KEY (employee_id)
        REFERENCES employee(id)
        ON DELETE SET NULL,
    CONSTRAINT fk_client
        FOREIGN KEY (client_id)
        REFERENCES client(id)
        ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS sale_item (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    quantity INT UNSIGNED,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    sale_id BIGINT UNSIGNED,
    service_id BIGINT UNSIGNED,
    CONSTRAINT fk_sale
        FOREIGN KEY (sale_id)
        REFERENCES sale(id),
    CONSTRAINT fk_service
            FOREIGN KEY (service_id)
            REFERENCES service(id)
);