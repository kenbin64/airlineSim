-- Create the airline simulation database
CREATE DATABASE IF NOT EXISTS airline_sim;
USE airline_sim;

-- Drop existing tables if they exist to start fresh
DROP TABLE IF EXISTS boarding_pass, trip_flight, trip, booking, seat_assignment, flight_seat_availability, passenger_passenger_type, passenger_type, passenger, seat, flight, gate, terminal, route, fare, aircraft, airline, airport;

-- Create airport table
-- Stores information about airports including their geographical location
CREATE TABLE airport (
    airport_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    iata VARCHAR(3) NOT NULL,
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6)    
) ENGINE=InnoDB;

-- Create airline table
-- Details of airlines, including both ICAO and IATA codes
CREATE TABLE airline (
    airline_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    icao VARCHAR(3),
    iata VARCHAR(3) NOT NULL
) ENGINE=InnoDB;

-- Create aircraft table
-- Aircraft details, linked to airlines and including capacity
CREATE TABLE aircraft (
    aircraft_id INT AUTO_INCREMENT PRIMARY KEY,
    airline_id INT,
    model VARCHAR(255) NOT NULL,
    total_seats INT NOT NULL,
    FOREIGN KEY (airline_id) REFERENCES airline(airline_id)
) ENGINE=InnoDB;

-- Create route table
-- Flight routes from origin to destination airports
CREATE TABLE route (
    route_id INT AUTO_INCREMENT PRIMARY KEY,
    origin_airport_id INT,
    destination_airport_id INT,
    FOREIGN KEY (origin_airport_id) REFERENCES airport(airport_id),
    FOREIGN KEY (destination_airport_id) REFERENCES airport(airport_id)
) ENGINE=InnoDB;

-- Create fare table
-- Fare details for routes, including class of service
CREATE TABLE fare (
    fare_id INT AUTO_INCREMENT PRIMARY KEY,
    route_id INT,
    amount DECIMAL(10,2) NOT NULL,
    class_of_service ENUM('First', 'Business', 'Premium Economy', 'Economy') NOT NULL,
    FOREIGN KEY (route_id) REFERENCES route(route_id)
) ENGINE=InnoDB;

-- Create terminal table
-- Terminals within airports
CREATE TABLE terminal (
    terminal_id INT AUTO_INCREMENT PRIMARY KEY,
    airport_id INT,
    name VARCHAR(255) NOT NULL,
    FOREIGN KEY (airport_id) REFERENCES airport(airport_id)
) ENGINE=InnoDB;

-- Create gate table
-- Gates within terminals, specifying their number
CREATE TABLE gate (
    gate_id INT AUTO_INCREMENT PRIMARY KEY,
    terminal_id INT NOT NULL,
    number VARCHAR(10) NOT NULL,
    FOREIGN KEY (terminal_id) REFERENCES terminal(terminal_id)
) ENGINE=InnoDB;

-- Create flight table
-- Flight schedules and status, including delays and cancellations
CREATE TABLE flight (
    flight_id INT AUTO_INCREMENT PRIMARY KEY,
    route_id INT,
    aircraft_id INT,
    departure_time DATETIME NOT NULL,
    arrival_time DATETIME NOT NULL,
    status ENUM('On Time', 'Delayed', 'Cancelled') NOT NULL,
    delay_reason VARCHAR(255),
    terminal_id INT,
    gate_id INT,
    FOREIGN KEY (route_id) REFERENCES route(route_id),
    FOREIGN KEY (aircraft_id) REFERENCES aircraft(aircraft_id),
    FOREIGN KEY (terminal_id) REFERENCES terminal(terminal_id),
    FOREIGN KEY (gate_id) REFERENCES gate(gate_id)
) ENGINE=InnoDB;

-- Create passenger type table
-- Types of passengers, such as Adult, Child, Infant, etc.
CREATE TABLE passenger_type (
   passenger_type_id INT AUTO_INCREMENT PRIMARY KEY,
   description VARCHAR(255) NOT NULL,
   code VARCHAR(4) NOT NULL
) ENGINE=InnoDB;

-- Create passenger table
-- Passenger personal information, including passport details
CREATE TABLE passenger (
    passenger_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    passport_number VARCHAR(255)
) ENGINE=InnoDB;

-- Create passenger_passenger_type junction table
-- Associates passengers with their respective passenger types
CREATE TABLE passenger_passenger_type (
    passenger_id INT NOT NULL,
    passenger_type_id INT NOT NULL,
    FOREIGN KEY (passenger_id) REFERENCES passenger(passenger_id),
    FOREIGN KEY (passenger_type_id) REFERENCES passenger_type(passenger_type_id),
    PRIMARY KEY (passenger_id, passenger_type_id)
) ENGINE=InnoDB;

-- Create booking table
-- Booking information, including the fare and validity of the booking
CREATE TABLE booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    passenger_id INT,
    fare_id INT,
    booking_date DATETIME NOT NULL,
    is_valid BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (fare_id) REFERENCES fare(fare_id),
    FOREIGN KEY (passenger_id) REFERENCES passenger(passenger_id)
) ENGINE=InnoDB;

-- Create trip table
-- Trips, potentially including multiple flights, associated with bookings
CREATE TABLE trip (
    trip_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT,
    FOREIGN KEY (booking_id) REFERENCES booking(booking_id)
) ENGINE=InnoDB;

-- Create trip_flight junction table
-- Associates flights with trips for itinerary building
CREATE TABLE trip_flight (
    trip_flight_id INT AUTO_INCREMENT PRIMARY KEY,
    trip_id INT,
    flight_id INT,
    FOREIGN KEY (trip_id) REFERENCES trip(trip_id),
    FOREIGN KEY (flight_id) REFERENCES flight(flight_id)
) ENGINE=InnoDB;

-- Create seat table
-- Seat details within aircraft, including type and number
CREATE TABLE seat (
    seat_id INT AUTO_INCREMENT PRIMARY KEY,
    aircraft_id INT,
    seat_number VARCHAR(10) NOT NULL,
    seat_type ENUM('Aisle', 'Window', 'Middle', 'Exit Row', 'Bulkhead'),
    FOREIGN KEY (aircraft_id) REFERENCES aircraft(aircraft_id)
) ENGINE=InnoDB;

-- Create flight_seat_availability table
-- Tracks seat availability on flights
CREATE TABLE flight_seat_availability (
    flight_seat_availability_id INT AUTO_INCREMENT PRIMARY KEY,
    seat_id INT,
    flight_id INT,
    availability ENUM('Available', 'Booked') NOT NULL DEFAULT 'Available',
    FOREIGN KEY (seat_id) REFERENCES seat(seat_id),
    FOREIGN KEY (flight_id) REFERENCES flight(flight_id)
) ENGINE=InnoDB;

-- Create seat_assignment table
-- Assigns passengers to specific seats on specific flights
CREATE TABLE seat_assignment (
    seat_assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    seat_id INT,
    passenger_id INT,
    flight_id INT,
    FOREIGN KEY (seat_id) REFERENCES seat(seat_id),
    FOREIGN KEY (passenger_id) REFERENCES passenger(passenger_id),
    FOREIGN KEY (flight_id) REFERENCES flight(flight_id)
) ENGINE=InnoDB;

-- Create boarding_pass table
-- Generates boarding passes for passengers, including seat and flight details
CREATE TABLE boarding_pass (
    boarding_pass_id INT AUTO_INCREMENT PRIMARY KEY,
    seat_assignment_id INT,
    issued_time DATETIME NOT NULL,
    FOREIGN KEY (seat_assignment_id) REFERENCES seat_assignment(seat_assignment_id)
) ENGINE=InnoDB;
