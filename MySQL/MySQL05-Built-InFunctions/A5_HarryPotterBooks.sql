#Write a SQL query to retrieve titles of all the Harry Potter books.
#Order the information by id. Submit your query statements as Prepare DB & run queries.
SELECT `title`
FROM `books`
WHERE `title` LIKE 'Harry Potter%';