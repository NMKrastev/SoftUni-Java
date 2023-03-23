#5. Modifying Columns
#Change the property "VARCHAR(50)" to "VARCHAR(100)" to the "middle_name" column in "employees" table.

use gamebar;
alter table employees
    modify middle_name VARCHAR(100);