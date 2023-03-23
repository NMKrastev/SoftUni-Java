#2. Insert Data in Tables
#Inserting data can be done with a query too. To do that we use the "INSERT" clause. Populate the "employees" table with 3 test values.

use gamebar;
insert into employees (first_name, last_name)
values ("Pesho", "Petrov"), ("Ivan", "Ivanov"), ("Dimitar", "Dimitrov");