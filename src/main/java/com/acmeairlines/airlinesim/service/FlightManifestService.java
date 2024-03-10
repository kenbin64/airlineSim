package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.FlightManifest;

import java.util.List;
import java.util.Optional;

public interface FlightManifestService {
    FlightManifest saveManifest(FlightManifest manifest);
    List<FlightManifest> getAllManifests();
    Optional<FlightManifest> getManifestById(Integer id);
    FlightManifest updateManifest(FlightManifest manifest);
    void deleteManifest(Integer id);
}

