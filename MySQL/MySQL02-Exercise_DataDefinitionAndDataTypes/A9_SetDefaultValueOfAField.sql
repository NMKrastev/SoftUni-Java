#9.	Set Default Value of a Field
#Using SQL queries modify table users. Make the default value of last_login_time field to be the current time.

use minions;
alter table users
    modify column last_login_time datetime default now();