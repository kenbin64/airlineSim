package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.AirportClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportClubRepository extends JpaRepository<AirportClub, Integer> {
}
