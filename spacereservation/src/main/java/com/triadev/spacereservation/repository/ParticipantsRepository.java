package com.triadev.spacereservation.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.triadev.spacereservation.entitie.Participants;

public interface ParticipantsRepository extends JpaRepository<Participants,UUID>{
    
}
