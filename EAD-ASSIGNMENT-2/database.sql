drop database student;
CREATE DATABASE STUDENT;
USE STUDENT;
CREATE TABLE STUDENT_DETAIL(
  email VARCHAR(50) PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  father_name VARCHAR(30),
  class INT,
  age INT
);
select * from student_detail;