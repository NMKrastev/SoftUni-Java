#13. Basic Insert
/*Now create bigger database called soft_uni. You will use database in the future tasks.
It should hold information about
    • towns (id, name)
    • addresses (id, address_text, town_id)
    • departments (id, name)
    • employees (id, first_name, middle_name, last_name, job_title, department_id, hire_date, salary, address_id)
Id columns are auto incremented starting from 1 and increased by 1 (1, 2, 3, 4…).
Make sure you use appropriate data types for each column.
Add primary and foreign keys as constraints for each table. Use only SQL queries.
Consider which fields are always required and which are optional.

Use the SoftUni database and insert some data using SQL queries.
•	towns: Sofia, Plovdiv, Varna, Burgas
•	departments: Engineering, Sales, Marketing, Software Development, Quality Assurance
•	employees:
name					job_title				department				hire_date				salary
Ivan Ivanov Ivanov		.NET Developer			Software Development	01/02/2013				3500.00
Petar Petrov Petrov		Senior Engineer			Engineering				02/03/2004				4000.00
Maria Petrova Ivanova	Intern					Quality Assurance		28/08/2016				525.25
Georgi Terziev Ivanov	CEO						Sales					09/12/2007				3000.00
Peter Pan Pan			Intern					Marketing				28/08/2016				599.88*/

create database soft_uni;

create table towns
(
    id   INT         not null auto_increment,
    name Varchar(50) not null,
    primary key (id)
);

insert into towns (name)
values ('Sofia'),
       ('Plovdiv'),
       ('Varna'),
       ('Burgas');

create table `addresses`
(
    id           INT not null auto_increment,
    address_text Varchar(100),
    town_id      INT,
    primary key (id)
);

create table `departments`
(
    id   INT not null auto_increment,
    name Varchar(100),
    primary key (id)
);

insert into departments (name)
values ('Engineering'),
       ('Sales'),
       ('Marketing'),
       ('Software Development'),
       ('Quality Assurance');

create table `employees`
(
    id            INT         not null auto_increment,
    first_name    Varchar(30) not null,
    middle_name   Varchar(30),
    last_name     Varchar(30) not null,
    job_title     Varchar(100),
    department_id INT,
    hire_date     date,
    salary        double,
    address_id    INT,
    primary key (id)
);

alter table addresses
    add constraint FK_AddressesTowns
        foreign key (town_id) references addresses (id);

alter table employees
    add constraint FK_EmployeesTowns
        foreign key (department_id) references departments (id);

alter table employees
    add constraint FK_EmployeesAddress
        foreign key (address_id) references addresses (id);

insert into employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
values ('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
       ('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
       ('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
       ('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
       ('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);