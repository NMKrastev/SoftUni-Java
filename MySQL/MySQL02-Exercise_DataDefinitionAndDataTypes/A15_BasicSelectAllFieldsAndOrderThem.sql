#15. Basic Select All Fields and Order Them
/*Modify queries from previous problem by sorting:
•	towns - alphabetically by name
•	departments - alphabetically by name
•	employees - descending by salary*/

use soft_uni;

select *
from towns
order by name asc;

select *
from departments
order by name asc;

select *
from employees
order by salary desc;