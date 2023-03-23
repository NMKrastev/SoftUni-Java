#6.	Create Table People
/*
Using SQL query create table "people" with columns:
•	id – unique number for every person there will be no more than 231-1people. (Auto incremented)
•	name – full name of the person will be no more than 200 Unicode characters. (Not null)
•	picture – image with size up to 2 MB. (Allow nulls)
•	height –  In meters. Real number precise up to 2 digits after floating point. (Allow nulls)
•	weight –  In kilograms. Real number precise up to 2 digits after floating point. (Allow nulls)
•	gender – Possible states are m or f. (Not null)
•	birthdate – (Not null)
•	biography – detailed biography of the person it can contain max allowed Unicode characters. (Allow nulls)
Make id primary key. Populate the table with 5 records.*/

use minions;
create table `people`
(
    id        INT auto_increment,
    name      Varchar(200)    not null,
    picture   longblob,
    height    double(4, 2),
    weight    double(4, 2),
    gender    enum ('m', 'f') not null,
    birthdate Varchar(50)     not null,
    biography text,
    primary key (id)
);

insert into people (id, name, picture, height, weight, gender, birthdate, biography)
values (1, 'John Doe', null, 1.50, 50.50, 'f', '10.10.1970', null),
       (2, 'John Doe', null, 1.60, 55.5, 'f', '10.10.1980', null),
       (3, 'John Doe', null, 1.70, 60.50, 'f', '10.10.1990', null),
       (4, 'John Doe', null, 1.80, 80.5, 'm', '10.10.2000', null),
       (5, 'John Doe', null, 1.90, 90.50, 'm', '10.10.2010', null);