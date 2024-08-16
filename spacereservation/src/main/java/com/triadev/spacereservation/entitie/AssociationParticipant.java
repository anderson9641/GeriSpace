package com.triadev.spacereservation.entitie;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssociationParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cod;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PARTICIPANT", nullable = false)
    private Participants participant;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ASSOCIATION", nullable = false)
    private Association association;
    
    @Column(name = "ROLE",nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role; // "Membro", "Responsável"
}
