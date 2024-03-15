DELIMITER $$

CREATE PROCEDURE AssignSeatToPassenger(
    IN bookingID INT,
    IN seatID INT
)
BEGIN
    -- Check if the seat is currently available
    DECLARE seatAvailable VARCHAR(10);
    SELECT availability INTO seatAvailable
    FROM aircraft_seat
    WHERE seat_id = seatID;
    
    IF seatAvailable = 'Available' THEN
        -- Assign the seat
        INSERT INTO seat_assignment (booking_id, seat_id)
        VALUES (bookingID, seatID);
        
        -- Update the seat's availability
        UPDATE aircraft_seat
        SET availability = 'Booked'
        WHERE seat_id = seatID;
    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The seat is not available.';
    END IF;
END$$

DELIMITER ;