#1.	Create Tables
/*In the newly created database Minions add table minions (id, name, age).
Then add new table towns (town_id, name).
Set id and town_id columns of both tables to be primary key as constraint,
id's must be auto increment. Submit yours create table queries in Judge
together for both tables (one after another separated by ";") as Run queries & check DB.*/

use minions;
create table `minions`
(
    id   INT         not null auto_increment,
    name Varchar(50) not null,
    age  INT         not null,
    primary key (id)
);

create table `towns`
(
    town_id INT         not null auto_increment,
    name    Varchar(50) not null,
    primary key (town_id)
);