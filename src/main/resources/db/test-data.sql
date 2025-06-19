-- Insert customer 1: Ana Carolina Mendes (PF)
INSERT INTO
    customer (
        id,
        name,
        email,
        phone_number,
        document,
        customer_type,
        created_at,
        updated_at,
        deleted_at,
        deleted
    )
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440001',
        'Ana Carolina Mendes',
        'ana.mendes@email.com',
        '+55 41 99876-5432',
        '12345678909',
        'PF',
        '2025-06-17 09:25:00',
        '2025-06-17 09:25:00',
        NULL,
        FALSE
    );

INSERT INTO
    address (
        id,
        customer_id,
        address_type,
        street,
        address_number,
        complement,
        neighborhood,
        city,
        state,
        postal_code,
        country,
        is_primary
    )
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440101',
        '550e8400-e29b-41d4-a716-446655440001',
        'residential',
        'Rua das Flores',
        '789',
        'Apto 101',
        'Jardim Botânico',
        'Curitiba',
        'PR',
        '80210-170',
        'Brazil',
        TRUE
    ),
    (
        '550e8400-e29b-41d4-a716-446655440102',
        '550e8400-e29b-41d4-a716-446655440001',
        'commercial',
        'Avenida Sete de Setembro',
        '2450',
        'Sala 305',
        'Centro',
        'Curitiba',
        'PR',
        '80060-000',
        'Brazil',
        FALSE
    );

-- Insert customer 2: Lucas Ferreira Costa (PF)
INSERT INTO
    customer (
        id,
        name,
        email,
        phone_number,
        document,
        customer_type,
        created_at,
        updated_at,
        deleted_at,
        deleted
    )
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440002',
        'Lucas Ferreira Costa',
        'lucas.costa@email.com',
        '+55 11 98765-4321',
        '98765432100',
        'PF',
        '2025-06-17 09:25:00',
        '2025-06-17 09:25:00',
        NULL,
        FALSE
    );

INSERT INTO
    address (
        id,
        customer_id,
        address_type,
        street,
        address_number,
        complement,
        neighborhood,
        city,
        state,
        postal_code,
        country,
        is_primary
    )
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440201',
        '550e8400-e29b-41d4-a716-446655440002',
        'residential',
        'Rua XV de Novembro',
        '1234',
        'Casa 3',
        'Alto da Glória',
        'Curitiba',
        'PR',
        '80050-200',
        'Brazil',
        TRUE
    );

-- Insert customer 3: Mariana Oliveira Souza (PF)
INSERT INTO
    customer (
        id,
        name,
        email,
        phone_number,
        document,
        customer_type,
        created_at,
        updated_at,
        deleted_at,
        deleted
    )
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440003',
        'Mariana Oliveira Souza',
        'mariana.souza@email.com',
        '+55 21 97654-3210',
        '45678912345',
        'PF',
        '2025-06-17 09:25:00',
        '2025-06-17 09:25:00',
        NULL,
        FALSE
    );

INSERT INTO
    address (
        id,
        customer_id,
        address_type,
        street,
        address_number,
        complement,
        neighborhood,
        city,
        state,
        postal_code,
        country,
        is_primary
    )
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440301',
        '550e8400-e29b-41d4-a716-446655440003',
        'residential',
        'Rua Marechal Deodoro',
        '567',
        'Bloco B',
        'Centro',
        'Curitiba',
        'PR',
        '80020-320',
        'Brazil',
        TRUE
    ),
    (
        '550e8400-e29b-41d4-a716-446655440302',
        '550e8400-e29b-41d4-a716-446655440003',
        'commercial',
        'Rua Comendador Araújo',
        '890',
        'Loja 12',
        'Batel',
        'Curitiba',
        'PR',
        '80420-000',
        'Brazil',
        FALSE
    );

-- Insert customer 4: Tech Solutions LTDA (PJ)
INSERT INTO
    customer (
        id,
        name,
        email,
        phone_number,
        document,
        customer_type,
        created_at,
        updated_at,
        deleted_at,
        deleted
    )
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440004',
        'Tech Solutions LTDA',
        'contato@techsolutions.com.br',
        '+55 41 99999-0000',
        '12345678000199',
        'PJ',
        '2025-06-17 09:25:00',
        '2025-06-17 09:25:00',
        NULL,
        FALSE
    );

INSERT INTO
    address (
        id,
        customer_id,
        address_type,
        street,
        address_number,
        complement,
        neighborhood,
        city,
        state,
        postal_code,
        country,
        is_primary
    )
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440401',
        '550e8400-e29b-41d4-a716-446655440004',
        'commercial',
        'Avenida Vicente Machado',
        '333',
        'Torre A',
        'Centro',
        'Curitiba',
        'PR',
        '80420-010',
        'Brazil',
        TRUE
    );

-- Insert customer 5: Global Imports S/A (PJ)
INSERT INTO
    customer (
        id,
        name,
        email,
        phone_number,
        document,
        customer_type,
        created_at,
        updated_at,
        deleted_at,
        deleted
    )
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440005',
        'Global Imports S/A',
        'financeiro@globalimports.com.br',
        '+55 41 98888-7777',
        '98765432000188',
        'PJ',
        '2025-06-17 09:25:00',
        '2025-06-17 09:25:00',
        NULL,
        FALSE
    );

INSERT INTO
    address (
        id,
        customer_id,
        address_type,
        street,
        address_number,
        complement,
        neighborhood,
        city,
        state,
        postal_code,
        country,
        is_primary
    )
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440501',
        '550e8400-e29b-41d4-a716-446655440005',
        'commercial',
        'Rua Emiliano Perneta',
        '450',
        'Andar 5',
        'Batel',
        'Curitiba',
        'PR',
        '80420-080',
        'Brazil',
        TRUE
    ),
    (
        '550e8400-e29b-41d4-a716-446655440502',
        '550e8400-e29b-41d4-a716-446655440005',
        'commercial',
        'Rua Presidente Faria',
        '200',
        'Galpão 1',
        'Centro',
        'Curitiba',
        'PR',
        '80020-290',
        'Brazil',
        FALSE
    );