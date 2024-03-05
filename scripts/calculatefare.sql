DELIMITER $$

CREATE PROCEDURE CalculateFare(
    IN cabinClass ENUM('First', 'Business', 'Premium Economy', 'Economy'),
    IN routeDistance INT,
    OUT calculatedFare DECIMAL(10,2)
)
BEGIN
    -- Define base rate multipliers for simplicity
    -- These values are arbitrary and for demonstration purposes
    DECLARE baseRate DECIMAL(10,2);
    DECLARE multiplier DECIMAL(5,2);

    -- Set base rate multiplier based on cabin class
    CASE
        WHEN cabinClass = 'First' THEN SET multiplier = 2.0;
        WHEN cabinClass = 'Business' THEN SET multiplier = 1.5;
        WHEN cabinClass = 'Premium Economy' THEN SET multiplier = 1.2;
        WHEN cabinClass = 'Economy' THEN SET multiplier = 1.0;
        ELSE SET multiplier = 1.0; -- Default to Economy if an unknown class is provided
    END CASE;

    -- Assume a base rate per mile (this could be dynamic based on other factors)
    SET baseRate = 0.15; -- $0.15 per mile as a base for calculation

    -- Calculate the fare
    SET calculatedFare = routeDistance * baseRate * multiplier;
END$$

DELIMITER ;