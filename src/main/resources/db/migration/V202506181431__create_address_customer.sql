SET
    client_encoding TO utf8;

CREATE TABLE
    customer (
        id UUID PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        phone_number VARCHAR(255) NOT NULL,
        document VARCHAR(255) NOT NULL UNIQUE,
        customer_type CHAR(2) NOT NULL,
        created_at timestamp(6) NOT NULL,
        updated_at timestamp(6) NOT NULL,
        deleted_at timestamp(6),
        deleted BOOLEAN NOT NULL DEFAULT FALSE
    );

CREATE TABLE
    address (
        id UUID PRIMARY KEY,
        customer_id UUID NOT NULL,
        address_type VARCHAR(50) NOT NULL,
        street VARCHAR(255) NOT NULL,
        address_number VARCHAR(20) NOT NULL,
        complement VARCHAR(100),
        neighborhood VARCHAR(100) NOT NULL,
        city VARCHAR(100) NOT NULL,
        state VARCHAR(2) NOT NULL,
        postal_code VARCHAR(10) NOT NULL,
        country VARCHAR(255) NOT NULL,
        is_primary BOOLEAN NOT NULL
    );

ALTER TABLE address ADD CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE;