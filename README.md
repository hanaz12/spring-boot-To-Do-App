# Task Management API

A simple Task Management API built with Spring Boot.

## Features
- Add new tasks
- Retrieve all tasks
- Retrieve tasks sorted by status (not completed first)
- Update task status
- Delete tasks

## Technologies Used
- Spring Boot
- MySQL
- JPA/Hibernate

## Database Schema
```sql
CREATE TABLE tasks (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) UNIQUE NOT NULL,
    status ENUM('completed', 'not') NOT NULL DEFAULT 'not',
    PRIMARY KEY (id)
);
