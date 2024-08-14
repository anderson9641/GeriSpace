package com.triadev.spacereservation.service;

import com.triadev.spacereservation.entitie.Reservation;
import com.triadev.spacereservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        // Lógica de negócio pode ser adicionada aqui, como checar disponibilidade.
        return repo.save(reservation);
    }

    public Reservation updateReservation(UUID id, Reservation reservationDetails) {
        return repo.findById(id)
            .map(reservation -> {
                reservation.setAssociation(reservationDetails.getAssociation());
                reservation.setSpace(reservationDetails.getSpace());
                reservation.setStartTime(reservationDetails.getStartTime());
                reservation.setEndTime(reservationDetails.getEndTime());
                // Atualize outros campos conforme necessário
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
}
