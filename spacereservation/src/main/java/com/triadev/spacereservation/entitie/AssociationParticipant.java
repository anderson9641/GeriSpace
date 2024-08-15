package com.triadev.spacereservation.entitie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AssociationParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PARTICIPANT", nullable = false)
    private Participants participante;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ASSOCIATION", nullable = false)
    private Association associacao;
    
    @Column(name = "ROLE",nullable = false)
    private String role; // "Membro", "Responsável"
}
