package com.acmeairlines.airlinesim.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;

@Repository
public class SeatAvailabilityRepository {

    private final JdbcTemplate jdbcTemplate;

    public SeatAvailabilityRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean checkSeatAvailability(int flightId, int seatId) {
        // Assuming the stored procedure returns a boolean or similar indicator
        // This is a simplified example; actual implementation might require a more complex handling
        return jdbcTemplate.queryForObject(
                "CALL CheckSeatAvailability(?, ?)",
                Boolean.class,
                flightId, seatId);
    }
}
