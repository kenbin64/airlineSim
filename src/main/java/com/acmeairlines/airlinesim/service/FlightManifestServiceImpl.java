package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.FlightManifest;
import com.acmeairlines.airlinesim.repository.FlightManifestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FlightManifestServiceImpl implements FlightManifestService {

    private final FlightManifestRepository manifestRepository;

    @Autowired
    public FlightManifestServiceImpl(FlightManifestRepository manifestRepository) {
        this.manifestRepository = manifestRepository;
    }

    @Override
    public FlightManifest saveManifest(FlightManifest manifest) {
        // Additional validations or business logic can be added here
        return manifestRepository.save(manifest);
    }

    @Override
    public List<FlightManifest> getAllManifests() {
        return manifestRepository.findAll();
    }

    @Override
    public Optional<FlightManifest> getManifestById(Integer id) {
        return manifestRepository.findById(id);
    }

    @Override
    public FlightManifest updateManifest(FlightManifest manifest) {
        // Ensure the manifest exists and is valid before attempting an update
        if (manifest != null && manifest.getManifestID() != null && manifestRepository.existsById(manifest.getManifestID())) {
            return manifestRepository.save(manifest);
        } else {
            // Handle the case where the manifest is null or does not exist
            throw new IllegalArgumentException("Manifest is null or does not exist.");
        }
    }

    @Override
    public void deleteManifest(Integer id) {
        if (manifestRepository.existsById(id)) {
            manifestRepository.deleteById(id);
        } else {
            // Handle the case where the manifest does not exist
            throw new IllegalArgumentException("Manifest with id " + id + " does not exist.");
        }
    }


}

