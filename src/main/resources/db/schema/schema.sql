CREATE TABLE IF NOT EXISTS users
(
    id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    50
),
    email VARCHAR
(
    100
),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS scenes (id, )
