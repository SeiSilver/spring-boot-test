--liquibase formatted sql

--changeset datpd:1;
CREATE TABLE `db_user`
(
    `user_id`      int primary key AUTO_INCREMENT,
    `username`     varchar(255),
    `last_name`    varchar(255),
    `first_name`   varchar(255),
    `birth`        timestamp,
    `created_date` timestamp
);
