#16. Basic Select Some Fields
/*Modify queries from previous problem to show only some of the columns. For table:
•	towns – name
•	departments – name
•	employees – first_name, last_name, job_title, salary
Keep the ordering from the previous problem*/

use soft_uni;

select name
from towns
order by name asc;

select name
from departments
order by name asc;

select first_name, last_name, job_title, salary
from employees
order by salary desc;