-- Create the database and switch to it
CREATE DATABASE IF NOT EXISTS airline_sim;
USE AirlineSim;

-- Drop existing tables if they exist to avoid conflicts during development
DROP TABLE IF EXISTS SeatAssignments, FlightManifest, Passengers, Flights, Aircraft, Airlines, Airports, Routes, Fares, FrequentFlyerAccounts, FrequentFlyerTiers, AirportClubs, Booking;

-- Airports
CREATE TABLE Airports (
    AirportID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    City VARCHAR(255) NOT NULL,
    Country VARCHAR(255) NOT NULL,
    IATA VARCHAR(3) NOT NULL,
    Latitude DECIMAL(9,6),
    Longitude DECIMAL(9,6)
);

-- Airlines
CREATE TABLE Airlines (
    AirlineID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    ICAO VARCHAR(3),
    IATA VARCHAR(3) NOT NULL
);

-- Aircraft
CREATE TABLE Aircraft (
    AircraftID INT AUTO_INCREMENT PRIMARY KEY,
    AirlineID INT,
    Model VARCHAR(255) NOT NULL,
    TotalSeats INT NOT NULL,
    FirstClassSeats INT,
    BusinessClassSeats INT,
    PremiumEconomySeats INT,
    EconomySeats INT,
    FOREIGN KEY (AirlineID) REFERENCES Airlines(AirlineID)
);

-- Routes
CREATE TABLE Routes (
    RouteID INT AUTO_INCREMENT PRIMARY KEY,
    DepartureAirportID INT,
    ArrivalAirportID INT,
    DistanceMiles INT,
    FOREIGN KEY (DepartureAirportID) REFERENCES Airports(AirportID),
    FOREIGN KEY (ArrivalAirportID) REFERENCES Airports(AirportID)
);

-- Flights
CREATE TABLE Flights (
    FlightID INT AUTO_INCREMENT PRIMARY KEY,
    RouteID INT,
    AircraftID INT,
    DepartureTime DATETIME NOT NULL,
    ArrivalTime DATETIME NOT NULL,
    Status ENUM('On Time', 'Delayed', 'Cancelled') NOT NULL,
    Terminal VARCHAR(5),
    Gate VARCHAR(5),
    FOREIGN KEY (RouteID) REFERENCES Routes(RouteID),
    FOREIGN KEY (AircraftID) REFERENCES Aircraft(AircraftID)
);

-- Passengers
CREATE TABLE Passengers (
    PassengerID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    PassportNumber VARCHAR(255),
    FrequentFlyerID INT
    -- Additional passenger details can be added here
);

-- FrequentFlyerAccounts
CREATE TABLE FrequentFlyerAccounts (
    FrequentFlyerID INT AUTO_INCREMENT PRIMARY KEY,
    AirlineID INT,
    PassengerID INT,
    Points INT DEFAULT 0,
    Tier ENUM('Bronze', 'Silver', 'Gold', 'Platinum'),
    FOREIGN KEY (AirlineID) REFERENCES Airlines(AirlineID),
    FOREIGN KEY (PassengerID) REFERENCES Passengers(PassengerID)
);

-- AirportClubs
CREATE TABLE AirportClubs (
    ClubID INT AUTO_INCREMENT PRIMARY KEY,
    AirportID INT,
    Name VARCHAR(255) NOT NULL,
    LocationDescription VARCHAR(255),
    AccessTier ENUM('Bronze', 'Silver', 'Gold', 'Platinum'),
    FOREIGN KEY (AirportID) REFERENCES Airports(AirportID)
);

-- Fares
CREATE TABLE Fares (
    FareID INT AUTO_INCREMENT PRIMARY KEY,
    RouteID INT,
    CabinClass ENUM('First', 'Business', 'Premium Economy', 'Economy') NOT NULL,
    BasePrice DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (RouteID) REFERENCES Routes(RouteID)
);

-- Booking (Simplified for this script)
CREATE TABLE Booking (
    BookingID INT AUTO_INCREMENT PRIMARY KEY,
    FlightID INT,
    PassengerID INT,
    FareID INT,
    SeatNumber VARCHAR(10),
    Status ENUM('Booked', 'Checked-in', 'Boarded', 'No Show', 'Bumped', 'Standby', 'Confirmed'),
    FOREIGN KEY (FlightID) REFERENCES Flights(FlightID),
    FOREIGN KEY (PassengerID) REFERENCES Passengers(PassengerID),
    FOREIGN KEY (FareID) REFERENCES Fares(FareID)
);

-- SeatAssignments (Simplified version)
CREATE TABLE SeatAssignments (
    SeatAssignmentID INT AUTO_INCREMENT PRIMARY KEY,
    BookingID INT,
    SeatType ENUM('Aisle', 'Window', 'Middle', 'Exit Row', 'Bulkhead'),
    FOREIGN KEY (BookingID) REFERENCES Booking(BookingID)
);

-- FlightManifest
CREATE TABLE FlightManifest (
    ManifestID INT AUTO_INCREMENT PRIMARY KEY,
    FlightID INT,
    PassengerID INT,
    Status ENUM('Checked-in', 'Boarded', 'No Show', 'Bumped', 'Standby', 'Confirmed'),
    FOREIGN KEY (FlightID) REFERENCES Flights(FlightID),
    FOREIGN KEY (PassengerID) REFERENCES Passengers(PassengerID)
);
