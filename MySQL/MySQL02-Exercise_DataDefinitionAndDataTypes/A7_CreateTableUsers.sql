#7.	Create Table Users
/*Using SQL query create table users with columns:
•	id – unique number for every user. There will be no more than 263-1 users. (Auto incremented)
•	username – unique identifier of the user will be no more than 30 characters (non Unicode). (Required)
•	password – password will be no longer than 26 characters (non Unicode). (Required)
•	profile_picture – image with size up to 900 KB.
•	last_login_time
•	is_deleted – shows if the user deleted his/her profile. Possible states are true or false.
Make id primary key. Populate the table with 5 records. Submit your CREATE and INSERT statements. */

use minions;
create table `users`
(
    id              BIGINT auto_increment,
    username        Varchar(30) unique,
    password        Varchar(26),
    profile_picture longblob,
    last_login_time time,
    is_deleted      boolean,
    primary key (id)
);

insert into users (username, password, profile_picture, last_login_time, is_deleted)
values ('John DoeOne', '12345', null, null, false),
       ('John DoeTwo', '11111', null, null, false),
       ('John DoeThree', '22222', null, null, true),
       ('John DoeFour', '33333', null, null, true),
       ('John DoeFive', '44444', null, null, false);