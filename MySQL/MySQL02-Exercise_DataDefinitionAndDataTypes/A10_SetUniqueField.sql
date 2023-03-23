#10. Set Unique Field
/*Using SQL queries modify table users.
Remove username field from the primary key so only the field id would be primary key.
Now add unique constraint to the username field.
The initial primary key name on (id, username) is pk_users.*/

use minions;
alter table users
    drop primary key,
    add constraint pk_users primary key users (id),
    modify column username Varchar(30) unique;