# PresentationProject

Steps:
Run this sql script 

create database turntabl;

create table Employees(
id SERIAL primary key not null,
emp_id varchar(20) not null,
firstname varchar(100) not null,
lastname varchar(100),
email varchar(100),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

