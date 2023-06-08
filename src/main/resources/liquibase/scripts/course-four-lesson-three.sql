-- liquibase formatted sql

--changeset aelchikushuulu:1
SELECT * FROM students WHERE name=''

--changeset aelchikushuulu:2
SELECT * FROM faculties WHERE color = '' AND name = ''
