package com.triadev.spacereservation.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triadev.spacereservation.entitie.Association;
import com.triadev.spacereservation.entitie.Reservation;
import com.triadev.spacereservation.entitie.Week;
import com.triadev.spacereservation.repository.ReservationRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repo;

    public List<Reservation> getAllReservations() {
        return repo.findAll();
    }

    public Optional<Reservation> getReservationById(UUID id) {
        return repo.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        
        if(isReservationConflict(reservation)){
            throw new RuntimeException("Conflicting reservation exists");
        }
        return repo.save(reservation);

    }

    public List<Reservation> getResrvationsByDay(Week day){
        return repo.findAllByDayReservation(day);
    }

    public List<Reservation> getReservationByAssociation(UUID cod){
        return repo.findByAssociationCod(cod);
    }

    @Transactional
    public Reservation updateReservation(UUID id, Reservation reservationDetails) {
        return repo.findById(id)
            .map(reservation -> {
                reservation.setAssociation(reservationDetails.getAssociation());
                reservation.setSpace(reservationDetails.getSpace());
                reservation.setStartTime(reservationDetails.getStartTime());
                reservation.setEndTime(reservationDetails.getEndTime());
                reservation.setDayReservation(reservationDetails.getDayReservation());
                return repo.save(reservation);
            })
            .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public void deleteReservation(UUID id) {
        repo.deleteById(id);
    }

    /* public List<Reservation> findByDate(LocalDate date) {
        return repo.findByDate(date);
    } */

    public Boolean isReservationConflict(Reservation reservation){
        return repo.existsByTimeRange(reservation.getSpace(),reservation.getDayReservation(), reservation.getEndTime(), reservation.getStartTime());
    }
}
