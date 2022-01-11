use hibernatedemo;
create table employee (
ID SERIAL PRIMARY KEY NOT NULL,
FIRST_NAME VARCHAR(255) NOT NULL,
LAST_NAME VARCHAR(255) NOT NULL,
JOB VARCHAR(255) NOT NULL,
SALARY DECIMAL(12,2)
);

show tables;
show create table employee
use hibernatedemo;
select * from employee

drop table employee;