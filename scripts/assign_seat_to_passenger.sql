DELIMITER $$

CREATE PROCEDURE assign_seat_to_passenger (
    IN p_booking_id INT,
    IN p_seat_id INT,
    IN p_flight_id INT
)
BEGIN
    DECLARE v_seat_available ENUM('Available', 'Booked');
    DECLARE v_exists INT;

    -- Check if the booking, seat, and flight exist
    SELECT COUNT(*) INTO v_exists FROM booking WHERE id = p_booking_id;
    IF v_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Booking ID does not exist.';
    END IF;

    SELECT COUNT(*) INTO v_exists FROM seat WHERE id = p_seat_id;
    IF v_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Seat ID does not exist.';
    END IF;

    SELECT COUNT(*) INTO v_exists FROM flight WHERE id = p_flight_id;
    IF v_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Flight ID does not exist.';
    END IF;

    -- Check if the seat is available for the flight
    SELECT availability INTO v_seat_available
    FROM flight_seat_availability
    WHERE seat_id = p_seat_id AND flight_id = p_flight_id
    FOR UPDATE; -- Lock the row for update to prevent race conditions

    IF v_seat_available = 'Available' THEN
        START TRANSACTION;

        INSERT INTO seat_assignment (booking_id, seat_id, flight_id)
        VALUES (p_booking_id, p_seat_id, p_flight_id);

        UPDATE flight_seat_availability
        SET availability = 'Booked'
        WHERE seat_id = p_seat_id AND flight_id = p_flight_id;

        COMMIT;
    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The seat is not available for this flight.';
    END IF;
END$$

DELIMITER ;
