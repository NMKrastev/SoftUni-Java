#17.	Increase Employees Salary
/*Use softuni database and increase the salary of all employees by 10%.
Then select only salary column from the employees table. */

use soft_uni;

update employees
set salary = salary * 1.1;

select salary
from employees;