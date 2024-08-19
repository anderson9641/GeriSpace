package com.triadev.spacereservation.entitie;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cod;
    
    @ManyToOne
    @JoinColumn(name = "COD_SPACE", nullable = false)
    private Association association;
    
    @ManyToOne
    @JoinColumn(name = "COD_ASSOCIATION", nullable = false)
    private Space space;

    @Column(name = "DAY_RESAERVATION", nullable = false)
    @Enumerated(EnumType.STRING)
    private Week dayReservation; 

    @Column(name = "STARTTIME", nullable = false)
    private LocalTime startTime;
    @Column(name = "ENDTIME")
    private LocalTime endTime;

    @Column(name = "STARTDATE")
    private LocalDate startDate;

    @Column(name = "ENDDATE")
    private LocalDate endDate; 

    public LocalTime getHoraFim() {
        return startTime.plusMinutes(80);
    }
}
