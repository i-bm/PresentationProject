# Template Method Pattern Project

This project implements the Template Mehod pattern. A typical implementation is in Frameworks. 

We simulate how ORMs work.



## Database Setup

Run the sql scripts below to prep up the database.

```sql
# create database

CREATE DATABASE turntabl;
```

```sql
# create table (Employee)

CREATE TABLE employees(
id SERIAL PRIMARY KEY NOT NULL,
emp_id VARCHAR(20) NOT NULL,
firstname VARCHAR(100) NOT NULL,
lastname VARCHAR(100),
email VARCHAR(100),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

