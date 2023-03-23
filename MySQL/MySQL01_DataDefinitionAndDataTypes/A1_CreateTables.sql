#1. Create Tables
#When we create tables, we specify the database we want to add them to. This is done by using the "USE" clause.
/*Table "employees":
•	id – INT, primary key, AUTO_INCREMENT;
•	first_name – VARCHAR, NOT NULL;
•	last_name – VARCHAR, NOT NULL;
Create the "categories" and "products" tables analogically:
Table "categories":
•	id – INT, primary key, AUTO_INCREMENT;
•	name – VARCHAR, NOT NULL;
Table "products":
•	id –  INT, primary key, AUTO_INCREMENT;
•	name – VARCHAR, NOT NULL;
•	category_id – INT, NOT NULL – it is not a foreign key for now.*/

use gamebar;
create table `employees` (
    id INT not null auto_increment,
    first_name Varchar(50) not null,
    last_name Varchar(50) not null,
    primary key (id)
);

use gamebar;
create table `categories` (
    id INT not null auto_increment,
    name Varchar(50) not null,
    primary key (id)
);

use gamebar;
create table `products` (
    id INT not null auto_increment,
    name Varchar(50) not null,
    category_id INT not null,
    primary key (id)
);