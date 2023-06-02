DELIMITER $$

CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
    READS SQL DATA

BEGIN

    DECLARE `count` INT;

    SET `count` := (SELECT COUNT(op.`product_id`)
                       FROM `orders_products` AS op
                                JOIN `orders` AS o ON o.`id` = op.`order_id`
                                JOIN `customers` AS c ON c.`id` = o.`customer_id`
                       WHERE c.`first_name` = `name`
                       GROUP BY o.customer_id);

    RETURN `count`;

END $$
