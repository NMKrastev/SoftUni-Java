#Define a function ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
#that returns 1 or 0 depending on that if the word is a comprised of the given set of letters.
#Submit your query statement as Run skeleton, run queries & check DB in Judge.
DELIMITER $$

CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))

    RETURNS INT
    NOT DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `result` INT;

    SET `result` :=
            (SELECT `word` REGEXP (CONCAT('^[', set_of_letters, ']+$')));

    RETURN `result`;
END $$

DELIMITER ;

SELECT ufn_is_word_comprised('oistmiahf', 'Sofia');