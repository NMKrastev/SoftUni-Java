#3.	Insert Records in Both Tables
/*Populate both tables with sample records given in the table below.
minions									towns
id	name	age		town_id				id	name
1	Kevin	22		1					1	Sofia
2	Bob		15		3					2	Plovdiv
3	Steward	NULL	2					3	Varna
Use only insert SQL queries. */

use minions;
insert into towns (id, name)
values (1, 'Sofia'), (2, 'Plovdiv'), (3, 'Varna');

insert into minions (id, name, age, town_id)
values (1, 'Kevin', 22, 1), (2, 'Bob', 15, 3), (3, 'Steward', null, 2);