#3. Alter Tables
#Altering the tables is done via the "ALTER TABLE" clause. Add a new column – "middle_name" to the "employees" table.

use gamebar;
alter table employees
add column middle_name Varchar(50) not null after first_name;