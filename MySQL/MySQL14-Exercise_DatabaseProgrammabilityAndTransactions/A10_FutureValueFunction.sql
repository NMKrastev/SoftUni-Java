#Your task is to create a function ufn_calculate_future_value that accepts as parameters –
#sum (with precision, 4 digits after the decimal point), yearly interest rate (double) and number of years(int).
# It should calculate and return the future value of the initial sum.
# The result from the function must be decimal, with precision 4.
#Using the following formula:
#FV = I x ((1 + R)^T)
#• I – Initial sum
#• R – Yearly interest rate
#• T – Number of years
#Submit your query statement as Run skeleton, run queries & check DB in Judge.
DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value(`sum` DECIMAL(19, 4), `yearly_interest_rate` DOUBLE, `year` INT)

    RETURNS DECIMAL(19, 4)
    NOT DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `future_value` DECIMAL(19, 4);

    SET `future_value` := `sum` * POW((1 + `yearly_interest_rate`), `year`);

    RETURN `future_value`;

    #RETURN `sum` * POW((1 + `yearly_interest_rate`), `year`);
END $$

DELIMITER ;

SELECT ufn_calculate_future_value(1000, 0.5, 5);