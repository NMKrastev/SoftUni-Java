#8.	Change Primary Key
/*Using SQL queries modify table users from the previous task.
First remove current primary key then create new primary key that would be combination of fields id and username.
The initial primary key name on id is pk_users.*/

use minions;
alter table users
    modify id BIGINT not null,
    drop primary key,
    add constraint pk_users primary key (id, username);