package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.FlightManifest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightManifestRepository extends JpaRepository<FlightManifest, Integer> {
}
