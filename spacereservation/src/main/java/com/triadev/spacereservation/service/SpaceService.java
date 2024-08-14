package com.triadev.spacereservation.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triadev.spacereservation.entitie.Space;
import com.triadev.spacereservation.repository.SpaceRepository;

@Service
public class SpaceService {

    @Autowired
    private SpaceRepository repo;

    public List<Space> getAllSpaces() {
        return repo.findAll();
    }

    public Optional<Space> getSpaceById(UUID cod) {
        return repo.findById(cod);
    }

    public Space createSpace(Space space) {
        return repo.save(space);
    }

    public void deleteSpace(UUID cod) {
        repo.deleteById(cod);
    }

    public Space updateSpace(UUID cod, Space spaceDetails) {
        return repo.findById(cod)
                .map(space -> {
                    space.setName(spaceDetails.getName());
                    space.setAdrress(spaceDetails.getAdrress());
                    return repo.save(space);
                })
                .orElseThrow(() -> new RuntimeException("Space not found"));
    }

}
