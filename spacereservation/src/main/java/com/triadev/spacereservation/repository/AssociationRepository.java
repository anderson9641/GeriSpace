package com.triadev.spacereservation.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triadev.spacereservation.entitie.Association;

@Repository
public interface AssociationRepository extends JpaRepository<Association,UUID> {
    
}
