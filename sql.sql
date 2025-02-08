create database TODO;
use TODO;

CREATE TABLE tasks (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) UNIQUE NOT NULL,
    status ENUM('completed', 'not') NOT NULL DEFAULT 'not',
    PRIMARY KEY (id)
);

INSERT INTO tasks (id, title, status) VALUES (1, "do my to do project", "not");


select * from tasks;