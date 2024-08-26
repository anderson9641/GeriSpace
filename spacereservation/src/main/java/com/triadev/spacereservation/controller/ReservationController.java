package com.triadev.spacereservation.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triadev.spacereservation.entitie.Reservation;
import com.triadev.spacereservation.entitie.Week;
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

    @GetMapping("day/{day}")
    public ResponseEntity<List<Reservation>> getReservationByDay(@PathVariable Week day){
        List<Reservation> reservations = reservationService.getReservationsByDay(day);
        return ResponseEntity.ok().body(reservations);
    }
    @GetMapping(params = {"day", "cod"})
    public ResponseEntity<List<Reservation>> getReservationByDayAndSpace(@RequestParam("day") Week day,@RequestParam("cod") UUID cod){
        List<Reservation> reservations = reservationService.getReservationByDayAndSpace(day, cod);
        return ResponseEntity.ok().body(reservations);
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        Reservation newReservation = reservationService.createReservation(reservation);
        return ResponseEntity.ok().body(newReservation);
    }

    @DeleteMapping("/{cod}")
    public ResponseEntity<Reservation> deleteReservatio(@PathVariable UUID cod){
        reservationService.deleteReservation(cod);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cod}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable UUID cod,@RequestBody Reservation reservationDetails){
        Reservation newReservation = reservationService.updateReservation(cod, reservationDetails);
        return ResponseEntity.ok().body(newReservation);
    }

    

    
}
