--liquibase formatted sql

--changeset maynim:1
CREATE TABLE IF NOT EXISTS revision
(
    id SERIAL PRIMARY KEY,
    timestamp BIGINT NOT NULL
);

--changeset maynim:2
CREATE TABLE IF NOT EXISTS users_aud
(
    id BIGINT,
    rev INT REFERENCES revision (id),
    revtype SMALLINT,
    username varchar(64) NOT NULL UNIQUE,
    birth_date DATE,
    firstname VARCHAR(64),
    lastname VARCHAR(64),
    role VARCHAR(32),
    company_id INT
);
