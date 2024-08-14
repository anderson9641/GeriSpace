package com.triadev.spacereservation.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.triadev.spacereservation.entitie.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,UUID> {
    
}
