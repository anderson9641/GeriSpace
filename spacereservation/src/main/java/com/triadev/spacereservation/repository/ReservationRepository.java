package com.triadev.spacereservation.repository;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.triadev.spacereservation.entitie.Reservation;
import com.triadev.spacereservation.entitie.Space;
import com.triadev.spacereservation.entitie.Week;

public interface ReservationRepository extends JpaRepository<Reservation,UUID> {
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Reservation r WHERE r.space = :space AND r.dayReservation = :dayReservation AND (:startTime < r.endTime AND :endTime > r.startTime)")
    boolean existsByTimeRange(@Param("space") Space space, @Param("dayReservation") Week week, @Param("startTime") LocalTime startTime, @Param("endTime") LocalTime endTime);

}
