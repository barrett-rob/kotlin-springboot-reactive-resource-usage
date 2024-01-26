-- liquibase formatted sql

-- changeset barrett.rob@gmail.com:deadbeef-1

CREATE SEQUENCE
    IF NOT EXISTS
    db_seq
    INCREMENT BY 1
    AS BIGINT
    MINVALUE 0
    NO MAXVALUE
    START WITH 1;
