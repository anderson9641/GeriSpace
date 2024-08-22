package com.triadev.spacereservation.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triadev.spacereservation.entitie.Association;
import com.triadev.spacereservation.entitie.Reservation;
import com.triadev.spacereservation.service.ReservationService;


@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservation(){
        return reservationService.getAllReservations();
    }

    @GetMapping("/{cod}")
    public ResponseEntity<Optional<Reservation>> getReservatioById(@PathVariable UUID cod){
        Optional<Reservation> newReservation = reservationService.getReservationById(cod);
        return ResponseEntity.ok().body(newReservation);
    }

    @GetMapping("/association/{cod}")
    public ResponseEntity<List<Reservation>> getReservationByAssociation(@PathVariable UUID cod){
       
        List<Reservation> reservations = reservationService.getReservationByAssociation(cod);
        return ResponseEntity.ok().body(reservations);
    } 

    
}
